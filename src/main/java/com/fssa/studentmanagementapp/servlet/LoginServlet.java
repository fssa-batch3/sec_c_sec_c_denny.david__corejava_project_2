package com.fssa.studentmanagementapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fssa.studentmanagementapp.Service.StudentService;
import com.fssa.studentmanagementapp.model.Student;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String email = request.getParameter("email");
//		String password = request.getParameter("password");
//		HttpSession session = request.getSession();
//		if (email.equals("admin@gmail.com") && password.equals("Admin@123")) {
//			response.sendRedirect("./home.jsp");
//		} else {
//			try {
//				Student student = StudentService.findStudentByEmail(email);
//				System.out.println(student);
//
//				System.out.println(password);
//				System.out.println(student.getPassword());
//				if (student != null && student.isActive() && password.equals(student.getPassword())) {
//					session.setAttribute("email", email);
//
//					session.setAttribute("LoggedStudent", email);
//
//					response.sendRedirect("./home.jsp");
//				} else {
//					request.setAttribute("ErrorMessage", "Invalid email or password");
//					RequestDispatcher rd = request.getRequestDispatcher("./login.jsp");
//					rd.forward(request, response);
//				}
//			} catch (Exception e) {
//				request.setAttribute("ErrorMessage", e.getMessage());
//				RequestDispatcher rd = request.getRequestDispatcher("./login.jsp");
//				rd.forward(request, response);
//			}
//
//		}
//	}

	

}