package com.github.overz.camel.modules.books.configs;

import com.github.overz.camel.modules.books.routes.BookRouter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class BooksConfig {

	@Bean
	public BookRouter bookRouter() {
		return new BookRouter();
	}
}
