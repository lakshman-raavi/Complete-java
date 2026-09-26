package com.klu.jdbclearning;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class LaunchApp5 {
    public static void main(String[] args) {
        

        // Declare connection and statement variables
        Connection connect = null;
        Statement statement = null;

        try {
            // 1. Register the JDBC Driver (Optional for modern JDBC, but good practice)
        	connect=JdbcUtil.getConnection();
            // 3. Creating statement
            statement = connect.createStatement();

            // 4. Execute query
            String sql = "INSERT INTO studentinfo(id, sname, sage, scity) VALUES(2, 'Rohit', 18, 'Bengaluru')";
            int rowAffected = statement.executeUpdate(sql);

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
                JdbcUtil.closeConnection(connect, statement);
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}
