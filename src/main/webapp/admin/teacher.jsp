
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
<title>Admin:Teacher Page</title>
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

			<div class="col-md-4 ">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Add Teacher</p>


						<c:if test="${not empty errorMsg}">
							<p class="fs-3 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>


						<c:if test="${not empty succMsg}">
							<div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
							<c:remove var="succMsg" scope="session" />
						</c:if>



						<form action="../addTeacher" method="post">
							<div class="mb-3">
								<label class="form-label">Full Name</label> <input type="text"
									required name="fullname" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Death Of Birth</label> <input
									type="date" required name="dob" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Qualification</label> <input required
									name="qualification" type="text" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Course Teaches</label> <select
									name="course" required class="form-control">
									<option>--select--</option>

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
									required name="email" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Mob No</label> <input type="text"
									required name="mobno" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Password</label> <input required
									name="password" type="password" class="form-control">
							</div>

							<button type="submit" class="btn btn-primary">Submit</button>
						</form>
					</div>
				</div>
			</div>


			<div class="col-md-8 ">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Teacher Details</p>

						<c:if test="${not empty errMsg}">
							<p class="fs-3 text-center text-danger">${errMsg}</p>
							<c:remove var="errMsg" scope="session" />
						</c:if>


						<c:if test="${not empty sucMsg}">
							<div class="fs-3 text-center text-success" role="alert">${sucMsg}</div>
							<c:remove var="sucMsg" scope="session" />
						</c:if>

						<table class="table">
							<thead>
								<tr>
									<th scope="col">Full Name</th>
									<th scope="col">Death of Birth</th>
									<th scope="col">Qualification</th>
									<th scope="col">Subject</th>
									<th scope="col">Email</th>
									<th scope="col">Mob No</th>
									<th scope="col">Action</th>
								</tr>


							</thead>
							<tbody>

								<%
								teacherDao dao2 = new teacherDao(DBConnect.getConn());
								List<teacher> list2 = dao2.getAllTeacher();
								for (teacher t : list2) {
								%>
								<tr>
									<td><%=t.getFullName()%></td>
									<td><%=t.getDob()%></td>
									<td><%=t.getQualification()%></td>
									<td><%=t.getCourse_teaches()%></td>
									<td><%=t.getEmail()%></td>
									<td><%=t.getMobNo()%></td>

									<td><a href="edit_teacher.jsp?id=<%=t.getId()%>"
										class="btn btn-sm btn-primary">Edit</a> <a
										href="../deleteTeacher?id=<%=t.getId()%>"
										class="btn btn-sm btn-danger">Delete</a></td>

								</tr>
								<%
								}
								%>



							</tbody>
						</table>




					</div>

				</div>
			</div>
		</div>
	</div>
</body>
</html>