package com.learn.restfulwebservices.restful_webservice.exception;

public class UserIdNotFoundException extends RuntimeException{

	public UserIdNotFoundException(String message) {
		super(message);
	}
}
