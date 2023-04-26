package com.springmvc.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.entity.Book;
import com.springmvc.entity.User;
import com.springmvc.entity.UserBook;
import com.springmvc.service.BookService;
import com.springmvc.service.UserBookService;
import com.springmvc.service.UserService;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
	@Autowired
	private UserService userservice;
	
	@Autowired
	private BookService bookservice;
	
	@Autowired
	private UserBookService userbookservice;
	
	@GetMapping
	public String dashboardPage(Map<String, List<Book>> map) {
		List<Book> books = bookservice.getAllBooks();
		map.put("books", books);
		return "Dashboard";
	}
	
	@GetMapping("/readlater/{bookid}")
	public String addToReadlater(@PathVariable int bookid, HttpSession session) {
		User user = (User) session.getAttribute("user");
		System.out.println(user);
		Book book = bookservice.getBookById(bookid);
		boolean readlater = true;
		UserBook userbook = new UserBook();
		userbook.setUserId(user);
		userbook.setBookId(book);
		userbook.setReadLater(readlater);
		try {
			userbookservice.insertUserBook(userbook);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "redirect:/readlater";
	}
	
	@GetMapping("/liked/{bookid}")
	public String addTolikedbook(@PathVariable int bookid, HttpSession session) {
		User user = (User) session.getAttribute("user");
		System.out.println(user);
		Book book = bookservice.getBookById(bookid);
		boolean readlater = true;
		UserBook userbook = new UserBook();
		userbook.setUserId(user);
		userbook.setBookId(book);
		userbook.setLiked(readlater);
		try {
			userbookservice.insertUserBook(userbook);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "redirect:/like";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		session.invalidate();
		return "redirect:/login";
	}
	
}
