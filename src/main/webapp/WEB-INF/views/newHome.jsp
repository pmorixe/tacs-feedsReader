<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="<c:url value="/resources/dist/css/bootstrap.css" />" >

<!-- Custom styles for this template -->
<!-- <link href="justified-nav.css" rel="stylesheet"> -->
<title><fmt:message key="welcome.title"/></title>


</head>

<body>

	<div class="container">

		<div class="masthead">
			<h1 class="text-muted">TACS Feeds Reader</h1>
			<ul class="nav nav-justified">
				<li><a href="subscription/update">Update!</a></li>
				<li><a href="subscription/add">Subscribe</a></li>
				<li><a href="feed/list">Categories</a></li>
				<li><a href="subscription/read">Show News</a></li>
				<li><a href="<c:url value="/j_spring_security_logout" />">Logout</a></li>
			</ul>
		</div>



		<!-- Example row of columns -->
<!-- 		<div class="row"> -->
			<!-- 			<div class="col-lg-4"> -->
			<!-- 				<h2>Heading</h2> -->
			<!-- 				<p>Donec id elit non mi porta gravida at eget metus. Fusce -->
			<!-- 					dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, -->
			<!-- 					ut fermentum massa justo sit amet risus. Etiam porta sem malesuada -->
			<!-- 					magna mollis euismod. Donec sed odio dui.</p> -->
			<!-- 				<p> -->
			<!-- 					<a class="btn btn-primary" href="#">View details »</a> -->
			<!-- 				</p> -->
			<!-- 			</div> -->
			<!-- 			<div class="col-lg-4"> -->
			<!-- 				<h2>Heading</h2> -->
			<!-- 				<p>Donec id elit non mi porta gravida at eget metus. Fusce -->
			<!-- 					dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, -->
			<!-- 					ut fermentum massa justo sit amet risus. Etiam porta sem malesuada -->
			<!-- 					magna mollis euismod. Donec sed odio dui.</p> -->
			<!-- 				<p> -->
			<!-- 					<a class="btn btn-primary" href="#">View details »</a> -->
			<!-- 				</p> -->
			<!-- 			</div> -->
			<!-- 			<div class="col-lg-4"> -->
			<!-- 				<h2>Heading</h2> -->
			<!-- 				<p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, -->
			<!-- 					egestas eget quam. Vestibulum id ligula porta felis euismod semper. -->
			<!-- 					Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum -->
			<!-- 					nibh, ut fermentum massa.</p> -->
			<!-- 				<p> -->
			<!-- 					<a class="btn btn-primary" href="#">View details »</a> -->
			<!-- 				</p> -->
			<!-- 			</div> -->
<!-- 		</div> -->

		<!-- Site footer -->
		<div class="footer">
			<p>© TACS UTN 2013</p>
		</div>

	</div>
	<!-- /container -->


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->


</body>
</html>