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
<title>Home</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
    crossorigin="anonymous">

</head>
<body>
<h1>Dojo and Ninja Home Page</h1>
<a href="/dojo/new">Create a new Dojo!</a>
<a href="/ninja/new">Create a new Ninja!</a>

<table class="table table-striped">
<tr>
<th>Choose a Dojo below to see its ninjas!</th>
</tr>
<c:forEach var="dojo" items="${allDojos}">
<tr>
<td>

<a href="/dojo/${dojo.id}">${ dojo.name}</a>
</td>
</tr>

</c:forEach>

</table>
</body>
</html>