package com.flight.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.booking.repository.entity.AirlinesEntity;

public interface AirlineRepository extends JpaRepository<AirlinesEntity, Integer> {
}
