package com.klu.jdbclearning;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LaunchApp3 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Load and register the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		
		String url="jdbc:mysql://localhost:3306/jdbclearning";
		String user="root";
		String password="Lucky@630";
		Connection connect  = DriverManager.getConnection(url,user,password);
		
		
		// creating statement
		
		
		//Connection connects Java to the database, while Statement is the object used to send SQL commands through that connection.
		Statement statement = connect.createStatement();
		
		//execute the query
		//the return type of the executeUpdate is int it will return how many rows are effected
		String sql="SELECT * FROM  studentinfo";
		ResultSet res =statement.executeQuery(sql);
		
		//process the result
		//res will should know what type of data type and column number
		while(res.next()) {
			//using column number
			//System.out.println(res.getInt(1) + " " + res.getString(2) +" " + res.getInt(3) + " "+ res.getString(4) );
			
			//using column name
			
			System.out.println(res.getInt("id") + " " + res.getString("sname") +" " + res.getInt("sage") + " "+ res.getString("scity") );
		}
		
		
		
		
		//close the resources
		res.close();
		statement.close();
		connect.close();

	}

}
