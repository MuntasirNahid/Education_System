package com.teacher.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.courseEnrollmentDao;
import com.db.DBConnect;

@WebServlet("/updateStatus")
public class updateStatus extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int id = Integer.parseInt(req.getParameter("id"));
			int tid = Integer.parseInt(req.getParameter("tid"));
			String comm = req.getParameter("comm");

			courseEnrollmentDao dao = new courseEnrollmentDao(DBConnect.getConn());

			HttpSession session = req.getSession();

			if (dao.updateCommentStatus(id, tid, comm)) {
				session.setAttribute("succMsg", "Comment Updated");
				resp.sendRedirect("teacher/student.jsp");
			} else {
				session.setAttribute("errorMsg", "Something wrong on server");
				resp.sendRedirect("teacher/student.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}