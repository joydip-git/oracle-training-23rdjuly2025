package com.oracle.beansconfig_code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

	@Bean
	public DbDataReader dbDataReader() {
		return new DbDataReader();
	}

	//DI will take place through setter or directly to private data member
	@Bean
	public DataManager dataManager() {
		return new DataManager();
	}
	
	//DI will take place through parameterized constructor	
//	@Bean
//	public DataManager dataManager(DbDataReader reader) {
//		return new DataManager(reader);
//	}	
}
