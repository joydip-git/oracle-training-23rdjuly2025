package userinterface;

import java.util.Scanner;

import models.abstraction.Person;
import models.implementation.Student;
import models.implementation.Professor;

public class OustandingPersonUI {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("how many people? ");
		int count = scanner.nextInt();

		Person[] people = new Person[count];

		for (int i = 0; i < people.length; i++) {
			System.out.println("\n1. student\n2. professor");
			System.out.print("enter choice[1/2]: ");
			int choice = scanner.nextInt();

			Person person;

			System.out.print("enter name: ");
			String name = scanner.next();

			switch (choice) {
			case 1:
				System.out.print("\nenter marks: ");
				double marks = scanner.nextDouble();
				person = new Student(name, marks);
				break;

			case 2:
				System.out.print("\nenter books published: ");
				int books = scanner.nextInt();
				person = new Professor(name, books);
				break;

			default:
				person = null;
				break;
			}

			people[i] = person;
		}

		for (Person person : people) {
			if (person != null) {
				boolean isTrue = person.isOutstanding();
				if (isTrue) {
					Class<? extends Person> personTypeInfo = person.getClass();
					String info = person.getName() + " is an oustanding " + personTypeInfo.getName();
					if (person instanceof Student) {
						Student student = (Student) person;
						info.concat(" with " + student.getMarks() + " marks");
					} else if (person instanceof Professor) {
						Professor professor = (Professor) person;
						info.concat(" with " + professor.getBooksPublished() + " books published");
					}
				}
			}
		}

		scanner.close();
	}

}
