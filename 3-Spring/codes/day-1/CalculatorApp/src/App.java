import java.io.InputStream;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		Scanner scanner = null;

		ICalculator calculator = null;
		CalculationManager manager = null;

		char decisionToContinue = 'n';
		try {
			do {
				UiUtility.printMenu();

				scanner = new Scanner(inputStream);
				int choice = UiUtility.getChoice(scanner);

				int first = UiUtility.getValue(scanner);
				int second = UiUtility.getValue(scanner);

				calculator = new ArithmeticCalculator();
				manager = new CalculationManager(calculator);
				CalculationResultDTO cResult = manager.calculate(choice, first, second);
				System.out.println(cResult.getFormattedResult());

				decisionToContinue = UiUtility.decideToContinue(scanner);

			} while (decisionToContinue != 'n');
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (scanner != null)
				scanner.close();
		}
	}
}
