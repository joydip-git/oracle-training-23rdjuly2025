package userinterface;

import java.util.ArrayList;
import java.util.List;

import models.Employee;
import userinterface.utilities.PayRollUIUtility;

public class PayRollUI {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<Employee>();
		PayRollUIUtility.saveEmployees(employees);
		//before sorting
		PayRollUIUtility.printEmployees(employees);
		PayRollUIUtility.sortEmployees(employees);
		//after sorting
		PayRollUIUtility.printEmployees(employees);
	}
}
