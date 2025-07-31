import java.time.LocalDate;

public class DrivingLicenseApplication {

	private String name;
	private LocalDate dateOfBirth;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) throws AgeLessThanEighteenException {
		this.dateOfBirth = dateOfBirth;
		int diff = LocalDate.now().getYear() - dateOfBirth.getYear();
		if (diff < 18) {
			AgeLessThanEighteenException e = new AgeLessThanEighteenException("driving license can't be issued since the age is less than 18");
			throw e;
		} else
			age = diff;
	}

	public int getAge() {
		return age;
	}
}
