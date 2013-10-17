<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" />" >
<title>Login page</title>
<style>.error {	color: red;}
</style>
</head>
<body>
	<div class="container" align="center" >  
		<h1>Login page</h1>
		
		<p>
		<c:if test="${error == true}">
			<b class="error">Invalid login or password.</b>
		</c:if>
		</p>
		
		<form method="post" action="<c:url value='/j_spring_security_check'/>" >
		<table>
		<tbody>
		<tr>
		<td>Login:</td>
		<td><input type="text" name="j_username" id="j_username" placeholder="admin" size="30" maxlength="40"  /></td>
		</tr>
		<tr>
		<td>Password:</td>
		<td><input type="password" name="j_password" id="j_password" placeholder="admin" size="30" maxlength="32" /></td>
		</tr>
		<tr>
		<td></td>
		<td><input type="submit" value="Login" /></td>
		</tr>
		</tbody>
		</table>
		</form>	
		
		<p>
		<a href="${pageContext.request.contextPath}/register">Register</a><br/>
		</p>
	</div>
</body>
</html>