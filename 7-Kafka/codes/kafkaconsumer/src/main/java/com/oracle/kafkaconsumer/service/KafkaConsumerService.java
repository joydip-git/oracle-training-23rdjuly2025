package com.oracle.kafkaconsumer.service;

import org.springframework.boot.context.properties.bind.Name;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.oracle.kafkaconsumer.models.Employee;

@Service
public class KafkaConsumerService {

	private String message;
	private Employee data;

	@KafkaListener(topics = "message-topic", groupId = "consumer-group-1", containerFactory = "StringListenerBean")
	public void consumeMessage(String message) {
		System.out.println("Received: " + message);
		this.message = message;
	}

	@KafkaListener(topics = "emp-data-topic", groupId = "consumer-group-1", containerFactory = "EmployeeListenerBean")
	public void consumeEmployee(Employee data) {
		System.out.println("Received: " + data.getName());
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public Employee getEmployee() {
		return data;
	}
}
