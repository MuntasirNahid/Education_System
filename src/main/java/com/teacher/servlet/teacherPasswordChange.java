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

@WebServlet("/teacherChangePassword")
public class teacherPasswordChange extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int tid = Integer.parseInt(req.getParameter("tid"));
		String oldPassword = req.getParameter("oldPassword");
		String newPassword = req.getParameter("newPassword");

		teacherDao dao = new teacherDao(DBConnect.getConn());
		HttpSession session = req.getSession();

		if (dao.checkOldPassword(tid, oldPassword)) {

			if (dao.changePassword(tid, newPassword)) {
				session.setAttribute("succMsg", "Password Change Sucessfully");
				resp.sendRedirect("teacher/edit_profile.jsp");

			} else {
				session.setAttribute("errorMsg", "Something wrong on server");
				resp.sendRedirect("teacher/edit_profile.jsp");
			}

		} else {
			session.setAttribute("errorMsg", "Old Password Incorrect");
			resp.sendRedirect("teacher/edit_profile.jsp");
		}

	}
}