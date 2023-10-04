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
<title>Home Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
    crossorigin="anonymous">

</head>
<body>
<h1>Welcome <c:out value="${loggedInUser.name }"></c:out>!</h1>
<p>Books from everyone's shelves:</p>
<a href="/logout">Logout</a>
<a href="/books/new">+Add to my shelf</a>

<table class="table table-striped">
	<tr>
		<th>Id</th>
		<th>Title</th>
		<th>Author</th>
		<th>Posted By</th>
	</tr>
	<c:forEach var="book" items="${allBooks}">
		<tr>
			<td> <c:out value="${book.id}"></c:out> 	</td>
			<td> <a href="/books/${book.id}"><c:out value="${book.title}"/> </a></td>
			<td> <c:out value="${book.author}"/></td>
			<td> <c:out value="${book.user.name}"/></td>
		</tr>
	</c:forEach>



</table>

</body>
</html>