package com.tripmaster.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class BookingDescription {
	
	private Double hotelCost;
	private Double travelCost;
	private Double gst;
	private Double packageCost;
	private Double totalCost;
	private String description;
}
