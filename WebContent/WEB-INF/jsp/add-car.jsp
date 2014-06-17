<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css"></link>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<title>Create an Ad</title>
</head>
<body>
	<div id="body_wrapper">
		<%@ include file="header.jspf" %>
		<%@ include file="main-nav.jspf" %>
		
		<section>
			<header>
				<hgroup>
					<h2>Create an ad</h2>
					<h3>Car Details</h3>
				</hgroup>
			</header>
			
			<!-- 
			<c:catch var="message">${message}</c:catch>
			<c:if test="">${message}</c:if>
			 -->
			<article>
			<form:form method="POST" action="${pageContext.request.contextPath}/docreatecar" commandName="vehicle">
				<div class="form-group">
					<label for="reg" >Registration</label>
					<form:input class="form-control" id="reg" name="reg" type="text" path="reg"></form:input>
					<form:errors path="reg"></form:errors>
				</div>
				<div class="form-group">
					<label for="year" >Year</label>
					<form:input class="form-control" id="year" name="year" type="text" path="year"></form:input>
					<form:errors path="year"></form:errors>
				</div>
				<div class="form-group">
					<label for="milage" >Milage</label>
					<form:input class="form-control" id="milage" name="milage" type="text" path="milage"></form:input>
					<form:errors path="milage"></form:errors>
				</div>
				<div class="form-group">
					<label for="colour" >Colour</label>
					<form:input class="form-control" id="colour" name="colour" type="text" path="colour"></form:input>
					<form:errors path="colour"></form:errors>
				</div>
				<div class="form-group">
					<label for="make" >Make</label>
					<form:input class="form-control" id="make" name="make" type="text" path="make"></form:input>
					<form:errors path="make"></form:errors>
				</div>
				<div class="form-group">
					<label for="model" >Model</label>
					<form:input class="form-control" id="model" name="model" type="text" path="model"></form:input>
					<form:errors path="model"></form:errors>
				</div>
				<div>
					<input class="btn" name="Create" type="submit" value="Save"></input>
				</div>
			<%-- 	<table>
					<tr>
						<td>Registration: </td><td><form:input name="reg" type="text" path="reg"/><br>
						<form:errors path="reg"></form:errors></td>
					</tr>
					<tr>
						<td>Year :</td><td><form:input name="year" type="text" path="year"/><br>
						<form:errors path="year"></form:errors>
						</td>
					</tr>
					<tr>
						<td>Milage:</td><td><form:input name="milage" type="text" path="milage"/><br>
						<form:errors path="milage"></form:errors>
						</td>
					</tr>
					<tr>
						<td>Colour:</td><td><form:input name="colour" type="text" path="colour"/><br>
						<form:errors path="colour"></form:errors>
						</td>
					</tr>
					<tr>
						<td>Make:</td><td><form:input name="make" type="text" path="make"/><br>
						<form:errors path="make"></form:errors>
						</td>
					</tr>
					<tr>
						<td>Model:</td><td><form:input name="model" type="text" path="model"/><br>
						<form:errors path="model"></form:errors>
						</td>
					</tr>
					<tr>
						<td></td><td><input name="Create" type="submit" value="continue"></input></td>
					</tr>
				</table> --%>
			</form:form>
			</article>
		</section>
		
		<%@ include file="footer.jspf" %>
	</div>
</body>
</html>