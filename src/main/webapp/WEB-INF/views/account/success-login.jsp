<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<link rel="stylesheet"
	href="<c:url value="/resources/dist/css/bootstrap.css" />">
<title>Welcome page</title>
</head>
<body>
	<div class="container">
		<h1>Welcome page</h1>
		<p>
			You have successfully logged in.<br /> <a
				href="${pageContext.request.contextPath}/">Home page</a><br />
		</p>
	</div>
</body>
</html>