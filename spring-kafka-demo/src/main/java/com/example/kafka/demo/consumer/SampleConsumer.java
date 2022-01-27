package com.example.kafka.demo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SampleConsumer {

	@KafkaListener(id = "sampleGroup", topics = "sample-topic4")
	public void foo(String object) {
		System.out.println("Received: " + object);
	}
}
