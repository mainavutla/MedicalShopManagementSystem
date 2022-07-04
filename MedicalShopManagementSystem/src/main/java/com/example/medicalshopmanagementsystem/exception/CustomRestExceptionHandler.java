package com.example.medicalshopmanagementsystem.exception;


import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomRestExceptionHandler {
	@ExceptionHandler
	private ResponseEntity<CustomErrorResponse> exceptionHandle(CustomNotFoundException e){
		
		CustomErrorResponse error = new CustomErrorResponse();
		error.setErrorMessage(e.getMessage());
		error.setTime(new Date());
		//error.setDetails(null);
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND) ;
		
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomErrorResponse> exceptionHandle(Exception e){
		
		
		CustomErrorResponse error = new CustomErrorResponse();
		error.setErrorMessage(e.getMessage());
		error.setTime(new Date());
		//error.setDetails(null);
		
		
//		Return ResponseEntity
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler()
	public ResponseEntity<CustomErrorResponse> customExceptionHandle(MethodArgumentNotValidException ex){
		
		CustomErrorResponse error = new CustomErrorResponse("Validation Failed", new Date(), ex.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<CustomErrorResponse>(error,HttpStatus.BAD_REQUEST);
	}

}
