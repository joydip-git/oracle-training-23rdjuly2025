package models;

public class Employee {
	private int id;
	private String name;
	private float basicPayment;
	private float daPayment;
	private float hraPayment;
	private float totalPayment;

	public Employee() {
	}

	public Employee(int id, String name, float basicPayment, float daPayment, float hraPayment) {
		this.id = id;
		this.name = name;
		this.basicPayment = basicPayment;
		this.daPayment = daPayment;
		this.hraPayment = hraPayment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getBasicPayment() {
		return basicPayment;
	}

	public void setBasicPayment(float basicPayment) {
		this.basicPayment = basicPayment;
	}

	public float getDaPayment() {
		return daPayment;
	}

	public void setDaPayment(float daPayment) {
		this.daPayment = daPayment;
	}

	public float getHraPayment() {
		return hraPayment;
	}

	public void setHraPayment(float hraPayment) {
		this.hraPayment = hraPayment;
	}

	public int getId() {
		return id;
	}

	public float getTotalPayment() {
		return totalPayment;
	}
	protected void setTotalPayment(float value) {
		totalPayment= value;
	}

	public void calculateSalary() {
		totalPayment = basicPayment + daPayment + hraPayment;
	}

}
