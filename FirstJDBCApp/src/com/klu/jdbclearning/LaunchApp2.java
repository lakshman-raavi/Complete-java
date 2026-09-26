package com.klu.jdbclearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class LaunchApp2 {

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
				String sql="UPDATE studentinfo SET sage=20 WHERE id=1";
				int rowsEffected =statement.executeUpdate(sql);
				//process the result
				if(rowsEffected==0) {
					System.out.println("Unable to Update the data");
				}
				else {
					System.out.println("Data Updated succesfully");
				}
				
				
				
				
				//close the resources
				statement.close();
				connect.close();
	}

}
