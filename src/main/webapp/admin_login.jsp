<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login Page</title>
<%@include file="component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@include file="component/navbar.jsp"%>

	<div class="container-fluid">
		<div class="row p-5">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<div class="text-center">
							<i class="fa-solid fa-user" aria-hidden="true"></i>
							<h5>Admin Login</h5>
						</div>

						<c:if test="${not empty succMsg}">
							<h4 class="text-center text-success fs-3">${succMsg }</h4>
							<c:remove var="succMsg" scope="session" />
						</c:if>


						<c:if test="${not empty errorMsg}">
							<h4 class="text-center text-danger fs-5">${errorMsg}</h4>
							<c:remove var="errorMsg" scope="session" />
						</c:if>

						<form action="adminLogin" method="post">
							<div class="form-group">
								<label>Email address</label> <input type="email"
									class="form-control" required="required"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									placeholder="Enter email" name="email">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									placeholder="Password" name="password">
							</div>
							<br>
							<button type="submit" class="btn bg-success text-white col-md-12">Login</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>


	<%@include file="component/footer.jsp"%>

</body>
</html>