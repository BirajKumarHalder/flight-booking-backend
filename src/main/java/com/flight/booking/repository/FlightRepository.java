package com.flight.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.booking.repository.entity.FlightsEntity;

public interface FlightRepository extends JpaRepository<FlightsEntity, Integer> {
}
