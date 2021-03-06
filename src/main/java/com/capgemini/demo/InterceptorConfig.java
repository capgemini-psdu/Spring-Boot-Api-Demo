package com.capgemini.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.capgemini.psdu.presentation.HeaderAmenderInterceptor;

@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

	@Bean
	public HeaderAmenderInterceptor headerAmenderInterceptor() {
		return new HeaderAmenderInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(headerAmenderInterceptor());
	}

}
