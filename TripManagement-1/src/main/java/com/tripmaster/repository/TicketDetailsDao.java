package com.tripmaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.tripmaster.models.TicketDetails;

@Service
public interface TicketDetailsDao extends JpaRepository<TicketDetails, Integer>{

}
