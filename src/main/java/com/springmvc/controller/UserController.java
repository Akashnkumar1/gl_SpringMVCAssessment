package com.springmvc.controller;

import com.springmvc.database.UserbookDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	@Autowired
	private UserbookDatabase db;
	
	@GetMapping("/Get")
	public void getall() {

	}
	
}
 