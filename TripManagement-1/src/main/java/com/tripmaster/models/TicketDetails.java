package com.tripmaster.models;

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
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String ticketId;
	private String status;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Route route;
}
