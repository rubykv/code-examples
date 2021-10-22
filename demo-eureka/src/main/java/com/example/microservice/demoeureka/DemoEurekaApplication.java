package com.example.microservice.demoeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DemoEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoEurekaApplication.class, args);
	}
}
