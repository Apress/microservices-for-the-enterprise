package com.apress.ch04.sample07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.apress.ch04.sample07.model.Order;

@Service
public class OrderPublisher {
	
	@Autowired
	private Source source;
	
	public void publish(Order order) {
		source.output().send(MessageBuilder.withPayload(order).build());
	}

}
