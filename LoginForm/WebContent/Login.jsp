<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="css/form.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="Container">
	
		<div class="row">
			<div class="col-sm-12">
				<h3>Login</h3>
			</div>
		</div>
		<form name="myform" action="LoginC" method="post">
		<font color="red">
	<%
	String message=(String)session.getAttribute("error");
	if((message)!=null){
		out.println(message);
		session.removeAttribute("error");
	}
	%>
	</font>
			<div class="row">
				<div class="col-sm-12">
					<div class="form-group">

						<label for="email">Email:</label> <input class="form-control"
							type="email" name="email" Placeholder="Enter email" id="email"
							required>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<div class="form-group">
						<label for="pwd">Password:</label> <input type="password"
							class="form-control" name="password" Placeholder="Enter password"
							id="pwd" required>
					</div>
				</div>
			</div>
			<div class="btn-center">
				<div class="row">
					<div class="col-sm-10">
						<button type="submit" class="btn btn-danger">Login</button>
					</div>
				</div>
			</div>
		</form>
		<div class="btn-margin">
		<div class="btn-center">
			<div class="row">
				<div class="col-sm-10">

					<a href="Signup.html">

						<button type="submit" class="btn btn-primary">Sign Up</button>
					</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>