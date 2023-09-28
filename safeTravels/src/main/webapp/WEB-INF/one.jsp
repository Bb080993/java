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
<title>One Expense</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
    crossorigin="anonymous">
</head>
<body>

	<h1>Expense Details</h1>
	<a href="/expenses">Go Back</a>

<p>Expense Name: <c:out value="${oneExpense.expenseName }"/></p>
<p>Expense Description:  <c:out value="${oneExpense.description }"/></p>
<p>Vendor:  <c:out value="${oneExpense.vendor }"/></p>
<p>Amount Spent: $<c:out value="${oneExpense.amount }"/></p>
</body>
</html>