package com.fssa.studentmanagementapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fssa.studentmanagementapp.Enum.Gender;
import com.fssa.studentmanagementapp.Service.StudentService;
import com.fssa.studentmanagementapp.model.Student;
import com.fssa.studentmanagementapp.util.Logger;

/**
 * Servlet implementation class RegistrationServlet
 */
/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/Registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Handles the HTTP POST request for adding a new student.
	 *
	 * @param request  The HttpServletRequest containing student data.
	 * @param response The HttpServletResponse for sending the response.
	 * @throws ServletException If the servlet encounters a servlet-specific
	 *                          problem.
	 * @throws IOException      If an I/O error occurs while handling the request.
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
	
		try {
			// Collect student data from request parameters
			String mobileNo = request.getParameter("mobileNo");			String firstName = request.getParameter("firstName");
			Gender gender = Gender.valueToEnumMapping(request.getParameter("gender"));
			String dobString = request.getParameter("dob"); // Assuming the date format is yyyy-MM-dd
			String emailId = request.getParameter("email");
			String password = request.getParameter("password");
			String confirmPassword = request.getParameter("confirmpass");
		
			
		
			if (!password.equals(confirmPassword)) {
				Logger.info("Password and confirm password doesn't match");
				RequestDispatcher rd = request.getRequestDispatcher("./registration.jsp");
				rd.forward(request, response);
			} 

			// Parse dob from String to LocalDate
			LocalDate dob = LocalDate.parse(dobString);



			// Create a Student object
			Student student = new Student();
			student.setName(firstName);
			student.setGender(gender);
			student.setDob(dob);
			student.setEmailId(emailId);
			student.setPassword(password);
			student.setMobileNo(mobileNo);
			PrintWriter out = response.getWriter();
			// Call the addStudent method to add the student to the Service layer
			boolean success = StudentService.addStudent(student);

			if (success) {
				out.println("Successfully Created an account");
			} else {
				out.println("Failed to Create an account.");
			}
		}	catch (SQLException  e) {
				e.printStackTrace();
				request.setAttribute("ErrorMessage", e.getMessage());
				RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/registration.jsp");
				dispatcher.forward(request, response);			
	}
}
}