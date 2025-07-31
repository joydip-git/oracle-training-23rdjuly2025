
public class Vehicle {
	public static final float MAX_SPEED = 100;
	private float currentSpeed;

	public Vehicle() {
	}

	public Vehicle(float initialSpeed) {
		currentSpeed = initialSpeed;
	}

	public float getCurrentSpeed() {
		return currentSpeed;
	}

	public void increaseSpeed(float speed) throws MaximumSpeedLimitExccededException {
		if (currentSpeed + speed > MAX_SPEED) {
			throw new MaximumSpeedLimitExccededException("you have exceded maximum speed limit of " + MAX_SPEED);
		} else {
			currentSpeed = speed;
		}
	}
}
