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
	<div id="body_wrapper">
		<%@ include file="header.jspf" %>
		<%@ include file="main-nav.jspf" %>

		<section>
			<article>
				<header>
						<h2>Available cars</h2>
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
</body>
</html>