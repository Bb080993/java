<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- This bootstrap link did not work -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
    crossorigin="anonymous">
<title>All Books</title>
</head>
<body>
<h1>All Books!</h1>
<table class="table table-striped">
    <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Language</th>
            <th>Number of Pages</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="book" items="${books}">
        <tr>
        	<th><c:out value="${book.id }"/></th>
        	<th> <a href="/books/<c:out value="${book.id }"/>"> <c:out value="${book.title }"/> </a>   </th>
        	<th><c:out value="${book.language }"/></th>
        	<th><c:out value="${book.numberOfPages }"/></th>
        
        </tr>
        
        </c:forEach>
    </tbody>
</table>

</body>
</html>