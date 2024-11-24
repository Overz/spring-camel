package com.github.overz.camel.infra.configs;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class ApplicationConfig implements WebMvcConfigurer {
	@PostConstruct
	public void init() {
		log.info("Configuring '{}'", getClass().getSimpleName());
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/openapi/**")
			.addResourceLocations("classpath:/openapi/")
		;
	}
}
