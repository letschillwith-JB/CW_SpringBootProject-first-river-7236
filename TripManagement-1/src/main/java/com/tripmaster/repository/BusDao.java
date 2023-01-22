package com.tripmaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.tripmaster.models.Bus;
@Service
public interface BusDao extends JpaRepository<Bus, Integer> {

}
