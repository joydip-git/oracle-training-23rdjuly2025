
public class MyCollection<TValue> implements Collection<TValue> {
	private TValue[] elements;
	int index = 0;

	public MyCollection(TValue[] elements) {
		this.elements = elements;
	}

	public void Add(TValue value) {
		this.elements[index] = value;
		index++;
	}
}
