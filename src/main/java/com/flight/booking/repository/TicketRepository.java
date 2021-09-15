package com.flight.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.booking.repository.entity.TicketsEntity;

public interface TicketRepository extends JpaRepository<TicketsEntity, Integer> {
}
