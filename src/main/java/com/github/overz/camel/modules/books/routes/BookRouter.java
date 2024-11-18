package com.github.overz.camel.modules.books.routes;

import com.github.overz.camel.shared.context.WorkflowConstants;
import lombok.RequiredArgsConstructor;
import org.apache.camel.builder.RouteBuilder;

@RequiredArgsConstructor
public class BookRouter extends RouteBuilder {
	@Override
	public void configure() throws Exception {
		from(WorkflowConstants.FLOW_BOOK)
			.log("${id} - Books")
			.end()
		;
	}
}
