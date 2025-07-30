package abstractapp;

public class DbDataAccess extends DataAccess {
	
	public DbDataAccess() {}
	
	public DbDataAccess(String path) {
		super(path);
	}
	
	@Override
	public String readData() {
		return "db data";
	}
}
