<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>student details</title>
<style>
.img-container {
	text-align: center;
}
</style>

</head>
<body>
	<div class="img-container">
		<img src="images/error.png" width="800px" height="400px" />
		<center>
			<h1 style="color: red;">Record already exist.!</h1>
			<h1><a href="index.jsp">click here</a> to insert another student.</h1>
		</center>
	</div>
</body>
</html>