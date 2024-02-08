package com.fssa.studentmanagementapp.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fssa.studentmanagementapp.Service.StudentClassService;
import com.fssa.studentmanagementapp.model.Student;

public class StudentsByClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentClassService studentClassService = new StudentClassService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int classId=Integer.parseInt(request.getParameter("classId")) ;
		ArrayList<Student> studentDetails = null;
		try {
			studentDetails = studentClassService.getStudentsByClass(classId);
		} catch (SQLException e) {
			System.out.println("error in getting student details");
			e.printStackTrace();
		}
		request.setAttribute("STUDENT_LIST", studentDetails);
	RequestDispatcher rd = request.getRequestDispatcher("./studentList.jsp");
	rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
