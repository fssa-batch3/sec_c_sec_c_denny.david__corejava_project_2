package com.fssa.studentmanagementapp.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fssa.studentmanagementapp.Service.StudentClassService;
import com.fssa.studentmanagementapp.Service.StudentService;
import com.fssa.studentmanagementapp.model.Student;
import com.fssa.studentmanagementapp.util.Logger;

/**
 * Servlet implementation class AssignStudent
 */
public class AssignStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	StudentClassService studentClassService= new StudentClassService();
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchedStudentId = request.getParameter("StudentId");
		String searchedClassId = request.getParameter("ClassId");
		
		// Get a list of all students
		List<Student> allStudents = StudentService.getAllStudent();

		// Assuming StudentService.getId() and StudentClassService.getClass() return
		// data
		// Retrieve the student ID and class information
		int studentId = Integer.parseInt(searchedStudentId);
		int classId = Integer.parseInt(searchedClassId);
		Logger.info(studentId);
		Logger.info(classId);

		try {
			StudentService.getId(studentId);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		try {
			StudentClassService.getClass(classId);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		// Set the retrieved data as request attributes for use in the JSP page
		request.setAttribute("allStudents", allStudents);
		request.setAttribute("studentId", studentId);
		request.setAttribute("classId", classId);

		// Forward the request to a JSP page for rendering
		request.getRequestDispatcher("yourJspPage.jsp").forward(request, response);
	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String selectedStudent=(String) request.getParameter("selectedStudent");
		int selectedClass=Integer.parseInt(request.getParameter("ClassId")) ;
		System.out.println(selectedStudent + " hi");
		System.out.println(selectedClass + "Hi");
		try {
			studentClassService.assignStudentToClass(selectedStudent, selectedClass);
			System.out.println(" Student Assigned  to class successfully");
		} catch (SQLException e) {
			System.out.println(" Student Assigned  to class failed");
			e.printStackTrace();
		}
		
		response.sendRedirect("./StudentList");
	}

}
