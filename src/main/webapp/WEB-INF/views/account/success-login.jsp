<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" />" >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Welcome page</title>
</head>
<body>
<div class="container">  
	<h1>Welcome page</h1>
	<p>You have successfully logged in.<br/>
	<a href="${pageContext.request.contextPath}/">Home page</a><br/></p>
	</div>
</body>
</html>