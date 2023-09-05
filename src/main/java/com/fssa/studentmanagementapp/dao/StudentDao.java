package com.fssa.studentmanagementapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fssa.studentmanagementapp.Enum.Gender;
import com.fssa.studentmanagementapp.Validator.StudentValidator;
import com.fssa.studentmanagementapp.model.Student;
import com.fssa.studentmanagementapp.util.ConnectionUtil;
import com.fssa.studentmanagementapp.util.Logger;

public class StudentDao {

//	create student
	public static boolean addStudent(Student student) throws SQLException {
		StudentValidator.validateStudent(student);

		try (Connection con = ConnectionUtil.getConnection()) {
			String query = "INSERT INTO students (name,email,mobile_no,password,gender,dob,created_date) VALUES(?,?,?,?,?,?,?)";
			try (PreparedStatement pst = con.prepareStatement(query)) {
				pst.setString(1, student.getName());
				pst.setString(2, student.getEmailId());
				pst.setString(3, student.getMobileNo());
				pst.setString(4, student.getPassword());
				pst.setString(5, student.getGender() + "");
				pst.setDate(6, java.sql.Date.valueOf(student.getDob()));
				pst.setDate(7, java.sql.Date.valueOf(student.getCreatedDate()));

				int rows = pst.executeUpdate();

				System.out.println(rows);
				if (rows > 0) {
					return true;
				} else {
					return false;
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
			;
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
	public static boolean updateStudent(Student student, int id) {
		try (Connection con = ConnectionUtil.getConnection()) {
//		   String query = "INSERT INTO students (name,email,mobile_no,password,gender,dob) VALUES(?,?,?,?,?,?)";
			String query = "UPDATE students SET name=?,email=?,mobile_no=?,password=?,gender=?,dob=?,created_date=? WHERE id = ?";
			try (PreparedStatement pst = con.prepareStatement(query)) {
				pst.setString(1, student.getName());
				pst.setInt(2, id);
				pst.setString(3, student.getEmailId());
				pst.setString(4, student.getMobileNo());
				pst.setString(5, student.getPassword());
				pst.setString(6, student.getGender() + "");
				pst.setDate(7, java.sql.Date.valueOf(student.getDob()));
				pst.setDate(8, java.sql.Date.valueOf(student.getCreatedDate()));
				int rows = pst.executeUpdate();
				if (rows > 0) {
					return true;
				} else {
					return false;
				}
			}
		} catch (SQLException e) {
			Logger.info(e.getMessage());
			e.printStackTrace();
		}
		return true;
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
	public static Student findStudentByName(String name) throws SQLException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String query = "SELECT * FROM students WHERE name = ?";
			try (PreparedStatement pst = connection.prepareStatement(query)) {
				pst.setString(1, name);
				try (ResultSet rs = pst.executeQuery()) {
					if (rs.next()) {

						Student stu = new Student();

						stu.setId(rs.getInt(1));
						stu.setName(rs.getString(2));
						stu.setEmailId(rs.getString(3));
						stu.setMobileNo(rs.getString(4));
						Gender gen = Gender.valueOf(rs.getString(6));
						stu.setGender(gen);
						stu.setDob(rs.getDate(7).toLocalDate());
						stu.setCreatedDate(rs.getDate(8).toLocalDate());

						return stu;
					}
				}
			}
		}
		return null;
	}

}
