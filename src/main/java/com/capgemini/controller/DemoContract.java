package com.capgemini.controller;

import org.springframework.http.ResponseEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "/user", tags = { "User Operations" })
public interface DemoContract {
	
	@ApiOperation(value = "Create user", notes = "", response = Void.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "User created"),
			@ApiResponse(code = 400, message = "Invalid user supplied"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	ResponseEntity<Void> createUser(@ApiParam(value = "User to be created", required = true) final Object body);


}
