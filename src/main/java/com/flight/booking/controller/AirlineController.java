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

import com.flight.booking.model.Airline;
import com.flight.booking.service.AirlineService;

@RestController
@RequestMapping("flight")
@CrossOrigin
public class AirlineController {

	@Autowired
	private AirlineService airlineService;

	@PostMapping("add-airline")
	public List<Airline> addAirlines(@RequestBody List<Airline> airlines) {
		return airlineService.addAirlines(airlines);
	}

	@GetMapping("all-airlines")
	public List<Airline> getAllAirlines(
			@RequestParam(name = "include-inactive", defaultValue = "false") String includeInactive) {
		return airlineService.getAllAirlines(Boolean.parseBoolean(includeInactive));
	}

	@PutMapping("update-airlines")
	public List<Airline> updateAirlines(@RequestBody List<Airline> airlines) {
		return airlineService.updateAirlines(airlines);
	}

	@DeleteMapping("delete-airlines")
	public List<Airline> deleteAirlines(@RequestBody List<Airline> airlines) {
		return airlineService.deleteAirlines(airlines);
	}

}
