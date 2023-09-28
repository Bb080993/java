<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Count Page</title>
</head>
<body>

<h2>You have visited the welcome page <c:out value="${count}"/> times.</h2>
<p><a href="/">Test another visit?</a></p>
<p><a href="/clear">Clear counter?</a></p>

</body>
</html>