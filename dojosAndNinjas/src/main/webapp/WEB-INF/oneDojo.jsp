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
<title>One Dojo with Ninjas</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
    crossorigin="anonymous">

</head>
<body>

<h1><c:out value="${oneDojo.name }"/></h1>
<table class="table table-striped">
<tr>
<th>Ninja First Name</th>
<th>Ninja Last Name</th>
<th>Ninja Age</th>
</tr>


<c:forEach var="ninja" items="${oneDojo.ninjas }">
<tr>

<td><c:out value="${ninja.firstName }"/></td>
<td><c:out value="${ninja.lastName }"/></td>
<td><c:out value="${ninja.age }"/></td>
</tr>

</c:forEach>

</table>
<a href="/">Home</a>

</body>
</html>