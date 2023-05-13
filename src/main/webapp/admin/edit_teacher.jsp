<%@page import="com.entity.teacher"%>
<%@page import="com.entity.courseTeaches"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.courseTeachesDao"%>
<%@page import="com.dao.teacherDao"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin:Edit Teacher Page</title>
<%@include file="../component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@include file="navbar.jsp"%>

	<div class="container-fluid p-3">
		<div class="row">

			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Edit Teacher Details</p>


						<c:if test="${not empty errorMsg}">
							<p class="fs-3 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>


						<c:if test="${not empty succMsg}">
							<div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<%
						int id = Integer.parseInt(request.getParameter("id"));
						teacherDao dao2 = new teacherDao(DBConnect.getConn());
						teacher d = dao2.getTeacherById(id);
						%>



						<form action="../updateTeacher" method="post">
							<div class="mb-3">
								<label class="form-label">Full Name</label> <input type="text"
									required name="fullname" class="form-control" value = "<%=d.getFullName()%>">
							</div>

							<div class="mb-3">
								<label class="form-label">Death Of Birth</label> <input
									type="date" required name="dob" class="form-control" value = "<%=d.getDob()%>">
							</div>

							<div class="mb-3">
								<label class="form-label">Qualification</label> <input required
									name="qualification" type="text" class="form-control" value = "<%=d.getQualification()%>">
							</div>
							<div class="mb-3">
								<label class="form-label">Course Teaches</label> <select
									name="course" required class="form-control" >
									<option>---<%=d.getCourse_teaches() %> ---</option>

									<%
									courseTeachesDao dao = new courseTeachesDao(DBConnect.getConn());
									List<courseTeaches> list = dao.getAllCourses();
									for (courseTeaches s : list) {
									%>
									<option><%=s.getCourseTeachesName()%></option>
									<%
									}
									%>


								</select>
							</div>

							<div class="mb-3">
								<label class="form-label">Email</label> <input type="text"
									required name="email" class="form-control" value = "<%=d.getEmail()%>">
							</div>

							<div class="mb-3">
								<label class="form-label">Mob No</label> <input type="text"
									required name="mobno" class="form-control" value = "<%=d.getMobNo()%>">
							</div>

							<div class="mb-3">
								<label class="form-label">Password</label> <input required
									name="password" type="text" class="form-control" value = "<%=d.getPassword()%>">
							</div>
							
							<input type = "hidden" name = "id" value = "<%=d.getId() %>" >
							

							<button type="submit" class="btn btn-primary col-md-12">Update</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>