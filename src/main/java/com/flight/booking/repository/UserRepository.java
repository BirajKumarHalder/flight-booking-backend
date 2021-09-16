package com.flight.booking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.booking.repository.entity.UsersEntity;

public interface UserRepository extends JpaRepository<UsersEntity, Integer> {

	Optional<UsersEntity> findByEmail(String email);
}
