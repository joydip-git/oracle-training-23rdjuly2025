import java.time.LocalDate;

public class App {

//	private static int Divide() {
//		int x = 10;
//		int y = 0;
//		int z = 0;
//		try {
//			z = x / y;
//			return z;
//		} catch (ArithmeticException e) {
//			throw e;
//		} catch (Exception e) {
//			throw e;
//		}
//	}
	private static int Divide() throws ArithmeticException {
		int x = 10;
		int y = 0;
		int z = 0;

		try {
			z = x / y;
			return z;
		} catch (ArithmeticException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}

	public static void main(String[] args) {

		int result = 0;
		DrivingLicenseApplication application = null;
		try {
			application = new DrivingLicenseApplication();
			application.setName("anil");
			application.setDateOfBirth(LocalDate.parse("2010-12-03"));
			result = Divide();
		} catch (AgeLessThanEighteenException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (ArithmeticException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println(result == 0 ? "NA" : result);
		}
	}
}
