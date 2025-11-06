package com.example.demo.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.model.UserDetails;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
				
}
