import java.io.InputStream;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		Scanner scanner = new Scanner(inputStream);
		CalculationManager manager = new CalculationManager();
		
		char decisionToContinue = 'n';
		do {
			UiUtility.printMenu();

			int choice = UiUtility.getChoice(scanner);

			int first = UiUtility.getValue(scanner);
			int second = UiUtility.getValue(scanner);

			CalculationResultDTO cResult = manager.calculate(choice, first, second);
			System.out.println(cResult.getFormattedResult());

			decisionToContinue = UiUtility.decideToContinue(scanner);

		} while (decisionToContinue != 'n');
		scanner.close();
	}
}
