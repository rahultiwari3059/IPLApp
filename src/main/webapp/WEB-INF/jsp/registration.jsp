<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>
	<form:form action="main" method="post" modelAttribute="user">
		<table>
			<tr>
				<td>Name :</td>
				<%-- <td><form:label path="mName">Name</form:label></td> --%>
				<td><input type="text" name="mName" /> 
					<form:errors path="mName" cssClass="errors" /></td>
			</tr>
			<tr>
				<td>Username :</td>
				<%-- <td><form:label path="mUsername">Name</form:label></td> --%>
				<td><input type="text" name="mUsername" /> 
				<form:errors path="mUsername" cssClass="errors" /></td>
			</tr>
			<tr>
				<td>Email :</td>
				<%-- <td><form:label path="mEmail">Name</form:label>
				</td> --%>
				<td><input type="text" name="mEmail"  /> 
				<form:errors path="mEmail" cssClass="errors" /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<%-- <td>
				<form:label path="mPassword">Name</form:label>
				</td> --%>
				<td><input type="password" name="mPassword"  /> 
				<form:errors path="mPassword" cssClass="errors" /></td>
			</tr>
		</table>
		<input type="submit" value="Register" align="middle">
	</form:form>
</body>
</html>