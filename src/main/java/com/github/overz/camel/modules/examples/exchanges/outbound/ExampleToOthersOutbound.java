package com.github.overz.camel.modules.examples.exchanges.outbound;

import com.github.overz.camel.modules.examples.constants.ExampleConstants;
import com.github.overz.camel.modules.examples.exchanges.RouteAdapterConfiguration;
import com.github.overz.camel.modules.examples.exchanges.adapters.OutboundExample1Adapter;
import com.github.overz.camel.modules.examples.exchanges.adapters.OutboundExample2Adapter;
import com.github.overz.camel.shared.context.WorkflowConstants;
import lombok.RequiredArgsConstructor;
import org.apache.camel.model.RouteDefinition;

import java.util.Optional;

import static org.apache.camel.builder.Builder.exchangeProperty;

@RequiredArgsConstructor
public class ExampleToOthersOutbound implements RouteAdapterConfiguration {

	@Override
	public String from() {
		return WorkflowConstants.OUTBOUND_EXAMPLE_TO_OTHERS;
	}

	@Override
	public String id() {
		return WorkflowConstants.OUTBOUND_EXAMPLE_TO_OTHERS_ID;
	}

	@Override
	public Optional<String> description() {
		return Optional.empty();
	}

	@Override
	public void configure(RouteDefinition route) {
		// @formatter:off
		route.choice()
			.when(exchangeProperty(WorkflowConstants.SOURCE_ROUTE).isEqualTo(ExampleConstants.PROP_1))
				.process(new OutboundExample1Adapter())
				.to("direct:some-router-3")
			.when(exchangeProperty(WorkflowConstants.SOURCE_ROUTE).isEqualTo(ExampleConstants.PROP_2))
				.process(new OutboundExample2Adapter())
				.to("direct:some-route-4")
			.end()
		;
		// @formatter:on
	}
}
