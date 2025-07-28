package models;

public class Hr extends Employee {
	private float gratuityPayment;
	
	public Hr() {
	}
	
	public Hr(int id, String name, float basicPayment, float daPayment, float hraPayment, float gratuityPayment) {
		super(id, name, basicPayment, daPayment, hraPayment);
		this.gratuityPayment = gratuityPayment;
	}

	public float getGratuityPayment() {
		return gratuityPayment;
	}

	public void setGratuityPayment(float gratuityPayment) {
		this.gratuityPayment = gratuityPayment;
	}
	
//	public void calculateHrSalary() {
//		setTotalPayment(getBasicPayment() + getDaPayment() + getHraPayment() + gratuityPayment);
//	}
}
