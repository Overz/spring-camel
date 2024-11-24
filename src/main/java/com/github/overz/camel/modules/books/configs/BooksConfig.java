package com.github.overz.camel.modules.books.configs;

import com.github.overz.camel.modules.books.usecases.create.CreateBookRouter;
import com.github.overz.camel.modules.books.usecases.create.processors.CreateBookEntryPointProcessor;
import com.github.overz.camel.modules.books.usecases.create.processors.CreateBookExitPointProcessor;
import com.github.overz.camel.modules.books.usecases.create.processors.CreateBookRequestProcessor;
import com.github.overz.camel.modules.books.usecases.update.UpdateBookRouter;
import com.github.overz.camel.modules.books.usecases.update.processors.UpdateBookEntryPointProcessor;
import com.github.overz.camel.modules.books.usecases.update.processors.UpdateBookExitPointProcessor;
import com.github.overz.camel.modules.books.usecases.update.processors.UpdateBookRequestProcessor;
import com.github.overz.camel.shared.routes.AbstractRoutePreset;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class BooksConfig {

	@Bean
	public AbstractRoutePreset bookRoutesPreset() {
		return new BookRoutesPreset();
	}

	@Bean
	public CreateBookRouter createBookRouter() {
		return new CreateBookRouter(
			new CreateBookEntryPointProcessor(),
			new CreateBookExitPointProcessor(),
			new CreateBookRequestProcessor()
		);
	}

	@Bean
	public UpdateBookRouter updateBookRouter() {
		return new UpdateBookRouter(
			new UpdateBookEntryPointProcessor(),
			new UpdateBookExitPointProcessor(),
			new UpdateBookRequestProcessor()
		);
	}
}
