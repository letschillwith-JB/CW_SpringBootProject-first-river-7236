package com.tripmaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripmaster.models.Hotel;
import com.tripmaster.repository.HotelDao;

@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired 
	private HotelDao hotelDao;

	@Override
	public Hotel addHotel(Hotel hotel) {
		return hotelDao.save(hotel);
	}
}
