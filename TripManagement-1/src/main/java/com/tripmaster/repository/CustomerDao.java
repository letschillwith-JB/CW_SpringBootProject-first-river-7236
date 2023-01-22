package com.tripmaster.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.tripmaster.models.Customer;

public interface CustomerDao extends JpaRepository<Customer,Integer>{
	public Optional<Customer> findByCustomerMobileNo(String string);
}
