package com.fssa.studentmanagementapp.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fssa.studentmanagementapp.Service.StudentClassService;

public class UpdateStudentClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentClassService studentClassService= new StudentClassService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request,response);
	}
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String selectedStudent=(String) request.getParameter("ids");
		String[] arr = selectedStudent.split(",");

		List<Integer> ids = new ArrayList<>();

		for(String item : arr){

			ids.add(Integer.parseInt(item.trim()));
		}

		int selectedClass=Integer.parseInt(request.getParameter("class"));
		
		try {
			studentClassService.updateStudentToClass(ids, selectedClass);
			System.out.println(" Student updated  to class successfully");
		} catch (SQLException e) {
			System.out.println(" Student updation to class failed");
			e.printStackTrace();
		}
		
		response.sendRedirect("./Class.jsp");
	}
}
