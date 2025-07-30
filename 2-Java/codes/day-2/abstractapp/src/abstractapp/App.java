package abstractapp;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("1. from file\n2. from db");
		System.out.print("enter choice: ");
		int choice = scanner.nextInt();

		IDataAccess dataAccess;
		//DataAccess dataAccess;
		switch (choice) {
		case 1:
			dataAccess = new FileDataAccess("file path");
			break;

		case 2:
			dataAccess = new DbDataAccess("db path");
			break;

		default:
			dataAccess = null;
			break;
		}

		if (dataAccess != null) {
			DataAccess da = (DataAccess)dataAccess;
			System.out.println(da.getPath());
			System.out.println(dataAccess.readData());
		}
	}
}
