package com.github.overz.camel.shared.processors;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

@Slf4j
@RequiredArgsConstructor
public class ExceptionProcessor implements Processor {
	@Override
	public void process(Exchange exchange) throws Exception {
		log.error("Exception error....");
	}
}
