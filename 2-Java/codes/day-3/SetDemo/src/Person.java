
public class Person {
	private int id;
	private String name;

	public Person() {
	}

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return id + " " + name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = Integer.hashCode(id) * prime;
		return name.hashCode() * hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null) {
			
			if (obj instanceof Person) {
				
				Person other = (Person) obj;
				
				if (this.id != other.id)
					return false;
				
				if (!this.name.equals(other.name))
					return false;

				return true;
				
			} else
				return false;
			
		} else
			return false;
	}
}
