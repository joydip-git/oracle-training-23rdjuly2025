package userinterface;

import java.util.Scanner;

import models.abstraction.Shape;
import models.implementation.Circle;
import models.implementation.Triangle;

public class ShapeUI {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("how many shapes? ");
		int count = scanner.nextInt();

		Shape[] shapes = new Shape[count];

		for (int i = 0; i < shapes.length; i++) {
			System.out.println("\n1. circle\n2. triangle");
			System.out.print("enter choice[1/2]: ");
			int choice = scanner.nextInt();

			Shape shape;

			switch (choice) {
			case 1:
				System.out.print("\nenter radius: ");
				double radius = scanner.nextDouble();
				shape = new Circle(radius);
				break;

			case 2:
				System.out.print("\nenter base: ");
				double base = scanner.nextDouble();
				System.out.print("\nenter height: ");
				double height = scanner.nextDouble();
				shape = new Triangle(base, height);
				break;

			default:
				shape = null;
				break;
			}

			shapes[i] = shape;
		}

		for (Shape shape : shapes) {
			double area = shape.calculateArea();
			Class<? extends Shape> shapeClsInfo = shape.getClass();
			System.out.println("Area of " + shapeClsInfo.getName() + " is " + area);
		}
		
		scanner.close();
	}

}
