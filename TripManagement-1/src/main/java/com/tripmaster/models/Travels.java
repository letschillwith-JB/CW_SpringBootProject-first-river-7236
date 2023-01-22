package com.tripmaster.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Travels {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer travelsId;
	private String travelsName;
	private String agentName;
	private String address;
	private String contact;
	

}

