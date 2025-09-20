package com.cp.lab8sec4.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "custname")
	private String custName;
	
	@Column(name = "email")
	private String email;
	
	public Customer() {
		
	}
	
	public Customer(String custName, String email) {
		this.email = email;
		this.custName = custName;
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return custName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.custName = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", custName=" + custName + ", email=" + email + "]";
	}
}
