package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springmvc.entity.User;
import com.springmvc.service.UserService;

@Controller
public class RegisterController {
	@Autowired
	private UserService userservice;
	
	@GetMapping("/register")
	public String registerPage() {
		return "register";
	}
	
	@PostMapping("/register")
	public String register(User user) {
		try {
			userservice.insertUser(user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "redirect:login";
	}
	
}
