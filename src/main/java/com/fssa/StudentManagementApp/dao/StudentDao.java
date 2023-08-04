package com.fssa.StudentManagementApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import com.fssa.StudentManagementApp.model.Student;
import com.fsss.StudentManagementApp.Validator.StudentValidator;

public class StudentDao {
//	public static void main(String[] args) throws SQLException {
//		Student student = new Student();
//		student.setDob(LocalDate.of(2004, 02, 13));
//		student.setEmailId("denny@gmail.com");
//		student.setGender("M");
//		student.setMobileNo("8098665678");
//		student.setName("Denny");
//		student.setPassword("Naresh@123");
////		addStudent(student);
////		readStudent();
//		findStudentByName("Denny");
//	}

//	create student
	public static boolean addStudent(Student student) throws SQLException {
		StudentValidator.validateStudent(student);
                       
		try (Connection con = ConnectionUtil.getConnection()) {
			String query = "INSERT INTO students (name,email,mobile_no,password,gender,dob) VALUES(?,?,?,?,?,?)";
			try (PreparedStatement pst = con.prepareStatement(query)) {
				pst.setString(1, student.getName());
				pst.setString(2, student.getEmailId());
				pst.setString(3, student.getMobileNo());
				pst.setString(4, student.getPassword());
				pst.setString(5, student.getGender());
				pst.setDate(6, java.sql.Date.valueOf(student.getDob()));

				int rows = pst.executeUpdate();

				if (rows > 0) {
					return true;
				} else {
					return false;
				}

			}
		}
	}

//	read student
	public static boolean readStudent() throws SQLException {
		try (Connection con = ConnectionUtil.getConnection()) {
			String query = "SELECT * FROM students";
			try (Statement st = con.createStatement()) {
				try (ResultSet rs = st.executeQuery(query)) {
					while (rs.next()) {
						System.out.println("id : "+ rs.getInt(1));
						System.out.println("name : "+ rs.getString(2));
						System.out.println("email id : "+ rs.getString(3));
						System.out.println("mobile no : "+ rs.getString(4));
						System.out.println("password : "+ rs.getString(5));
						System.out.println("gender : "+ rs.getCharacterStream(6));
						System.out.println("dob : "+ rs.getDate(7));
						System.out.println("created_date : "+ rs.getDate(8));
						System.out.println("\n");
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
		try(Connection connection = ConnectionUtil.getConnection()){
			String query = "SELECT * FROM students WHERE name = ?";
			try(PreparedStatement pst = connection.prepareStatement(query)){
				pst.setString(1, name);
				try(ResultSet rs = pst.executeQuery()){
					while(rs.next()) {
						System.out.println("id : "+ rs.getInt(1));
						System.out.println("name : "+ rs.getString(2));
						System.out.println("email id : "+ rs.getString(3));
						System.out.println("mobile no : "+ rs.getString(4));
						System.out.println("password : "+ rs.getString(5));
						System.out.println("gender : "+ rs.getCharacterStream(6));
						System.out.println("dob : "+ rs.getDate(7));
						System.out.println("created_date : "+ rs.getDate(8));
						return true;
					}
				}
			}
		}
		return false;
	}
	
}
