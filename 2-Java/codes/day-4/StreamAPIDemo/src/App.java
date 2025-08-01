import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class App {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(4);
		numbers.add(2);
		numbers.add(5);
		numbers.add(3);

		// stream() method returns a sequential stream of values from the collection,
		// which is treated as source of data
//		Stream<Integer> numberStream = numbers.stream();
//		
//		Predicate<Integer> evenLogic = (a) -> a % 2 == 0;
//		Stream<Integer> evenStream = numberStream.filter(evenLogic);
//
//		Comparator<Integer> compareLogic = (a, b) -> a - b;
//		Stream<Integer> sortedEvenStream = evenStream.sorted(compareLogic);
//
//		Consumer<Integer> printLogic = (a) -> System.out.println(a);
//		sortedEvenStream.forEach(printLogic);

		numbers
			.stream()
			.filter((a) -> a % 2 == 0)
			.sorted((a, b) -> a - b)
			.forEach((a) -> System.out.println(a));
		
		//how to create a stream from a source of data (collection)?
		//1.
		Stream.of(numbers);
		
		//2. 
		Function<Integer, String> convertLogic = (num)-> "Value: "+ num.toString();
		numbers.stream().map(convertLogic).forEach((item)->System.out.println(item));
	}
}








