package com.flight.booking.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.booking.model.OperatingCity;
import com.flight.booking.repository.OperatingCityRepository;
import com.flight.booking.repository.entity.OperatingCitiesEntity;

@Service
public class OperatingCityService {

	@Autowired
	private OperatingCityRepository operatingCityRepository;

	public List<OperatingCity> addOperatingCitis(List<OperatingCity> operatingCities) {
		return operatingCities.parallelStream()
				.filter(city -> Optional
						.ofNullable(operatingCityRepository.findByCityCode(city.getCityCode()).orElse(null)).isEmpty())
				.map(city -> {
					OperatingCitiesEntity cityEntity = new OperatingCitiesEntity();
					cityEntity.setCityCode(city.getCityCode());
					cityEntity.setCityName(city.getCityName());
					cityEntity.setActive(city.isActive());
					cityEntity = operatingCityRepository.save(cityEntity);
					city.setCityId(cityEntity.getCityId());
					return city;
				}).collect(Collectors.toList());
	}

	public List<OperatingCity> getAllOperatingCities() {
		return operatingCityRepository.findAll().parallelStream().map(cityEntity -> {
			OperatingCity city = new OperatingCity();
			city.setCityId(cityEntity.getCityId());
			city.setCityCode(cityEntity.getCityCode());
			city.setCityName(cityEntity.getCityName());
			city.setActive(city.isActive());
			return city;
		}).collect(Collectors.toList());
	}

	public List<OperatingCity> updateOperatingCities(List<OperatingCity> operatingCities) {
		return operatingCities.parallelStream().map(city -> {
			OperatingCitiesEntity cityEntity = operatingCityRepository.findByCityCode(city.getCityCode())
					.orElse(new OperatingCitiesEntity());
			cityEntity.setCityName(city.getCityName());
			cityEntity.setActive(city.isActive());
			cityEntity = operatingCityRepository.save(cityEntity);
			city.setCityId(cityEntity.getCityId());
			return city;
		}).collect(Collectors.toList());
	}

}
