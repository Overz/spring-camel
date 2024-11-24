package com.github.overz.camel.shared.routes;

import org.apache.camel.Processor;

import java.util.Optional;

interface Error extends Base {
	Class<? extends Throwable> throwable();

	Processor processor();

	Optional<String> to();
}
