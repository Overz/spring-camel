package com.github.overz.camel.shared.processors;

import lombok.NoArgsConstructor;
import org.apache.camel.CamelContext;
import org.apache.camel.CamelContextAware;
import org.apache.camel.Processor;
import org.apache.camel.Traceable;
import org.apache.camel.spi.IdAware;
import org.apache.camel.spi.RouteIdAware;

import java.util.UUID;

@NoArgsConstructor
public abstract class AbstractProcessor implements Traceable, IdAware, RouteIdAware, CamelContextAware, Processor {
	private String id = UUID.randomUUID().toString();
	private String routeId;
	private CamelContext camelContext;

	public abstract String name();

	@Override
	public String getTraceLabel() {
		return "processor[%s-%s]".formatted(getRouteId(), name());
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public String getRouteId() {
		return this.routeId;
	}

	@Override
	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	@Override
	public void setCamelContext(CamelContext camelContext) {
		this.camelContext = camelContext;
	}

	@Override
	public CamelContext getCamelContext() {
		return this.camelContext;
	}
}
