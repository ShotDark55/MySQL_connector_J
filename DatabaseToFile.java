package database_connector;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.StringJoiner;

public class DatabaseToFile {
	

	
		
			private static final String mysql = "jdbc:mysql://localhost/";
			private static final String user_pass = "?User=root&Password=root";
			private static final String root = "C:/Users/oussama/Desktop/";
		public static void main(String[] args) {
			
			
			saveDB("employe_mail.txt", getDB("account","employe","emp_email"));
			
		}
		
		
		
		public static void saveDB(String filename,String data) {
			File f = new File(root+filename);
			try {
				FileOutputStream out = new FileOutputStream(f);
				if (f.exists()) {
					System.out.println("file was save at :");
					System.out.println(f.getAbsolutePath() + "......");
				}else {
					System.out.println("your file doesn't save ! ");
				}
				out.write(data.getBytes());
				out.close();
			}catch(Exception ex) {
				
			}
		}
		
		
		public static String getDB(String db,String table,String column) {
			
			StringJoiner joiner = new StringJoiner("\n","{\n" , "\n}");
			joiner.setEmptyValue("not data (0.00s)...");
			try {
				Connection connection = DriverManager.getConnection(mysql+db+user_pass);
				Statement statement = connection.createStatement();
				ResultSet set = statement.executeQuery("select " + column + " from " + table + ";");
				
				while(set.next()) {
					joiner.add(set.getString(1)); 
				}
				
			}catch (Exception ex) {
				System.out.println(ex.toString());
			}
			
			
			
			return joiner.toString();
		}
		
	}	
	


