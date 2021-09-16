package com.flight.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flight.booking.model.User;
import com.flight.booking.service.AuthService;

@RestController
@RequestMapping("user")
@CrossOrigin
public class AuthController {

	@Autowired
	private AuthService authService;

	@PostMapping("signin")
	public String signIn(@RequestHeader(name = "password", required = true) String password,
			@RequestParam(name = "signInId", required = true) String signInId) {
		return authService.signIn(signInId, password);
	}

	@PostMapping("signup")
	public String signUp(@RequestHeader(name = "password", required = true) String password, @RequestBody User userRq) {
		return authService.signUp(userRq, password);
	}

	@PostMapping("signout")
	public void signOut(@RequestHeader String accessToken) {
		authService.signOut(accessToken);
	}

	@PutMapping("update-details")
	public User updateUserDetails(@RequestBody User userRq) {
		return authService.updateUserDetails(userRq);
	}

	@PutMapping("update-pasword")
	public void updatePassword(@RequestHeader(name = "password", required = true) String password,
			@RequestParam(name = "userId", required = true) Integer userId) {
		authService.updatePassword(userId, password);
	}

}
