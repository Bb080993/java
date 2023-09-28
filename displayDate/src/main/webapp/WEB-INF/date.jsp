<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Date</title>
<link rel="stylesheet" type="text/css" href="/CSS/date.css">
</head>
<body>
	<div class="container">
	<h1><c:out value="${todaysDate}"/></h1>
	
	</div>
<script type="text/javascript" src="/js/date.js"></script>
</body>
</html>