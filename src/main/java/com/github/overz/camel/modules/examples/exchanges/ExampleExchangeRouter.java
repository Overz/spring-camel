package com.github.overz.camel.modules.examples.exchanges;

import com.github.overz.camel.modules.examples.exchanges.inbound.ExampleToOthersInbound;
import com.github.overz.camel.modules.examples.exchanges.outbound.ExampleToOthersOutbound;
import com.github.overz.camel.shared.context.WorkflowConstants;
import lombok.RequiredArgsConstructor;
import org.apache.camel.builder.RouteBuilder;

import java.util.List;

/**
 * Example adapter any data to inside/outside router module
 */
@RequiredArgsConstructor
public class ExampleExchangeRouter extends RouteBuilder {
	private final List<RouteAdapterConfiguration> inbounds = List.of(
		new ExampleToOthersInbound()
	);

	private final List<RouteAdapterConfiguration> outbounds = List.of(
		new ExampleToOthersOutbound()
	);

	@Override
	public void configure() throws Exception {
		for (var config : inbounds) {
			var route = from(config.from())
				.id(config.id())
				.description(config.description().orElse("Should process any inbound data incoming"))
				.log("incoming event from '" + WorkflowConstants.SOURCE_ROUTE_VALUE + "' and redirecting to '" + WorkflowConstants.TARGET_ROUTE_VALUE + "'");

			config.configure(route);
		}

		for (var config : outbounds) {
			var route = from(config.from())
				.id(config.id())
				.description(config.description().orElse("Should process any outbound data outgoing"))
				.log("ongoing event from '" + WorkflowConstants.SOURCE_ROUTE_VALUE + "' and redirecting to '" + WorkflowConstants.TARGET_ROUTE_VALUE + "'");

			config.configure(route);
		}
	}
}
