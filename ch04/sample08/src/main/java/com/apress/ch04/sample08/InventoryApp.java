package com.apress.ch04.sample08;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.apress.ch04.sample08.model.Order;

@SpringBootApplication
@EnableBinding(Sink.class)
public class InventoryApp {

	public static void main(String[] args) {
		SpringApplication.run(InventoryApp.class, args);
	}

	@StreamListener(Sink.INPUT)
	public void consumeOderUpdates(Order order) {
		System.out.println(order.getOrderId());
	}
}
