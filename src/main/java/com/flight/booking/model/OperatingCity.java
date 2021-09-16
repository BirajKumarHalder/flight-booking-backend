package com.flight.booking.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OperatingCity {

	private Integer cityId;
	private String cityCode;
	private String cityName;
	private boolean active;
	private String updatedBy;
	private String updatedOn;

}
