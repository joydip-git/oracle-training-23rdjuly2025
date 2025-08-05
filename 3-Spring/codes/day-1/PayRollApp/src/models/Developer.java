package models;

public class Developer extends Employee {
	private float incentivePayment;

	public Developer() {
		//super(0, null, 0, 0, 0);
	}

	public Developer(int id, String name, float basicPayment, float daPayment, float hraPayment,
			float incentivePayment) {
		super(id, name, basicPayment, daPayment, hraPayment);
		this.incentivePayment = incentivePayment;
	}

	public float getIncentivePayment() {
		return incentivePayment;
	}

	public void setIncentivePayment(float incentivePayment) {
		this.incentivePayment = incentivePayment;
	}

	@Override
	public void calculateSalary() {
		super.calculateSalary();
		float partialPayment = getTotalPayment();
		float total = partialPayment + incentivePayment;
		setTotalPayment(total);
	}
}
