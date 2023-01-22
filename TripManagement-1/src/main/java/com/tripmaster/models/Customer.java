package com.tripmaster.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
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
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	private String customerName;
	private String customerPassword;
	private String customerAddress;
	private String customerMobileNo;
	private String customerEmail;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Feedback> feedbacks = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Booking> bookings = new ArrayList<>();
	
}
