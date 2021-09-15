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
@Table(name = "flights")
public class FlightsEntity implements Serializable {

	private static final long serialVersionUID = -6889116364259577806L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "flight_id")
	private Integer flightId;

	@Column(name = "flight_number")
	private String flight_number;

	@Column(name = "start_time")
	private Timestamp startTime;

	@Column(name = "end_time")
	private Timestamp endTime;

	@Column(name = "on_sunday")
	private Boolean onSunday;

	@Column(name = "on_monday")
	private Boolean onMonday;

	@Column(name = "on_tuesday")
	private Boolean onTuesday;

	@Column(name = "on_wednesday")
	private Boolean onWednesday;

	@Column(name = "on_thursday")
	private Boolean onThursday;

	@Column(name = "on_friday")
	private Boolean onFriday;

	@Column(name = "instrument")
	private String instrument;

	@Column(name = "business_class_seats")
	private Integer businessClassSeats;

	@Column(name = "non_business_class_seats")
	private Integer nonBusinessClassSeats;

	@Column(name = "business_class_seats_price")
	private Integer businessClassSeatsPrice;

	@Column(name = "non_business_class_seat_price")
	private Integer nonBusinessClassSeatsPrice;

	@Column(name = "row_count")
	private Integer rowCount;

	@Column(name = "column_count")
	private Integer columnCount;

	@Column(name = "active")
	private Boolean active;

	@Column(name = "updated_by")
	@LastModifiedBy
	private String updatedBy;

	@Column(name = "updated_on")
	@LastModifiedDate
	private Timestamp updatedOn;

	@ManyToOne
	@JoinColumn(name = "airline", referencedColumnName = "airline_id")
	private AirlinesEntity airlines;

	@ManyToOne
	@JoinColumn(name = "from", referencedColumnName = "city_id")
	private OperatingCitiesEntity from;

	@ManyToOne
	@JoinColumn(name = "to", referencedColumnName = "city_id")
	private OperatingCitiesEntity to;

	@ManyToOne
	@JoinColumn(name = "meal", referencedColumnName = "meal_id")
	private MealsEntity meal;

	@OneToMany(mappedBy = "flight")
	private List<RoasterEntity> roasters;

}
