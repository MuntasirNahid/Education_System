<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.teacherDao"%>
<%@page import="com.dao.courseTeachesDao"%>
<%@page import="com.entity.courseTeaches"%>
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@page import="com.entity.teacher"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Course Enrollment</title>
<%@include file="component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 8px 0 rgba(0, 0, 0, 0.3);
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
	<%@include file="component/navbar.jsp"%>

	<div class="container-fulid backImg p-5">
		<p class="text-center fs-2 text-white"></p>
	</div>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-6 p-3">
				<img alt="" src="img/ron1.jpg" height="400px">
			</div>

			<div class="col-md-6">
				<div class="card paint-card">
					<div class="card-body">
						<p class="text-center fs-3">Course Enrollment</p>

						<c:if test="${not empty errorMsg}">
							<p class="fs-4 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>

						<c:if test="${not empty succMsg}">
							<p class=" fs-4 text-center text-success">${succMsg}</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>


						<form class="row g-3" action="addCourseEnrollment" method="post">

							<input type="hidden" name="studentId" value="${userObj.id }">

							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Full Name</label> <input
									required type="text" class="form-control" name="fullname">
							</div>

							<div class="col-md-6">
								<label>Gender</label> <select class="form-control" name="gender"
									required>
									<option value="">--select--</option>
									<option value="male">Male</option>
									<option value="female">Female</option>
								</select>
							</div>

							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Age</label> <input
									required type="number" class="form-control" name="age">
							</div>

							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Class Start
									Date</label> <input type="date" class="form-control" required
									name="class_start_date">
							</div>

							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Email</label> <input
									required type="email" class="form-control" name="email">
							</div>

							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Phone No</label> <input
									maxlength="10" required type="number" class="form-control"
									name="phno">
							</div>


							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Subject</label> <select
									required class="form-control" name="subject">
									<option value="">--select--</option>

									<%
									courseTeachesDao dao2 = new courseTeachesDao(DBConnect.getConn());
									List<courseTeaches> list2 = dao2.getAllCourses();
									for (courseTeaches d2 : list2) {
									%>
									<option value="<%=d2.getId()%>"><%=d2.getCourseTeachesName()%>
									</option>
									<%
									}
									%>




								</select>
							</div>

							<div class="col-md-6">
								<label for="inputPassword4" class="form-label">Teacher</label> <select
									required class="form-control" name="teacher">
									<option value="">--select--</option>

									<%
									teacherDao dao = new teacherDao(DBConnect.getConn());
									List<teacher> list = dao.getAllTeacher();
									for (teacher d : list) {
									%>
									<option value="<%=d.getId()%>"><%=d.getFullName()%> (<%=d.getCourse_teaches()%>)
									</option>
									<%
									}
									%>




								</select>
							</div>

							<div class="col-md-12">
								<label>Expectation About The Course</label>
								<textarea required name="expectation" class="form-control"
									rows="3" cols=""></textarea>
							</div>

							<c:if test="${empty userObj }">
								<a href="student_login.jsp"
									class="col-md-6 offset-md-3 btn btn-success">Submit</a>
							</c:if>

							<c:if test="${not empty userObj }">
								<button class="col-md-6 offset-md-3 btn btn-success">Submit</button>
							</c:if>
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>
	<%@include file="component/footer.jsp"%>

</body>
</html>