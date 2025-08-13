package com.oracle.kafkaproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.kafkaproducer.models.Employee;
import com.oracle.kafkaproducer.service.KafkaProducerService;

@RestController
public class KafkaProducerController {
	
	@Autowired
	private KafkaProducerService producerService;

	//http://localhost:8081/send-message?message=HelloKafka
	@GetMapping("/send-message")
	public ResponseEntity<String> publishMessage(@RequestParam String message){
		try {
			producerService.sendMessage(message);
			return new ResponseEntity<>("Message Sent",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Message Not Sent because "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//POST
	//http://localhost:8081/send-employee
	@PostMapping("/send-employee")
	public ResponseEntity<String> publishEmployee(@RequestBody Employee data){
		try {
			producerService.sendEmployeeData(data);
			return new ResponseEntity<>("Emloyee data Sent",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Emloyee data Not Sent because "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
