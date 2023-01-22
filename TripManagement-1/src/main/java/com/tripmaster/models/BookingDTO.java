package com.tripmaster.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingDTO {

	private Integer packageId;
	private Integer hotelId;
	private PaymentDetails paymentDetails;
}
