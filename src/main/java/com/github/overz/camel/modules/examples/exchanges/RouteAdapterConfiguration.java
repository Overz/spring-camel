package com.github.overz.camel.modules.examples.exchanges;

import org.apache.camel.model.RouteDefinition;

import java.util.Optional;

public interface RouteAdapterConfiguration {
	String from();

	String id();

	Optional<String> description();

	void configure(RouteDefinition route);
}
