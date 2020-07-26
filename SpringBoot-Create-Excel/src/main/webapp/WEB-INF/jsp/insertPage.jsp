<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>insert</title>
</head>
<body>
<h1> New Student </h1> <hr/>
	<form action="add" method="post">
		Enter Roll <br/>
		<input type="text" name="roll"> <br/>
		Enter Name <br/>
		<input type="text" name="sname"> <br/>
		ENter Address <br/>
		<input type="text" name="address"> <br/><br/>
		<input type="submit" value="Submit">
	</form>
	<hr/>
	<h4>${msg }</h4>
</body>
</html>