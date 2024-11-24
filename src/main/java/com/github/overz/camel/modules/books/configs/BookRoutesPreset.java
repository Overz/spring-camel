package com.github.overz.camel.modules.books.configs;

import com.github.overz.camel.modules.books.BookContext;
import com.github.overz.camel.modules.books.constants.Routes;
import com.github.overz.camel.shared.routes.AbstractError;
import com.github.overz.camel.shared.routes.AbstractRoutePreset;
import lombok.RequiredArgsConstructor;
import org.apache.camel.model.RouteConfigurationDefinition;

import java.util.Set;

@RequiredArgsConstructor
public class BookRoutesPreset extends AbstractRoutePreset {
	public static final String ROUTES_BOOKS_CONFIGURATION = "routes-books-configuration";

	@Override
	public String configurationId() {
		return ROUTES_BOOKS_CONFIGURATION;
	}

	@Override
	public Set<AbstractError> errors() {
		return Set.of();
	}

	@Override
	public void configure(RouteConfigurationDefinition config) {
		config.interceptFrom()
			.log("Intercepting book router")
			.process(exchange -> {
				var ctx = exchange.getProperty(Routes.CONTEXT_BOOK, new BookContext(), BookContext.class);
				exchange.setProperty(Routes.CONTEXT_BOOK, ctx);
			})
			.end()
		;
	}
}
