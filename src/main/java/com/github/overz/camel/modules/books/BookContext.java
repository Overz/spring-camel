package com.github.overz.camel.modules.books;

import com.github.overz.thymeleaf.dto.BookDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookContext {
	private List<BookDTO> books;
	private BookDTO newBookDto;
	private BookDTO updateBookDto;
}
