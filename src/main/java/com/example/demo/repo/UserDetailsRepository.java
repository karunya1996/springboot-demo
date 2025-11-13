package com.example.demo.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.model.UserDTO;
import com.example.demo.model.UserDetails;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
	/*
	@Query(value="SELECT * FROM user_details WHERE user_name = :userFirstName",nativeQuery=true)
	List<UserDetails> getUserDetailsByNameNativeQuery(@Param("userFirstName")String userName);
			
	@Query(value="SELECT user_name, phone FROM user_details WHERE user_name = :userFirstName",nativeQuery=true)
	List<UserDetails> getUserDetailsByNameNativeQuery(@Param("userFirstName")String userName);
	*/
	
	@Query(name="UserDetails.getUserDetailsByName",nativeQuery=true)
	List<UserDTO> getUserDetailsByNameNativeQuery(@Param("userFirstName")String userName);
}
