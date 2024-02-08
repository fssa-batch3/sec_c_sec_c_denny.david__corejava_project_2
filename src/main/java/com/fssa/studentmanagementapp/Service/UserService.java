package com.fssa.studentmanagementapp.Service;

import java.sql.SQLException;

import com.fssa.studentmanagementapp.exceptions.DAOException;
import com.fssa.studentmanagementapp.exceptions.InvalidUserDetailException;
import com.fssa.studentmanagementapp.Validator.UserValidator;
import com.fssa.studentmanagementapp.dao.UserDAO;
import com.fssa.studentmanagementapp.model.User;
import com.google.protobuf.ServiceException;

public class UserService {
	
	UserDAO userDAO = new UserDAO();

	public boolean userSignUp(User user) throws Exception {
	    try {
	        if (UserValidator.validateUser(user)) {
	            return userDAO.userRegistration(user);
	        }
	    } catch (InvalidUserDetailException | DAOException e) {
	        throw new ServiceException("Error during user sign-up: " + e.getMessage(), e);
	    }
	    return false;
	 
	}



	public boolean userLogin(String emailId, String password) throws Exception, InvalidUserDetailException, DAOException, SQLException {
	    if (userDAO.emailExists(emailId)) {
		    return userDAO.userLogin(emailId, password);
		} else {
		    return false;
		}
	    
	}


	public User getUserByEmail(String emailId) throws Exception, SQLException {
		try {
			if (UserValidator.validateUserEmailId(emailId)) {
				if (userDAO.emailExists(emailId)) {
					return userDAO.getUserByEmail(emailId);
				} else {
					throw new DAOException("User not found for email: " + emailId);
				}
			}
		} catch (InvalidUserDetailException | DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		return null; // Invalid email format
	}

	public boolean updateUserProfile(User user) throws Exception, SQLException {
		try {
			if (UserValidator.validateUser(user)) {
				if (userDAO.emailExists(user.getEmail())) {
					return userDAO.updateUserProfile(user);
				} else {
					throw new DAOException("Email not found: " + user.getEmail());
				}
			}
		} catch (DAOException | InvalidUserDetailException e) {
			throw new ServiceException("Error updating user profile: " + e.getMessage());
		}
		return false;
	}
	
}
