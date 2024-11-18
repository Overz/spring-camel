package com.github.overz.camel.infra.configs;

import com.github.overz.camel.shared.processors.ExceptionProcessor;
import com.github.overz.camel.shared.routes.WorkflowRouterConfiguration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Triple;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;
import java.util.Set;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class CamelConfig {
	@Bean
	public WorkflowRouterConfiguration workflowRouter() {
		return new WorkflowRouterConfiguration(Set.of(
			Triple.of(Exception.class, Optional.of(new ExceptionProcessor()), Optional.empty())
		));
	}
}
