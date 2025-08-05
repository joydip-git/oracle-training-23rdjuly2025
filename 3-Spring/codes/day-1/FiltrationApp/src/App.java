import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class App {

	static <T> List<T> filter(List<T> input, LogicInvoker<T> invoker) {
		List<T> output = new ArrayList<T>();
		for (T value : input) {
//			if (value %2 == 0)
			boolean isTrue = invoker.apply(value);
			if (isTrue)
				output.add(value);
		}
		return output;
	}

	static <T> List<T> filter(List<T> input, Predicate<T> invoker) {
		List<T> output = new ArrayList<T>();
		for (T value : input) {
//			if (value %2 == 0)
			boolean isTrue = invoker.test(value);
			if (isTrue)
				output.add(value);
		}
		return output;
	}

	static <T, R> List<T> filter(List<T> input, Function<T, R> invoker) {
		List<T> output = new ArrayList<T>();
		for (T value : input) {
//			if (value %2 == 0)
			boolean isTrue = (boolean) invoker.apply(value);
			if (isTrue)
				output.add(value);
		}
		return output;
	}

	public static void main(String[] args) {
		Integer[] originalArray = { 0, 3, 1, 5, 8, 6, 4, 9, 7, 2 };
		List<Integer> numbers = Arrays.asList(originalArray);

		// using our custom functional interface (LogicInvoker<T>)
		LogicInvoker<Integer> evenLogic = (num) -> num % 2 == 0;
		List<Integer> result = filter(numbers, evenLogic);
		for (Integer num : result) {
			System.out.println(num);
		}

		// using built-in functional interface (Predicate<T>)
		Predicate<Integer> oddLogic = (num) -> num % 2 != 0;
		List<Integer> oddResult = filter(numbers, oddLogic);
		for (Integer num : oddResult) {
			System.out.println(num);
		}

		// using built-in functional interface (Predicate<T>)
		Function<Integer, Boolean> greaterLogic = (num) -> num > 4;
		List<Integer> greaterResult = filter(numbers, greaterLogic);
		for (Integer num : greaterResult) {
			System.out.println(num);
		}

	}

}
