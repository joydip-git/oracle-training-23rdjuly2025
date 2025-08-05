package diapp;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		DataManager manager = null;
		DataReader reader = null;
		Scanner scanner = null;
		String data;
		try {
			System.out.println("1. from database\n2. from file");
			System.out.println("enter choice[1/2]: ");
			scanner = new Scanner(System.in);
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				reader = new DbDataReader();
				break;
			case 2:
				reader = new FileDataReader();
				break;
			default:
				System.out.println("make correct choice");
				break;
			}
			if (reader != null) {
				manager = new DataManager(reader);
				data = manager.fetchData();
				System.out.println(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
