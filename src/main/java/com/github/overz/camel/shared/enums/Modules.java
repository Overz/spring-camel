package com.github.overz.camel.shared.enums;

import com.github.overz.camel.shared.context.BooksContext;
import com.github.overz.camel.shared.context.DocumentsContext;
import com.github.overz.camel.shared.context.ExamplesContext;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Modules {
	EXAMPLES(ExamplesContext.class),
	BOOKS(BooksContext.class),
	DOCUMENTS(DocumentsContext.class),
	;

	private final Class<?> cls;
}
