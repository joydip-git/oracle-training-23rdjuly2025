package com.oracle.flightservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/flights")
public class FlightController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/{flightid}")
	public String getFlightPassengersAndServices(@PathVariable String flightid) {
		String response = restTemplate.getForObject("http://passengerservice/passengers/" + flightid, String.class);
		return "details of flight " + response;
	}
}
