package com.tripmaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.tripmaster.models.Report;
@Service
public interface ReportDao extends JpaRepository<Report, Integer>{
		
}
