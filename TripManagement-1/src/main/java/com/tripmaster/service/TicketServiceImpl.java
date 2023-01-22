package com.tripmaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripmaster.models.TicketDetails;
import com.tripmaster.repository.TicketDetailsDao;

@Service
public class TicketServiceImpl implements TicketService{
	@Autowired 
	private TicketDetailsDao ticketDetailsDao;
	
	@Override
	public TicketDetails addBusTicket(TicketDetails ticketDetails) {
		ticketDetails.setStatus("not booked");
		return ticketDetailsDao.save(ticketDetails);
	}
}
