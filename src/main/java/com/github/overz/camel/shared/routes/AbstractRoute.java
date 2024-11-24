package com.github.overz.camel.shared.routes;

import java.util.UUID;

public abstract class AbstractRoute implements Route {
	private final String id = UUID.randomUUID().toString();

	@Override
	public String id() {
		return id;
	}
}
