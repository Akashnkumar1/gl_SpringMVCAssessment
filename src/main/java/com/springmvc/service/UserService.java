package com.springmvc.service;

import com.springmvc.database.UserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.entity.User;

@Service
public class UserService {
	
	@Autowired
    UserDatabase userdb;
	
	public User getUserbyEmail(String email) throws Exception{
		try {
			User user = userdb.getUserByEmail(email);
			return user;
		} catch(Exception e) {
			throw new Exception("Invalid credentials!");
		}
	}
	
	public boolean validateUser(User user, String password) throws Exception {
		try {
			if(user.getPassword().equals(password)) {
				return true;
			}
		}catch(Exception e){
			throw new Exception("Invalid credentials!");
		}
		
		return false;
	}
	
	public void insertUser(User user) throws Exception {
		try {
			userdb.insertUser(user);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
}
