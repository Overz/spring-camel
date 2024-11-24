package com.github.overz.camel.shared.routes;

import java.util.UUID;

public abstract class AbstractError implements Error {
	private final String id = UUID.randomUUID().toString();

	@Override
	public String id() {
		return id;
	}
}
