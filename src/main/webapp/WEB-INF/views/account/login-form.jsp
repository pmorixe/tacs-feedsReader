<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en"><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../assets/ico/favicon.png">

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/dist/css/bootstrap.css" />" />
  </head>

  <body>

    <div class="container" align="center">
	
      <form class="form-signin"  method ="post" action="<c:url value='/j_spring_security_check'/>" style="max-width: 280px;">
		<p>
		<c:if test="${error == true}">
			<b class="error" style="color: red;">Invalid login or password.</b>
		</c:if>
		</p>
        <h2 class="form-signin-heading">Log In</h2>
        <input type="text" class="form-control" placeholder="Email address" autofocus="" name="j_username" id="j_username">
        <input type="password" class="form-control" placeholder="Password" name="j_password" id="j_password">
        <label class="checkbox">
          <input type="checkbox" value="remember-me"> Remember me(Not implemented yet)
        </label>
        <label class="text">
        <a href="${pageContext.request.contextPath}/register">Register</a>
        </label>
        <button class="btn btn-lg btn-primary btn-block" type="submit" value="Login">Sign in</button>
      </form>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  

</body></html>