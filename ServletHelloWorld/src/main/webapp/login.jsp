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
		<input username="username" type="text"> <br>
		<label>Password </label> <br>
		<input password="password" type="text"> <br> <br>
		<button type="submit">Submit</button> 
	</form>
</body>
</html>