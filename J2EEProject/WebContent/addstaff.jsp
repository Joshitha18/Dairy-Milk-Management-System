<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>issue Addition Form</title>
</head>
<body>
<h1>Issue Details </h1>
<form action="addStaff" method="post">
			<table style="with: 50%">
				<tr>
					<td>Id</td>
					<td><input type="text" name="id" /></td>
				</tr>
				<tr>
					<td>name</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>Salary</td>
					<td><input type="text" name="sal" /></td>
				</tr>
					<tr>
					<td>phone no</td>
					<td><input type="text" name="phno" /></td>
				</tr>
				</tr>
					<tr>
					<td>center no</td>
					<td><input type="text" name="hno" /></td>
				</tr>
			</table>
			<input type="submit" value="Submit" /></form>
</body>
</html>