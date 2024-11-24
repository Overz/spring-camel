package com.github.overz.camel.modules.books.usecases.update.processors;

import com.github.overz.camel.shared.constants.HttpMethods;
import com.github.overz.camel.shared.processors.AbstractProcessor;
import com.github.overz.thymeleaf.dto.BookDTO;
import lombok.RequiredArgsConstructor;
import org.apache.camel.Exchange;

@RequiredArgsConstructor
public class UpdateBookRequestProcessor extends AbstractProcessor {
	@Override
	public String name() {
		return getClass().getSimpleName();
	}

	@Override
	public void process(Exchange exchange) throws Exception {
		exchange.getIn().removeHeaders("*");
		exchange.getIn().setHeader(Exchange.HTTP_METHOD, HttpMethods.PATCH);
		exchange.getIn().setBody(new BookDTO());
	}
}
