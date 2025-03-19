package com.vishali.to_do_app.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public boolean Auth(String name, String password)
	{
		boolean isValidUser = name.equalsIgnoreCase("Vishali");
		boolean isValidPassword = password.equalsIgnoreCase("dummy");
		return isValidUser && isValidPassword;
		
	}
	
		public String getLoggedinUsername()
		{
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			return auth.getName();
		}

		

}
