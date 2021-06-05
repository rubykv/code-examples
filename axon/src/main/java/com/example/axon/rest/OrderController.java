package com.example.axon.rest;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.axon.command.CreateOrderCommand;
import com.example.axon.domain.Order;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrderController {
	
	@Autowired
	private CommandGateway commandGateway;
	
	@PostMapping("/order")
	public ResponseEntity<Void> createOrder(@RequestBody Order order){
		CreateOrderCommand command = new CreateOrderCommand(order.getOrderId(), order.getOrderAmount());
		 commandGateway.send(command);
		 return ResponseEntity.ok().build();
	}
}
