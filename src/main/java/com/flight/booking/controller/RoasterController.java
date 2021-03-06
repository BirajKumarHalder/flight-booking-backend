package com.flight.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flight.booking.model.Roaster;
import com.flight.booking.service.RoasterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("flight")
@CrossOrigin
@Api(tags = { "Roaster" }, value = "roaster")
public class RoasterController {

	@Autowired
	private RoasterService roasterService;

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("secure/schedule-roaster")
	@ApiOperation(value = "schedule-roaster", nickname = "schedule-roaster", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({ @ApiResponse(code = 200, message = "Ok", response = Roaster.class, responseContainer = "List") })
	public List<Roaster> scheduleRoaster(@RequestHeader("AccessToken") String token,
			@RequestBody List<Roaster> roasters) {
		return roasterService.scheduleRoaster(roasters);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("secure/roaster-for-date")
	@ApiOperation(value = "roaster-for-date", nickname = "roaster-for-date", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({ @ApiResponse(code = 200, message = "Ok", response = Roaster.class, responseContainer = "List") })
	public List<Roaster> getRoastersForDate(@RequestHeader("AccessToken") String token,
			@RequestParam(name = "date", required = true) String date) {
		return roasterService.getRoastersForDate(date);
	}

}
