package userinterface.utilities;

import java.util.Comparator;

import models.Employee;

public class EmployeeComparator implements Comparator<Employee> {

	private int sortChoice;

	public EmployeeComparator() {
	}

	public EmployeeComparator(int sortChoice) {
		this.sortChoice = sortChoice;
	}

	@Override
	public int compare(Employee o1, Employee o2) {
		int result = 0;
		switch (sortChoice) {
		case 1:
			result = Integer.compare(o1.getId(), o2.getId());
			break;

		case 2:
			result = o1.getName().compareTo(o2.getName());
			break;

		case 3:
			result = Float.compare(o1.getTotalPayment(), o2.getTotalPayment());
			break;

		default:
			result = Integer.compare(o1.getId(), o2.getId());
			break;
		}
		return result;
	}
}
