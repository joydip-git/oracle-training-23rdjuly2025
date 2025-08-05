
public class CalculationManager {
	private ICalculator calculator;
	
	public CalculationManager(ICalculator calculator) {
		this.calculator = calculator;
	}
	
	public CalculationResultDTO calculate(int choice, int firstValue, int secondValue) {
		//Calculator calculator = new Calculator();
		Integer result = null;
		String methodName = null;
		switch (choice) {
		case 1:
			result = calculator.add(firstValue, secondValue);
			methodName = "add";
			break;

		case 2:
			result = calculator.subtract(firstValue, secondValue);
			methodName = "subtract";
			break;

		case 3:
			result = calculator.multiply(firstValue, secondValue);
			methodName = "multiply";
			break;

		case 4:
			result = calculator.divide(firstValue, secondValue);
			methodName = "divide";
			break;

		default:
			result = null;
			methodName = "NA";
			break;
		}
		return new CalculationResultDTO(result, methodName);
	}

}
