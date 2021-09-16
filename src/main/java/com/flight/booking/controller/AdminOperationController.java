package com.flight.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight.booking.model.OperatingCity;
import com.flight.booking.service.OperatingCityService;

@RestController
@RequestMapping("admin")
public class AdminOperationController {

	@Autowired
	private OperatingCityService operatingCityService;

	@PostMapping("add-operating-cities")
	public List<OperatingCity> addOperatingCitis(@RequestBody List<OperatingCity> operatingCities) {
		return operatingCityService.addOperatingCitis(operatingCities);
	}

	@GetMapping("all-operating-cities")
	public List<OperatingCity> getAllOperatingCities() {
		return operatingCityService.getAllOperatingCities();
	}

	@PutMapping("update-operating-cities")
	public List<OperatingCity> updateOperatingCities(@RequestBody List<OperatingCity> operatingCities) {
		return operatingCityService.updateOperatingCities(operatingCities);
	}

}
