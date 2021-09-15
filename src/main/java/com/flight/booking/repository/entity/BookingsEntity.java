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

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bookings")
public class BookingsEntity implements Serializable {

	private static final long serialVersionUID = -8635694158270551717L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id")
	private Integer bookingId;

	@Column(name = "pnr_number")
	private String pnrNumber;

	@Column(name = "number_of_passengers")
	private Integer numberOfPassengers;

	@Column(name = "price")
	private Integer price;

	@Column(name = "confirmed")
	private Boolean confirmed;

	@Column(name = "active")
	private Boolean active;

	@Column(name = "refund_amount")
	private Integer refundAmount;

	@Column(name = "refund_date")
	private Timestamp refundDate;

	@ManyToOne
	@JoinColumn(name = "user", referencedColumnName = "user_id")
	private UsersEntity user;

	@ManyToOne
	@JoinColumn(name = "applied_coupon", referencedColumnName = "coupon_id")
	private CouponsEntity appliedCoupon;

	@ManyToOne
	@JoinColumn(name = "roaster", referencedColumnName = "roaster_id")
	private RoasterEntity roaster;

	@OneToMany(mappedBy = "booking")
	private List<TicketsEntity> tickets;

}
