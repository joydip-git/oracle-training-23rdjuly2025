import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class App {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(2); // 0
		list.add(13); // 1
		list.add(0); // 2
		list.add(3, 1); // 3

		IntegerComparator comparatorObj = new IntegerComparator();
		//	list.sort(comparatorObj);
		//list.sort((a, b) -> a - b);

		// by default ascending order sorting
		// Collections.sort(list);

		// custom sorting
		Collections.sort(list, comparatorObj);
		//Collections.sort(list, (a, b) -> a - b);

		// list.stream().sorted(comparatorObj);
		// list.stream().sorted((a, b) -> a - b);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i) + "->" + list.indexOf(list.get(i)));
		}
		/*
		 * list.remove(2); // passing index position to remove the value from
		 * 
		 * System.out.println("\nafter removal\n"); for (Integer num : list) {
		 * System.out.println(num + ":" + list.indexOf(num)); }
		 * 
		 * Object data = 13; list.remove(data); // passing value to be removed
		 * 
		 * System.out.println("\nafter removal\n"); Iterator<Integer> iteratorOfList =
		 * list.iterator(); while (iteratorOfList.hasNext()) {
		 * System.out.println(iteratorOfList.next()); }
		 */
	}
}
