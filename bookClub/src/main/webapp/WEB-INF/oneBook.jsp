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
<title>One Book</title>
</head>
<body>
	<h1><c:out value="${oneBook.title }"/></h1>
	<a href="/books">Back to Shelves</a>
	<p> <c:out value="${oneBook.user.name }"/> read "<c:out value="${oneBook.title }"/>" by <i><c:out value="${oneBook.author }"/></i>. </p>
	<p>Here are <c:out value="${oneBook.user.name }"/>'s thoughts:  </p>
	<p><i><c:out value="${oneBook.thoughts }"/></i></p>
	
	<c:if test="${userId==oneBook.user.id}">
	
	<a href="/edit/${oneBook.id}">Edit</a>
	<form action="/delete/${oneBook.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form>
	
	</c:if>

</body>
</html>