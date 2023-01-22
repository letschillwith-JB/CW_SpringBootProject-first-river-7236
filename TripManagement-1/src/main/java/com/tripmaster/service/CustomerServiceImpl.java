package com.tripmaster.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripmaster.models.CurrentCustomerSession;
import com.tripmaster.models.Customer;
import com.tripmaster.models.CustomerSigninDto;
import com.tripmaster.repository.CustomerDao;
import com.tripmaster.repository.CustomerSessionDAO;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao CustomerDao;
	
	
	@Autowired
	private CustomerSessionDAO CustomerSessionDAO;

	
	
	@Override
	public Customer createCustomer(CustomerSigninDto customersigninDto) {
		Optional<Customer> opt= CustomerDao.findByCustomerMobileNo(customersigninDto.getMobile());
		Customer customer = new Customer();
		customer.setCustomerName(customersigninDto.getCustomerName());
		customer.setCustomerPassword(customersigninDto.getPassword());
		customer.setCustomerMobileNo(customersigninDto.getMobile());
		customer.setCustomerEmail(customersigninDto.getEmail());
		customer.setCustomerAddress(customersigninDto.getAddress());
//		customer.setUserType("customer");

		if(opt.isPresent()) {
			System.out.println("User already exist");
		}
		return CustomerDao.save(customer);
	}

	
	@Override
	public Customer updateCustomer(CustomerSigninDto customersigninDto, String key) {
		 Optional<CurrentCustomerSession> optCurrcustomer= CustomerSessionDAO.findByUuid(key);
		 Customer customer = new Customer();
			customer.setCustomerName(customersigninDto.getCustomerName());
			customer.setCustomerPassword(customersigninDto.getPassword());
			customer.setCustomerMobileNo(customersigninDto.getMobile());
			customer.setCustomerEmail(customersigninDto.getEmail());
			customer.setCustomerAddress(customersigninDto.getAddress());
//			customer.setUserType("customer");
			if(!optCurrcustomer.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
			
			return CustomerDao.save(customer);
	}
	

	@Override
	public Customer updateUser(Customer customer, String key) {
		 Optional<CurrentCustomerSession> optCurrcustomer= CustomerSessionDAO.findByUuid(key);
			
			if(!optCurrcustomer.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
			
			return CustomerDao.save(customer);
	}


	@Override
	public List<Customer> allCustomer() {
		return CustomerDao.findAll();
	}

}
