package com.github.overz.camel.modules.examples.routes;

import com.github.overz.camel.modules.examples.processors.ExampleProcessor;
import lombok.RequiredArgsConstructor;
import org.apache.camel.builder.RouteBuilder;

@RequiredArgsConstructor
public class ExampleRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// @formatter:off
		from("direct:example-route")
			.id("example-route")
			.log("Processing...")
			.process(new ExampleProcessor())
			.end()
		;
		// @formatter:on
	}
}
