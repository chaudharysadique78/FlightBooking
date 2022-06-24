package com.flightapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entity.Flight;
import com.flightapp.service.FlightServiceImpl;

@RestController
@RequestMapping("/user")
public class FlightController {
	@Autowired
	FlightServiceImpl flightService;

	@GetMapping("/searchFlight/{dateOfDeparture}/{departureCity}/{arrivalCity}")
	public ResponseEntity<?> searchFlight(@PathVariable String dateOfDeparture,@PathVariable String departureCity,@PathVariable String arrivalCity ) throws Exception{ 
		List<Flight> flights = flightService.searchFlight(dateOfDeparture, departureCity, arrivalCity);
		if(flights.size()==0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Flight not found");
		}
		return 	ResponseEntity.ok(flights);
	}

}