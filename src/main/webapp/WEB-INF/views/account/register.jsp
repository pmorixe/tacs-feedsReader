<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="<c:url value="/resources/dist/css/bootstrap.css" />" >
</head>	
<body>
<div class="container" align="center">
	<h1>Register</h1>
	<div class="span-12 last">	
		<form:form modelAttribute="user" action="register" method="post" class="form-search">
		  	<fieldset>
				<p>
					<form:label	for="username" path="username" cssErrorClass="error" >Username: </form:label>
					<form:input path="username" class="input-xxlarge"/>
					<br/>
				</p>
				<p>
					<form:label	for="firstName" path="firstName" cssErrorClass="error" >First Name: </form:label>
					<form:input path="firstName" class="input-xxlarge"/>
					<br/>
				</p>
				<p>
					<form:label	for="lastName" path="lastName" cssErrorClass="error" >Last Name: </form:label>
					<form:input path="lastName" class="input-xxlarge"/>
					<br/>
				</p>
				<p>
					<form:label	for="email" path="email" cssErrorClass="error" >Email: </form:label>
					<form:input path="email" class="input-xxlarge"/>
					<br/>
				</p>
				<p>
					<form:label	for="password" path="password"  >Password: </form:label>
					<form:input path="password" class="input-xxlarge"/>
					<br/>
				</p>
				<p>
  					<button class="btn btn-primary" type="submit" value="Save">Sign Up</button>
				</p>
			</fieldset>
			<a href="/" class="btn btn-inverse" >Back to Login</a>
		</form:form>
	</div>
	<hr>	
</div>
</body>
</html>