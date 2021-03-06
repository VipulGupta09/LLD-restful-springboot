package com.learn.restfulwebservices.restful_webservice.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		ExceptionResponse response = new ExceptionResponse
				(new Date(), ex.getMessage(), request.getDescription(false));

		return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) throws Exception {
		ExceptionResponse response = new ExceptionResponse
				(new Date(), ex.getMessage(), request.getDescription(false));

		return new ResponseEntity(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserIdNotFoundException.class)
	public final ResponseEntity<Object> handleIdNotFoundForDeleteException(UserIdNotFoundException ex, WebRequest request) throws Exception {
		ExceptionResponse response = new ExceptionResponse
				(new Date(), ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<Object>(response, HttpStatus.NO_CONTENT);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse response = new ExceptionResponse
				(new Date(), "Validation Failed", ex.getBindingResult().toString());

		return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
	}
	
}
