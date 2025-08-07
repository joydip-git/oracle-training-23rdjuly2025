package com.oracle.productserviceapi.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.oracle.productserviceapi.models.ProductDTO;

import java.sql.Types;

public class ProductDao implements DaoContract<ProductDTO, Integer>{

	public int add(ProductDTO product) throws ClassNotFoundException, SQLException, Exception {
		Connection connection = null;
		CallableStatement statement = null;
		String query = "{call add_product(?,?,?,?,?,?,?)}";
		int result = 0;
		try {
			connection = DaoUtility.createConnection();
			statement = connection.prepareCall(query);

			statement.setInt(6, product.getCategoryId());
			statement.setInt(2, product.getId());
			statement.setString(1, product.getName());
			statement.setString(3, product.getDescription());
			statement.setFloat(4, product.getPrice());
			statement.setDate(5, Date.valueOf(product.getReleasedOn()));

			statement.registerOutParameter(7, Types.INTEGER);
			statement.executeUpdate();
			result = statement.getInt(7);
		} catch (ClassNotFoundException e) {
			throw e;
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			if (statement != null)
				statement.close();

			DaoUtility.closeConnection(connection);
		}
		return result;
	}

	public int delete(Integer id) throws ClassNotFoundException, SQLException, Exception {
		Connection connection = null;
		CallableStatement statement = null;
		String query = "{call delete_product(?,?)}";
		int result = 0;
		try {
			connection = DaoUtility.createConnection();
			statement = connection.prepareCall(query);
			statement.setInt(1, id);
			statement.registerOutParameter(2, Types.INTEGER);

			statement.executeUpdate();

			result = statement.getInt(2);
		} catch (ClassNotFoundException e) {
			throw e;
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			if (statement != null)
				statement.close();
			DaoUtility.closeConnection(connection);
		}
		return result;
	}

	public int update(Integer id, ProductDTO product) throws ClassNotFoundException, SQLException, Exception {
		Connection connection = null;
		CallableStatement statement = null;
		String query = "{call update_product(?,?,?,?,?,?,?)}";
		int result = 0;
		try {
			connection = DaoUtility.createConnection();
			statement = connection.prepareCall(query);

			statement.setInt(6, product.getCategoryId());
			statement.setInt(1,id);
			statement.setString(2, product.getName());
			statement.setString(4, product.getDescription());
			statement.setFloat(3, product.getPrice());
			statement.setDate(5, Date.valueOf(product.getReleasedOn()));
			statement.registerOutParameter(7, Types.INTEGER);

			statement.executeUpdate();

			result = statement.getInt(7);
		} catch (ClassNotFoundException e) {
			throw e;
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			if (statement != null)
				statement.close();
			DaoUtility.closeConnection(connection);
		}
		return result;
	}

	public List<ProductDTO> getAll() throws SQLException, ClassNotFoundException, Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		String query = "select * from products";
		List<ProductDTO> products = null;

		try {
			connection = DaoUtility.createConnection();
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
			if (statement != null)
				statement.close();
			DaoUtility.closeConnection(connection);
		}
		return products;
	}

	public ProductDTO get(Integer id) throws SQLException, ClassNotFoundException, Exception {
		Connection connection = null;
		String query = "select * from products where product_id=?";
		PreparedStatement statement = null;
		ResultSet result = null;
		ProductDTO product = null;

		try {
			connection = DaoUtility.createConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);

			result = statement.executeQuery();
			while (result.next()) {
				product = new ProductDTO();

				product.setId(result.getInt("product_id"));
				product.setName(result.getString("product_name"));
				product.setDescription(result.getString("product_desc"));
				product.setPrice(result.getFloat("product_price"));
				product.setReleasedOn(result.getDate("product_released_on").toLocalDate());
				product.setCategoryId(result.getInt("category_id"));
			}
		} catch (ClassNotFoundException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			if (statement != null)
				statement.close();
			DaoUtility.closeConnection(connection);
		}
		return product;
	}
}

