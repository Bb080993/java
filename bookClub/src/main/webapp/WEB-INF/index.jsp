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
<title>Login and Registration Page</title>
<link rel="stylesheet" href="/css/index.css"/>
</head>
<body>
	<div class="container">
		<h1>Book Club</h1>
		<p>A place for friends to share thoughts on books</p>
		<div class="main">
			<div class="register">
				<form:form action="/register" method="post" modelAttribute="newUser">
			<h2>Register</h2>
					<form:label path="name">Name: </form:label>
					<form:input path="name"></form:input>
					<form:errors path="name"></form:errors>
					
					<form:label path="email">Email: </form:label>
					<form:input path="email"></form:input>
					<form:errors path="email"></form:errors>
					
					<form:label path="password">Password: </form:label>
					<form:input type="password" path="password"></form:input>
					<form:errors path="password"></form:errors>
					
					<form:label path="confirm">Confirm Password:</form:label>
					<form:input type="password" path="confirm"></form:input>
					<form:errors path="confirm"></form:errors>
					
					<button>Submit</button>
				
				</form:form>
		
			</div>
			<div class="login">
				<form:form action="login" method="post" modelAttribute="newLogin">
				<h2>Login</h2>
					<form:label path="email">Email: </form:label>
					<form:input path="email"></form:input>
					<form:errors path="email"></form:errors>
					
					<form:label path="password">Password: </form:label>
					<form:input type="password" path="password"></form:input>
					<form:errors path="password"></form:errors>
					
					<button>Submit</button>
				
				</form:form>
			
			</div>
		</div>
		
	
	
	</div>

</body>
</html>