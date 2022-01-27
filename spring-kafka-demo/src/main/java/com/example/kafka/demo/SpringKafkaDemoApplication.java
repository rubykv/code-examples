package com.example.kafka.demo;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class SpringKafkaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaDemoApplication.class, args);
	}
	
	@Bean
	public NewTopic sampleTopic() {
		return new NewTopic("sample-topic4", 1, (short) 1);
	}
	
}
