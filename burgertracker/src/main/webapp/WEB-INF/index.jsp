<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Burger Tracker</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
    crossorigin="anonymous">

</head>
<body>
<h1>Burger Tracker</h1>

<table class="table table-striped">
	<tr>
		<th>Burger Name</th>
		<th>Restaurant</th>
		<th>Rating (out of 5)</th>
		<th>Action</th>
	</tr>
	<c:forEach var="burger" items="${allBurgers}">
	<tr>
		<td><c:out value="${burger.burgerName}"/></td>
		<td><c:out value="${burger.restaurantName}"/></td>
		<td><c:out value="${burger.rating}"/></td>
		<td> <a href="/edit/<c:out value="${burger.id}"/>">Edit</a> 
			 <a href="/burger/<c:out value="${burger.id}"/>">View</a>
			 	<form action="/delete/${burger.id}" method="post">
    		 		<input type="hidden" name="_method" value="delete">
    		 		<input type="submit" value="Delete">
				</form>
			  </td>
	</tr>
	</c:forEach>

</table>
<form:form modelAttribute="burger"  method="post" action="/create">

<form:label path="burgerName">Burger Name</form:label>
<form:errors path="burgerName"></form:errors>
<form:input path="burgerName"></form:input>

<form:label path="rating">Rating</form:label>
<form:errors path="rating"></form:errors>
<form:input type="number" path="rating"></form:input>

<form:label path="restaurantName">Restaurant Name</form:label>
<form:errors path="restaurantName"></form:errors>
<form:input path="restaurantName"></form:input>

<form:label path="notes">Notes</form:label>
<form:errors path="notes"></form:errors>
<form:textarea path="notes" rows="3" cols="20" />


<button>Submit</button>



</form:form>

</body>
</html>