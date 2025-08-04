package jdbcapp;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			printMenu();
			int choice = getChoice(scanner);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	static void printMenu() {
		System.out.println("1. print all records");
		System.out.println("2. print single record");
		System.out.println("3. add a record");
		System.out.println("4. update a record");
		System.out.println("5. delete a record");
	}

	static int getChoice(Scanner scanner) {
		try {
			System.out.print("enter choice[1/2/3/4/5]: ");
			return scanner.nextInt();
		} catch (Exception e) {
			throw e;
		}
	}

	static void performDbOperation(Scanner scanner, int choice) throws Exception {
		switch (choice) {
		case 1:
			getAllProducts();
			break;

		case 2:
			getProductById(scanner);
			break;

		case 3:
			addProduct(scanner);
			break;

		case 4:
			updateProduct(scanner);
			break;

		case 5:
			deleteProduct(scanner);
			break;

		default:
			throw new Exception("incorrect choice");
		}
	}

	static void deleteProduct(Scanner scanner) {
		ProductDao dao = null;
		try {
			System.out.print("enter product id: ");
			int id = scanner.nextInt();

			if (id > 0) {
				dao = new ProductDao();
				int result = dao.delete(id);
				if (result > 0) {
					System.out.println(result + " record deleted");
				} else {
					System.out.println(" could not delete record");
				}
			} else
				throw new Exception("product id incorrect");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void addProduct(Scanner scanner) {

		ProductDao dao = null;
		ProductDTO dto = null;
		try {
			System.out.print("enter product id: ");
			int id = scanner.nextInt();

			if (id > 0) {
				dto = new ProductDTO();
				dto.setId(id);

				System.out.print("enter product name: ");
				String name = scanner.nextLine();
				dto.setName(name);

				System.out.print("enter product description: ");
				String desc = scanner.nextLine();
				dto.setDescription(desc);

				System.out.print("enter product price: ");
				float price = scanner.nextFloat();
				dto.setPrice(price);

				System.out.print("enter product date [mm/dd/yyyy]: ");
				String date = scanner.nextLine();
				dto.setReleasedOn(LocalDate.parse(date, DateTimeFormatter.ofPattern("MM/dd/yyyy")));

				System.out.print("enter product catgory id: ");
				int cid = scanner.nextInt();
				dto.setCategoryId(cid);

				dao = new ProductDao();
				int result = dao.add(dto);
				if (result > 0) {
					System.out.println(result + " record added");
				} else {
					System.out.println(" could not add record");
				}
			} else
				throw new Exception("product id incorrect");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void updateProduct(Scanner scanner) {
		ProductDao dao = null;
		try {
			System.out.print("enter product id: ");
			int id = scanner.nextInt();

			dao = new ProductDao();
			ProductDTO p = dao.get(id);

			scanner.nextLine();
			if (p != null) {
				ProductDTO dto = new ProductDTO();

				if (dto.getId() > 0) {
					dto.setId(id);

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

					int res = dao.update(dto);
					if (res > 0)
						System.out.println(res + " record updated successfully..");
					else
						System.out.println("record was not updated");
				} else
					System.out.println("product with id: " + id + " not found...");
			} else
				throw new Exception("product id was not set...");
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
