package com.fssa.studentmanagementapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fssa.studentmanagement.exceptions.DAOException;
import com.fssa.studentmanagementapp.Enum.Gender;
import com.fssa.studentmanagementapp.Service.StudentService;
import com.fssa.studentmanagementapp.model.Student;

/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/AddStudent")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddStudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String strId = request.getParameter("id");
		String name = request.getParameter("name");
		Gender gender = Gender.valueOf(request.getParameter("gender"));
		String createdDate = request.getParameter("createdDate");
		String mobileNo = request.getParameter("mobileNo");
		String dateOfBirth = request.getParameter("dob");
		String emailId = request.getParameter("email");
		String password = request.getParameter("password");
		int id = Integer.parseInt(strId);
		LocalDate dob = LocalDate.parse(dateOfBirth);
		LocalDate createDate = LocalDate.parse(createdDate);
		try {
			Student student = new Student();
			student.setCreatedDate(createDate);
			student.setDob(dob);
			student.setEmailId(emailId);
			student.setGender(gender);
			student.setId(id);
			student.setMobileNo(password);
			student.setName(name);
			student.setPassword(password);

			boolean isAdded = StudentService.addStudent(student);
			if (isAdded) {
				out.println("Successfully added the student");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
