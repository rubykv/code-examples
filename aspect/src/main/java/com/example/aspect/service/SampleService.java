package com.example.aspect.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.instrument.async.TraceableExecutorService;
import org.springframework.stereotype.Service;

@Service
public class SampleService {
	Logger logger = LoggerFactory.getLogger(SampleService.class);

	@Autowired
	BeanFactory beanFactory;

	@Autowired
	ExecutorService executor;

	public String sampleAsyncCall(String name) {
		CompletableFuture.runAsync(() -> {
			logger.info("Inside Async Call");
		}, new TraceableExecutorService(beanFactory,executor));
		return "Hello " + name;
	}

}
