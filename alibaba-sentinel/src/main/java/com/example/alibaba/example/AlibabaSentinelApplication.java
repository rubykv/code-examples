package com.example.alibaba.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan("com.example.alibaba.example")
public class AlibabaSentinelApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlibabaSentinelApplication.class, args);
	}
}
