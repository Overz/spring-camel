package com.github.overz.camel.shared.routes;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.stream.Collectors;


@NoArgsConstructor(access = AccessLevel.NONE)
public class RoutesDefinitions {

	/**
	 * Create an ID based on 'from' used in the route
	 */
	public static String getId(final String from) {
		return from.substring(from.indexOf(':') + 1);
	}

	/**
	 * Helpful function to get exchange property
	 * in camel context route
	 */
	public static String exP(final String v) {
		return "${exchangeProperty." + v + "}";
	}

	/**
	 * Helpful function to get many exchanges properties
	 * in camel context route
	 */
	public static String multExP(final String... v) {
		return Arrays.stream(v)
			.map(RoutesDefinitions::exP)
			.collect(Collectors.joining(","))
			;
	}
}
