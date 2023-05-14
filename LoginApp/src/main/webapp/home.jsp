<%@page import="java.util.List"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="models.CourseModels"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome: ${sessionScope.username.username}</h2>

	<%
	List<CourseModels> list = (List<CourseModels>) request.getAttribute("course");
	%>

	<table>
		<%
		for (CourseModels course : list) {
		%>
		<tr>
			<td><%=course.getCourse_code()%></td>
			<td><%=course.getTitle()%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>