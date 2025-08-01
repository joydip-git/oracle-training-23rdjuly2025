public class Employee {
	private int id;
	private String name;
	private float salary;

	public Employee() {
	}

	public Employee(int id, String name, float salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "[Id:" + id + ", Name: " + name + ", Salary: " + salary + " ]";
	}

}
