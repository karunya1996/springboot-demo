package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.model.UserDetails;
import com.example.demo.service.UserDetailsService;
import com.example.demo.service.UserService;

@RestController
//Combines @Controller + @ResponseBody , Handles HTTP requests and results go straight as a web response(JSON)
@RequestMapping(value= "/api")
public class UserController {
	
	@Autowired //injects UserService automatically and not create it manually
	private UserService userService;
	
	@Autowired
	UserDetailsService userDetailsService;
	/*
	@GetMapping("/user") //Handles GET request at http://localhost:8080/user
	public User getUser() {
		return userService.getUserDetails();
	}
	*/
	
	@GetMapping(path = "/test-jpa")
		public UserDetails getUser() {
		UserDetails userDetails = new UserDetails("xyz","xyz@conceptcoding.com");
		userDetailsService.saveUser(userDetails);
		UserDetails output1 = userDetailsService.getUser(1L);
		return output1;
				
	}
	
	//data is directly inserted into db, no cache or validation happens
	@PostMapping(path ="/user")
			public UserDetails insertUser(@RequestBody UserDetails userDetails) {
			return userDetailsService.saveUser1(userDetails);
			}

		
//cache miss will happen an ddb call is made, second call hit will happena nd no db call
			@GetMapping("/user/{id}")
			public UserDetails getUser2(){
			return userDetailsService.findbyID(1L);

			}
			 
			@PutMapping("/user/{id}")
			public UserDetails updateUser(@PathVariable Long id, @RequestBody UserDetails userDetails) {
				return userDetailsService.updateUser(id,userDetails);
			}
	
}
