package com.cp.lab8sec4.service;

public class CustomerNotFoundException extends RuntimeException {
	
	public CustomerNotFoundException(long id) {
		super("Not Found Customer ID : " + id);
	}

}