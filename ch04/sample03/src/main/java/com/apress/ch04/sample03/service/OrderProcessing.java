package com.apress.ch04.sample03.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order")
public class OrderProcessing {

	@Value("${database.connection}")
	String dbUrl;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> checkOrderStatus(@PathVariable("id") String orderId) {
		// print the value of the dbUrl loaded from configuration server
		System.out.println("DB Url: " + dbUrl);
		return ResponseEntity.ok("{'status' : 'shipped'}");
	}
}
