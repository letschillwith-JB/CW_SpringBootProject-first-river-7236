package com.tripmaster.service;

import com.tripmaster.models.User;

public interface IUserService {

	public User addNewUser(User userDetails);
	public User signIn(User userDetails);
	public User signOut(User userDetails);
}
