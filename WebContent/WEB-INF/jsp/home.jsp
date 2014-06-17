<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Car Sales</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css"></link>
</head>
<body>
  <div id="body_wrapper">
	<%@ include file="header.jspf" %>
	<%@ include file="main-nav.jspf" %>
	<section id="main_section">
		<c:catch var="message">${message}</c:catch>
		<c:if test="not empty message">
			<article>
			<p>
				${message}
			</p>	
			</article>
		</c:if>
		<article>
			<header>
				<h3>Newest cars for sale</h3>
			</header>
			<article>
				<p>List the recent cars for sale here</p>
			</article>
		</article>
	</section>
	
	<aside id="side_news">
		<h3>Car sales news</h3>
	</aside>
	
   <%@ include file="footer.jspf" %>
  </div>
</body>
</html>