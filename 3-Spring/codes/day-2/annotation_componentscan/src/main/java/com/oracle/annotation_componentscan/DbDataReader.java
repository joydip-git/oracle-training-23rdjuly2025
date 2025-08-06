package com.oracle.annotation_componentscan;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository
public class DbDataReader {
	public DbDataReader() {
	}

	public String getData() {
		return "db data";
	}
}
