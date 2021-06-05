package com.example.axon.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.example.axon.command.CreateOrderCommand;
import com.example.axon.event.CreateOrderEvent;

@Aggregate
public class OrderAggregate {
	@AggregateIdentifier
	private String orderId;
	private Double orderAmount;
	
	public OrderAggregate() {}
	
	@CommandHandler
	public OrderAggregate(CreateOrderCommand command) {
		CreateOrderEvent event = new CreateOrderEvent(command.getOrderId(), command.getOrderAmount());
		AggregateLifecycle.apply(event);
	}
	
	@EventSourcingHandler
	public void on(CreateOrderEvent event) {
		this.orderId = event.getOrderId();
		this.orderAmount = event.getOrderAmount();
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}
}
