package com.example.kafka.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class SpringKafkaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaDemoApplication.class, args);
	}
}
