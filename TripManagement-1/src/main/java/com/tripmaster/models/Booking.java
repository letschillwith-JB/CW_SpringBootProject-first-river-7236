package com.tripmaster.models;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
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
@Data
@NoArgsConstructor
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookingId;
	private String bookingType;
	private String bookingTitle;
	private LocalDate bookingDate;
	
	//we can declare it as variable but created seperate class in order to provide more detail
	@Embedded
	private BookingDescription bookDescription;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Packages packages;
	
}
