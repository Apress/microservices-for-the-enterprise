package com.apress.ch04.sample06.service;

import java.net.URI;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.apress.ch04.sample06.InventoryClient;
import com.apress.ch04.sample06.model.Order;


@RestController
@RequestMapping(value = "/order")
public class OrderProcessing {


	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createOrder(@RequestBody Order order) {
		
		if (order != null) {
			new InventoryClient().updateItems(order.getItems());			
			order.setOrderId(UUID.randomUUID().toString());
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(order.getOrderId()).toUri();
			
			return ResponseEntity.created(location).build();
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
}
