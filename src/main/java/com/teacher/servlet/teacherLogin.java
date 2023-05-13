package com.teacher.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.teacherDao;
import com.db.DBConnect;
import com.entity.teacher;

@WebServlet("/teacherLogin")
public class teacherLogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		HttpSession session = req.getSession();

		teacherDao dao = new teacherDao(DBConnect.getConn());
		teacher teacher = dao.login(email, password);

		if (teacher != null) {
			session.setAttribute("teacherObj", teacher);
			resp.sendRedirect("teacher/index.jsp");
			
		} else {
			session.setAttribute("errorMsg", "invalid email & password");
			resp.sendRedirect("teacher_login.jsp");
		}

	}

}
