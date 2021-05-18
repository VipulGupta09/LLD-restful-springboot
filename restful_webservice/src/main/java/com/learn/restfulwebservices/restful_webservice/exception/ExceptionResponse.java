package com.learn.restfulwebservices.restful_webservice.exception;

import java.util.Date;

public class ExceptionResponse {

	private Date date;
	private String msg;
	private String details;
	
	public ExceptionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ExceptionResponse(Date date, String msg, String details) {
		super();
		this.date = date;
		this.msg = msg;
		this.details = details;
	}

	public Date getDate() {
		return date;
	}

	public String getMsg() {
		return msg;
	}

	public String getDetails() {
		return details;
	}

	
	
	
}
