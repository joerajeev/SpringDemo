<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
<title>Login</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
</head>
<body onload='document.loginform.j_username.focus();'>
	<div id="body_wrapper">
		<%@ include file="header.jspf" %>
		<section id="main_section">
			<article>
				<c:if test="${param.error != null}">
					<div class="alert alert-danger">Invalid email or password</div>
				</c:if>
			</article>
			<article>
				<form name='loginform' action='${pageContext.request.contextPath}/j_spring_security_check' method='POST' autocomplete='off'>
					<div class="form-group">
						<label for="username">Email</label>
						<input id="username" class="form-control" type="text" name="j_username" value="" autocomplete="off">
					</div>
					<div class="form-group">
						<label for="password">Password</label>
						<input id="password" class="form-control" type="password" name="j_password" value="">
					</div>
					<div class="form-group">
						<input class="btn" name="submit" type="submit" value="Sign in">
						<a class="btn" href="${pageContext.request.contextPath}/sign-up">Create New Account</a>
					</div>
				</form>
			</article>
		</section>
	</div>
</body>
</html>