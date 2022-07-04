package com.example.medicalshopmanagementsystem.exception;

import java.util.Date;

public class CustomErrorResponse {
	private String errorMessage;
	private Date time;
	private String details;

	public CustomErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomErrorResponse(String errorMessage, Date time, String details) {
		super();
		this.errorMessage = errorMessage;
		this.time = time;
		this.details = details;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
