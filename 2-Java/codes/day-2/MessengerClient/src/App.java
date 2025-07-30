import businesslogic.MessengerContract;
import businesslogic.Messenger;

public class App {

	public static void main(String[] args) {
		MessengerContract messenger = new Messenger();
		String message = messenger.getMesage("joydip");
		System.out.println(message);
	}
}
