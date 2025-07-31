
//public class AgeLessThanEighteenException extends Exception {	
//	private static final long serialVersionUID = 1L;
//	
//	public AgeLessThanEighteenException() {
//		super("age is less than permitted age...");
//	}
//	public AgeLessThanEighteenException(String errorMessage) {
//		super(errorMessage);
//	}
//}

public class AgeLessThanEighteenException extends Exception {
	private static final long serialVersionUID = 1L;

	private String message;

	public AgeLessThanEighteenException() {
		// super("age is less than permitted age...");
		message = "age is less than permitted age...";
	}

	public AgeLessThanEighteenException(String errorMessage) {
//		super(errorMessage);
		message = errorMessage;
	}

	@Override
	public String getMessage() {
		return message;
	}
}







