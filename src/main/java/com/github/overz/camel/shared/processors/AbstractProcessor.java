package com.github.overz.camel.shared.processors;

import lombok.NoArgsConstructor;
import org.apache.camel.CamelContext;
import org.apache.camel.CamelContextAware;
import org.apache.camel.Traceable;
import org.apache.camel.spi.IdAware;
import org.apache.camel.spi.RouteIdAware;

@NoArgsConstructor
public abstract class AbstractProcessor implements Traceable, IdAware, RouteIdAware, CamelContextAware {
	private String id;
	private String routeId;
	private CamelContext camelContext;

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
