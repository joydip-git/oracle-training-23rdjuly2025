package jdbcapp;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		getProductById(scanner);
		scanner.close();
	}

	static void getProductById(Scanner scanner) {
		try {
			System.out.println("enter product id: ");
			int id = scanner.nextInt();
			ProductDao dao = new ProductDao();
			ProductDTO p = dao.get(id);
			if (p != null) {
				System.out.println(p.getName() + ", " + p.getPrice());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	static void getAllProducts() {
		try {
			ProductDao dao = new ProductDao();
			List<ProductDTO> records = dao.getAll();
			if (records != null && records.size() > 0) {
				records.stream().forEach((p) -> System.out.println(p.getName()));
			} else
				System.out.println("no records found...");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
