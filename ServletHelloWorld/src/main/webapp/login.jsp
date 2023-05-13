<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="HomeServlet" method="post">
		<label>Username</label> <br>
		<input name="username" type="text"> <br>
		<label>Password </label>  <br>
		<input name="password" type="password"> <br> <br>
		<button type="submit">Submit</button> 
	</form>
</body>
</html>