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
<title>Create Ninja</title>
</head>
<body>
	<h1>New Ninja</h1>
	<form:form method="post" modelAttribute="ninja" action="/create/ninja">
	
	<form:label path="dojo">Dojo</form:label>
	<form:select path="dojo">
		<c:forEach var="dojo" items="${allDojos}">
		<option value="${dojo.id}">${dojo.name}</option>
		</c:forEach>
	</form:select>
	<form:errors path="dojo"></form:errors>
	
		<form:label path="firstName">First Name:</form:label>
<form:errors path="firstName"></form:errors>
<form:input path="firstName" ></form:input>

	<form:label path="lastName">Last Name:</form:label>
<form:errors path="lastName"></form:errors>
<form:input path="lastName" ></form:input>

	<form:label path="age">Age:</form:label>
<form:errors path="age"></form:errors>
<form:input path="age" ></form:input>

<button>Create Ninja</button>

	
	</form:form> 
	<a href="/">Home</a>

</body>
</html>