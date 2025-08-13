package com.oracle.kafkaconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.kafkaconsumer.service.KafkaConsumerService;

@RestController
public class KafkaConsumerController {
	
	@Autowired
	private KafkaConsumerService consumerService;
	
	public ResponseEntity<String> getPublishedMessage(){
		try {
			String message = consumerService.getMessage();
			return new ResponseEntity<String>(message,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("no data recevied", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
