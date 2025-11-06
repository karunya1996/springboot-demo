package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.CustomException;
import com.example.demo.model.UserDetails;
import com.example.demo.service.UserDetailsService;



@RestController
//@RequestMapping(value="/api/")
public class ExceptionHandling {
	
	@Autowired
	UserDetailsService userDetailsService;

	@GetMapping("/safe-null")
	public String getSafeExample() {
	   String data = null;
	   if (data == null) {
	       return "Data is null";
	   }
	   return "Data length: " + data.length();
	}
	
	@GetMapping("/throw-npe")
	   public String throwNullPointerExample() {
	       // Manually throw the exception
	       throw new NullPointerException("Null value encountered while processing request");
	   }
	/*
	@GetMapping("/throw-custom")
	public String throwCustomException() {
		throw new CustomException();
	}
	*/
	

	@GetMapping("/test-error")
	 public String triggerError() {
	       // Simulate an exception
	       throw new NullPointerException("Simulated Null Pointer Exception");
	   }
	
	@GetMapping(path="/test-jpa")
	public List<UserDetails> getUser(){
		UserDetails userDetails = new UserDetails("xyz","xyz@conceptandcoding.com");
		return userDetailsService.getAllUsers();
	}
	
}
