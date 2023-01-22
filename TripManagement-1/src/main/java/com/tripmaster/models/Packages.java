package com.tripmaster.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Packages {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer packageId;
	private String packageName;
	private String packageDescription;
	private String packageType;
	private double packageCost;
	
	//No info provided for this 
	@OneToOne(cascade = CascadeType.ALL)
	private Hotel bookedHotel;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Hotel> hotels = new ArrayList<>();
	
	@OneToOne(cascade = CascadeType.ALL)
	private TicketDetails ticketDetail;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<PaymentDetails> paymentDetails = new ArrayList<>();

	
}
