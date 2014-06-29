<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Available cars</title>
<link type="text/css" href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet"></link>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
</head>
<body>
	<div id="body_wrapper" class="container">
		<%@ include file="header.jspf" %>
		<%@ include file="main-nav.jspf" %>

		<section>
			<article>
				<header>
						<h3>Available cars</h3>
				</header>
				<div class="jumbotron">
					<ul>
						<c:forEach var="car" items="${vehicles}">
							<li>
								${car.make} ${car.model} (${car.year})
							</li>
						</c:forEach>
					</ul>
				</div>
			</article>
		</section>
		
		<%@ include file="footer.jspf" %>
	</div>
	
	 <!-- Placed at the end of the document so the pages load faster -->
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/common.js"></script>
	
</body>
</html>