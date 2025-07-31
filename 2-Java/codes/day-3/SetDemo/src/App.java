import java.util.HashSet;
import java.util.Set;

public class App {

	public static void main(String[] args) {
		Set<Integer> numbers = new HashSet<Integer>();
		numbers.add(12); // 12.hashCode() -> 12345
		numbers.add(1); // 1 -> 32145
		numbers.add(12); // 12 -> 12345 12.eqauls(12)
		numbers.add(6);

		// numbers.remove(12);

		for (Integer integer : numbers) {
			System.out.println(integer);
		}

		Person p1 = new Person(1, "anil");
		Person p2 = new Person(2, "sunil");
		Person p3 = new Person(1, "anil");
		//Person p3 = p2;
		p1.equals(p3);
		
		Set<Person> people = new HashSet<Person>();
		people.add(p1); //p1.hashCode() -> 12345
		people.add(p2); //p2.hashCode() -> 12333		
		people.add(p3); //p3.hashCode() -> 12345, p1.equals(p3);
		
		for (Person	person : people) {
			System.out.println(person);
		}
	}
}
