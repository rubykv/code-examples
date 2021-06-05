package com.example.axon.repository;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.example.axon.domain.Order;

@Repository
public class OrderRepository {
	
	private static HashMap<String,Order> orderStore = new HashMap<>();
	
	public void storeOrder(Order order) {
		orderStore.put(order.getOrderId(), order);
		System.out.println("order added to repository:::: Current map values ");
		orderStore.forEach((k,v) -> System.out.println(v));
	}
}
