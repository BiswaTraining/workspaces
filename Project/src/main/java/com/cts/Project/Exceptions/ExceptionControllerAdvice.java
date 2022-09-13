package com.cts.Project.Exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice // global exception handling   AOP
public class ExceptionControllerAdvice {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> exceptionHandler(Exception exception) {
		ErrorInfo error = new ErrorInfo();
		error.setErrorMessage("SOMETHING WENT WRONG.PLEASE TRY AGAIN");
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());  //500
		error.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	@ExceptionHandler(ProjectDetailsNotFoundException.class)
	public ResponseEntity<ErrorInfo> infyBankExceptionHandler(ProjectDetailsNotFoundException exception) {
		ErrorInfo error = new ErrorInfo();
		error.setErrorMessage(exception.getMessage());
		error.setTimestamp(LocalDateTime.now());   		
		error.setErrorCode(HttpStatus.NOT_FOUND.value());  //404
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.NOT_FOUND);//404
		
//return new ResponseEntity<>(environment.getProperty(exception.getMessage()), HttpStatus.NOT_FOUND);
	}
	
}
