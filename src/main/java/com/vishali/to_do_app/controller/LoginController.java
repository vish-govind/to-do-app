package com.vishali.to_do_app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vishali.to_do_app.service.AuthenticationService;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	private AuthenticationService authService;

	private Logger log = LoggerFactory.getLogger(getClass());
	

	public LoginController(AuthenticationService authService) {
		super();
		this.authService = authService;
	}

	@RequestMapping(value="login", method=RequestMethod.GET)
	public String gotoLoginPage()
	{
		return "login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String gotoWelcomePage(@RequestParam String name , @RequestParam String pass, ModelMap model)
	{
		log.info("Username is " + name +" password is "+pass);
		if(authService.Auth(name, pass))
		{
		model.put("name", name);
		model.put("password",pass);
		return "welcome";
		}
		model.put("error", "Invalid Credentials ! Please try again");
		return "login";
		
	}

}
