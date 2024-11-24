package com.github.overz.camel.infra.configs;

import com.github.overz.camel.infra.camel.MainRoutePreset;
import com.github.overz.camel.infra.camel.RoutesSetup.Preset;
import com.github.overz.camel.infra.camel.RoutesSetup.Routes;
import com.github.overz.camel.shared.routes.AbstractRoute;
import com.github.overz.camel.shared.routes.AbstractRoutePreset;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class CamelConfig {
	@Bean
	public AbstractRoutePreset mainRoutePreset() {
		return new MainRoutePreset();
	}

	@Bean
	public Preset config(Set<AbstractRoutePreset> presets) {
		return new Preset(presets);
	}

	@Bean
	public Routes routes(Set<AbstractRoute> routes) {
		return new Routes(routes);
	}
}
