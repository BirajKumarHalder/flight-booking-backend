package com.flight.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.booking.repository.entity.RoasterEntity;

public interface RoasterRepository extends JpaRepository<RoasterEntity, Integer> {
}
