package com.fssa.studentmanagementapp.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fssa.studentmanagementapp.Service.StudentService;
import com.fssa.studentmanagementapp.model.Student;

/**
 * Servlet implementation class FindByNameServlet
 */
public class FindByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String searchedName = request.getParameter("search").trim();//

		List<Student> resultStudents = new ArrayList<Student>();

		List<Student> allStudents = StudentService.getAllStudent();

		for (Student student : allStudents) {

			if (student.getName().toLowerCase().startsWith(searchedName)
					|| student.getName().startsWith(searchedName)) {
				// If the plant matches the search criteria, add it to the resultPlants list.
				resultStudents.add(student);
			}

		}

		// next JSP page.
		request.setAttribute("STUDENT_LIST", resultStudents);

		RequestDispatcher rd = request.getRequestDispatcher("./studentList.jsp");

		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
