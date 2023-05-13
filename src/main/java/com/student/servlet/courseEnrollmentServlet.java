package com.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.courseEnrollmentDao;
import com.db.DBConnect;
import com.entity.course_enrollment;

@WebServlet("/addCourseEnrollment")
public class courseEnrollmentServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int userId = Integer.parseInt(req.getParameter("studentId"));
		String fullname = req.getParameter("fullname");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String class_start_date = req.getParameter("class_start_date");
		String email = req.getParameter("email");
		String phno = req.getParameter("phno");

		int subject_id = Integer.parseInt(req.getParameter("subject"));
		int teacher_id = Integer.parseInt(req.getParameter("teacher"));
		String expectation = req.getParameter("expectation");

		course_enrollment ap = new course_enrollment(userId, fullname, gender, age, class_start_date, email, phno,
				subject_id, teacher_id, expectation, "Pending");

		courseEnrollmentDao dao = new courseEnrollmentDao(DBConnect.getConn());
		HttpSession session = req.getSession();

		if (dao.addCourseEnrollment(ap)) {
			session.setAttribute("succMsg", "Course Enrolled Sucessfully");
			resp.sendRedirect("course_enrollment.jsp");
		} else {
			session.setAttribute("errorMsg", "Something wrong on server");
			resp.sendRedirect("course_enrollment.jsp");
		}

	}

}