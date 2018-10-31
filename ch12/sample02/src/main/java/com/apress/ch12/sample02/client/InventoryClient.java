package com.apress.ch12.sample02.client;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Component;

import com.apress.ch12.sample02.model.Item;


@Component
public class InventoryClient {

	@Autowired
	OAuth2RestTemplate restTemplate;

	public void updateInventory(Item[] items) {
		URI uri = URI.create("https://localhost:10443/inventory");
		restTemplate.put(uri, items);
	}
}
