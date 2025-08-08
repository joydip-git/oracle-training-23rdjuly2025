package com.oracle.pmsapp.repository;

import java.sql.Connection;
import java.sql.SQLException;

public class DaoUtility {	
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
