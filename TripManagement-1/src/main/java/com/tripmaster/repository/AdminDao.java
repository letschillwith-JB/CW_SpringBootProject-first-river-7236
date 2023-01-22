package com.tripmaster.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.tripmaster.models.Admin;

@Service
public interface AdminDao extends JpaRepository<Admin, Integer>{

	public Optional<Admin> findByMobile(String mobile);
}
