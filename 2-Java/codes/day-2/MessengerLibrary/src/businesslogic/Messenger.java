package businesslogic;

public class Messenger implements MessengerContract {

	@Override
	public String getMesage(String name) {
		return "Welcome " + name;
	}

}
