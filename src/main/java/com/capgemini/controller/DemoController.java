package com.capgemini.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController implements DemoContract{
	

	@Override
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> createUser(@RequestBody final Object body) {
		// Implementation goes here
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
