package com.example.aspect;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.example.aspect.config.MyThreadFactory;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AspectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AspectApplication.class, args);
	}

	@Bean
	public ExecutorService executorService() {
		return Executors.newScheduledThreadPool(2, new MyThreadFactory());
	}
}
