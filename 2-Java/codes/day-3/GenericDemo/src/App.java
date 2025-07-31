
public class App {

	public static void main(String[] args) {
		Add(12, 13);
		Add(12.34, 13.45);
		//Add("", "");
	}

//	static void Add(int a, int b) {
//		System.out.println(a + b);
//	}

	// t -> Type parameter
	static <T extends Number> void Add(T a, T b) {

	}
	static <TElement> void print(TElement[] arr) {
		
	}

}
