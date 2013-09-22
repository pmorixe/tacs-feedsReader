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
			<legend>These are the channels you are currently subscribed to:</legend>
				<table>
				<tr>
					<td>
						#
					</td>
					<td>
						URL
					</td>
					<td>
						Since
					</td>
				</tr>
					     <c:forEach items="${subscriptions}" var="subscription">
					     <tr>
					       <td>${subscription.id}</td>
					       <td>${subscription.url}</td>
					       <td>${subscription.since}</td>
					       </tr>
					    </c:forEach>
				</table>
			</fieldset>
		</form:form>
	</div>
	<hr>	
</div>
<a href="/" >Back to home</a>
</body>
</html>