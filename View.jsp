<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="in.sts.StudentWebApp.dao.StudentDao"%>
<%@ page import="in.sts.StudentWebApp.model.StudentModel"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Web Application</title>
</head>
<body>
	<center><h1 style="color: orange;">All student details.</h1></center>
	<%
	StudentDao studentdao = new StudentDao();
	List<StudentModel> studentList = studentdao.getAllStudents();
	%>
	<center><h1><a href="index.jsp">Add New Student</a></h1></center>

	<table border='1' width='100%' cellpadding="5">
		<tr><th>Student ID</th>
			<th>First Name</th>
			<th>Middle Name</th>
			<th>Last Name</th>
			<th>Branch</th>
			<th>Maths</th>
			<th>English</th>
			<th>Science</th>
			<!-- <th>Edit</th>
			<th>Delete</th> -->
			<th colspan="2">Action</th></tr>
		<%
		for (StudentModel studentModel : studentList) {
		%>
		<tr><td><%=studentModel.getStudent_id()%></td>
			<td><%=studentModel.getFirstName()%></td>
			<td><%=studentModel.getMiddleName()%></td>
			<td><%=studentModel.getLastName()%></td>
			<td><%=studentModel.getBranch()%></td>
			<td><%=studentModel.getMaths()%></td>
			<td><%=studentModel.getEnglish()%></td>
			<td><%=studentModel.getScience()%></td>
			<td><a href="EditServlet?student_id=<%=studentModel.getStudent_id()%>">Edit</a>
			</td>
			<td><a href="DeleteServlet?student_id=<%=studentModel.getStudent_id()%>">Delete</a>
			</td></tr>
		<%
		}
		%>
	</table>
</body>
</html>
