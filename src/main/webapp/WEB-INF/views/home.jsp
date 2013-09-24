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
<!-- 	<style type="text/css"> body { background-color: ;  }   </style> -->
</head>
<body>
<div class="container">  
	<h1>
		TACS Feeds Reader 
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
<<<<<<< HEAD
	<p>
		<ul>
			<li><a href="subscription/updates">Show me the news</a></li>
=======
		<p>
		<ul>
			<li><a href="subscription/updates">Show my updates</a></li>
>>>>>>> branch 'dev' of https://github.com/hernan-pieroni/tacs-feedsReader.git
		</ul>
	</p>
		<p>
		<ul>
			<li><a href="subscription/updates">Show my updates</a></li>
		</ul>
	</p>
	<hr>	
</div>
</body>
</html>