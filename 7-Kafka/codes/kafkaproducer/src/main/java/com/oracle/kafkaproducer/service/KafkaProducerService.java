package com.oracle.kafkaproducer.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
	private static final String TOPIC = "message-topic";

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String message) {
		CompletableFuture<SendResult<String, String>> task = kafkaTemplate.send(TOPIC, message);
		task.whenComplete((SendResult<String, String> result, Throwable ex) -> {
			if (ex == null) {
				System.out.println(
						"Sent Message=[" + message + "] with offeset=[" + result.getRecordMetadata().offset() + "]");
			} else {
				System.out.println("Unable to end message=[" + message + "] due to: " + ex.getMessage());
			}
		});
	}
}
