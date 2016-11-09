<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- <form action="login" method=get >
<label>User Name</label></br>
<input type="text" name="username"></br>
<label>Password</label></br>
<input type="text" name="password"></br>
<input type="submit" value="Login"> 
</form> -->
	
	<table>
		<form:form action="login" method="get">
			<h3>User Login</h3>
			<%-- <form:input path="username" /> --%>
			<tr>
			<td>User Name:</td>
			<td><input type="text" name="mUsername">
			<form:errors path="mUsername" />
			<br>
			</td>
			<tr>
			<td>
			<%-- <form:password path="password" /> --%>
			Password:</td>
			<td><input type="text" name="mPassword">
			<form:errors path="mPassword" />
			<br>
			</td>
			</tr>
			<input type="submit" value="Login" align="bottom">
		</form:form>
	</table>
</body>
</html>