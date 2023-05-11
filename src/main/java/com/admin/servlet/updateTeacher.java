package com.admin.servlet;

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

@WebServlet("/updateTeacher")
public class updateTeacher extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String fullName = req.getParameter("fullname");
			String dob = req.getParameter("dob");
			String qualification = req.getParameter("qualification");

			String course = req.getParameter("course");

			String email = req.getParameter("email");
			String mobno = req.getParameter("mobno");
			String password = req.getParameter("password");

			int id = Integer.parseInt(req.getParameter("id"));

			teacher d = new teacher(id, fullName, dob, qualification, course, email, mobno, password);
		
			teacherDao dao = new teacherDao(DBConnect.getConn());
			HttpSession session = req.getSession();

			if (dao.updateTeacher(d)) {
				session.setAttribute("sucMsg", "Teacher Update Sucessfully..");
				resp.sendRedirect("admin/teacher.jsp");
			} else {
				session.setAttribute("errMsg", "something wrong on server");
				resp.sendRedirect("admin/teacher.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
