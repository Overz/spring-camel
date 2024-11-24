package com.github.overz.camel.modules.documents.configs;


import com.github.overz.camel.modules.documents.usecases.base64.DocumentsBase64Router;
import com.github.overz.camel.modules.documents.usecases.base64.processors.DocumentBase64EntryPointProcessor;
import com.github.overz.camel.modules.documents.usecases.base64.processors.DocumentBase64ExitPointProcessor;
import com.github.overz.camel.modules.documents.usecases.base64.processors.DocumentBase64RequestProcessor;
import com.github.overz.camel.shared.routes.AbstractRoutePreset;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Configuration;
import org.springframework.context.annotation.Bean;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class DocumentsConfig {
	@Bean
	public AbstractRoutePreset documentsRoutePreset() {
		return new DocumentsRoutesPreset();
	}

	@Bean
	public DocumentsBase64Router documentsBase64Router() {
		return new DocumentsBase64Router(
			new DocumentBase64EntryPointProcessor(),
			new DocumentBase64ExitPointProcessor(),
			new DocumentBase64RequestProcessor()
		);
	}
}
