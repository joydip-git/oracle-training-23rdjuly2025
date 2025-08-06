package com.oracle.productapiservice;

public class Message {
	private String greeting;
	private String framework;
	
	public Message(String greeting, String framework) {
		this.greeting = greeting;
		this.framework = framework;
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public String getFramework() {
		return framework;
	}

	public void setFramework(String framework) {
		this.framework = framework;
	}	
}
