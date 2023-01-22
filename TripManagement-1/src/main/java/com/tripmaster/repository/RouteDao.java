package com.tripmaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.tripmaster.models.Route;

@Service
public interface RouteDao extends JpaRepository<Route, Integer>{

}
