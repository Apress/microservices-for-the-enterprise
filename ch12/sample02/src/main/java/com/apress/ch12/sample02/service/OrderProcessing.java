package com.apress.ch12.sample02.service;

import java.net.URI;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.apress.ch12.sample02.client.InventoryClient;
import com.apress.ch12.sample02.model.Item;
import com.apress.ch12.sample02.model.Order;
import com.apress.ch12.sample02.model.PaymentMethod;



@RestController
@RequestMapping(value = "/order")
public class OrderProcessing {
	

	@Autowired
	InventoryClient inventoryClient;

	@RequestMapping(value = "/{id}/status", method = RequestMethod.GET)
	public ResponseEntity<?> checkOrderStatus(@PathVariable("id") String orderId) {
		return ResponseEntity.ok("{'status' : 'shipped'}");
	}

	//@PreAuthorize("#oauth2.hasScope('bar') and hasRole('USER')")
	//@PreAuthorize("hasRole('USER')")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getOrder(@PathVariable("id") String orderId) {
		Item book1 = new Item("101", 1);
		Item book2 = new Item("103", 5);
		PaymentMethod myvisa = new PaymentMethod("VISA", "01/22", "John Doe", "201, 1st Street, San Jose, CA");
		Order order = new Order("101021", orderId, myvisa, new Item[] { book1, book2 },
				"201, 1st Street, San Jose, CA");
		return ResponseEntity.ok(order);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createOrder(@RequestBody Order order) {
		
		if (order != null) {
			inventoryClient.updateInventory(order.getItems());
			order.setOrderId(UUID.randomUUID().toString());
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(order.getOrderId()).toUri();
			
			return ResponseEntity.created(location).build();
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
}
