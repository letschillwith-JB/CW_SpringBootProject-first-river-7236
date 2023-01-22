package com.tripmaster.service;

import java.util.List;

import com.tripmaster.models.Booking;

public interface BookingService {

	public Booking makeBooking(Booking booking);
	
	public Booking cancelBooking(Integer bookingId);
	
	public Booking viewBooking(Integer bookingId);
	
	public List<Booking> viewAllBookings();
}
