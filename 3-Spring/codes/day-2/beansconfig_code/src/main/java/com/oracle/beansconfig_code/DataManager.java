package com.oracle.beansconfig_code;

import org.springframework.beans.factory.annotation.Autowired;

public class DataManager {
	@Autowired
	private DbDataReader reader;// =new...();

	public DataManager() {
	}

    //@Autowired
	public DataManager(DbDataReader reader) {
		this.reader = reader;
	}

	//@Autowired
	public void setReader(DbDataReader reader) {
		this.reader = reader;
	}

	public String fetchData() {
		if (reader != null)
			return reader.getData().toUpperCase();
		else
			throw new NullPointerException("DbDataReader was not instantiated, hence reader is null");
	}
}
