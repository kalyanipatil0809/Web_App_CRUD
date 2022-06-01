<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="in.sts.studentwebapp.dao.StudentDao"%>
<%@ page import="in.sts.studentwebapp.model.StudentModel"%>
<%@ page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Web Application</title>
<style>
tr:nth-child(even) {
	background-color: rgba(150, 212, 212, 0.4);
}
tr:hover {
	background-color: lightgray;
}
th, td {
border: 1px solid black;
	border-collapse: collapse;
	text-align: center;
}
</style>

</head>
<body>
	<center>
		<h1 style="color: orange;">All student details.</h1>
		<h1>
			<a href="index.jsp">Add New Student</a>
		</h1>
	</center>
	<table border='1' cellpadding="8" width='100%'>
		<tr>
			<th>Student ID</th>
			<th>First Name</th>
			<th>Middle Name</th>
			<th>Last Name</th>
			<th>Branch</th>
			<th>Maths</th>
			<th>English</th>
			<th>Science</th>
			<th colspan="2">Action</th>
		</tr>
		<c:forEach var="student" items="${studentModel}">
			<tr>
				<td><c:out value="${student.student_id}" /></td>
				<td><c:out value="${student.firstName}" /></td>
				<td><c:out value="${student.middleName}" /></td>
				<td><c:out value="${student.lastName}" /></td>
				<td><c:out value="${student.branch}" /></td>
				<td><c:out value="${student.maths}" /></td>
				<td><c:out value="${student.english}" /></td>
				<td><c:out value="${student.science}" /></td>
				<td><a
					href="/StudentWebApp/EditServlet?student_id=<c:out value='${student.student_id}'/>">Edit</a>
				<td><a onclick="onDelete()"
					href="/StudentWebApp/DeleteServlet?student_id=<c:out value='${student.student_id}'/>">Delete</a>
			</tr>
		</c:forEach>
	</table>
	<script>
		function onDelete() {
			alert("Record deleted.!");
		}
	</script>
</body>
</html>