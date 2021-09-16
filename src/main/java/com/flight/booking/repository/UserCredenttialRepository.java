package com.flight.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.booking.repository.entity.UserCredentialsEntity;

public interface UserCredenttialRepository extends JpaRepository<UserCredentialsEntity, Integer> {
}
