package database_connector;

public class Main {
	
	
	public static void main(String[] args) {
		
	
		MySQL_DB_ConnectJ instance = new MySQL_DB_ConnectJ("account");
		
		instance.Insert();
		
		String db = instance.Select();
		
		System.out.println(db);
		
		
		
		
		
		
		
		
		
	
		
		
	}
	
	

}
