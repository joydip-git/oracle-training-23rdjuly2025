package com.oracle.passengerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

	@GetMapping("/{flightid}")
	public String getPassengers(@PathVariable String flightid) {
		return "passengers of flight " + flightid;
	}
}
