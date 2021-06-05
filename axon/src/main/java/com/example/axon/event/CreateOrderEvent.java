package com.example.axon.event;

import lombok.Value;

@Value
public class CreateOrderEvent {
	private final String orderId;
	
	private final Double orderAmount;
}
