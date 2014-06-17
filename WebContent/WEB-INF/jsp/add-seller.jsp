<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css">
<title>Spring Car Sales</title>
</head>
<body>	
	<%@ include file="header.jspf" %>
	<%@ include file="main-nav.jspf" %>
	<section>
		<header>Sign up</header>
		<article>
			<form:form method="POST" action="${pageContext.request.contextPath}/docreatead" commandName="seller">
				<table>
					<tr>
						<td>Name: </td><td><form:input name="name" type="text" path="name" /><br><form:errors path="name"></form:errors></td>
					</tr>
					<tr>
						<td>Phone: </td><td><form:input name="phone" type="text" path="phone"/><br><form:errors path="phone"></form:errors></td>
					</tr>
					<tr>
						<td>Address: </td><td><form:input name="address" type="text" path="address"/><br><form:errors path="address"></form:errors></td>
					</tr>
					<tr>
						<td>E-Mail: </td><td><form:input name="email" type="text" path="email"/><br><form:errors path="email"></form:errors></td>
					</tr>
					<tr>
						<td>Password: </td><td><form:input name="password" type="text" path="password"/><br><form:errors path="password"></form:errors></td>
					</tr>
					<tr>
						<td>Confirm Password: </td><td><input name="confirm-password" type="text"/><br></td>
					</tr>
					<tr>
						<td></td><td><input name="Create" type="submit" value="Add"></input></td>
					</tr>
				</table>
				
			</form:form>
		</article>
	</section> 
	<%@ include file="footer.jspf" %>
</body>
</html>