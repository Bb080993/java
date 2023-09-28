<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Burger</title>
</head>
<body>
<h1>Edit Burger</h1>
</table>
<form:form modelAttribute="oneBurger"  method="post" action="/update/${oneBurger.id}">

<input type="hidden" name="_method" value="put">

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
<a href="/">Home</a>

</body>
</html>