package database_connector;

import java.util.Scanner;

public class MySQL_DB_ConnectJ extends Connector{
	

	
	public MySQL_DB_ConnectJ(String db_name) {
		super(db_name);  // db name is non static
		// TODO Auto-generated constructor stub
	}



	public static Scanner scanner = new Scanner(System.in);
	
	public void Insert() {
		
		System.out.println("enter name : "); 
		String name = scanner.nextLine();
		
		System.out.println("enter email : ");
		String email = scanner.nextLine();
		
		System.out.println("enter salary : ");
		double salary = scanner.nextDouble();
	
		WriteDatabase(name,email,salary);
	}
	
	
	
	public String Select() {
		System.out.println("enter table : ");
		String table = scanner.nextLine();
		return(ReadDatabase(table));
	}
	
	

}
