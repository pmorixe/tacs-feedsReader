<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
	<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title><fmt:message key="welcome.title"/></title>
	<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" />" >

</head>
<body>
<div class="container">  
	<h1>
		TACS Feeds Reader (90's style)
	</h1>
	<p>
		<ul>
			<li><a href="subscription/add">Subscribe to a new channel</a></li>
		</ul>
	</p>
	<p>
		<ul>
			<li><a href="subscription/list">Show me the channels I'm subscribed to</a></li>
		</ul>
	</p>
	<hr>	
</div>
</body>
</html>