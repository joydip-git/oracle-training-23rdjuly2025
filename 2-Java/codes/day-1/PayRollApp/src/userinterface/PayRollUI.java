package userinterface;

import models.Employee;
import userinterface.utilities.PayRollUIUtility;

public class PayRollUI {

	public static void main(String[] args) {
		int count =  PayRollUIUtility.getRecordCount();
		Employee[] employees = new Employee[count];
		PayRollUIUtility.saveEmployees(employees);
		PayRollUIUtility.printEmployees(employees);
	}
}
