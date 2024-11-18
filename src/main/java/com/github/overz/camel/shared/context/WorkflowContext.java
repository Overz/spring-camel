package com.github.overz.camel.shared.context;

import com.github.overz.camel.shared.enums.Modules;
import lombok.*;
import org.apache.camel.CamelContext;
import org.apache.camel.CamelContextAware;
import org.apache.camel.Exchange;
import org.apache.camel.Traceable;
import org.apache.camel.spi.IdAware;
import org.apache.camel.spi.RouteIdAware;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Shared context for more visibility and easy understanding
 * about what is being used in all flows/routes
 * <p>
 * DO NOT ADD ANY SPECIFIC DATA FROM MODULES.
 */
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WorkflowContext implements Traceable, RouteIdAware, CamelContextAware {
	private String routeId;
	private CamelContext camelContext;

	private Map<Modules, Object> shared = new ConcurrentHashMap<>();
	private Object response;
	private Object error;

	@Override
	public void setCamelContext(CamelContext camelContext) {
		this.camelContext = camelContext;
	}

	@Override
	public String getTraceLabel() {
		return "workflowContext[%s]".formatted(getClass().getSimpleName());
	}

	@Override
	public CamelContext getCamelContext() {
		return this.camelContext;
	}

	@Override
	public String getRouteId() {
		return this.routeId;
	}

	@Override
	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}
}
