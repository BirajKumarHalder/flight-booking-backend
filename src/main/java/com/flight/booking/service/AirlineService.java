package com.flight.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.booking.model.Airline;
import com.flight.booking.repository.AirlineRepository;

@Service
public class AirlineService {

	@Autowired
	private AirlineRepository airlineRepository;

	public List<Airline> addAirlines(List<Airline> airlines) {
		return null;
	}

	public List<Airline> getAllAirlines(boolean includeInactive) {
		return null;
	}

	public List<Airline> updateAirlines(List<Airline> airlines) {
		return null;
	}

	public List<Airline> deleteAirlines(List<Airline> airlines) {
		return null;
	}

}
