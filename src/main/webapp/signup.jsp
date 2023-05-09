<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up Page</title>
<%@include file="component/allcss.jsp"%>
</head>
<body>
	<%@include file="component/navbar.jsp"%>
	<div class="container p-5">
		<div class=" col-md-4 offset-md-4">
			<div class="card paint-card">
				<div class="card-body">
					<form>
						<p class="fs-4 text-center">Sign Up</p>
						<div class="mb-3">
							<label for="fullname" class="form-label">Full Name</label> <input
								type="text" class="form-control" id="fullname" name="fullname"
								required>
						</div>
						<div class="mb-3">
							<label for="email" class="form-label">Email address</label> <input
								type="email" class="form-control" id="email" name="email"
								aria-describedby="emailHelp" required>
							<div id="emailHelp" class="form-text">We'll never share
								your email with anyone else.</div>
						</div>
						<div class="mb-3">
							<label for="password" class="form-label">Password</label> <input
								type="password" class="form-control" id="password"
								name="password" required>
						</div>
						<button type="submit" class="btn btn-primary">Sign Up</button>
					</form>

				</div>
			</div>
		</div>
	</div>


</body>
</html>