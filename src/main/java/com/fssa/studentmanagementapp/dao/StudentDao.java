package com.fssa.studentmanagementapp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import com.fssa.studentmanagement.exceptions.DAOException;
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
				System.out.println("jnh  "+student.getGender());
				pst.setDate(6, java.sql.Date.valueOf(student.getDob()));
				pst.setDate(7, Date.valueOf(LocalDate.now()));

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

			throw new SQLException(e.getMessage());
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
				pst.setString(2, student.getEmailId());
				pst.setString(3, student.getMobileNo());
				pst.setString(4, student.getPassword());
				pst.setString(5, student.getGender().getValue());
				pst.setDate(6, java.sql.Date.valueOf(student.getDob()));
				pst.setDate(7, java.sql.Date.valueOf(student.getCreatedDate()));
				pst.setInt(8, id);
				int rows = pst.executeUpdate();
				if (rows > 0) {
					return true;
				}
			}
		} catch (SQLException e) {
			Logger.info(e.getMessage());
			e.printStackTrace();
		}
		return false;
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

	public static int getStudentIdByemail(String email) throws SQLException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String query = "select id FROM students WHERE email = ?";
			try (PreparedStatement pst = connection.prepareStatement(query)) {
				pst.setString(1, email);
				ResultSet rs = pst.executeQuery();
				int studentId;
				if (rs.next()) {
					studentId = rs.getInt("id");
					return studentId;
				}

			}
		}
		return -1;
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
						Gender gen = Gender.valueToEnumMapping(rs.getString("gender").toUpperCase());
						stu.setGender(gen);
						stu.setDob(rs.getDate(7).toLocalDate());
						stu.setCreatedDate(rs.getDate(8).toLocalDate());
						stu.setClass_id(getClassByStudentId(rs.getInt(1)));
						return stu;
					}
				}
			}
		}
		return null;
	}

	public static boolean getId(int id) {
		try (Connection con = ConnectionUtil.getConnection()) {
//		   String query = "INSERT INTO students (name,email,mobile_no,password,gender,dob) VALUES(?,?,?,?,?,?)";
			String query = "SELECT CLASS FROM STUDENTS";
			try (Statement st = con.createStatement()) {
				try (ResultSet rs = st.executeQuery(query)) {
					while (rs.next()) {
						rs.getInt(id);

						return true;
					}
				}
			}
		} catch (SQLException e) {
			Logger.info(e.getMessage());
			e.printStackTrace();
		}
		return false;

	}

	public static ArrayList<Student> getAllStudent() throws IllegalArgumentException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			// SQL query to select all rows from the bloodrequest table
			String selectQuery = "SELECT * FROM students";
			try (PreparedStatement psmt = connection.prepareStatement(selectQuery)) {
				try (ResultSet rs = psmt.executeQuery()) {
					// Create an ArrayList to store BloodRequest objects
					ArrayList<Student> Student = new ArrayList<Student>();

					// Loop through the result set to retrieve each row's data
					while (rs.next()) {
						// Create a new BloodRequest object for each row
						Student stu = new Student();

						stu.setId(rs.getInt("id"));
						stu.setName(rs.getString("name"));
						Gender gen = Gender.valueToEnumMapping(rs.getString("gender").toUpperCase());
						stu.setGender(gen);
						System.out.println(Gender.valueToEnumMapping(rs.getString("gender").toUpperCase()));
						stu.setDob(rs.getDate("dob").toLocalDate());
						stu.setEmailId(rs.getString("email"));
						stu.setMobileNo(rs.getString("mobile_no"));
						stu.setCreatedDate(rs.getDate("created_date").toLocalDate());
						stu.setClass_id(getClassByStudentId(rs.getInt("id")));
						// Convert "reqVerification" column to boolean value
						// stu.setVerification(rs.getString("reqVerification").equals("True") ? ACTIVE :
						// INACTIVE);

						// Set the status property using data from the result set
						// stu.setStatus(RequestStatus.valueToEnumMapping(rs.getString("status")));

						// Add the populated BloodRequest object to the ArrayList
						Student.add(stu);
					}

					// Return the ArrayList containing BloodRequest objects
					return Student;
				}
			}
		} catch (SQLException e) {
			// Throw an exception with an error message if a SQL error occurs
			throw new IllegalArgumentException("Error while reading Student: " + e.getMessage());
		}
	}

	public static ArrayList<Student> getStudentsDetailsByIds(ArrayList<Integer> studentIds) {
		ArrayList<Student> studentsList = new ArrayList<Student>();
		try (Connection connection = ConnectionUtil.getConnection()) {

			for (int id : studentIds) {
				String selectQuery = "SELECT * FROM students where id=?";
				try (PreparedStatement psmt = connection.prepareStatement(selectQuery)) {
					psmt.setInt(1, id);
					try (ResultSet rs = psmt.executeQuery()) {

						if (rs.next()) {

							Student stu = new Student();

							stu.setId(rs.getInt("id"));
							stu.setName(rs.getString("name"));
							Gender gen = Gender.valueToEnumMapping(rs.getString("gender").toUpperCase());
							stu.setGender(gen);
							System.out.println(Gender.valueToEnumMapping(rs.getString("gender").toUpperCase()));
							stu.setDob(rs.getDate("dob").toLocalDate());
							stu.setEmailId(rs.getString("email"));
							stu.setMobileNo(rs.getString("mobile_no"));
							stu.setCreatedDate(rs.getDate("created_date").toLocalDate());
							stu.setClass_id(getClassByStudentId(id));
							studentsList.add(stu);
						}

					}
				}
			}

		} catch (SQLException e) {
			throw new IllegalArgumentException("Error while reading Student: " + e.getMessage());
		}
		return studentsList;
	}

	public static int getClassByStudentId(int id) {
		try (Connection con = ConnectionUtil.getConnection()) {
//		   String query = "INSERT INTO students (name,email,mobile_no,password,gender,dob) VALUES(?,?,?,?,?,?)";
			String query = "SELECT class FROM student_class WHERE student_id = ? ";
			try (PreparedStatement pst = con.prepareStatement(query)) {
				pst.setInt(1, id);

				ResultSet rs = pst.executeQuery();
				if (rs.next()) {

					int classNum = rs.getInt("class");
					return classNum;
				}
			}
		} catch (SQLException e) {
			Logger.info(e.getMessage());
			e.printStackTrace();
		}
		return -1;

	}
     
	public static Student findStudentByEmail(String email) throws DAOException, SQLException, Exception {

		Student studentList = new Student();
		try (Connection connection = ConnectionUtil.getConnection()) {

			String query = "SELECT * FROM students WHERE email =?";
			try (PreparedStatement pst = connection.prepareStatement(query)) {
				pst.setString(1, email);
				try (ResultSet rs = pst.executeQuery()) {
					if (rs.next()) {
						Student stu = new Student();

						stu.setId(rs.getInt("id"));
						stu.setName(rs.getString("name"));
						Gender gen = Gender.valueToEnumMapping(rs.getString("gender").toUpperCase());
						stu.setGender(gen);
						System.out.println(Gender.valueToEnumMapping(rs.getString("gender").toUpperCase()));
						stu.setDob(rs.getDate("dob").toLocalDate());
						stu.setEmailId(rs.getString("email"));
						stu.setMobileNo(rs.getString("mobile_no"));

					}

				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new Exception(e);
			}
		}
		return studentList;
	}

}
