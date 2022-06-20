package com.flightapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entity.Flight;
import com.flightapp.service.FlightServiceImpl;

@RestController
@RequestMapping("/admin")
public class FlightController {
	@Autowired
	private FlightServiceImpl flightService;
	
	@PostMapping("/addFlight")
	public String addFlight(@RequestBody Flight flight) {
		flightService.addFlight(flight);
		System.out.println(flight.getEstimatedDepartureTime());
		return "Flight added successfully";		
	}
}
