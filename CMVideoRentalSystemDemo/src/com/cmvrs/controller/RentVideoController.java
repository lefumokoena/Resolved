package com.cmvrs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RentVideoController 
{
	
	@RequestMapping(value = "home")
	public String home()
	{
		return("homePage");
	}
	
}
