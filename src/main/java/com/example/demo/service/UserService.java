package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;

@Service
//Marks this as a Spring-managed service (business logic layer)
public class UserService {
	
	public User getUserDetails() {
		//pretending its coming from db
		return new User(1,"Karunya","karunya@example.com");
	}

}
