package jdbcapp;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DaoUtility {

	private static Properties dbProperties;

	static {
		dbProperties = new Properties();
	}

	private static void loadDbConfiguration() throws FileNotFoundException, Exception {
		try {
			FileReader reader = new FileReader("src//main//resources//db.properties");
			dbProperties.load(reader);
		} catch (FileNotFoundException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}

	private static void loadDriver() throws ClassNotFoundException {
		String driver = dbProperties.getProperty("driver");
		if (driver != null && !driver.isBlank()) {
			Class.forName(driver);
		}
	}

	public static Connection createConnection() throws SQLException, Exception {
		Connection connection = null;
		if (dbProperties != null) {
			try {
				loadDbConfiguration();
				loadDriver();
				String url = dbProperties.getProperty("url");
				String username = dbProperties.getProperty("username");
				String password = dbProperties.getProperty("password");
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
