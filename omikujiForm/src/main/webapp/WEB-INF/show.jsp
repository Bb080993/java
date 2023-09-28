<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Fortune</title>
<link rel="stylesheet" type="text/css" href="/css/show.css">
</head>
<body>
	<div class="container">
		<h1>Here's your Omikuji!!!</h1>
		<div class="fortune">
			<p>In <c:out value="${ number}"/> years, you will live in <c:out value="${ city}"/> with <c:out value="${name }"/> as your roommate, <c:out value="${hobby}"/> as a living. The next time you see a <c:out value="${livingThing}"/> you will have good luck. Also, <c:out value="${nice }"/>.</p>
		</div>
		<a href="/omikuji">Go Back</a>
	
	</div>
	

</body>
</html>