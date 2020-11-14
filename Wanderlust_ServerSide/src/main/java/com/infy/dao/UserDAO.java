package com.infy.dao;

import com.infy.model.Users;

public interface UserDAO {
	
	public Users getUserByUserId(Integer userId) throws Exception;
	
	public Users getUserByContactNumber(String contactNumber) throws Exception;
	
	public Users registerUser(Users user) throws Exception;
}
