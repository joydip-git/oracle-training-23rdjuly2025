
public class PersonInfo {
	private String name;
	private long mobileNo;
	static String company;
	
	//default constructor
	public PersonInfo() {		
	}
	
	//parameterized constructor
	public PersonInfo(String name, long mobileNo, String company) {
		this.name = name;
		this.mobileNo = mobileNo;
		this.company = company;
	}
	public static String getCompany() {
		return company;
	}
	public String getName() {
		return name;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
}
