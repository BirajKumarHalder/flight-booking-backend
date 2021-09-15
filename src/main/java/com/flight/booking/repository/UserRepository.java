package com.flight.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.booking.repository.entity.UsersEntity;

public interface UserRepository extends JpaRepository<UsersEntity, Integer> {
}
