package com.github.overz.camel.shared.routes;

import org.apache.camel.model.RouteDefinition;

import java.util.Optional;

interface Base {
	String id();

	Optional<String> description();

	void configure(final RouteDefinition route);
}
