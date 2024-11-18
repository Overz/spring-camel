package com.github.overz.camel.shared.context;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.InitializingBean;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class WorkflowContextInitializer implements Processor, InitializingBean {
	@Override
	public void process(Exchange exchange) throws Exception {
		var opt = Optional.ofNullable(exchange.getIn().getBody(WorkflowContext.class));
		var ctx = opt.orElse(new WorkflowContext());
		if (opt.isEmpty()) {
			exchange.getFromRouteId();
		}

		exchange.setProperty(WorkflowConstants.CONTEXT_PROPERTY, ctx);
	}

	@Override
	public void afterPropertiesSet() throws Exception {

	}
}
