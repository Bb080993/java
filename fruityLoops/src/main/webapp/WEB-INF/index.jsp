<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fruits</title>
<link rel="stylesheet" type="text/css" href="/css/index.css">
</head>
<body>

	<div class="container">
	
		<h1>Fruit Store</h1>
		<div class="fruits">
			<table>
				<tr class="col">
					<th>Name</th>
					<th>Price</th>
				</tr>
				<c:forEach var="oneFruit" items="${fruits}">
				<tr class="col">
					<td><c:out value="${oneFruit.name}"/></td>
					<td><c:out value="${oneFruit.price}"/></td>
				
				</tr>
				</c:forEach>
				
				

		
			</table>
		</div>
	
	
	
	</div>
	
	

</body>
</html>