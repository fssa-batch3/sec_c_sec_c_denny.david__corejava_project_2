package com.fssa.StudentManagementApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.fssa.StudentManagementApp.model.Student;
import com.fssa.StudentManagementApp.util.ConnectionUtil;
import com.fssa.StudentManagementApp.util.Logger;
import com.fssa.studentmanagement.exceptions.DAOException;
import com.fsss.StudentManagementApp.Validator.StudentValidator;

public class StudentDao {
	

//	create student
	public static boolean addStudent(Student student) throws  SQLException{
		StudentValidator.validateStudent(student);

		try (Connection con = ConnectionUtil.getConnection()) {
			String query = "INSERT INTO students (name,email,mobile_no,password,gender,dob) VALUES(?,?,?,?,?,?)";
			try (PreparedStatement pst = con.prepareStatement(query)) {
				pst.setString(1, student.getName());
				pst.setString(2, student.getEmailId());
				pst.setString(3, student.getMobileNo());
				pst.setString(4, student.getPassword());
				pst.setString(5, student.getGender()+"");
				pst.setDate(6, java.sql.Date.valueOf(student.getDob()));

				int rows = pst.executeUpdate();

				System.out.println(rows);
				if (rows > 0) {
					return true;
				} else {
					return false;
				}

			} 
		}catch (SQLException e) {
			e.printStackTrace();;
			throw new SQLException("Error while connecting to DB");
		}
	
	}
	
	
//	read student
	public static boolean readStudent() throws SQLException {
		try (Connection con = ConnectionUtil.getConnection()) {
			String query = "SELECT * FROM students";
			try (Statement st = con.createStatement()) {
				try (ResultSet rs = st.executeQuery(query)) {
					while (rs.next()) {
						Logger.info("id : " + rs.getInt(1));
						Logger.info("name : " + rs.getString(2));
						Logger.info("email id : " + rs.getString(3));
						Logger.info("mobile no : " + rs.getString(4));
						Logger.info("password : " + rs.getString(5));
						Logger.info("gender : " + rs.getCharacterStream(6));
						Logger.info("dob : " + rs.getDate(7));
						Logger.info("created_date : " + rs.getDate(8));
						Logger.info("\n"); 
					}
				}
			}
		}
		return false;
	}

//	update student
	public static boolean updateStudent(Student student, int id) throws SQLException {
		try (Connection con = ConnectionUtil.getConnection()) {
//		   String query = "INSERT INTO students (name,email,mobile_no,password,gender,dob) VALUES(?,?,?,?,?,?)";
			String query = "UPDATE students SET name = ? WHERE id = ?";
			try (PreparedStatement pst = con.prepareStatement(query)) {
				pst.setString(1, student.getName());
				pst.setInt(2, id);
				int rows = pst.executeUpdate();
				if (rows > 0) {
					return true;
				} else {
					return false;
				}
			}
		}
	}

//	delete student
	public static boolean deleteStudent(int id) throws SQLException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String query = "DELETE FROM students WHERE id = ?";
			try (PreparedStatement pst = connection.prepareStatement(query)) {
				pst.setInt(1, id);
				int rows = pst.executeUpdate();
				if (rows > 0) {
					return true;
				} else {
					return false;
				}
			}
		}
	}

//	findStudentByName
	public static boolean findStudentByName(String name) throws SQLException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String query = "SELECT * FROM students WHERE name = ?";
			try (PreparedStatement pst = connection.prepareStatement(query)) {
				pst.setString(1, name);
				try (ResultSet rs = pst.executeQuery()) {
					while (rs.next()) {
						Logger.info("id : " + rs.getInt(1));
						Logger.info("name : " + rs.getString(2));
						Logger.info("email id : " + rs.getString(3));
						Logger.info("mobile no : " + rs.getString(4));
						Logger.info("password : " + rs.getString(5));
						Logger.info("gender : " + rs.getCharacterStream(6));
						Logger.info("dob : " + rs.getDate(7));
						Logger.info("created_date : " + rs.getDate(8));
						return true;
					}
				}
			}
		}
		return false;
	}

}
