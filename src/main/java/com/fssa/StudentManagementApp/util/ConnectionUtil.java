package com.fssa.StudentManagementApp.util;

import java.sql.Connection;
import java.sql.DriverManager;

import io.github.cdimascio.dotenv.Dotenv;
public class ConnectionUtil {
	 
	 public static Connection getConnection() {
	        Connection con = null;

	        String url, userName, passWord;

	        if (System.getenv("CI") != null) {
	            url = System.getenv("DATABASE_HOST");
	            userName = System.getenv("DATABASE_USERNAME");
	            passWord = System.getenv("DATABASE_PASSWORD");
	        } else {
	            Dotenv env = Dotenv.load();
	            url = env.get("DATABASE_HOST");
	            userName = env.get("DATABASE_USERNAME");
	            passWord = env.get("DATABASE_PASSWORD");
	        }
 
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection(url, userName, passWord);
	            System.out.println("Connection Successful....");
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException("Unable to connect to the database");
	        }
	        return con;
	    }
	 
	 public static void main(String[] args) {
		  Connection con = getConnection();
	}
}

//public static Connection getConnection()  {
//	 
//    Connection con = null;   
//    String url = "jdbc:mysql://localhost:3306/StudentManagementApp"; // url for to connect local database
//    String userName = "root";
//    String passWord = "123456";
//    try {
////        Class.forName("com.mysql.cj.jdbc.Driver");
//        con = DriverManager.getConnection(url, userName, passWord);
//    } catch (Exception e) {
//        e.printStackTrace();
//        throw new RuntimeException("Unable to connect to the database");
//    }
//    return con;
//}
// 
//public static void close(Connection conn , Statement stmt, ResultSet rs){
//     
//    try
//    {
//        if ( rs != null ){
//            rs.close();
//        }
//        if ( stmt != null ) {
//            stmt.close();
//        }
//        if ( conn != null ){
//            conn.close();
//        }
//    }
//    catch(SQLException e){
//         e.printStackTrace();
//					 // No need re throw the exception.
//    }
//}