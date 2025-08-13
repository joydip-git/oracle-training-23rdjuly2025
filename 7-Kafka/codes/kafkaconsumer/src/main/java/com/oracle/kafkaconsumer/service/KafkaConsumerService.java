package com.oracle.kafkaconsumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

	private String message;
	
	@KafkaListener(topics = "message-topic", groupId = "consumer-group-1")
	public void consume(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
