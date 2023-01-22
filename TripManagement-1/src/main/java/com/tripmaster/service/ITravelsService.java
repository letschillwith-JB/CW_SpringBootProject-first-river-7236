package com.tripmaster.service;

import java.util.List;

import com.tripmaster.exceptions.TravelsException;
import com.tripmaster.models.Travels;

public interface ITravelsService {

	Travels addTravels(Travels travels)  throws TravelsException;
	Travels updateTravels(Travels travels) throws TravelsException;
	Travels removeTravels(int travelId) throws TravelsException;
	Travels searchTravels(int travelId) throws TravelsException;
	List<Travels> viewTravels() throws TravelsException;
}
