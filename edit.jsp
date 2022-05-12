<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="in.sts.StudentWebApp.dao.StudentDao"%>
<%@ page import="in.sts.StudentWebApp.model.StudentModel"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1 style="color: orange;">Edit & update the record.</h1>
	</center>

	<%
	String student_id = request.getParameter("student_id");
	int Student_id = Integer.parseInt(student_id);

	StudentModel StudentModel = StudentDao.getStudentById(Student_id);
	%>

	<div align="center">
		<form action="EditServlet" method="post">
			<input type="hidden" name="student_id" required="required"
				value=" <%=StudentModel.getStudent_id()%>" />
			</td>

			<table border="1" cellpadding="5">
				<tr>
					<td>Student First Name:</td>
					<td><input type="text" name="firstName" required="required"
						value=" <%=StudentModel.getFirstName()%>" /></td>
				</tr>
				<tr>
					<td>Student Middle Name:</td>
					<td><input type="text" name="middleName" required="required"
						value="<%=StudentModel.getMiddleName()%>" /></td>
				</tr>
				<tr>
					<td>Student Last Name:</td>
					<td><input type="text" name="lastName" required="required"
						value="<%=StudentModel.getLastName()%>" /></td>
				</tr>
				<tr>
					<td>Branch:</td>
					<td><input type="text" name="branch"
						value="<%=StudentModel.getBranch()%>"></td>
				</tr>

				<tr>
					<td>Maths:</td>
					<td><input type="text" name="maths"
						value="<%=StudentModel.getMaths()%>"></td>
				</tr>

				<tr>
					<td>English:</td>
					<td><input type="text" name="english"
						value="<%=StudentModel.getEnglish()%>"></td>
				</tr>

				<tr>
					<td>Science:</td>
					<td><input type="text" name="science"
						value="<%=StudentModel.getScience()%>"></td>
				</tr>

				<tr>
					<td colspan="2"><input type="Submit" value="Edit &amp; Save" /></td>
				</tr>

			</table>

		</form>
	</div>

</body>
</html>