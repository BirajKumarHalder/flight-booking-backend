package com.flight.booking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.booking.repository.entity.OperatingCitiesEntity;

public interface OperatingCityRepository extends JpaRepository<OperatingCitiesEntity, Integer> {

	Optional<OperatingCitiesEntity> findByCityCode(String cityCode);

}
