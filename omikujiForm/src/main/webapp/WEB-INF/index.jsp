<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji</title>
<link rel="stylesheet" type="text/css" href="/css/index.css">
</head>
<body>
	<div class="container">
	<h1>Send an Omikuji!</h1>
	<form action="/fortune" method="post">
		<label for="number">Pick any number from 5 to 25</label>
		<input type="number" name="number"/>
		<label for="city">Enter the name of any city</label>
		<input type="text" name="city" />
		<label for="name">Enter the name of any real person</label>
		<input type="text" name="name" />
		<label for="hobby">Enter professional endeavor or hobby</label>
		<input type="text" name="hobby" />
		<label for="livingThing">Enter any type of living thing</label>
		<input type="text" name="livingThing" />
		<label for="nice">Say something nice to someone</label>
		<textarea name="nice" cols="30" rows="10"></textarea>
		<label for="submit">Send and show a friend</label>
		<button>Send</button>
	</form>
	
	</div>
</body>
</html>