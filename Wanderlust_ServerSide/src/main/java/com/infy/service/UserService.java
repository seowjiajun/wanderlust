package com.infy.service;

import com.infy.model.Users;

public interface UserService {
	
	public Users getUser(Integer userId) throws Exception;

	public Users authenticateUser(String contactNumber, String password) throws Exception;
	
	public Users registerUser(Users user) throws Exception;	
}
