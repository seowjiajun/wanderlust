package com.infy.validator;

import com.infy.model.Users;

public class UserValidator {

	public static void validateUserForLogin(String contactNumber, String password) throws Exception {
		if (!validateContactNumber(contactNumber))
			throw new Exception("UserValidator.INVALID_CONTACT_NUMBER_FORMAT");
		if (!validatePassword(password))
			throw new Exception("UserValidator.INVALID_PASSWORD_FORMAT");
	}
	
	public static void validateUserForRegistration(Users user) throws Exception {
		if (!validateUserName(user.getUserName()))
			throw new Exception("UserValidator.INVALID_USER_NAME_FORMAT");
		if (!validateEmailId(user.getEmailId()))
			throw new Exception("UserValidator.INVALID_EMAIL_ID_FORMAT");
		if (!validateContactNumber(user.getContactNumber()))
			throw new Exception("UserValidator.INVALID_CONTACT_NUMBER_FORMAT");
		if (!validatePassword(user.getPassword()))
			throw new Exception("UserValidator.INVALID_PASSWORD_FORMAT");
	}

	public static Boolean validateUserName(String userName) {
		if (userName == null)
			return false;
		Boolean flag = false;
		System.out.println(userName);
		if (userName.matches("^[a-zA-Z]+( [a-zA-Z]+)*"))
			flag = true;
		return flag;
	}

	public static Boolean validateEmailId(String emailId) {
		if (emailId == null)
			return false;
		Boolean flag = false;
		if (emailId.matches("[a-zA-Z0-9]{1,}@[a-zA-Z0-9]{1,}.com"))
			flag = true;
		return flag;
	}

	public static Boolean validatePassword(String password) {
		if (password == null)
			return false;
		Boolean flag = false;
		if (password.length() >= 7 && password.length() <= 20)
			if (password.matches(".*[A-Z]+.*"))
				if (password.matches(".*[a-z]+.*"))
					if (password.matches(".*[0-9]+.*"))
						if (password.matches(".*[!@#$%^&*].*"))
							flag = true;
		return flag;
	}

	public static Boolean validateContactNumber(String contactNumber) {
		if (contactNumber == null)
			return false;
		Boolean flag = false;
		if (contactNumber.matches("[6-9][0-9]{9}"))
			flag = true;
		return flag;
	}
}
