package com.klu.jdbcprepraredStatements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.klu.jdbclearning.JdbcUtil;

public class Launch7 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  // Declare connection and statement variables
        Connection connect = null;
        PreparedStatement prep=null;
        Scanner scan=new Scanner(System.in);
        try {
            connect=JdbcUtil.getConnection();
          //String sql="UPDATE studentinfo SET sage=? WHERE id=?";
          //String sql="DELETE FROM studentinfo WHERE id=?";
            String sql="SELECT * FROM studentinfo WHERE id=?";
			prep=connect.prepareStatement(sql);
			

//            System.out.println("Enter your age");
//            Integer age=scan.nextInt();
            
			System.out.println("Enter your id");
            Integer id=scan.nextInt();


//			prep.setInt(1, age);
			prep.setInt(1, id);
			
			ResultSet res=prep.executeQuery();
			if(res.next()) {
				System.out.println("Record Retrived Successfully");
				System.out.println(res.getInt("id") + " " + res.getString("sname") +" " + res.getInt("sage") + " "+ res.getString("scity"));
			}
			else {
				System.out.println("Record Not Retrived");
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
