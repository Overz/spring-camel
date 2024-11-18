package com.github.overz.camel.modules.examples.configs;

import com.github.overz.camel.modules.examples.routes.ExampleRouter;
import com.github.overz.camel.modules.examples.exchanges.ExampleExchangeRouter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class ExamplesConfig {
	@Bean
	public ExampleRouter exampleRouter() {
		return new ExampleRouter();
	}

	@Bean
	public ExampleExchangeRouter exchangeModuleRouter() {
		return new ExampleExchangeRouter();
	}
}
