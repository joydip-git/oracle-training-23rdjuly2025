package abstractapp;

public class FileDataAccess extends DataAccess {

	public FileDataAccess() {
	}

	public FileDataAccess(String path) {
		super(path);
	}

	@Override
	public String readData() {
		return "file data";
	}
}
