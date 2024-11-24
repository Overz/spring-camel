package com.github.overz.camel.modules.documents.usecases.base64;

import com.github.overz.camel.modules.documents.configs.DocumentsRoutesPreset;
import com.github.overz.camel.modules.documents.constants.Routes;
import com.github.overz.camel.modules.documents.usecases.base64.processors.DocumentBase64EntryPointProcessor;
import com.github.overz.camel.modules.documents.usecases.base64.processors.DocumentBase64ExitPointProcessor;
import com.github.overz.camel.modules.documents.usecases.base64.processors.DocumentBase64RequestProcessor;
import com.github.overz.camel.shared.processors.AbstractProcessor;
import com.github.overz.camel.shared.routes.AbstractRoute;
import lombok.RequiredArgsConstructor;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.RouteDefinition;

import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
public class DocumentsBase64Router extends AbstractRoute {
	private final DocumentBase64EntryPointProcessor documentBase64EntryPointProcessor;
	private final DocumentBase64ExitPointProcessor documentBase64ExitPointProcessor;
	private final DocumentBase64RequestProcessor documentBase64RequestProcessor;

	@Override
	public String from() {
		return Routes.ROUTE_BASE64_DOCUMENTS;
	}

	@Override
	public Optional<AbstractProcessor> entrypoint() {
		return Optional.of(documentBase64EntryPointProcessor);
	}

	@Override
	public Optional<AbstractProcessor> exitpoint() {
		return Optional.of(documentBase64ExitPointProcessor);
	}

	@Override
	public Optional<String> description() {
		return Optional.empty();
	}

	@Override
	public void configure(final RouteDefinition route) {
		route.routeConfigurationId(DocumentsRoutesPreset.ROUTES_DOCUMENTS_CONFIGURATION)
			.log("Creating request for recovery base64 document")
			.process(documentBase64RequestProcessor)
			.marshal(new JacksonDataFormat(Map.class))
			.log("Body: ${body}")
			.end()
		;
	}
}
