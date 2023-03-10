package com.tripmaster.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.tripmaster.models.CurrentCustomerSession;

@Service
public interface CustomerSessionDAO extends JpaRepository<CurrentCustomerSession,Integer> {
	
	public Optional<CurrentCustomerSession> findByUserId(Integer userId);
	
	public Optional<CurrentCustomerSession> findByUuid(String uuid);

}
