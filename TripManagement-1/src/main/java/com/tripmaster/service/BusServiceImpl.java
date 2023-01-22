package com.tripmaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripmaster.models.Bus;
import com.tripmaster.repository.BusDao;

@Service
public class BusServiceImpl implements BusService{
	
	@Autowired 
	private BusDao busDao;

	@Override
	public Bus addBus(Bus bus) {
		return busDao.save(bus);
	}

}
