package com.training.springmvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/")
public class HomeController {
	
@RequestMapping(method=RequestMethod.GET)
public String greet() {
	return "home";
}

@GetMapping("login") 
	public String login() {
		return "login";
}



}
