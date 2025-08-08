package com.oracle.productapiservice;

//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.InputStream;
//import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.util.Properties;

public class DaoUtility {

	/*
	private static Properties dbProperties;

	static {
		dbProperties = new Properties();
	}

	
	private static void loadDbConfiguration() throws FileNotFoundException, Exception {
		FileReader reader = null;
		InputStream inputStream = null;
		try {
			reader = new FileReader(""); 
			dbProperties.load(reader);
		} catch (FileNotFoundException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			if (reader != null)
				reader.close();
		}
	}
*/
	private static void loadDriver() throws ClassNotFoundException {
		//String driver = dbProperties.getProperty("driver");
		String driver =  ApplicationConfiguration.DB_PROPERTIES.getProperty("driver");
		if (driver != null && !driver.isBlank()) {
			Class.forName(driver);
		}
	}

	public static Connection createConnection() throws SQLException, Exception {
		Connection connection = null;
		//if (dbProperties != null) {
		if(ApplicationConfiguration.DB_PROPERTIES!=null) {
			try {
				//loadDbConfiguration();
				loadDriver();
//				String url = dbProperties.getProperty("url");
//				String username = dbProperties.getProperty("username");
//				String password = dbProperties.getProperty("password");
				String url = ApplicationConfiguration.DB_PROPERTIES.getProperty("url");
				String username = ApplicationConfiguration.DB_PROPERTIES.getProperty("username");
				String password = ApplicationConfiguration.DB_PROPERTIES.getProperty("password");
				if (url != null && username != null && password != null && !url.isBlank() && !username.isBlank()
						&& !password.isBlank())
					connection = DriverManager.getConnection(url, username, password);
				else
					throw new Exception("either url or username or password is/are null or blank");
			} catch (SQLException e) {
				throw e;
			} catch (Exception e) {
				throw e;
			}
			return connection;
		} else
			throw new NullPointerException("Properties object is null");
	}

	public static void closeConnection(Connection connection) throws SQLException {
		try {
			if (connection != null && !connection.isClosed())
				connection.close();
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}
}
