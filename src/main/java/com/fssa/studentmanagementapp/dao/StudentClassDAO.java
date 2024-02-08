package com.fssa.studentmanagementapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fssa.studentmanagementapp.Enum.Gender;
import com.fssa.studentmanagementapp.Enum.Stu_Status;
import com.fssa.studentmanagementapp.model.Student;
import com.fssa.studentmanagementapp.model.StudentClass;
import com.fssa.studentmanagementapp.util.ConnectionUtil;

public class StudentClassDAO {
	// Reading the students in a classwise
	public static StudentClass readClass() throws SQLException {
		try (Connection con = ConnectionUtil.getConnection()) {
			String query = "SELECT * FROM student_class";
			try (Statement st = con.createStatement()) {
				try (ResultSet rs = st.executeQuery(query)) {
					while (rs.next()) {
						StudentClass stu = new StudentClass();
						stu.setId(rs.getInt(1));
						stu.setStudentId(rs.getInt(2));
						stu.setStandard(rs.getInt(3));
						Stu_Status status = Stu_Status.valueOf(rs.getString(4));
						stu.setStatus(status);
						return stu;
					}
				}
			}
		}
		return null;
	}

	public static int Class() throws SQLException {
		try (Connection con = ConnectionUtil.getConnection()) {
			String query = "SELECT class FROM student_class ";
			try (Statement st = con.createStatement()) {
				try (ResultSet rs = st.executeQuery(query)) {
					while (rs.next()) {
						return rs.getInt(1);
					}
				}
			}
		}
		return 0;

	}

	public static boolean assignStudentToClass(String email, int classNum) throws SQLException {
		try (Connection con = ConnectionUtil.getConnection()) {
			String query = "INSERT INTO student_class (student_id, class, status) VALUES(?,?,?)";
			try (PreparedStatement pst = con.prepareStatement(query)) {
				int studentId = StudentDao.getStudentIdByemail(email);
				pst.setInt(1, studentId);
				pst.setInt(2, classNum);
				pst.setString(3, Stu_Status.ACTIVE + "");

				int rows = pst.executeUpdate();
				System.out.println(rows + "row/rows affected");
				return true;
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
		return false;
	}
	
	public static boolean updateStudentToClass(List<Integer> ids, int classNum) throws SQLException {
		try (Connection con = ConnectionUtil.getConnection()) {

			String query = "Update student_class SET  class=? WHERE student_id=?";

			for(int item : ids){


			try (PreparedStatement pst = con.prepareStatement(query)) {
				pst.setInt(1, classNum);
				pst.setInt(2, item);

				int rows = pst.executeUpdate();

				}

			}

		}
		catch(Exception e) {
			e.printStackTrace();
			throw new SQLException(e);
        }
	return true;
	}

//getStudentsByClass
	public static ArrayList<Student> getStudentsByClass(int classNum) throws SQLException {

		try (Connection connection = ConnectionUtil.getConnection()) {
			// SQL query to select all rows from the bloodrequest table
			String selectQuery = "SELECT student_id FROM student_class where class=? ";
			try (PreparedStatement psmt = connection.prepareStatement(selectQuery)) {
				psmt.setInt(1, classNum);
				try (ResultSet rs = psmt.executeQuery()) {
					
					ArrayList<Integer> studentIds= new ArrayList<Integer>();
					while (rs.next()) {
				
						studentIds.add(rs.getInt("student_id"));
					}

					return StudentDao.getStudentsDetailsByIds(studentIds);
				}
			}
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error while reading Student: " + e.getMessage());
		}
	}
	
	
}
