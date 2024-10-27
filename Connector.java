package database_connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Connector {
	
	private static String link =
	"jdbc:mysql://localhost/";
	private static String user_and_password = "?User=root&Password=root";
	
	private static String Query = "select * from ";
	
	private Connection connection;// connect MySql Server
	private Statement statement;  //  get MySql Data
//	private PreparedStatement preparedStatement; // set MySql Data
	private ResultSet resultSet;  // cursor data set
	
	
	public Connector(String db_name) {
		
		System.out.println("welecom to MySQL Server");
		
		try {
			connection= DriverManager.getConnection(link+db_name+user_and_password); // link with driver or driver manger 
			statement = connection.createStatement();
			
			
		}catch(Exception ex) {
			System.out.println("constract : " + ex.toString());
		}
		
		
	
	}
	 
	
	 void WriteDatabase(String name,String email,double salary) {
		try { 
			String insertQuery = "insert into employe(emp_full_name,emp_email,salary) values('"+ name +"','"+ email +"'," + salary +");";
			
			 connection.prepareStatement(insertQuery).executeUpdate();
			
			
		} catch (SQLException e) {
 
			System.out.println(e.toString());
		}
	}
	
	
	public String ReadDatabase(String table) {
		String result = "";
		
		try {
			
			resultSet = statement.executeQuery(Query+table+";");
				
			while(resultSet.next()) {
				
				String dash = "\n**************************************************\n";

				String ID = "emp ID : " + resultSet.getString("emp_id") + "\n";
				String full_name = "emp full_name : " + resultSet.getString("emp_full_name") + "\n";
				String fullemail = "emp email : " + resultSet.getString("emp_email") + "\n";
				double salary = resultSet.getDouble("salary");
				String emp_salary = "emp salary : $" + salary + "\n";
				
				
				result += dash + ID + full_name+ fullemail + emp_salary + dash;
			}
			
			if (result.equals("")) {
				return "Empty set (0.00Sec)";
			}
				
			 
		}catch (SQLException e) {
			System.out.println("function read db" + e.toString());
		}
		return result;
		
		
	}
	
	
	
	public void Delete(int id ) {
			

		try {
			connection.prepareStatement("delete from employe where emp_id = " + id).executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public String ShowTables() {
			
		String[] list;
		int row  = 0;
		try {
			resultSet = statement.executeQuery("show tables;");
			
			while(resultSet.isAfterLast()) {
				 list = new String[resultSet.getRow()];
				 row = resultSet.getRow();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return("row : " + row);
	}
	
	
	
	
	
	

}
