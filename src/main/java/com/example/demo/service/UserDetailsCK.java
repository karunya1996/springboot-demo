package com.example.demo.service;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class UserDetailsCK implements Serializable{
	private String name;
	private String address;
	
	public UserDetailsCK() {
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		if(!(obj instanceof UserDetailsCK)) {
			return false;
		}
		UserDetailsCK userCk =(UserDetailsCK)obj;
		return this.name.equals(userCk.name)&&this.address.equals(userCk.address);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, address);
	}

}
