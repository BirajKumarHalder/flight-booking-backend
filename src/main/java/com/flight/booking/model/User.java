package com.flight.booking.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

	private Integer userId;
	private String userName;
	private String email;
	private String phone;
	private boolean emailVerified;
	private String role;

}
