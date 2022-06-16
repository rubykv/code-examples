package com.example.aspect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.aspect.service.SampleService;

@RestController
@RequestMapping("/api")
public class SampleResource {
	
	@Autowired
	SampleService service;

	@GetMapping(path = "/greetings", produces = "application/json")
	public ResponseEntity<String> greetings(@RequestParam(value = "name") String name) {
		return new ResponseEntity<>(service.sampleAsyncCall(name), HttpStatus.OK);
	}
}
