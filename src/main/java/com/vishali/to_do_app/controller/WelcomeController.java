package com.vishali.to_do_app.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vishali.to_do_app.service.AuthenticationService;

@Controller
@SessionAttributes("name")
public class WelcomeController {
	
	private AuthenticationService authService;
	
	
	
	public WelcomeController(AuthenticationService authService) {
		super();
		this.authService = authService;
	}

	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String gotoWelcomePage(ModelMap model)
	{
		model.put("name", authService.getLoggedinUsername());
		return "welcome";
	}
	
	
}
