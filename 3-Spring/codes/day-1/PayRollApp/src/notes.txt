package userinterface;

import java.util.Scanner;

import models.*;

public class PayRollUI {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

//		System.out.println("enter name: ");
//		String name = scanner.next();
//		
//		System.out.println("enter id: ");
//		int id = scanner.nextInt();
//				
//		System.out.println("enter basic: ");
//		float basic = scanner.nextFloat();
//		
//		System.out.println("enter da: ");
//		float da = scanner.nextFloat();
//		
//		System.out.println("enter hra: ");
//		float hra = scanner.nextFloat();
//		
//		System.out.println("enter incentive: ");
//		float incentive = scanner.nextFloat();

		//up-casting:
		//base class's reference variable can store reference of any child class object
		Developer dev = new Developer(1, "anil", 1, 1, 1, 1);
		Hr hr = new Hr(2, "sunil", 2, 2, 2, 2);
		printSalary(dev);
		printSalary(hr);

		scanner.close();
	}
	private static void printSalary(Employee e) {
		e.calculateSalary();
//		if(e instanceof Developer) {
//			//down-casting: storing the reference of child class instance back to the same child class reference variable from base class reference variable
//			Developer d = (Developer)e;
//			d.calculateSalary();
//		}
//		if(e instanceof Hr) {
//			//down-casting: storing the reference of child class instance back to the same child class reference variable from base class reference variable
//			Hr h = (Hr)e;
//			h.calculateSalary();
//		}
	}
}
