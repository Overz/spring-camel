package com.github.overz.camel.modules.examples.processors;

import com.github.overz.camel.shared.processors.AbstractProcessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

@Slf4j
@RequiredArgsConstructor
public class ExampleProcessor extends AbstractProcessor implements Processor {
	@Override
	public void process(Exchange exchange) throws Exception {
		// some logic
	}

	@Override
	public String getTraceLabel() {
		return "processor[%s]".formatted(getClass().getSimpleName());
	}
}
