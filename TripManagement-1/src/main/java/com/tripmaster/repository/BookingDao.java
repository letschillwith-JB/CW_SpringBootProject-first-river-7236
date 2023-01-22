package com.tripmaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.tripmaster.models.Booking;
@Service
public interface BookingDao extends JpaRepository<Booking, Integer> {

}
