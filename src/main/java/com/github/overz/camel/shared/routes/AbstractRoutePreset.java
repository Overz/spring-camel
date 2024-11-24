package com.github.overz.camel.shared.routes;

import org.apache.camel.model.RouteConfigurationDefinition;

import java.util.Set;

public abstract class AbstractRoutePreset {
	public abstract String configurationId();

	public abstract Set<AbstractError> errors();

	public abstract void configure(final RouteConfigurationDefinition config);
}
