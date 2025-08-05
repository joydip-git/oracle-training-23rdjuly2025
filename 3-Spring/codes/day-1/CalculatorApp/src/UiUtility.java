import java.util.Scanner;

public class UiUtility {
	public static void printMenu() {
		System.out.println("1. Add\n2. Subtract\n3. Multiply\n4. Divide");
	}

	public static int getChoice(Scanner scanner) {
		System.out.print("\nenter choice[1/2/3/4]: ");
		return scanner.nextInt();
	}

	public static int getValue(Scanner scanner) {
		System.out.print("enter value: ");
		return scanner.nextInt();
	}
	
	public static char decideToContinue(Scanner scanner) {
		System.out.println("\nWould you like to continue[y/Y/n/N]? ");
		Character ch = scanner.next().charAt(0);
		if (Character.isUpperCase(ch))
			ch = Character.toLowerCase(ch);

		//return ch.charValue();
		return ch;
	}
}
