package com.flight.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flight.booking.model.Flight;
import com.flight.booking.service.FlightService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("flight")
@CrossOrigin
@Api(tags = { "Flight" }, value = "flight")
public class FlightController {

	@Autowired
	private FlightService flightService;

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("secure/add-flight")
	@ApiOperation(value = "add-flight", nickname = "add-flight", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({ @ApiResponse(code = 200, message = "Ok", response = Flight.class, responseContainer = "List") })
	public List<Flight> addFlights(@RequestHeader("AccessToken") String token, @RequestBody List<Flight> flights) {
		return flightService.addFlights(flights);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("secure/all-flight")
	@ApiOperation(value = "all-flight", nickname = "all-flight", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({ @ApiResponse(code = 200, message = "Ok", response = Flight.class, responseContainer = "List") })
	public List<Flight> getAllFlights(@RequestHeader("AccessToken") String token,
			@RequestParam(name = "include-inactive", defaultValue = "false") String includeInactive) {
		return flightService.getAllFlights(Boolean.parseBoolean(includeInactive));
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("secure/flight-for-date")
	@ApiOperation(value = "flight-for-date", nickname = "flight-for-date", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({ @ApiResponse(code = 200, message = "Ok", response = Flight.class, responseContainer = "List") })
	public List<Flight> getFlightsForDate(@RequestHeader("AccessToken") String token,
			@RequestParam(name = "date", required = true) String date,
			@RequestParam(name = "include-inactive", defaultValue = "false") String includeInactive) {
		return flightService.getFlightsForDate(date, Boolean.parseBoolean(includeInactive));
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("secure/update-flight")
	@ApiOperation(value = "update-flight", nickname = "update-flight", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({ @ApiResponse(code = 200, message = "Ok", response = Flight.class, responseContainer = "List") })
	public List<Flight> updateFlights(@RequestHeader("AccessToken") String token, @RequestBody List<Flight> flights) {
		return flightService.updateFlights(flights);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("secure/change-flight-status")
	@ApiOperation(value = "change-flight-status", nickname = "change-flight-status", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({ @ApiResponse(code = 200, message = "Ok", response = Integer.class) })
	public Integer changeFlightStatus(@RequestHeader("AccessToken") String token,
			@RequestParam(name = "flightId", required = true) String flightId,
			@RequestParam(name = "status", required = true) String status) {
		return flightService.changeFlightStatus(Integer.parseInt(flightId), Boolean.parseBoolean(status));
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("secure/delete-flight")
	@ApiOperation(value = "delete-flight", nickname = "delete-flight", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({ @ApiResponse(code = 200, message = "Ok", response = Integer.class, responseContainer = "List") })
	public List<Integer> deleteFlights(@RequestHeader("AccessToken") String token,
			@RequestParam List<Integer> flightIds) {
		return flightService.deleteFlights(flightIds);
	}

}
