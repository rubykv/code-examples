package com.example.alibaba.example.service;

import org.springframework.stereotype.Service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;

@Service
public class TestService {

	@SentinelResource(value = "getResponseFromFallback", fallback = "fallbackTestMethod", defaultFallback = "defaultFallback")
	public String getResponseFromFallback(int i) {
		if (i == 0) {
			throw new IllegalArgumentException("Error occurred");
		}
		return "success";
	}

	public String fallbackTestMethod(int s, Throwable ex) {
		return "success from fallback";
	}

	public String defaultFallback() {
		return "default_fallback";
	}

}
