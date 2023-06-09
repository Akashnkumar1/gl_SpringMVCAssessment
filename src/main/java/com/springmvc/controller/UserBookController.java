package com.springmvc.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springmvc.entity.User;
import com.springmvc.entity.UserBook;
import com.springmvc.service.BookService;
import com.springmvc.service.UserBookService;


@Controller
public class UserBookController {
	
	@Autowired
	private UserBookService userbookservice;
	
	@Autowired
	private BookService bookservice;
	
	@GetMapping("readlater")
	public String readlater(Map<String, List<UserBook>> map, HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<UserBook> userbook = userbookservice.getUserBookbyReadLater(user, true);
		map.put("userbook", userbook);
		return "readlater";
	}
	
	@GetMapping("like")
	public String liked(Map<String, List<UserBook>> map, HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<UserBook> userbook = userbookservice.getUserBookbyliked(user, true);
		map.put("userbook", userbook);
		return "liked";
	}
	
	@GetMapping("/removelike/{userbookid}")
	public String removeLiked(@PathVariable int userbookid) {
		userbookservice.deleteUserbook(userbookid);
		return "redirect:/like";
	}
	
	@GetMapping("/removereadlater/{userbookid}")
	public String removeReadlater(@PathVariable int userbookid) {
		userbookservice.deleteUserbook(userbookid);
		return "redirect:/readlater";
	}
	
	
	
}
