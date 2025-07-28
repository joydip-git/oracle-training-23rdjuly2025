package models;

public class Developer extends Employee {
	private float incentivePayment;
	
	public Developer() {
	}
	
	public Developer(int id, String name, float basicPayment, float daPayment, float hraPayment, float incentivePayment) {
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
		setTotalPayment(getBasicPayment() + getDaPayment() + getHraPayment() + incentivePayment);
	}
}
