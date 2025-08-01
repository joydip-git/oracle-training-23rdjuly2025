//1. declaring an interface with a method whose signature is same as that of the method of any class that will be invoked
//this interface can store reference to any method from any class, irrespective of static or instance, with "void" as return type and exactly one argument of type String.
//Functional Interface or Single Abstract Method (SAM) interface

@FunctionalInterface
public interface MethodInvoker {
	void call(String name);

	// without implementing the interface
//	class Implementation{
//		public void test(String name) {
//			System.out.println("welcome " + name);
//		}
//	}

	// with implementing the interface
//	class Implementation implements MethodInvoker {
//
//		@Override
//		public void call(String name) {
//			System.out.println("welcome " + name);
//		}
//	}
}
