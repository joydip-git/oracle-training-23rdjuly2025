package com.oracle.pmsapp.repository;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.pmsapp.entities.ProductDTO;

@Service
public class ProductRepository implements DaoContract<ProductDTO, Integer> {

	@Autowired
	private DataSource dataSource;
	
	@Override
	public int add(ProductDTO data) throws ClassNotFoundException, SQLException, Exception {
		return 0;
	}

	@Override
	public int delete(Integer id) throws ClassNotFoundException, SQLException, Exception {
		return 0;
	}

	@Override
	public int update(Integer id, ProductDTO data) throws ClassNotFoundException, SQLException, Exception {
		return 0;
	}

	@Override
	public List<ProductDTO> getAll() throws SQLException, Exception {
		Connection connection = null;
		Statement statement = null;
		String query = "";
		ResultSet result = null;
		List<ProductDTO> products = null;

		try {
			connection =dataSource.getConnection();
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
		} catch (SQLException e) {
			throw e;
		} finally {
			DaoUtility.closeConnection(connection);
		}
		return products;
	}

	@Override
	public ProductDTO get(Integer id) throws ClassNotFoundException, SQLException, Exception {
		return null;
	}

}
