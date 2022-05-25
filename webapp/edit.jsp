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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Web Application</title>
</head>
<body>
	<center>
		<h1 style="color: orange;">Edit & update the record.</h1>
	</center>
	<div align="center">

		<form action="EditServlet" method="post">

			<input type="hidden" name="student_id"
				value="${studentModel.student_id}" />

			<table border="1" cellpadding="8" style="background-color: rgba(150, 212, 212, 0.4)">
				<tr>
					<td>Student First Name:</td>
					<td><input type="text" name="firstName" required="required"
						value="${studentModel.firstName}" /></td>
				</tr>
				<tr>
					<td>Student Middle Name:</td>
					<td><input type="text" name="middleName" required="required"
						value="${studentModel.middleName}" /></td>
				</tr>
				<tr>
					<td>Student Last Name:</td>
					<td><input type="text" name="lastName" required="required"
						value="${studentModel.lastName}" /></td>
				</tr>
				<tr>
					<td>Branch:</td>
					<td><input type="text" name="branch" required="required"
						value="${studentModel.branch}" /></td>
				</tr>
				<tr>
					<td>Maths:</td>
					<td><input type="text" name="maths"
						value="${studentModel.maths}" /></td>
				</tr>
				<tr>
					<td>English:</td>
					<td><input type="text" name="english"
						value="${studentModel.english}" /></td>
				</tr>
				<tr>
					<td>Science:</td>
					<td><input type="text" name="science"
						value="${studentModel.science}" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center" onclick="onEdit()"><input
						type="submit" name="Action" value="Edit & Save"></td>
				</tr>
			</table>

		</form>
	</div>
	<script>
		function onEdit() {
			alert("Record updated successfully.!");
		}
	</script>
</body>
</html>