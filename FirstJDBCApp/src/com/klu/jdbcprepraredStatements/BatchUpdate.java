package com.klu.jdbcprepraredStatements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.klu.jdbclearning.JdbcUtil;

public class BatchUpdate {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  // Declare connection and statement variables
        Connection connect = null;
        PreparedStatement prep=null;
        Scanner scan=new Scanner(System.in);
        try {
            connect=JdbcUtil.getConnection();
            String sql="UPDATE studentinfo SET sage=? WHERE id=?";
          //String sql="DELETE FROM studentinfo WHERE id=?";
          //String sql="SELECT * FROM studentinfo WHERE id=?";
			prep=connect.prepareStatement(sql);
			

//            System.out.println("Enter your age");
//            Integer age=scan.nextInt();
            
//			System.out.println("Enter your id");
//            Integer id=scan.nextInt();


			prep.setInt(1, 75);
			prep.setInt(2, 1);
			prep.addBatch();
			prep.setInt(1, 76);
			prep.setInt(2, 4);
			prep.addBatch();
			prep.setInt(1, 77);
			prep.setInt(2, 5);
			prep.addBatch();
			
			
			
			prep.executeBatch();
			System.out.println("Check the data base for updated result");

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
