package com.flight.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flight.booking.model.Flight;
import com.flight.booking.service.FlightService;

@RestController
@RequestMapping("flight")
@CrossOrigin
public class FlightController {

	@Autowired
	private FlightService flightService;

	@PostMapping("add-flight")
	public List<Flight> addFlights(@RequestBody List<Flight> flights) {
		return flightService.addFlights(flights);
	}

	@GetMapping("all-flight")
	public List<Flight> getAllFlights(
			@RequestParam(name = "include-inactive", defaultValue = "false") String includeInactive) {
		return flightService.getAllFlights(Boolean.parseBoolean(includeInactive));
	}

	@PutMapping("update-flight")
	public List<Flight> updateFlights(@RequestBody List<Flight> flights) {
		return flightService.updateFlights(flights);
	}

	@DeleteMapping("delete-flight")
	public List<Flight> deleteFlights(@RequestBody List<Flight> flights) {
		return flightService.deleteFlights(flights);
	}

}
