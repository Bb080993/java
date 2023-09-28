<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!-- for form tag library -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- for form validations -->
<%@ page isErrorPage="true" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login and Registration</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<h1>Welcome!</h1>
		<h4>Join our growing community</h4>
		<div class="forms">
		
		
		<div class="register">
		<h2>Register</h2>
		<form:form method="post" action="/register" modelAttribute="newUser">
		
		<form:label path="userName">User Name</form:label>
		<form:errors path="userName"></form:errors>
		<form:input path="userName"></form:input>
		
		<form:label path="email">Email</form:label>
		<form:errors path="email"></form:errors>
		<form:input type="email"  path="email"></form:input>
		
		<form:label path="password">Password</form:label>
		<form:errors path="password"></form:errors>
		<form:password path="password"/>
		
		<form:label path="confirm">Confirm Password</form:label>
		<form:errors path="confirm"></form:errors>
		<form:password path="confirm"/>
		
		<button>Register</button>
		
		</form:form>
		
		
		</div>
		<div class="login">
		<h2>Login</h2>
		<form:form method="post" action="/login" modelAttribute="newLogin">
		
		<form:label path="email">Email</form:label>
		<form:errors path="email"></form:errors>
		<form:input path="email"></form:input>
		
		<form:label path="password">Password</form:label>
		<form:errors path="password"></form:errors>
		<form:password path="password"/>
		
		<button>Login</button>
		
		</form:form>
		
		
		</div>
		
		</div>
	
	</div>
	
</body>
</html>