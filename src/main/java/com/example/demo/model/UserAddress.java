package com.example.demo.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_address")
public class UserAddress {
	
	@EmbeddedId
	private UserAddressCK userId;
	
	@Id //primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String street;
	private String city;
	private String state;
	private String country;
	private String pincode;
	
	//Constructors
	public UserAddress() {
		
	}

}
