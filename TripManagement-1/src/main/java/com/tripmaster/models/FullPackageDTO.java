package com.tripmaster.models;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FullPackageDTO {
	
	private String packageName;
	private String packageDescription;
	private String packageType;
	private Integer packageCost;
	
	private List<Hotel> hotels = new ArrayList<>();
	private TicketDetails ticketDetails;

}
