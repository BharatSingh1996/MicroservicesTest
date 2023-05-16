package com.bharat.hotel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<ExceptionResponse> handlerResourceNotFound(ResourceNotFound ex){
		
		String message = ex.getMessage();
		ExceptionResponse build = ExceptionResponse.builder().msg(message).success(false).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<ExceptionResponse>(build,HttpStatus.NOT_FOUND);
	}
}
