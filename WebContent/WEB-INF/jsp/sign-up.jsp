<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<title>Spring Car Sales</title>
</head>
<body>	
	<div id="body_wrapper">
		<%@ include file="header.jspf" %>
		<%@ include file="main-nav.jspf" %>
		<section>
 			<form:form method="POST" action="${pageContext.request.contextPath}/docreateuser" commandName="seller">
 				<div class="form-group">
 					<label for="name">Name</label>
 					<form:input class="form-control" id="name" name="name" type="text" path="name" />
 					<form:errors class="form-error" path="name"></form:errors>
 				</div>
 				<div class="form-group">
 					<label for="phone">Phone</label>
 					<form:input class="form-control" id="phone" name="phone" type="text" path="phone" />
 					<form:errors class="form-error" path="phone"></form:errors>
 				</div>
 				<div class="form-group">
 					<label for="address">Address</label>
 					<form:input class="form-control" id="address" name="address" type="text" path="address" />
 					<form:errors class="form-error" path="address"></form:errors>
 				</div>
 				<div class="form-group">
 					<label for="email">Email</label>
 					<form:input class="form-control" id="email" name="email" type="text" path="email" />
 					<form:errors class="form-error" path="email"></form:errors>
 				</div>
 				<div class="form-group">
 					<label for="password">Password</label>
 					<form:input class="form-control" id="password" name="password" type="password" path="password" />
 					<form:errors class="form-error" path="password"></form:errors>
 				</div>
 				<div class="form-group">
 					<label for="confirm-password">Confirm Password</label>
 					<input class="form-control" id="confirm-password" name="confirm-password" type="password" />
 				</div>
 				<div class="form-group">
	 				<input class="btn" name="submit" type="submit" value="Sign Up">
 				</div>
 			</form:form>
 		</section> 
		<%@ include file="footer.jspf" %>
	</div>
</body>
</html>