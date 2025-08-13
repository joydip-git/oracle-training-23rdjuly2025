package com.oracle.kafkaproducer.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.Name;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.oracle.kafkaproducer.models.Employee;

@Service
public class KafkaProducerService {
	private static final String MESSAGE_TOPIC = "message-topic";
	private static final String EMP_DATA_TOPIC = "emp-data-topic";

	@Autowired
	@Name("StringTemplateBean")
	private KafkaTemplate<String, String> stringKafkaTemplate;

	@Autowired
	@Name("EmployeeTemplateBean")
	private KafkaTemplate<String, Employee> empKafkaTemplate;

	public void sendMessage(String message) {
		CompletableFuture<SendResult<String, String>> task = stringKafkaTemplate.send(MESSAGE_TOPIC, message);
		task.whenComplete((SendResult<String, String> result, Throwable ex) -> {
			if (ex == null) {
				System.out.println(
						"Sent Message=[" + message + "] with offeset=[" + result.getRecordMetadata().offset() + "]");
			} else {
				System.out.println("Unable to end message=[" + message + "] due to: " + ex.getMessage());
			}
		});
	}

	public void sendEmployeeData(Employee data) {
		CompletableFuture<SendResult<String, Employee>> task = empKafkaTemplate.send(EMP_DATA_TOPIC, data);
		task.whenComplete((SendResult<String, Employee> result, Throwable ex) -> {
			if (ex == null) {
				System.out.println("Sent emp data=[" + data.getName() + "] with offeset=["
						+ result.getRecordMetadata().offset() + "]");
			} else {
				System.out.println("Unable to send data=[" + data.getName() + "] due to: " + ex.getMessage());
			}
		});
	}
}
