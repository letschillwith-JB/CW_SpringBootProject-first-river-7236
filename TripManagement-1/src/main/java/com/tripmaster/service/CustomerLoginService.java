package com.tripmaster.service;

import javax.security.auth.login.LoginException;

import com.tripmaster.models.CustomerDTO;

public interface CustomerLoginService {
	public String logIntoAccount(CustomerDTO customerDTO);
	public String logOutAccount(String key);
	public boolean isLoggedIn(Integer customerId) throws LoginException ;
	public boolean isLoggedInByUUID(String uuid) throws LoginException ;
}
