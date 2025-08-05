package diapp;

public class DataManager {
	private DataReader reader;
	
	//supply the instance of any DataReader type (a class which implements the DataReader interface) to the constructor of this class while creating instance of this class
	//DI through constructor
	public DataManager(DataReader reader) {
		//reader = new DbDataReader()/FileDataReader();
		this.reader = reader;
	}
//	public DataManager() {
//		reader = new DbDataReader()/FileDataReader();		
//	}

	public String fetchData() throws Exception {
		//DataReader reader = new DbDataReader()/FileDataReader();
		String data = reader.getData();
		if (data != null && !data.isBlank())
			return data.toUpperCase();
		else
			throw new Exception("data unavailable");
	}
}
