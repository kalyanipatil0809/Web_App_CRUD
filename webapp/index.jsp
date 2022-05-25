<%@page import="in.sts.studentwebapp.dao.StudentDao"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="in.sts.studentwebapp.dao.StudentDao"%>
<%@ page import="in.sts.studentwebapp.model.StudentModel"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Web Application</title>
</head>
<body>
	<center>
		<h1 style="color: orange;">Add New Student</h1>
	</center>
	<div align="center">
		<form action="SaveServlet" method="post">
			<table border="1" cellpadding="8"
				style="background-color: rgba(150, 212, 212, 0.4)">
				<tr>
					<td>Student First Name:</td>
					<td><input type="text" name="firstName" required="required" /></td>
				</tr>
				<tr>
					<td>Student Middle Name:</td>
					<td><input type="text" name="middleName" required="required" /></td>
				</tr>
				<tr>
					<td>Student Last Name:</td>
					<td><input type="text" name="lastName" required="required" /></td>
				</tr>
				<tr>
					<td>Branch:</td>
					<td><input type="text" name="branch" required="required" /></td>
				</tr>

				<tr>
					<td>Maths:</td>
					<td><input type="number" name="maths" value=0 /></td>
				</tr>

				<tr>
					<td>English:</td>
					<td><input type="number" name="english" value=0 /></td>
				</tr>

				<tr>
					<td>Science:</td>
					<td><input type="number" name="science" value=0 /></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit" value="Save" /></td>
				</tr>

			</table>
		</form>
		<h1>
			<a href="ViewServlet">View students</a>
		</h1>
	</div>
</body>
</html>
