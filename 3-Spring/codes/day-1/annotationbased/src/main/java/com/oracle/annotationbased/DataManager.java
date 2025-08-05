package com.oracle.annotationbased;

import org.springframework.beans.factory.annotation.Autowired;

public class DataManager {
	@Autowired
	private DbDataReader reader;

	public DataManager() {
	}

	//Marks a constructor, field, setter method, or config method as to be autowired by Spring's dependency injection facilities
//	@Autowired
//	public DataManager(DbDataReader reader) {
//		this.reader = reader;
//	}

//	@Autowired
//	public void setReader(DbDataReader reader) {
//		this.reader = reader;
//	}
	
	public String fetchData() {
		if (reader != null)
			return reader.getData().toUpperCase();
		else
			throw new NullPointerException("DbDataReader was not instantiated, hence reader is null");
	}
}
