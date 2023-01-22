package com.tripmaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.tripmaster.models.Travels;

@Service
public interface TravelsDao extends JpaRepository<Travels, Integer>{

}
