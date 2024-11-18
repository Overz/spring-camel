package com.github.overz.camel.modules.documents.configs;

import com.github.overz.camel.modules.documents.routes.DocumentsRouter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class DocumentsConfig {
	@Bean
	public DocumentsRouter documentsRouter() {
		return new DocumentsRouter();
	}

}
