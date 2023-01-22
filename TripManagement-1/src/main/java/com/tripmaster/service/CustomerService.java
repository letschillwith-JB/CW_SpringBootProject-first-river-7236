package com.tripmaster.service;

import java.util.List;

import com.tripmaster.models.Customer;
import com.tripmaster.models.CustomerSigninDto;

public interface CustomerService {
	
	public Customer createCustomer(CustomerSigninDto customersigninDto);
	public Customer updateUser(Customer customer, String key);
	public Customer updateCustomer(CustomerSigninDto customersigninDto, String key);
	public List<Customer> allCustomer();

}
