package com.flight.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.booking.repository.entity.BlockedTokensEntity;

public interface BlockedTokenRepository extends JpaRepository<BlockedTokensEntity, Integer> {
}
