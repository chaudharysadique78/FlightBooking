package com.flightapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entity.Airline;
import com.flightapp.service.AirlineServiceImpl;

@RestController
@RequestMapping("/admin")
public class AirlineController {
	@Autowired
	private AirlineServiceImpl airlineSevice;

	@PostMapping("/addAirline")
	public String addAirline(@RequestBody Airline airline) {
		try {
			airlineSevice.addAirline(airline);
			return "Airline added successfully";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Airline already added";
	}
}
