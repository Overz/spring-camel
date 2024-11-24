package com.github.overz.camel.modules.books.usecases.create;

import com.github.overz.camel.modules.books.configs.BookRoutesPreset;
import com.github.overz.camel.modules.books.constants.Routes;
import com.github.overz.camel.modules.books.usecases.create.processors.CreateBookEntryPointProcessor;
import com.github.overz.camel.modules.books.usecases.create.processors.CreateBookExitPointProcessor;
import com.github.overz.camel.modules.books.usecases.create.processors.CreateBookRequestProcessor;
import com.github.overz.camel.shared.processors.AbstractProcessor;
import com.github.overz.camel.shared.routes.AbstractRoute;
import lombok.RequiredArgsConstructor;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.RouteDefinition;

import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
public class CreateBookRouter extends AbstractRoute {
	private final CreateBookEntryPointProcessor createBookEntryPointProcessor;
	private final CreateBookExitPointProcessor createBookExitPointProcessor;
	private final CreateBookRequestProcessor createBookRequestProcessor;

	@Override
	public String from() {
		return Routes.ROUTE_CREATE_BOOK;
	}

	@Override
	public Optional<AbstractProcessor> entrypoint() {
		return Optional.of(createBookEntryPointProcessor);
	}

	@Override
	public Optional<AbstractProcessor> exitpoint() {
		return Optional.of(createBookExitPointProcessor);
	}

	@Override
	public Optional<String> description() {
		return Optional.empty();
	}

	@Override
	public void configure(final RouteDefinition route) {
		route.routeConfigurationId(BookRoutesPreset.ROUTES_BOOKS_CONFIGURATION)
			.log("Creating request for a new book")
			.process(createBookRequestProcessor)
			.marshal(new JacksonDataFormat(Map.class))
			.log("Body: ${body}")
			.end()
		;
	}
}
