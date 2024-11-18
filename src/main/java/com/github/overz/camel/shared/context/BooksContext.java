package com.github.overz.camel.shared.context;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BooksContext {
	private Object book;
	private List<Object> books;
}
