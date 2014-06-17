<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Available cars</title>
<link type="text/css" href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet"></link>
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
				<ul>
					<c:forEach var="car" items="${vehicles}">
						<li>
							${car.make} ${car.model} (${car.year})
						</li>
					</c:forEach>
				</ul>
			</article>
		</section>
		

		<%@ include file="footer.jspf" %>
	</div>
</body>
</html>