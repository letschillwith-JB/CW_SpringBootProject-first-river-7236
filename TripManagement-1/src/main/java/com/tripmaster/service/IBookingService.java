package com.tripmaster.service;

import java.util.List;

import com.tripmaster.exceptions.BookingException;
import com.tripmaster.exceptions.CustomerException;
import com.tripmaster.exceptions.HotelException;
import com.tripmaster.exceptions.PackageException;
import com.tripmaster.models.Booking;
import com.tripmaster.models.BookingDTO;

public interface IBookingService {
	public Booking createBooking(BookingDTO bookingDTO,Integer customerId)throws PackageException,CustomerException,HotelException;
	public Booking cancelBooking(Integer bookingId,Integer customerId)throws BookingException;
	public Booking viewBooking(Integer bookingId)throws BookingException;
	public List<Booking> viewAllBooking()throws BookingException ;

}
