package com.tripmaster.controller;

import java.util.List;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tripmaster.exceptions.BookingException;
import com.tripmaster.exceptions.CustomerException;
import com.tripmaster.exceptions.FeedbackException;
import com.tripmaster.exceptions.HotelException;
import com.tripmaster.exceptions.PackageException;
import com.tripmaster.models.Booking;
import com.tripmaster.models.BookingDTO;
import com.tripmaster.models.Customer;
import com.tripmaster.models.CustomerSigninDto;
import com.tripmaster.models.Feedback;
import com.tripmaster.models.Packages;
import com.tripmaster.service.CBookingService;
import com.tripmaster.service.CustomerLoginService;
import com.tripmaster.service.CustomerService;
import com.tripmaster.service.IFeedbackService;
import com.tripmaster.service.IPackageService;
import com.tripmaster.service.IReportService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired 
	private CustomerService customerService;
	@Autowired 
	private CBookingService bookingService;
	@Autowired 
	private IFeedbackService feedbackService;
	@Autowired 
	private IReportService reportService;
	@Autowired 
	private CustomerLoginService customerLoginService;
	@Autowired 
	private IPackageService packageService;
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello";
	}
	@PostMapping("/")
	public Customer saveCustomer(@Valid @RequestBody CustomerSigninDto customer) {
		return customerService.createCustomer(customer);
	}

	// to update customer by passing key
	@PutMapping("/update")
	public Customer updateCustomer(@RequestBody CustomerSigninDto customer, @RequestParam(required = false) String key) throws LoginException {
		customerLoginService.isLoggedInByUUID(key);
		return customerService.updateCustomer(customer, key);
	}

	@PostMapping("/booking/{customerId}")
	public ResponseEntity<Booking> createBooking(@RequestBody BookingDTO bookingDTO,@PathVariable("customerId") Integer customerId) throws PackageException, CustomerException,HotelException, LoginException{
		customerLoginService.isLoggedIn(customerId);
		Booking booking = bookingService.createBooking(bookingDTO, customerId);
		return new ResponseEntity<Booking>(booking,HttpStatus.CREATED);
	}

	@DeleteMapping("/booking/{customerId}/{bookingId}")
	public ResponseEntity<Booking> cancelBooking(@PathVariable("bookingId") int bookingId,@PathVariable("customerId") Integer customerId) throws BookingException, LoginException{
		customerLoginService.isLoggedIn(customerId);
		Booking booking = bookingService.cancelBooking(bookingId,customerId);
		return new ResponseEntity<Booking>(booking,HttpStatus.OK);
	}


	@PostMapping("/feedback/{id}")
	public ResponseEntity<Feedback> createFeedback(@RequestBody Feedback feedback, @PathVariable Integer id) throws FeedbackException, CustomerException, LoginException{
		customerLoginService.isLoggedIn(id);
		Feedback savedFeedback = feedbackService.addFeedback(feedback, id);
		return new ResponseEntity<Feedback>(savedFeedback, HttpStatus.CREATED);	
	}

	@GetMapping("/feedback/{id}")
	public ResponseEntity<List<Feedback>> getFeedbacks(@PathVariable Integer id) throws FeedbackException, CustomerException{
		List<Feedback> feedbackList = feedbackService.findByCustomerId(id);
		return new ResponseEntity<List<Feedback>>(feedbackList, HttpStatus.OK);
	}
	
	@GetMapping("/packagesViewAll")
	public ResponseEntity<List<Packages>> viewAllPackages() throws PackageException{
		List<Packages> packages=packageService.viewAllPackage();
		return new ResponseEntity<List<Packages>>(packages,HttpStatus.OK);
	}
	
	@GetMapping("/packagesView{packageId}")
	public ResponseEntity<Packages> searchPackages(@PathVariable int packageId) throws PackageException{
		Packages packages=packageService.searchPackage(packageId);
		return new ResponseEntity<Packages>(packages,HttpStatus.OK);
	}

}
