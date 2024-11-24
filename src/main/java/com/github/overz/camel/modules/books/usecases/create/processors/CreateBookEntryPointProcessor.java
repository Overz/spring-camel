package com.github.overz.camel.modules.books.usecases.create.processors;

import com.github.overz.camel.shared.processors.AbstractProcessor;
import lombok.RequiredArgsConstructor;
import org.apache.camel.Exchange;

@RequiredArgsConstructor
public class CreateBookEntryPointProcessor extends AbstractProcessor {
	@Override
	public String name() {
		return getClass().getSimpleName();
	}

	@Override
	public void process(Exchange exchange) throws Exception {
		System.out.println("CreateBookEntryPointProcessor");
	}
}
