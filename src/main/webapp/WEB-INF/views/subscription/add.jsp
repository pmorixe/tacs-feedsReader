<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>TACS FeedsReader</title>
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" />" >
</head>	
<body>
<div class="container">
	<div class="span-12 last">	
		<form:form modelAttribute="subscription" action="add" method="post">
		  	<fieldset>
			<legend>Subscribe me to this channel!</legend>
				<p>
					<form:label	for="url" path="url" cssErrorClass="error">URL: </form:label>
					<form:input path="url"/><br/>
				</p>
				<p>
					<input type="submit" value="Save"/>
				</p>
			</fieldset>
		</form:form>
	</div>
	<hr>	
</div>
<a href="/" >Back to home</a>
</body>
</html>