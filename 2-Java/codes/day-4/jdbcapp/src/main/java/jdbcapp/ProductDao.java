package jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

	public List<ProductDTO> getAll() throws SQLException {
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		String query = "select * from products";
		List<ProductDTO> products = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "Oracle@2024");

			statement = connection.createStatement();

			result = statement.executeQuery(query);

			products = new ArrayList<ProductDTO>();
			while (result.next()) {

				ProductDTO product = new ProductDTO();
				product.setId(result.getInt("product_id"));
				product.setName(result.getString("product_name"));
				product.setDescription(result.getString("product_desc"));
				product.setPrice(result.getFloat("product_price"));
				product.setReleasedOn(result.getDate("product_released_on").toLocalDate());
				product.setCategoryId(result.getInt("category_id"));
				
				products.add(product);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			throw e;
		} finally {
			if (connection != null)
				connection.close();
		}
		return products;
	}
}
