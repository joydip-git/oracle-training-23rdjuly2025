
public class ArithmeticCalculator implements ICalculator {
	@Override
	public int add(int first, int second) {
		return first + second;
	}

	@Override
	public int subtract(int first, int second) {
		return first - second;
	}

	@Override
	public int multiply(int first, int second) {
		return first * second;
	}

	@Override
	public int divide(int first, int second) {
		return first / second;
	}
}
