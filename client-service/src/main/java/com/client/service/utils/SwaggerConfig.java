package com.client.service.utils;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig{
	/*
	 * Configuración de Swagger para Documentación
	 * 
	 * */
	@Bean
	public GroupedOpenApi  api() {
		return GroupedOpenApi.builder()
                .group("controller-api")
                .packagesToScan("com.client.service.controller")
                .build();
	}
}
