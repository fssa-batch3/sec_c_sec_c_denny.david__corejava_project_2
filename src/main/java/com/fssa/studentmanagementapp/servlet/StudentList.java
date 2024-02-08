package com.fssa.studentmanagementapp.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fssa.studentmanagementapp.Service.StudentService;
import com.fssa.studentmanagementapp.model.Student;

/**
 * Servlet implementation class StudentList
 */
public class StudentList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Student> stu = StudentService.getAllStudent();
		request.setAttribute("STUDENT_LIST", stu);

		RequestDispatcher dis = request.getRequestDispatcher("./studentList.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
