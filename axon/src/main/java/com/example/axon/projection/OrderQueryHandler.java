package com.example.axon.projection;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.axon.domain.Order;
import com.example.axon.event.CreateOrderEvent;
import com.example.axon.repository.OrderRepository;

@Component
public class OrderQueryHandler {

	@Autowired
	private OrderRepository orderRepository;

	@EventHandler
	public void on(CreateOrderEvent event) {
		orderRepository.storeOrder(new Order(event.getOrderId(), null, event.getOrderAmount()));
	}
}
