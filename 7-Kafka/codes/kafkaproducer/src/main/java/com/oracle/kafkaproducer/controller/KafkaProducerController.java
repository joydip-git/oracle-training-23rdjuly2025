package com.oracle.kafkaproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.kafkaproducer.service.KafkaProducerService;

@RestController
public class KafkaProducerController {
	
	@Autowired
	private KafkaProducerService producerService;

	//http://loclahost:8081/send?message=HelloKafka
	@GetMapping("/send")
	public ResponseEntity<String> publishMessage(@RequestParam String message){
		try {
			producerService.sendMessage(message);
			return new ResponseEntity<>("Message Sent",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Message Not Sent because "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
