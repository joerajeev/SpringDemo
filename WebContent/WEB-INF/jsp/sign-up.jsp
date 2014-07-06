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

<script type="text/javascript">
	function validateForm(){
		var valid =  ($('#password').val() == $('#confirm-password').val());
		
		if(!valid){
			$('#sign-up-messages').text("Passwords do not match");
			$('#sign-up-messages').addClass("alert alert-danger");
		}else{
			$('#sign-up-messages').text("");
			$('#sign-up-messages').removeClass("alert alert-danger");
		}	
		return valid;
	}
</script>
<title>Spring Car Sales</title>
</head>
<body>	
	<div id="body_wrapper">
		<%@ include file="header.jspf" %>
		<%@ include file="main-nav.jspf" %>
		<section>
			<article id="sign-up-messages"></article>
			<article>
	 			<form:form method="POST" action="${pageContext.request.contextPath}/docreateuser" commandName="user" onsubmit="return validateForm()">
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
	 		</article>
 		</section> 
		<%@ include file="footer.jspf" %>
	</div>
	
	 <!-- Placed at the end of the document so the pages load faster -->
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
</body>
</html>