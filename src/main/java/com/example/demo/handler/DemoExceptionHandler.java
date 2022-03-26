package com.example.demo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exception.ErrorMessage;
import com.example.demo.exception.RecordNotFoundExeption;

@ControllerAdvice
public class DemoExceptionHandler {
	
	@ExceptionHandler(RecordNotFoundExeption.class)
	public ResponseEntity<ErrorMessage> recordsNotFoundException(RecordNotFoundExeption rnfEx){
		ErrorMessage errorMessage= new ErrorMessage(rnfEx.getMessage(), HttpStatus.NOT_FOUND.toString(), java.time.LocalDate.now().toString());
		return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.OK);
		
	}

}
