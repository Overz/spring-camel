package com.github.overz.camel.infra.camel;

import com.github.overz.camel.shared.routes.AbstractError;
import com.github.overz.camel.shared.routes.AbstractRoute;
import com.github.overz.camel.shared.routes.AbstractRoutePreset;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.builder.RouteConfigurationBuilder;
import org.apache.camel.model.RouteConfigurationDefinition;

import java.util.Set;

import static com.github.overz.camel.shared.constants.Routes.*;

public abstract class RoutesSetup {

	@Getter
	@RequiredArgsConstructor
	public static class Preset extends RouteConfigurationBuilder {
		private final Set<AbstractRoutePreset> presets;

		@Override
		public void configuration() throws Exception {
			for (var preset : presets) {
				var config = routeConfiguration(preset.configurationId());
				handlers(config, preset.errors());
				preset.configure(config);
			}
		}

		private void handlers(final RouteConfigurationDefinition config, Set<AbstractError> errors) {
			for (final var spec : errors) {
				final var throwable = spec.throwable();
				final var to = spec.to();
				final var processor = spec.processor();
				var route = config.onException(throwable)
					.log(LoggingLevel.DEBUG, "Handling exception '" + throwable.getSimpleName() + "' with processor '" + processor.getClass().getSimpleName() + "'")
					.handled(true)
					.process(processor);

				to.ifPresent(route::to);

				route.end();
			}
		}
	}

	@Getter
	@RequiredArgsConstructor
	public static class Routes extends RouteBuilder {
		private final Set<AbstractRoute> abstractRoutes;

		@Override
		public void configure() throws Exception {
			for (final var adapter : abstractRoutes) {
				final var description = adapter.description()
					.orElse("Implementation of '" + adapter.getClass().getSimpleName() + "'");

				final var route = from(adapter.from())
					.id(adapter.id())
					.description(description)
					.routeConfigurationId(ROUTES_MAIN_CONFIGURATION);

				final var entrypoint = adapter.entrypoint();

				if (entrypoint.isPresent()) {
					final var processor = entrypoint.get();
					processor.setCamelContext(getCamelContext());
					processor.setRouteId(route.getId());

					route
						.setProperty("entrypoint", simple(processor.getClass().getSimpleName()))
						.log("Processing request content with entrypoint {entrypoint}")
						.process(processor);
				}

				final var exitpoint = adapter.exitpoint();
				if (exitpoint.isPresent()) {
					final var processor = exitpoint.get();
					route
						.setProperty("exitpoint", simple(processor.getClass().getSimpleName()))
						.onCompletion()
						.log("Processing request content with exitpoint {exitpoint}")
						.process();
				}

				adapter.configure(route);
			}
		}
	}
}
