package com.oracle.basicspringapp;

public class Employee {
	private Address address;
	
	public Employee(Address address) {
		this.address = address;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}	
}
