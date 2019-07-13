package com.example.demo.response;

public class StudentResponse {
	private Integer statusCode;
	private String message;
	private Object response;

	public StudentResponse(Integer statusCode, String message, Object response) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.response = response;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

}
