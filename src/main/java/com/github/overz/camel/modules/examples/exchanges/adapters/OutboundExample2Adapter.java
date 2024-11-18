package com.github.overz.camel.modules.examples.exchanges.adapters;

import com.github.overz.camel.shared.processors.AbstractProcessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

@Slf4j
@RequiredArgsConstructor
public class OutboundExample2Adapter extends AbstractProcessor implements Processor {
	@Override
	public void process(Exchange exchange) throws Exception {
		// some logic to adapt the outbound content
	}

	@Override
	public String getTraceLabel() {
		return "adapter[%s]".formatted(getClass().getSimpleName());
	}
}
