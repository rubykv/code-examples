package com.example.axon.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Value;

@Value
public class CreateOrderCommand {
	
	@TargetAggregateIdentifier
	private final String orderId;
	
	private final Double orderAmount;

}
