package com.apress.ch13.sample03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OrderProcessingApp {

	public static void main(String[] args) {
		SpringApplication.run(OrderProcessingApp.class, args);
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}


}
