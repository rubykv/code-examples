package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigServerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerAppApplication.class, args);
	}

}
