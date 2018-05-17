package com.capgemini.demo;


import javax.servlet.Filter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ResponseErrorHandler;
import com.capgemini.psdu.httplogger.filter.HttpRequestResponseFilter;
import com.capgemini.psdu.presentation.LoggingResponseEntityExceptionHandler;
import com.capgemini.demo.integration.FileCheckHealthIndicator;

@Configuration
public class BootConfig {

	@Value("${graphite.host}")
	private String graphiteHost;

	@Value("${graphite.port}")
	private int graphitePort;
	
	@Value("${keepalive.location}")
	private String keepAliveLocation;

	@Bean
	public LoggingResponseEntityExceptionHandler exceptionHandler() {		
		return new LoggingResponseEntityExceptionHandler();
	}

	
	@Bean
	public FileCheckHealthIndicator fileCheckHealthIndicator() {		
		return new FileCheckHealthIndicator(keepAliveLocation);
	}

	/**
	 * Stops Spring treating 4xx and 5xx received from outbound REST calls as exceptions.  
	 */
	@Bean
	public ResponseErrorHandler getResponseErrorHandler() {
		return new DefaultResponseErrorHandler() {
			@Override
			protected boolean hasError(HttpStatus statusCode) {
				return false;
			}
		};
	}
	
	/**
	 * Allows logging of request and response via logback.xml setting
	 */
	@Bean
	public Filter httpRequestResponseFilter(){
		return new HttpRequestResponseFilter();
	}
}