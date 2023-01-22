package com.tripmaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tripmaster.models.Hotel;

public interface HotelDao extends JpaRepository<Hotel, Integer>{

}
