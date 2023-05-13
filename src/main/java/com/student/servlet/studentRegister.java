package com.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Student;
import com.dao.studentDao;
import com.db.DBConnect;

@WebServlet("/student_register")
public class studentRegister extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// getting these from signup.jsp page ,name parameter
			String fullName = req.getParameter("fullname");
			String email = req.getParameter("email");
			String password = req.getParameter("password");

			Student u = new Student(fullName, email, password);

			studentDao dao = new studentDao(DBConnect.getConn());

			HttpSession session = req.getSession();
			boolean f = dao.studentRegister(u);
			if (f) {

	
				session.setAttribute("succMsg","Registration successfull" );

				resp.sendRedirect("signup.jsp");

			} else {

				session.setAttribute("errorMsg", "Something wrong on server");

				resp.sendRedirect("signup.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
