package com.github.overz.camel.modules.documents.processors;

import com.github.overz.camel.shared.context.WorkflowConstants;
import com.github.overz.camel.shared.enums.Modules;
import com.github.overz.camel.shared.context.WorkflowContext;
import com.github.overz.camel.shared.context.DocumentsContext;
import com.github.overz.camel.shared.processors.AbstractProcessor;
import lombok.RequiredArgsConstructor;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

@RequiredArgsConstructor
public class DocumentsEntrypointProcessor extends AbstractProcessor implements Processor {
	@Override
	public void process(Exchange exchange) throws Exception {
		var main = exchange.getProperty(WorkflowConstants.CONTEXT_PROPERTY, WorkflowContext.class);
		var ctx = main.getShared().putIfAbsent(Modules.DOCUMENTS, new DocumentsContext());
	}

	@Override
	public String getTraceLabel() {
		return "";
	}
}
