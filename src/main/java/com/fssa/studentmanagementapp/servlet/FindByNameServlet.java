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
import com.fssa.studentmanagementapp.model.Student;
import com.fssa.studentmanagementapp.Service.StudentService;

/**
 * Servlet implementation class Sample
 */
@WebServlet("/FindStudentByName")
public class FindByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

//		response.getWriter().append("Served at: ").append(request.getContextPath());

		
        String name = request.getParameter("name");
		try {
			Student stu = StudentService.findStudentByName(name);
			request.setAttribute("STUDENT_DETAIL", stu);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		RequestDispatcher dis = getServletContext().getRequestDispatcher("/index.jsp");
		dis.forward(request, response);
	}

}
