package com.github.overz.camel.modules.books.usecases.update.processors;

import com.github.overz.camel.shared.processors.AbstractProcessor;
import lombok.RequiredArgsConstructor;
import org.apache.camel.Exchange;

@RequiredArgsConstructor
public class UpdateBookExitPointProcessor extends AbstractProcessor {
	@Override
	public String name() {
		return getClass().getSimpleName();
	}

	@Override
	public void process(Exchange exchange) throws Exception {

	}
}
