<%@page import="com.entity.teacher"%>
<%@page import="com.dao.teacherDao"%>
<%@page import="com.entity.course_enrollment"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.courseEnrollmentDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Details</title>
<%@include file="../component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<div class="col-md-12">
		<div class="card paint-card">
			<div class="card-body">
				<p class="fs-3 text-center">Student Details</p>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Full Name</th>
							<th scope="col">Gender</th>
							<th scope="col">Age</th>
							<th scope="col">Class Start Date</th>
							<th scope="col">Email</th>
							<th scope="col">Mob No</th>
							<th scope="col">Subject</th>
							<th scope="col">Teacher Name</th>
							<th scope="col">Address</th>
							<th scope="col">Status</th>
						</tr>
					</thead>
					<tbody>
						<%
						courseEnrollmentDao dao = new courseEnrollmentDao(DBConnect.getConn());
						teacherDao dao2 = new teacherDao(DBConnect.getConn());
						
						List<course_enrollment> list = dao.getAllCourseEnrollment();
						
						for (course_enrollment ap : list) {
							teacher d = dao2.getTeacherById(ap.getTeacherId());
						%>
						<tr>
							<th><%=ap.getFullName()%></th>
							<td><%=ap.getGender()%></td>
							<td><%=ap.getAge()%></td>
							<td><%=ap.getClass_start_date()%></td>
							<td><%=ap.getEmail()%></td>
							<td><%=ap.getPhNo()%></td>
							<td><%=d.getCourse_teaches()%></td>
							<td><%=d.getFullName()%></td>
							<td><%=ap.getExpectation()%></td>
							<td><%=ap.getStatus()%></td>
						</tr>
						<%
						}
						%>


					</tbody>
				</table>

			</div>
		</div>
	</div>
</body>
</html>