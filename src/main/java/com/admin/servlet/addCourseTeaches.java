package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.courseTeachesDao;
import com.db.DBConnect;
import com.entity.Student;

@WebServlet("/addCourseTeaches")
public class addCourseTeaches extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String courseName = req.getParameter("courseName");

		courseTeachesDao dao = new courseTeachesDao(DBConnect.getConn());
		boolean f = dao.addCourseTeaches(courseName);

		HttpSession session = req.getSession();

		if (f) {
			session.setAttribute("succMsg", "Course Added");
			resp.sendRedirect("admin/index.jsp");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
			resp.sendRedirect("admin/index.jsp");
		}

	}

}