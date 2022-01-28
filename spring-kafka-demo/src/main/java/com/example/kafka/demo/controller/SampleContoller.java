package com.example.kafka.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.demo.common.Sample;

@RestController
public class SampleContoller {
	@Autowired
	private KafkaTemplate<Object, Object> template;

	@PostMapping(path = "/send/{name}")
	public void sendFoo(@PathVariable String name) {
		this.template.send("sample-topic4", new Sample(name));
	}
}
