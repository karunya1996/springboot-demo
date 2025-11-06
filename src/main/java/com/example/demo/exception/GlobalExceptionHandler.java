package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.example.demo.exception.CustomException;
public class GlobalExceptionHandler {
/*
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<String> handleCustomException(CustomException ex){
		return new ResponseEntity<>("Handled custom exception: "+ ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
	*/
}
