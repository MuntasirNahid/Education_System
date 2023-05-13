<%@page import="com.entity.Student"%>
<%@page import="com.entity.teacher"%>
<%@page import="com.dao.teacherDao"%>
<%@page import="com.entity.course_enrollment"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.courseEnrollmentDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Enrollment</title>
<%@include file="component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}

.backImg {
	background: linear-gradient(rgba(0, 0, 0, .4), rgba(0, 0, 0, .4)),
		url("img/boy1.jpg");
	height: 20vh;
	width: 100%;
	background-size: cover;
	background-repeat: no-repeat;
}
</style>
</head>
<body>
	<c:if test="${empty userObj }">
		<c:redirect url="student_login.jsp"></c:redirect>
	</c:if>

	<%@include file="component/navbar.jsp"%>

	<div class="container-fulid backImg p-5">
		<p class="text-center fs-2 text-white"></p>
	</div>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-9">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 fw-bold text-center text-success">Enrolled
							Course Details</p>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Full Name</th>
									
									<th scope="col">Class Start Date</th>
									<th scope="col">Subject</th>
									<th scope="col">Teacher Name</th>
									<th scope="col">Status</th>

								</tr>
							</thead>
							<tbody>
							
								<%
								Student user = (Student) session.getAttribute("userObj");
								courseEnrollmentDao dao = new courseEnrollmentDao(DBConnect.getConn());
							
								teacherDao dao2 = new teacherDao(DBConnect.getConn());
								
								List<course_enrollment> list = dao.getAllCoursesByLoginStudent(user.getId());
								
								for (course_enrollment ap : list) {
									teacher d = dao2.getTeacherById(ap.getTeacherId());
								%>
								<tr>
									<th><%=ap.getFullName()%></th>
								
									<td><%=ap.getClass_start_date()%></td>
									<td><%=d.getCourse_teaches()%></td>
									<td><%=d.getFullName()%></td>
									<td>
										<%
										if ("Pending".equals(ap.getStatus())) {
										%> <a href="#" class="btn btn-sm btn-warning">Pending</a> <%
										
										} else {
 												%> <%=ap.getStatus()%> <%
 											}
 										%>
									</td>
								</tr>
								<%
								}
								%>



							</tbody>
						</table>

					</div>
				</div>
			</div>

			<div class="col-md-3 p-3">
				<img alt="" src="img/ron1.jpg">
			</div>
		</div>
	</div>


</body>
</html>