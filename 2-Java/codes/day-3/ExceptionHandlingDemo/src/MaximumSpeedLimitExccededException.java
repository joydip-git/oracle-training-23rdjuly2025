
public class MaximumSpeedLimitExccededException extends Throwable {
	private static final long serialVersionUID = -2926012302816788182L;

	public MaximumSpeedLimitExccededException() {
		super("maximum speed limit exceded");
	}

	public MaximumSpeedLimitExccededException(String errorMessage) {
		super(errorMessage);
	}
}
