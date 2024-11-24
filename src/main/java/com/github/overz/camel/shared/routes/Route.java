package com.github.overz.camel.shared.routes;

import com.github.overz.camel.shared.processors.AbstractProcessor;

import java.util.Optional;

interface Route extends Base {
	String from();

	Optional<AbstractProcessor> entrypoint();

	Optional<AbstractProcessor> exitpoint();
}
