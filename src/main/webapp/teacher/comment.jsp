<%@page import="com.entity.course_enrollment"%>
<%@page import="com.entity.teacher"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.courseEnrollmentDao"%>
<%@page import="com.dao.teacherDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Comment Page</title>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}

.backImg {
	background: linear-gradient(rgba(0, 0, 0, .4), rgba(0, 0, 0, .4)),
		url("../img/boy1.jpg");
	height: 20vh;
	width: 100%;
	background-size: cover;
	background-repeat: no-repeat;
}
</style>
<%@include file="../component/allcss.jsp"%>
</head>
<body>
	<c:if test="${empty teacherObj }">
		<c:redirect url="../teacher_login.jsp"></c:redirect>
	</c:if>


	<%@include file="navbar.jsp"%>
	<div class="container-fulid backImg p-5">
		<p class="text-center fs-2 text-white"></p>
	</div>
	<div class="container p-3">
		<div class="row">

			<div class="col-md-6 offset-md-3">
				<div class="card paint-card">
					<div class="card-body">
						<p class="text-center fs-4">Student Comment</p>

						<%
						int id = Integer.parseInt(request.getParameter("id"));
					
						courseEnrollmentDao dao = new courseEnrollmentDao(DBConnect.getConn());
					
						course_enrollment ap = dao.getCourseEnrollmentById(id);
						teacherDao dao2 = new teacherDao(DBConnect.getConn());
						teacher d = dao2.getTeacherById(ap.getTeacherId());
						%>
						<form class="row" action="../updateStatus" method="post">
							<div class="col-md-6">
								<label>Student Name</label> <input type="text" readonly
									value="<%=ap.getFullName()%>" class="form-control">
							</div>

							


							<div class="col-md-6">
								<br> <label>Mob No</label> <input type="text" readonly
									value="<%=ap.getPhNo()%>" class="form-control">
							</div>

							<div class="col-md-6">
								<br> <label>Class Start Date</label> <input type="text" readonly
									value="<%=ap.getClass_start_date()%>" class="form-control">
							</div>
							
								<div class="col-md-6">
								<br> <label>Subject</label> <input type="text" readonly
									value="<%=d.getCourse_teaches()%>" class="form-control">
							</div>
								
							<div class="col-md-12">
								<br> <label>Comment</label>
								<textarea required name="comm" class="form-control" row="3"
									cols=""></textarea>
							</div>

							<input type="hidden" name="id" value="<%=ap.getId()%>"> <input
								type="hidden" name="tid" value="<%=ap.getTeacherId()%>">

							<button class=" mt-3 btn btn-primary col-md-6 offset-md-3">Submit</button>

						</form>

					</div>
				</div>
			</div>
		</div>
	</div>






</body>
</html>