package com.github.overz.camel.infra.camel;

import com.github.overz.camel.shared.constants.Routes;
import com.github.overz.camel.shared.routes.AbstractError;
import com.github.overz.camel.shared.routes.AbstractRoutePreset;
import lombok.RequiredArgsConstructor;
import org.apache.camel.model.RouteConfigurationDefinition;

import java.util.Set;

@RequiredArgsConstructor
public class MainRoutePreset extends AbstractRoutePreset {
  @Override
  public String configurationId() {
    return Routes.ROUTES_MAIN_CONFIGURATION;
  }

  @Override
  public Set<AbstractError> errors() {
    return Set.of();
  }

  @Override
  public void configure(RouteConfigurationDefinition config) {
    // empty
  }
}
