package com.github.overz.camel.modules.documents.configs;

import com.github.overz.camel.modules.documents.DocumentsContext;
import com.github.overz.camel.modules.documents.constants.Routes;
import com.github.overz.camel.shared.routes.AbstractError;
import com.github.overz.camel.shared.routes.AbstractRoutePreset;
import lombok.RequiredArgsConstructor;
import org.apache.camel.model.RouteConfigurationDefinition;

import java.util.Set;

import static org.apache.camel.builder.Builder.exchangeProperty;

@RequiredArgsConstructor
public class DocumentsRoutesPreset extends AbstractRoutePreset {
	public static final String ROUTES_DOCUMENTS_CONFIGURATION = "routes-documents-configuration";

	@Override
	public String configurationId() {
		return ROUTES_DOCUMENTS_CONFIGURATION;
	}

	@Override
	public Set<AbstractError> errors() {
		return Set.of();
	}

	@Override
	public void configure(RouteConfigurationDefinition config) {
		config.interceptFrom()
			.log("Intercepting documents router")
			// @formatter:off
			.choice()
				.when(exchangeProperty(Routes.CONTEXT_DOCUMENTS).isNull())
					.process(exchange -> {
						var ctx = exchange.getProperty(Routes.CONTEXT_DOCUMENTS, new DocumentsContext(), DocumentsContext.class);
						exchange.setProperty(Routes.CONTEXT_DOCUMENTS, ctx);
					})
			// @formatter:on
			.end()
		;
	}
}
