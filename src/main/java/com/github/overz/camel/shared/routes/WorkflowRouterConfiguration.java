package com.github.overz.camel.shared.routes;

import com.github.overz.camel.shared.context.WorkflowConstants;
import com.github.overz.camel.shared.processors.WorkflowContextProcessor;
import lombok.RequiredArgsConstructor;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteConfigurationBuilder;
import org.apache.camel.model.RouteConfigurationDefinition;
import org.apache.commons.lang3.tuple.Triple;

import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
public class WorkflowRouterConfiguration extends RouteConfigurationBuilder {
	private final Set<Triple<Class<? extends Throwable>, Optional<Processor>, Optional<String>>> errors;

	@Override
	public void configuration() throws Exception {
		final var config = routeConfiguration(WorkflowConstants.ROUTE_CONFIGURATION);
		intercept(config);
		handlers(config);
	}

	private void intercept(final RouteConfigurationDefinition config) {
		// @formatter:off
		config.interceptFrom()
			.choice()
				.when(exchangeProperty(WorkflowConstants.CONTEXT_PROPERTY).isNull())
					.process(new WorkflowContextProcessor())
			.end()
			;
		// @formatter:on
	}

	private void handlers(final RouteConfigurationDefinition config) {
		for (final var spec : errors) {
			final var throwable = spec.getLeft();

			log.info("Creating handler for exception '{}'", throwable.getSimpleName());

			if (spec.getMiddle().isEmpty()) continue;

			var handler = config.onException(throwable)
				.handled(true)
				.process(spec.getMiddle().get());

			if (spec.getRight().isEmpty()) {
				handler.end();
				continue;
			}

			handler.to(spec.getRight().get())
				.end();
		}
	}
}
