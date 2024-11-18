package com.github.overz.camel.shared.context;

import lombok.*;

/**
 * Data that runs through all routes inside the module Example
 * <p>
 * This context should add specific data or functions to help,
 * understanding and tracking any content between routes
 */
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ExamplesContext {
	private Object example;
}
