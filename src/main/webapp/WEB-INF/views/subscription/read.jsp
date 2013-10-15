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
			<legend>These are the news!</legend>
			<a href="/" class="btn btn-inverse" >Back to home</a>
			     <c:forEach items="${entries}" var="entry">
			       <p>
			       	<c:choose>
				      <c:when test="${entry.important==true}">
			       			<i class=" icon-star"></i>
				      </c:when>
						<c:otherwise>
						
			       	   <a href="/subscription/important?id=${entry.id}">
				       <i class=" icon-star-empty"></i>
				       </a>
						
				      </c:otherwise>
				</c:choose>
				       <a href="${entry.link}">
				       <h1>${entry.title}</h1> 
				       </a>
				       <h3>${entry.description}</h3>
				   </p>
			    </c:forEach>
			</fieldset>
		<a href="/" class="btn btn-inverse" >Back to home</a>
		</form:form>
	</div>
	<hr>	
</div>
</body>
</html>