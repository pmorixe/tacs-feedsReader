<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>@FeedsReader</title>
	<link rel="stylesheet" href="<c:url value="/resources/blueprint/screen.css" />" type="text/css" media="screen, projection">
	<link rel="stylesheet" href="<c:url value="/resources/blueprint/print.css" />" type="text/css" media="print">
	<!--[if lt IE 8]>
		<link rel="stylesheet" href="<c:url value="/resources/blueprint/ie.css" />" type="text/css" media="screen, projection">
	<![endif]-->
</head>	
<body>
	
<div class="container">
	<div class="span-12 last">	
		<form:form modelAttribute="account" action="${account.id}" method="post">
		  	<fieldset>		
			<legend>RSS del suario</legend>
				<p>
					<form:label	for="lastName" path="lastName" cssErrorClass="error">Apellido: </form:label>
					<form:input path="lastName" readonly="true"/><br/>
					<form:label	for="name" path="name" cssErrorClass="error">Nombre: </form:label> 
					<form:input path="name" readonly="true"/><br/>		
				</p>
			</fieldset>
		</form:form>
	</div>
<a href="/" >Back to home</a>
</div>
</body>
</html>