package com.example.demo.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.example.demo.service.UserDetailsCK;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Table(name ="USER_DETAILS", schema="ONBOARDING",uniqueConstraints= {
		@UniqueConstraint(columnNames="phone"),
		@UniqueConstraint(columnNames= {"name","Email"})
},
indexes= {@Index(name="index_phone",columnList="phone"),
		@Index(name="index_name_email",columnList="name,email")
})
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE,region="userDetailsCache")
public class UserDetails {
	
	@EmbeddedId
	UserDetailsCK userDetailsCK;
	//composite primary key iscombiantion of two or more col to fro primary key
	
	@Id //primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@SequenceGenerator(name="unique_user_seq",
	sequenceName="db_seq_name",
	initialValue=100,
	allocationSize=5)
	private Long id;
	
	@Id
	private String name;
	@Id
	private String address;
	

	private String email;
	private String phone;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="address_id",referencedColumnName="id")
	private UserAddress userAddress;
	//constructors
	public UserDetails() {	
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public UserDetails(String name,String email) {
		this.name=name;
		this.email=email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
