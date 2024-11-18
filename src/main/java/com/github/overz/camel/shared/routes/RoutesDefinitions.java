package com.github.overz.camel.shared.routes;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.stream.Collectors;


@UtilityClass
public class RoutesDefinitions {

	/**
	 * Create and ID base on 'from' used in the route
	 */
	public String getId(final String from) {
		return from.substring(from.indexOf(':') + 1);
	}

	/**
	 * Helpful function to get exchange property
	 * in camel context route
	 */
	public String exP(final String v) {
		return "${exchangeProperty." + v + "}";
	}

	/**
	 * Helpful function to get many exchanges properties
	 * in camel context route
	 */
	public String multExP(final String... v) {
		return Arrays.stream(v)
			.map(RoutesDefinitions::exP)
			.collect(Collectors.joining(","))
			;
	}
}
