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
<title>Create Dojo</title>

</head>
<body>
	<h1>New Dojo</h1>
<form:form modelAttribute="dojo"  method="post" action="/create/dojo">
	
	<form:label path="name">Dojo Name:</form:label>
<form:errors path="name"></form:errors>
<form:input path="name" ></form:input>

<button>Create Dojo</button>

</form:form>
<a href="/">Home</a>

</body>
</html>