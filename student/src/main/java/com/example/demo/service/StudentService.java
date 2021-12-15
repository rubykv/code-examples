package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.remote.SubjectService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class StudentService {
	
	@Autowired
	private SubjectService subjectService;
	
	@CircuitBreaker(name = "breaker", fallbackMethod = "getStudentInfoFallback")
	public String getStudentInfo() {
		return subjectService.getSubject();
	}
	
	public String getStudentInfoFallback(Exception ex) {
		return "From fallback";
	}
}
