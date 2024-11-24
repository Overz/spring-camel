package com.github.overz.camel.infra.configs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class SerializationConfig {

	@Bean
	public ObjectMapper objectMapper() {
		return JsonMapper.builder()
			.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
			.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
			.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
			.build()
			.setDefaultPropertyInclusion(JsonInclude.Include.NON_EMPTY)
			;
	}
}
