package com.flight.booking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.booking.repository.entity.RolesEntity;

public interface RoleRepository extends JpaRepository<RolesEntity, Integer> {

	Optional<RolesEntity> findByRole(String role);

}
