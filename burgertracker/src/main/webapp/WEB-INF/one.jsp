<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>One Burger</title>
</head>
<body>
<h1><c:out value="${oneBurger.burgerName }"/></h1>
<p>This burger is made at <c:out value="${oneBurger.restaurantName }"/></p>
<p>I rated this burger <c:out value="${oneBurger.rating }"/> stars</p>
<p>Here what this burger is all about: <c:out value="${oneBurger.notes}"/></p>

<a href="/">Home</a>

</body>
</html>