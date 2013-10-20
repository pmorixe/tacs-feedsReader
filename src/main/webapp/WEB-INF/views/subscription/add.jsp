<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<title>TACS FeedsReader</title>
		<link rel="stylesheet" href="<c:url value="/resources/dist/css/bootstrap.css" />" >
</head>	
<body>
<div class="container">
	<div class="span-12 last">	
		<form:form modelAttribute="subscription" action="add" method="post" class="form-search">
		  	<fieldset>
			<legend>Subscribe me to this channel!</legend>
				<p>
					<form:label	for="url" path="url" cssErrorClass="error" >URL: </form:label>
					<form:input path="url" class="input-xxlarge" placeholder="Paste the URL here!" />
					<br/>
				</p>
				<p>
  					<button class="btn btn-primary" type="submit" value="Save">Save</button>
				</p>
			</fieldset>
			<a href="/" class="btn btn-inverse" >Back to home</a>
		</form:form>
	</div>
	<hr>	
</div>
</body>
</html>