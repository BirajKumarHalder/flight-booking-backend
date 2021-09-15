package com.flight.booking.repository.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "roaster")
public class RoasterEntity implements Serializable {

	private static final long serialVersionUID = 2143083037562687695L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "roaster_id")
	private Integer roasterId;

	@Column(name = "depurture")
	private Timestamp depurture;

	@Column(name = "arrival")
	private Timestamp arrival;

	@Column(name = "delay_time_in_mins")
	private Integer delay_time_in_mins;

	@Column(name = "business_class_seats_available")
	private Integer businessClassSeatsAvailable;

	@Column(name = "non_business_class_seats_available")
	private Integer nonBusinessClassSeatsAvailable;

	@Column(name = "business_class_seats_price")
	private Integer businessClassSeatsPrice;

	@Column(name = "non_business_class_seat_price")
	private Integer nonBusinessClassSeatsPrice;

	@Column(name = "remarks")
	private String remarks;

	@Column(name = "updated_by")
	@LastModifiedBy
	private String updatedBy;

	@Column(name = "updated_on")
	@LastModifiedDate
	private Timestamp updatedOn;

	@ManyToOne
	@JoinColumn(name = "flight", referencedColumnName = "flight_id")
	private FlightsEntity flight;

	@ManyToOne
	@JoinColumn(name = "from", referencedColumnName = "city_id")
	private OperatingCitiesEntity from;

	@ManyToOne
	@JoinColumn(name = "to", referencedColumnName = "city_id")
	private OperatingCitiesEntity to;

	@ManyToOne
	@JoinColumn(name = "status", referencedColumnName = "status_id")
	private RoasterStatusEntity status;

	@OneToMany(mappedBy = "roaster")
	private List<BookingsEntity> bookings;

}
