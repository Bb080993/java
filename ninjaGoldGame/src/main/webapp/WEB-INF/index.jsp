<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gold Game</title>
<link rel="stylesheet" type="text/css" href="/css/index.css">
</head>
<body>
 	<div class="container">
 		<nav>
 			<h1>Your Gold: <c:out value="${gold}"/></h1>
 		</nav>
 		<div class="middle">
 			<div class="farm">
 				<h3>Farm</h3>
 				<p>(earns 10-20 gold)</p>
 				<form action="/gold" method="post">
 					<input type="hidden" name="number" value="1"/>
 					<button>Find Gold</button>
 				</form>
 			</div>
 			<div class="cave">
 				<h3>Cave</h3>
 				<p>(earns 5-10 gold)</p>
 				<form action="/gold" method="post">
 					<input type="hidden" name="number" value="2"/>
 					<button>Find Gold</button>
 				</form>
 			</div>
 			<div class="house">
 				<h3>House</h3>
 				<p>(earns 2-5 gold)</p>
 				<form action="/gold" method="post">
 					<input type="hidden" name="number" value="3"/>
 					<button>Find Gold</button>
 				</form>
 			</div>
 			<div class="quest" >
 				<h3>Quest</h3>
 				<p>(earns/takes 0-50 gold)</p>
 				<form action="/gold" method="post">
 					<input type="hidden" name="number" value="4"/>
 					<button>Find Gold</button>
 				</form>
 			</div>
 			<div class="spa" >
 				<h3>Spa</h3>
 				<p>(takes 5-20 gold)</p>
 				<form action="/gold" method="post">
 					<input type="hidden" name="number" value="5"/>
 					<button>Spend Gold</button>
 				</form>
 			</div>
 		</div>
 		<div class="activities">
 			<h3>Activities</h3>
 			<div class="all">
 				<c:forEach var="activity" items="${ activities}">	
 					<p><c:out value="${activity}"/></p>
 				
 				</c:forEach>
 			</div>
 		</div>
 		<div class="reset">
 			<a href="/reset">Reset Game</a>
 		</div>
 		
 	</div>
</body>
</html>