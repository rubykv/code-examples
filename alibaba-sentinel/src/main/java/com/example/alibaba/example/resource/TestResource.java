package com.example.alibaba.example.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.alibaba.example.service.remote.TestService;

@RestController
@RequestMapping("/api")
public class TestResource {
	
	@Autowired
	TestService testService;
	
	@GetMapping("/test")
	public ResponseEntity<String> getResponseFromFallback() {
		return new ResponseEntity<>(testService.getResponseFromFallback(0), HttpStatus.OK);
	}

}
