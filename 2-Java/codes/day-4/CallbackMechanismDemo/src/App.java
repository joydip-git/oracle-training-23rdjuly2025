import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;

public class App {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, InstantiationException {
		// 2. storing the so called "reference" to the method in the reference variable
		// of the interface
		// a. storing reference of a static method
		MethodInvoker<String> invokerOfPrint = Printer::print;

		// 3. use the reference variable to call the method (by invoking the print
		// method via the interface method
		invokerOfPrint.call("joydip");

//		Class<Printer> printerInfo =  Printer.class;
//		Method printMethodInfo = printerInfo.getMethod("Print", String.class);
//		printMethodInfo.invoke(printerInfo.newInstance(), "joydip");

		// b. storing reference of an instance method
		MethodInvoker<String> invokerOfShow = new Printer()::show;
		invokerOfShow.call("anil");

		// MethodInvoker invokerOfAnonymous = new MethodInvoker.Implementation()::test;

		// you are referring to a a method (instance) of inner anonymous type
		// implementing the interface
		MethodInvoker<String> invokerOfAnonymous = new MethodInvoker<String>() {
			@Override
			public void call(String name) {
				System.out.println("welcome " + name);
			}
		};
		invokerOfAnonymous.call("sunil");

		// Lamnda expression is a short-hand notation of the previous code
		MethodInvoker<String> invokerOfLambda = (String data) -> {
			System.out.println(data);
		};

		invokerOfLambda.call("joy");

		CalculationInvoker<Integer, Integer> addInvoker = Calculation::add;
		CalculationInvoker<Integer, Integer> subtractInvoker = new Calculation()::subtract;
		System.out.println(addInvoker.calculate(12, 13));
		System.out.println(subtractInvoker.calculate(12, 3));

		CalculationInvoker<Integer, Integer> multiplyInvoker = (Integer a, Integer b) -> {
			return a * b;
		};

		CalculationInvoker<Integer, Integer> divideInvoker = (a, b) -> a / b;

		System.out.println(multiplyInvoker.calculate(12, 3));
		System.out.println(divideInvoker.calculate(12, 3));

		CalculationInvoker<String, String> concatenator = (fname, lname) -> fname.concat(" " + lname);
		System.out.println(concatenator.calculate("anil", "narayan"));
	}
}
