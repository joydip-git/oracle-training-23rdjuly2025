import java.lang.reflect.Method;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

//		for (int i = 0; i < 2; i++) {
//			System.out.println("enter name: ");
//			String name = scanner.next();
//
//			System.out.println("enter mobile: ");
//			long mobile = scanner.nextLong();
//
//			System.out.println("enter company name: ");
//			String companyName = scanner.next();
//
//			PersonInfo pInfo = create(name, mobile, companyName);
//		}
		// class name is nothing but a refernce to object of the Class class which
		// stores the information of PersonInfo class
		PersonInfo.getCompany();
		
		PersonInfo pInfo = create(null, 0, "Oracle");
		Class pInfoClsRef = pInfo.getClass();

		//Class<PersonInfo> pInfoClsRef = PersonInfo.class;
//		pInfoClsRef.newInstance();
		System.out.println("Name: " + pInfoClsRef.getName());
		Method[] allMethods = pInfoClsRef.getMethods();
		for (Method method : allMethods) {
			System.out.println("Method Name: " + method.getName());
		}
		// System.out.println(pInfoClsRef);
		
		

		System.out.println("pres any key to terminate...");
		scanner.next();
		scanner.close();
	}

	private static PersonInfo create(String name, long mobile, String companyName) {
		PersonInfo personInfo = null;
		personInfo = new PersonInfo(name, mobile, companyName);
		System.out.println(personInfo.getName());
		return personInfo;
	}
}
