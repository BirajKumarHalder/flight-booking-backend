package com.flight.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.booking.model.Flight;
import com.flight.booking.repository.FlightRepository;

@Service
public class FlightService {

	@Autowired
	private FlightRepository flightRepository;

	public List<Flight> addFlights(List<Flight> flights) {
		return null;
	}

	public List<Flight> getAllFlights(boolean parseBoolean) {
		return null;
	}

	public List<Flight> updateFlights(List<Flight> flights) {
		return null;
	}

	public List<Flight> deleteFlights(List<Flight> flights) {
		return null;
	}

}
