import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;

public class App {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, InstantiationException {
		// 2. storing the so called "reference" to the method in the reference variable
		// of the interface
		// a. storing reference of a static method
		MethodInvoker invokerOfPrint = Printer::print;

		// 3. use the reference variable to call the method (by invoking the print
		// method via the interface method
		invokerOfPrint.call("joydip");

//		Class<Printer> printerInfo =  Printer.class;
//		Method printMethodInfo = printerInfo.getMethod("Print", String.class);
//		printMethodInfo.invoke(printerInfo.newInstance(), "joydip");

		// b. storing reference of an instance method
		MethodInvoker invokerOfShow = new Printer()::show;
		invokerOfShow.call("anil");

		// MethodInvoker invokerOfAnonymous = new MethodInvoker.Implementation()::test;

		// you are referring to a a method (instance) of inner anonymous type
		// implementing the interface
		MethodInvoker invokerOfAnonymous = new MethodInvoker() {
			@Override
			public void call(String name) {
				System.out.println("welcome " + name);
			}
		};
		invokerOfAnonymous.call("sunil");

		//Lamnda expression is a short-hand notation of the previous code
		MethodInvoker invokerOfLambda = (String data) -> {
			System.out.println(data);
		};

	}
}







