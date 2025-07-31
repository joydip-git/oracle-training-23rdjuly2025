package userinterface.utilities;

import java.util.List;
import java.util.Scanner;

import models.Developer;
import models.Employee;
import models.Hr;

public class PayRollUIUtility {
	private static Scanner scanner;

	static {
		scanner = new Scanner(System.in);
	}

	private static int getRecordCount() {
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

	public static void saveEmployees(List<Employee> employees) {
		int count = getRecordCount();
		for (int i = 0; i < count; i++) {
			printMenu();
			int choice = getChoice();
			printRecordHeader(i, choice);
			Employee e = createEmployee(choice);
			employees.add(e);
		}
	}

	public static void printEmployees(List<Employee> employees) {
		for (Employee employee : employees) {
			System.out.println(employee.toString());
		}
	}

	private static void printSortChoices() {
		System.out.println("\n1. sort by id\n2. sort by name\n3. sort by total payment");
	}

	private static int getSortChoice() {
		System.out.print("enter choice[1/2/3]: ");
		return scanner.nextInt();
	}

	public static void sortEmployees(List<Employee> employees) {
		printSortChoices();
		int choice = getSortChoice();
		employees.sort(new EmployeeComparator(choice));
	}
}
