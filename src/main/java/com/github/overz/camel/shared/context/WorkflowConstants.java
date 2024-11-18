package com.github.overz.camel.shared.context;

import com.github.overz.camel.shared.routes.RoutesDefinitions;
import lombok.experimental.UtilityClass;

/**
 * Dedicated class of constants about the CONTEXT and only the CONTEXT
 */
@UtilityClass
public class WorkflowConstants {
	public final String ROUTE_CONFIGURATION = "main-route-configuration";
	public final String FLOW_ROUTE = "direct:getTest";
	public final String FLOW_BOOK = "direct:book-route";
	public final String CONTEXT_PROPERTY = "context-property";

	public final String INBOUND_EXAMPLE_TO_OTHERS = "direct:inbound-example-to-others";
	public final String INBOUND_EXAMPLE_TO_OTHERS_ID = RoutesDefinitions.getId(INBOUND_EXAMPLE_TO_OTHERS);
	public final String OUTBOUND_EXAMPLE_TO_OTHERS = "direct:outbound-example-to-others";
	public final String OUTBOUND_EXAMPLE_TO_OTHERS_ID = RoutesDefinitions.getId(OUTBOUND_EXAMPLE_TO_OTHERS);

	public final String INBOUND_BOOKS_TO_DOCUMENT = "direct:inbound-books-to-document";
	public final String OUTBOUND_BOOKS_TO_DOCUMENT = "direct:outbound-books-to-document";

	public final String INBOUND_DOCUMENTS_TO_BOOKS = "direct:inbound-documents-to-books";
	public final String OUTBOUND_DOCUMENTS_TO_BOOKS = "direct:outobund-documents-to-books";

	public final String TARGET_ROUTE = "direct:target-route";
	public final String TARGET_ROUTE_VALUE = RoutesDefinitions.exP("target-route-value");
	public final String SOURCE_ROUTE = "direct:source-route";
	public final String SOURCE_ROUTE_VALUE = RoutesDefinitions.exP("source-route-value");

}
