
public record CalculationResultDTO(Integer result, String methodName) {
	public String getFormattedResult() {
		if (result == null)
			return "No method was called..hence result is not available";
		else
			return "Result of " + methodName + " is " + result;
	}
}

/*
public class CalculationResultDTO {
	private Integer result; 
	private String methodName;
	
	public CalculationResultDTO(Integer result, String methodName) {
		super();
		this.result = result;
		this.methodName = methodName;
	}
	
	public Integer getResult() {
		return result;
	}
	
	public String getMethodName() {
		return methodName;
	}
	
	public String getFormattedResult() {
		if (result == null)
			return "No method was called..hence result is not available";
		else
			return "Result of " + methodName + " is " + result;
	}
}
*/
