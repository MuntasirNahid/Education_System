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

@WebServlet("/teacherUpdateProfile")
public class editProfile extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String fullName = req.getParameter("fullname");
			String dob = req.getParameter("dob");
			String qualification = req.getParameter("qualification");
			String course = req.getParameter("course");
			String email = req.getParameter("email");
			String mobno = req.getParameter("mobno");

			int id = Integer.parseInt(req.getParameter("id"));

			teacher d = new teacher(id, fullName, dob, qualification, course, email, mobno, "");

			teacherDao dao = new teacherDao(DBConnect.getConn());
			HttpSession session = req.getSession();

			if (dao.editTeacherProfile(d)) {
				
				//session value over ride
				
				teacher updateTeacher = dao.getTeacherById(id);
				session.setAttribute("succMsgd", "Doctor Update Sucessfully..");
				session.setAttribute("teacherObj", updateTeacher);
				resp.sendRedirect("teacher/edit_profile.jsp");
		
			} else {
				session.setAttribute("errorMsgd", "something wrong on server");
				resp.sendRedirect("teacher/edit_profile.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}