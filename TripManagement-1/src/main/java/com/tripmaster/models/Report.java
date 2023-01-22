package com.tripmaster.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Report {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer reportId;
	private String reportName;
	private String reportType; 
	

}
