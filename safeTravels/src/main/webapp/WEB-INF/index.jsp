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
<title>All Expenses</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
    crossorigin="anonymous">

</head>
<body>

	<h1>Save Travels</h1>
	<table class="table table-striped">
		<tr>
			<th>Expense</th>
			<th>Vendor</th>
			<th>Amount</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="oneExpense" items="${allExpenses }">
		<tr>
			<td><a href="/expense/<c:out value="${oneExpense.id}"/>"><c:out value="${oneExpense.expenseName }"/></a></td>
			<td><c:out value="${oneExpense.vendor }"/></td>
			<td>$<c:out value="${oneExpense.amount }"/></td>
			<td><a href="/edit/<c:out value="${oneExpense.id}"/>">Edit</a><form action="/delete/${oneExpense.id}" method="post">
    		 		<input type="hidden" name="_method" value="delete">
    		 		<input type="submit" value="Delete">
				</form></td>
		</tr>
		
		</c:forEach>
	</table>
	
	<h2>Add an expense:</h2>
	<form:form modelAttribute="expense"  method="post" action="/create">
	
	<form:label path="expenseName">Expense Name:</form:label>
<form:errors path="expenseName"></form:errors>
<form:input path="expenseName" class="form-control"></form:input>
	
	<form:label path="vendor">Vendor:</form:label>
<form:errors path="vendor"></form:errors>
<form:input path="vendor" class="form-control"></form:input>

	<form:label path="amount">Amount:</form:label>
<form:errors path="amount"></form:errors>
<form:input  path="amount" class="form-control"></form:input>

	<form:label path="description">Description:</form:label>
<form:errors path="description"></form:errors>
<form:textarea path="description" rows="3" cols="20" class="form-control" />

<button type="submit" class="btn btn-primary">Submit</button>
	
	
	
	</form:form>


</body>
</html>