package com.oracle.pmsapp.repository;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.oracle.pmsapp.entities.ProductDTO;

//@Service
@Repository
public class ProductRepository implements DaoContract<ProductDTO, Integer> {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int add(ProductDTO data) throws Exception {
		String query = "insert into products(product_id,product_name, product_desc,product_released_on,product_price,category_id) values(?,?,?,?,?,?)";
		try {
			return jdbcTemplate.update(query, data.getId(), data.getName(), data.getDescription(),
					Date.valueOf(data.getReleasedOn()), data.getPrice(), data.getCategoryId());
		} catch (DataAccessException e) {
			throw e;
		}
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
	public List<ProductDTO> getAll() throws Exception {

		String query = "select * from products";
		List<ProductDTO> products = null;

		try {
			products = jdbcTemplate.queryForList(query, ProductDTO.class);
		} catch (Exception e) {
			throw e;
		}
		return products;
	}

	@Override
	public ProductDTO get(Integer id) throws Exception {
		String query = "select * from products where product_id=?";
		return jdbcTemplate.queryForObject(query, ProductDTO.class, id);
	}
}

//@Service
//public class ProductRepository implements DaoContract<ProductDTO, Integer> {
//
//	@Autowired
//	private DataSource dataSource;
//	
//	@Override
//	public int add(ProductDTO data) throws ClassNotFoundException, SQLException, Exception {
//		return 0;
//	}
//
//	@Override
//	public int delete(Integer id) throws ClassNotFoundException, SQLException, Exception {
//		return 0;
//	}
//
//	@Override
//	public int update(Integer id, ProductDTO data) throws ClassNotFoundException, SQLException, Exception {
//		return 0;
//	}
//
//	@Override
//	public List<ProductDTO> getAll() throws SQLException, Exception {
//		Connection connection = null;
//		Statement statement = null;
//		String query = "select * from products";
//		ResultSet result = null;
//		List<ProductDTO> products = null;
//
//		try {
//			connection =dataSource.getConnection();
//			statement = connection.createStatement();
//			result = statement.executeQuery(query);
//
//			products = new ArrayList<ProductDTO>();
//			while (result.next()) {
//
//				ProductDTO product = new ProductDTO();
//				product.setId(result.getInt("product_id"));
//				product.setName(result.getString("product_name"));
//				product.setDescription(result.getString("product_desc"));
//				product.setPrice(result.getFloat("product_price"));
//				product.setReleasedOn(result.getDate("product_released_on").toLocalDate());
//				product.setCategoryId(result.getInt("category_id"));
//
//				products.add(product);
//			}
//		} catch (SQLException e) {
//			throw e;
//		} finally {
//			DaoUtility.closeConnection(connection);
//		}
//		return products;
//	}
//
//	@Override
//	public ProductDTO get(Integer id) throws ClassNotFoundException, SQLException, Exception {
//		return null;
//	}
//
//}
