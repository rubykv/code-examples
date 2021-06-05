package com.example.axon.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Order {
	@Id
	private String orderId;
	private String orderStatus;
	private Double orderAmount;
}
