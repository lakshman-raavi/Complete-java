package com.klu.jdbcprepraredStatements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.klu.jdbclearning.JdbcUtil;

public class DemoPrepredStatement {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  // Declare connection and statement variables
        Connection connect = null;
        PreparedStatement prep=null;

        try {
            // 1. Register the JDBC Driver (Optional for modern JDBC, but good practice)
        	connect=JdbcUtil.getConnection();
            // 3. Creating statement
            

            // 4. Execute query
            String sql = "INSERT INTO studentinfo(id, sname, sage, scity) VALUES(?,?,?,?)";
            prep=connect.prepareStatement(sql);
            
            
            System.out.println("Please enter the following details to be stored in DB");
            Scanner scan=new Scanner(System.in);
            System.out.println("Enter your id");
            Integer id=scan.nextInt();

            System.out.println("Enter your name");
            String name=scan.next();

            System.out.println("Enter your age");
            Integer age=scan.nextInt();

            System.out.println("Enter your city");
            String addr=scan.next();

            prep.setInt(1, id);
            prep.setString(2, name);
            prep.setInt(3, age);
            prep.setString(4, addr);
            int rowAffected=prep.executeUpdate();
            // 5. Process the result
            if (rowAffected == 0) {
                System.out.println("Unable to insert the data");
            } else {
                System.out.println("Data Inserted Successfully!");
            }

        } catch (Exception e) {
            System.out.println("Some other exception occurred " + e.getMessage());
        } 
        finally {
            // 6. Properly close resources to prevent memory leaks
            try {
                JdbcUtil.closeConnection(connect,prep);
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }

	}

}
