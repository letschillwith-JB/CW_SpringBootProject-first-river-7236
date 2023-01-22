package com.tripmaster.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String feedbackId;
	private String feedback;
	private Integer rating;
	private LocalDate submitDate;
	
}
