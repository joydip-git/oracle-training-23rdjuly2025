@FunctionalInterface
public interface CalculationInvoker<T, TResult> {
	TResult calculate(T a, T b);
}
