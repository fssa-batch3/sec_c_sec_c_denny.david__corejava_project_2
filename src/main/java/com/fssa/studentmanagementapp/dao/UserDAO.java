package com.fssa.studentmanagementapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.studentmanagement.exceptions.DAOException;
import com.fssa.studentmanagementapp.model.User;
import com.fssa.studentmanagementapp.util.ConnectionUtil;

public class UserDAO {

	public boolean userRegistration(User user) throws Exception {
	    try (Connection connection = ConnectionUtil.getConnection()) {
	        String insertQuery = "INSERT INTO user (name,gender,dob,mobile_no, email_id, password) VALUES (?, ?, ?, ?, ?, ?)";
	        try (PreparedStatement psmt = connection.prepareStatement(insertQuery)) {
	            psmt.setString(1, user.getName());
	            psmt.setString(3, user.getMobileNo());
	            psmt.setString(3, user.getEmail());
	            psmt.setString(3, user.getEmail());
	            psmt.setString(4, user.getPassword());

	            int rowsAffected = psmt.executeUpdate();
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            // Handle any SQLException that may occur during PreparedStatement execution
	            throw new Exception("Error while executing the insert query: " + e.getMessage(), e);
	        }
	    } catch (SQLException e) {
	        // Handle any SQLException that may occur during database connection
	        throw new Exception("Error while connecting to the database: " + e.getMessage(), e);
	    }
	}


	public boolean emailExists(String emailId) throws Exception {
	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement psmt = connection.prepareStatement("SELECT user_id FROM User WHERE email_id = ?")) {
	        
	        psmt.setString(1, emailId);

	        try (ResultSet rs = psmt.executeQuery()) {
	            if (rs.next()) {
	                // If a row with the given email exists, return true
	                return true;
	            }
	        } catch (SQLException e) {
	            // Handle any SQLException that may occur during result set processing
	            throw new Exception("Error while processing the result set: " + e.getMessage(), e);
	        }
	    } catch (SQLException e) {
	        // Handle any SQLException that may occur during database connection or statement creation
	        throw new Exception("Error while checking email existence: " + e.getMessage(), e);
	    }

	    // If no matching email was found, return false
	    return false;
	}


	public static void main(String[] args) throws DAOException, SQLException {
		UserDAO user = new UserDAO();
		
	}

	
	
	
	public boolean userLogin(String emailId, String password) throws Exception {
		
		try (Connection connection = ConnectionUtil.getConnection()) {
			
			String selectQuery = "SELECT COUNT(*) FROM User WHERE email_id = ? AND password = ?";
			
			try (PreparedStatement psmt = connection.prepareStatement(selectQuery)) {
				psmt.setString(1, emailId);
				psmt.setString(2, password);

				try (ResultSet rs = psmt.executeQuery()) {
					if (rs.next()) {
						int count = rs.getInt(1);
						return count==1 ; // Return true if count is greater than 0 (successful login)
					}
				}
			}
		} catch (SQLException e) {
			throw new Exception("Error while checking login for email: " + emailId, e);
		}

		// Return false if no user with the given email and password was found
		return false;
	}
	
	
	
	
	
	

	public User getUserByEmail(String emailId) throws DAOException {

		try (Connection connection = ConnectionUtil.getConnection()) {

			String selectQuery = "SELECT user_id, firstname, lastname, password FROM User WHERE email_id = ?";
			try (PreparedStatement psmt = connection.prepareStatement(selectQuery)) {
				psmt.setString(1, emailId);

				try (ResultSet rs = psmt.executeQuery()) {
					if (rs.next()) {
						User user = new User();
					
						user.setName(rs.getString("name"));
					    user.setPassword(rs.getString("password"));
						user.setMobileNo(rs.getString("mobileNo"));
						return user;
					}
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		return null; // User not found
	}

	public boolean updateUserProfile(User user) throws DAOException {
		String updateQuery = "UPDATE User SET firstname = ?,lastname = ?, password = ? WHERE email_id = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				
				PreparedStatement psmt = connection.prepareStatement(updateQuery)) {

			psmt.setString(1, user.getName());
			
			psmt.setString(3, user.getPassword());

			int rowsUpdated = psmt.executeUpdate();

			return rowsUpdated > 0;

		} catch (SQLException e) {
			throw new DAOException("Error updating user profile: " + e.getMessage());
		}
	}
}