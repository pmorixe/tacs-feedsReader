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
	<link rel="stylesheet" href="<c:url value="/resources/blueprint/screen.css" />" type="text/css" media="screen, projection">
	<link rel="stylesheet" href="<c:url value="/resources/blueprint/print.css" />" type="text/css" media="print">
	<!--[if lt IE 8]>
		<link rel="stylesheet" href="<c:url value="/resources/blueprint/ie.css" />" type="text/css" media="screen, projection">
	<![endif]-->
</head>	
<body>
<div class="container">
	<div class="span-12 last">	
		<form:form modelAttribute="subscription" action="add" method="post">
		  	<fieldset>
			<legend>These are the feeds you are currently subscribed to:</legend>
				<table>
				<tr>
					<td>
						#
					</td>
					<td>
						URL
					</td>
				</tr>
					     <c:forEach items="${subscriptions}" var="subscription">
					     <tr>
					       <td>${subscription.id}</td>
					       <td>${subscription.url}</td>
					       </tr>
					    </c:forEach>
				</table>
			</fieldset>
		</form:form>
	</div>
	<hr>	
</div>
</body>
</html>