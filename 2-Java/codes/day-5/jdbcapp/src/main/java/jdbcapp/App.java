package jdbcapp;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// getProductById(scanner);
		updateProduct(scanner);
		scanner.close();
	}

	static void updateProduct(Scanner scanner) {
		try {
			System.out.print("enter product id: ");
			int id = scanner.nextInt();

			ProductDao dao = new ProductDao();
			ProductDTO p = dao.get(id);

			scanner.nextLine();
			if (p != null) {
				ProductDTO dto = new ProductDTO();

				System.out.println("product name: " + p.getName());
				System.out.print("enter product name: ");
				String name = scanner.nextLine();
				dto.setName((name != null && !name.isBlank()) ? name : p.getName());

				System.out.println("product description: " + p.getDescription());
				System.out.print("enter product description: ");
				String desc = scanner.nextLine();
				dto.setDescription((desc != null && !desc.isBlank()) ? desc : p.getDescription());

				System.out.println("product price: " + p.getPrice());
				System.out.print("enter product price: ");
				float price = scanner.nextFloat();
				dto.setPrice(price > 0 ? price : p.getPrice());
				scanner.nextLine();

				System.out.println("product released on: " + p.getReleasedOn().toString());
				System.out.print("enter product date [mm/dd/yyyy]: ");
				String date = scanner.nextLine();
				dto.setReleasedOn(
						LocalDate.parse((date != null && !date.isBlank()) ? date : p.getReleasedOn().toString(),
								DateTimeFormatter.ofPattern("MM/dd/yyyy")));

				System.out.println("product category id: " + p.getCategoryId());
				System.out.print("enter product catgory id: ");
				int cid = scanner.nextInt();
				dto.setCategoryId(cid > 0 ? cid : p.getCategoryId());

				dto.setId(p.getId());

				if (dto.getId() > 0) {
					int res = dao.update(dto);
					if (res > 0)
						System.out.println(res + " record updated successfully..");
					else
						System.out.println("record was not updated");
				} else
					System.out.println("product with id: " + id + " not found...");
			} else
				System.out.println("product id was not set...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void getProductById(Scanner scanner) {
		try {
			System.out.print("enter product id: ");
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
