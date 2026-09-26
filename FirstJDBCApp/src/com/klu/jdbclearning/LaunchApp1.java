package com.klu.jdbclearning;
import java.sql.*;
public class LaunchApp1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//Load and register the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Establish the connection
		
		//for which we need get the connection object
		//the connection object will be given by a method called get connection 
		//which is present in driver manager class
		
		
		//DriverManager.getConnection(url,user,password);
		
		String url="jdbc:mysql://localhost:3306/jdbclearning";
		String user="root";
		String password="Lucky@630";
		Connection connect  = DriverManager.getConnection(url,user,password);
		
		
		// creating statement
		//In JDBC, Statement is used to send SQL commands from your Java program to the database.
		//eg : 
		//ResultSet result = statement.executeQuery(
		//		"SELECT * FROM students"
		//	);
		
		//Connection connects Java to the database, while Statement is the object used to send SQL commands through that connection.
		Statement statement = connect.createStatement();
		
		//execute the query
		//the return type of the executeUpdate is int it will return how many rows are effected
		String sql="INSERT INTO studentinfo (id, sname , sage, scity) VALUES (1,'Lakshman',19,'Tuni')";
		int rowsEffected =statement.executeUpdate(sql);
		//process the result
		if(rowsEffected==0) {
			System.out.println("Unable to insert the data");
		}
		else {
			System.out.println("Data insert succesfully");
		}
		
		
		
		//close the resources
		statement.close();
		connect.close();

	}

}
