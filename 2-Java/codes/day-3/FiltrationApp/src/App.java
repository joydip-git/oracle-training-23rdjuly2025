import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

	static List<Integer> filter(List<Integer> input, Logic logic) {
		List<Integer> output = new ArrayList<Integer>();
		for (Integer num : input) {		
			if (logic.isEven(num))
				output.add(num);
		}
		return output;
	}

	public static void main(String[] args) {
		Integer[] originalArray = { 0, 3, 1, 5, 8, 6, 4, 9, 7, 2 };
		List<Integer> numbers = Arrays.asList(originalArray);
		List<Integer> result = filter(numbers, new Logic());
		for (Integer num : result) {
			System.out.println(num);
		}

	}

}
