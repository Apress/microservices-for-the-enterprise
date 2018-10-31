package com.apress.ch13.sample02.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apress.ch13.sample02.model.Item;

@RestController
@RequestMapping(value = "/inventory")
public class Inventory {

	private static final Logger logger = LoggerFactory.getLogger(Inventory.class);

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> updateItems(@RequestBody Item[] items) {

		if (items == null || items.length == 0) {
			return ResponseEntity.badRequest().build();
		}
		for (Item item : items) {
			if (item != null) {
				logger.info("item code " + item.getCode());
			}
		}
		return ResponseEntity.noContent().build();
	}
}
