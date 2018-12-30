package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbTranscation {
	
	static Connection conn = null;
	public static Connection getConnection()
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/team1","root","");
		} 
		catch (SQLException | ClassNotFoundException e) 
		{
			e.printStackTrace();
			
		}
		return conn;
	}

}
