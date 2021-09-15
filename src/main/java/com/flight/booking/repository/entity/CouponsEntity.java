package com.flight.booking.repository.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "coupons")
public class CouponsEntity implements Serializable {

	private static final long serialVersionUID = 2835756327227107486L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "coupon_id")
	private Integer couponId;

	@Column(name = "coupon_name")
	private String couponName;

	@Column(name = "discount_coupon")
	private Boolean discountCoupon;

	@Column(name = "coupon_description")
	private String couponDescription;

	@Column(name = "coupon_discount_percentage")
	private Integer couponDiscountPercentage;

	@Column(name = "active")
	private Boolean active;

	@Column(name = "updated_by")
	@LastModifiedBy
	private String updatedBy;

	@Column(name = "updated_on")
	@LastModifiedDate
	private Timestamp updatedOn;

	@OneToMany(mappedBy = "appliedCoupon")
	private List<BookingsEntity> bookings;

}
