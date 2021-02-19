package com.example.demo;

public class TestDao {
	
	
	String message;

	public String getMessage() {
		return message;
	}
	
	public TestDao (String message) {
		this.setMessage(message);
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
