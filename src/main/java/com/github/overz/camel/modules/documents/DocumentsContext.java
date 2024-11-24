package com.github.overz.camel.modules.documents;

import com.github.overz.thymeleaf.dto.DocumentEncodedDTO;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DocumentsContext {
	public DocumentEncodedDTO base64;
}
