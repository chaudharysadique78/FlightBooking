package com.flightapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.entity.Airline;
import com.flightapp.repository.AirlineRepo;

@Service
public class AirlineServiceImpl implements AirlineService {
	@Autowired
	private AirlineRepo airlineRepo;

	@Override
	public Long addAirline(Airline airline) {
		Airline savedAirline = airlineRepo.save(airline);
		 return savedAirline.getId();
	}

}
