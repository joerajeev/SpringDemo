<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Car Sales</title>
<link type="text/css" rel="stylesheet"	href="${pageContext.request.contextPath}/static/css/main.css"></link>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
</head>
<body>
	<div id="body_wrapper" class="container">
		<%@ include file="header.jspf"%>
		<%@ include file="main-nav.jspf"%>
		<section id="main_section">
			<c:if test="${message != null}">
				<article class="alert alert-success">
					${message}
				</article>
			</c:if>
			<c:if test="${param.msg != null}">
				<c:if test="${param.msg eq 'logged-out'}">
					<article class="alert alert-info">
						Successfully logged out
					</article>
				</c:if>
					<c:if test="${param.msg eq 'logged-in'}">
					<article class="alert alert-success">
						Successfully logged in
					</article>
				</c:if>
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
		<aside id="side_news" class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">News</h3>
			</div>
			<div class="panel-body">Buying and Selling just got easier!</div>
		</aside>
		<%@ include file="footer.jspf"%>
	</div>
	
	 <!-- Placed at the end of the document so the pages load faster -->
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/common.js"></script>
	
</body>
</html>