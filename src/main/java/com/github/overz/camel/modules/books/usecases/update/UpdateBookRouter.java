package com.github.overz.camel.modules.books.usecases.update;

import com.github.overz.camel.modules.books.configs.BookRoutesPreset;
import com.github.overz.camel.modules.books.constants.Routes;
import com.github.overz.camel.modules.books.usecases.update.processors.UpdateBookEntryPointProcessor;
import com.github.overz.camel.modules.books.usecases.update.processors.UpdateBookExitPointProcessor;
import com.github.overz.camel.modules.books.usecases.update.processors.UpdateBookRequestProcessor;
import com.github.overz.camel.shared.processors.AbstractProcessor;
import com.github.overz.camel.shared.routes.AbstractRoute;
import lombok.RequiredArgsConstructor;
import org.apache.camel.model.RouteDefinition;
import org.apache.camel.model.dataformat.JsonDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;

import java.util.Optional;

@RequiredArgsConstructor
public class UpdateBookRouter extends AbstractRoute {
	private final UpdateBookEntryPointProcessor updateBookEntryPointProcessor;
	private final UpdateBookExitPointProcessor updateBookExitPointProcessor;
	private final UpdateBookRequestProcessor updateBookRequestProcessor;

	@Override
	public String from() {
		return Routes.ROUTE_UPDATE_BOOK;
	}

	@Override
	public Optional<AbstractProcessor> entrypoint() {
		return Optional.of(updateBookEntryPointProcessor);
	}

	@Override
	public Optional<AbstractProcessor> exitpoint() {
		return Optional.of(updateBookExitPointProcessor);
	}

	@Override
	public Optional<String> description() {
		return Optional.empty();
	}

	@Override
	public void configure(RouteDefinition route) {
		route.routeConfigurationId(BookRoutesPreset.ROUTES_BOOKS_CONFIGURATION)
			.log("Creating request for update book")
			.process(updateBookRequestProcessor)
			.marshal(new JsonDataFormat(JsonLibrary.Jackson))
			.log("Body: ${body}")
			.end()
		;
	}
}
