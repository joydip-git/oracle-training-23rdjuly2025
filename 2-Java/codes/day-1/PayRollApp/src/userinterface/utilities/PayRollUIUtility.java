package userinterface.utilities;

import java.util.Scanner;

import models.Developer;
import models.Employee;
import models.Hr;

public class PayRollUIUtility {
	private static Scanner scanner;

	static {
		scanner = new Scanner(System.in);
	}

	public static int getRecordCount() {
		System.out.print("how many records? ");
		return scanner.nextInt();
	}

	private static void printMenu() {
		System.out.println("\n1. Developer\n2. Hr");
	}

	private static int getChoice() {
		System.out.print("enter choice[1/2]: ");
		return scanner.nextInt();
	}

	private static void printRecordHeader(int index, int choice) {
		switch (choice) {
		case 1:
			System.out.println("\nrecord #" + (index + 1) + ": [Developer]");
			break;

		case 2:
			System.out.println("\nrecord #" + (index + 1) + ": [Hr]");
			break;

		default:
			System.out.println("Incorrect choice");
			break;
		}
	}

	private static Employee createEmployee(int choice) {

		System.out.println("\nenter name: ");
		String name = scanner.next();

		System.out.println("enter id: ");
		int id = scanner.nextInt();

		System.out.println("enter basic: ");
		float basic = scanner.nextFloat();

		System.out.println("enter da: ");
		float da = scanner.nextFloat();

		System.out.println("enter hra: ");
		float hra = scanner.nextFloat();

		Employee employee;
		switch (choice) {
		case 1:
			System.out.println("enter incentive: ");
			float incentive = scanner.nextFloat();
			employee = new Developer(id, name, basic, da, hra, incentive);
			break;

		case 2:
			System.out.println("enter gratuity: ");
			float gratuity = scanner.nextFloat();
			employee = new Hr(id, name, basic, da, hra, gratuity);
			break;

		default:
			employee = null;
			break;
		}
		if (employee != null)
			employee.calculateSalary();
		
		return employee;
	}

	public static void saveEmployees(Employee[] employees) {
		for (int i = 0; i < employees.length; i++) {
			printMenu();
			int choice = getChoice();
			printRecordHeader(i, choice);
			employees[i] = createEmployee(choice);
		}
	}

	public static void printEmployees(Employee[] employees) {
		for (Employee employee : employees) {
			System.out.println(employee.toString());
		}
	}
}
