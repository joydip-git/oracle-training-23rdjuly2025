package com.oracle.basicspringapp;

public class Employee {
	private String name;
	private Address address;

	//required if you are 
	//a. creating child class inheriting from it
	//b. using setter methods to set the values using Beans in Spring IoC
	public Employee() {
	}

	public Employee(String name, Address address) {
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
