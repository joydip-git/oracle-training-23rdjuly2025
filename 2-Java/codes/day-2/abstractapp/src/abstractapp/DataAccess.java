package abstractapp;

public abstract class DataAccess implements IDataAccess {
	private String path;

	public DataAccess() {
	}

	public DataAccess(String path) {
		this.path = path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPath() {
		return this.path;
	}

	public abstract String readData();
}
