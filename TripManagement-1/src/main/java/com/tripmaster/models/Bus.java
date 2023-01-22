package com.tripmaster.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Bus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer busId;
	private String busType;
	private String busNumber;
	private Integer capacity;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Travels travels;

}
