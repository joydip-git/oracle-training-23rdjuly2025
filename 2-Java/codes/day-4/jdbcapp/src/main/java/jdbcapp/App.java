package jdbcapp;

import java.sql.SQLException;
import java.util.List;

public class App {

	public static void main(String[] args) {
		try {
			ProductDao dao = new ProductDao();
			List<ProductDTO> records = dao.getAll();
			if (records != null && records.size() > 0) {
				records
					.stream()
					.forEach((p) -> System.out.println(p.getName()));
			}else
				System.out.println("no records found...");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
