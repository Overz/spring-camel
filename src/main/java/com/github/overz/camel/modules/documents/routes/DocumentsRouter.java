package com.github.overz.camel.modules.documents.routes;

import com.github.overz.camel.dto.GetTest200ResponseDTO;
import com.github.overz.camel.shared.context.WorkflowConstants;
import com.github.overz.camel.shared.routes.RoutesDefinitions;
import lombok.RequiredArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.RouteDefinition;

@RequiredArgsConstructor
public class DocumentsRouter extends RouteBuilder {
	@Override
	public void configure() throws Exception {
		// @formatter:off
//		interceptFrom()
//			.choice()
//				.when(exchangeProperty(WorkflowConstants.CONTEXT_PROPERTY).isNull())
//					.process(new WorkflowContextProcessor())
//			.end()
//		;
		// @formatter:on

		// @formatter:off
		from(WorkflowConstants.FLOW_ROUTE)
			.log("${id} - Documents")
			.id(RoutesDefinitions.getId(WorkflowConstants.FLOW_ROUTE))
			.routeConfigurationId(WorkflowConstants.ROUTE_CONFIGURATION)
			.setBody(exchange -> new GetTest200ResponseDTO().ok(true))
			.end()
		;
		// @formatter:on
	}
}
