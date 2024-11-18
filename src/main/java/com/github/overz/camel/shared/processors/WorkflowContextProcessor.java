package com.github.overz.camel.shared.processors;

import com.github.overz.camel.shared.context.WorkflowConstants;
import com.github.overz.camel.shared.context.WorkflowContext;
import com.github.overz.camel.shared.enums.Modules;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

@Slf4j
@RequiredArgsConstructor
public class WorkflowContextProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		var ctx = exchange.getProperty(WorkflowConstants.CONTEXT_PROPERTY, new WorkflowContext(), WorkflowContext.class);

		ctx.setRouteId(exchange.getFromRouteId());
		ctx.setCamelContext(exchange.getContext());
		for (var module : Modules.values()) {
			var instance = module.getCls().getDeclaredConstructor().newInstance();
			ctx.getShared().putIfAbsent(module, instance);
		}

		exchange.setProperty(WorkflowConstants.CONTEXT_PROPERTY, ctx);
	}
}
