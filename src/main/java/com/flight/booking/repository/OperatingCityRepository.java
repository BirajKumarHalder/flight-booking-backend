package com.flight.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.booking.repository.entity.OperatingCitiesEntity;

public interface OperatingCityRepository extends JpaRepository<OperatingCitiesEntity, Integer> {
}
