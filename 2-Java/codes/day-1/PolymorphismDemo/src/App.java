
public class App {

	public static void main(String[] args) {
		Add(12, 13);
		Add(12, 13, 14);
		Add(12, 13, 123456789);
		Add(12, 123456789, 13);
	}

	static void Add(int x, int y) {
		System.out.println(x + y);
	}

	static void Add(int x, int y, int z) {
		System.out.println(x + y + z);
	}

	static void Add(int x, int y, long z) {
		System.out.println(x + y + z);
	}

	static void Add(int x, long y, int z) {
		System.out.println(x + y + z);
	}
}
