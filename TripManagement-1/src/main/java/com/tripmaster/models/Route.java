package com.tripmaster.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Route {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String routeId;
	private String routeFrom;
	private String routeTo;
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;
	private LocalDate dateOfJourney;
	private String pickupPoint;
	private double fare;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Bus bus;
	
	//private TicketDetails ticketDetails; 

}
