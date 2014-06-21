<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Car Sales</title>
<%-- <link type="text/css" rel="stylesheet"	href="${pageContext.request.contextPath}/static/css/main.css"></link> --%>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
</head>
<body>
	<div id="body_wrapper" class="container">
		<%@ include file="header.jspf"%>
		<%@ include file="main-nav.jspf"%>
		<section id="main_section">
			<c:catch var="message">${message}</c:catch>
			<c:if test="not empty message">
				<article>
					<p>${message}</p>
				</article>
			</c:if>
			<article class="jumbotron">
				<div>
					<header>
						<h2>Newest cars for sale</h2>
					</header>
					<p>A Car sales web app that would demonstate Spring MVC, Spring Security, Spring DAO (JDBC), Spring form validation etc.</p>
					<p>
						<a class="btn btn-lg btn-primary" href="${pageContext.request.contextPath}/sell"
							role="button">Start with creating an ad &raquo;</a>
					</p>
				</div>
			</article>
		</section>

		<!-- <aside id="side_news">
			<h3>Car sales news</h3>
		</aside> -->
		<%@ include file="footer.jspf"%>
	</div>
</body>
</html>