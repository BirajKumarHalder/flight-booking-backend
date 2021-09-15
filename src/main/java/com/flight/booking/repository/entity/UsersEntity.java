package com.flight.booking.repository.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class UsersEntity implements Serializable {

	private static final long serialVersionUID = -1506448393895398L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;

	@Column(name = "email_verified")
	private Boolean emailVerified;

	@ManyToOne
	@JoinColumn(name = "role", referencedColumnName = "role_id")
	private RolesEntity role;

	@OneToOne
	@JoinColumn(name = "credentials", referencedColumnName = "credentials_id")
	private UserCredentialsEntity userCredentials;

	@OneToMany(mappedBy = "user")
	private List<BookingsEntity> bookings;

}