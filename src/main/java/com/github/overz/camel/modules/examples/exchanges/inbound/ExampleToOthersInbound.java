package com.github.overz.camel.modules.examples.exchanges.inbound;

import com.github.overz.camel.modules.examples.constants.ExampleConstants;
import com.github.overz.camel.modules.examples.exchanges.RouteAdapterConfiguration;
import com.github.overz.camel.modules.examples.exchanges.adapters.InboundExample1Adapter;
import com.github.overz.camel.modules.examples.exchanges.adapters.InboundExample2Adapter;
import com.github.overz.camel.shared.context.WorkflowConstants;
import lombok.RequiredArgsConstructor;
import org.apache.camel.model.RouteDefinition;

import java.util.Optional;

import static org.apache.camel.builder.Builder.exchangeProperty;

@RequiredArgsConstructor
public class ExampleToOthersInbound implements RouteAdapterConfiguration {
	@Override
	public String from() {
		return WorkflowConstants.INBOUND_EXAMPLE_TO_OTHERS;
	}

	@Override
	public String id() {
		return WorkflowConstants.INBOUND_EXAMPLE_TO_OTHERS_ID;
	}

	@Override
	public Optional<String> description() {
		return Optional.empty();
	}

	@Override
	public void configure(RouteDefinition route) {
		// @formatter:off
		route.choice()
			.when(exchangeProperty(WorkflowConstants.TARGET_ROUTE).isEqualTo(ExampleConstants.PROP_1))
				.process(new InboundExample1Adapter())
				.to("direct:some-route-1")
			.when(exchangeProperty(WorkflowConstants.TARGET_ROUTE).isEqualTo(ExampleConstants.PROP_2))
				.process(new InboundExample2Adapter())
				.to("direct:some-route-2")
			.end()
		;
		// @formatter:on
	}
}
