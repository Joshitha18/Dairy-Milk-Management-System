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
<form action="addSeller" method="post">
			<table style="with: 50%">
				<tr>
					<td>code</td>
					<td><input type="text" name="code" /></td>
				</tr>
				<tr>
					<td>id</td>
					<td><input type="text" name="id" /></td>
				</tr>
				<tr>
					<td>name</td>
					<td><input type="text" name="name" /></td>
				</tr>
					<tr>
					<td>center number</td>
					<td><input type="text" name="add" /></td>
				</tr>
				<tr>
					<tr>
					<td>cattle type</td>
					<td><input type="text" name="cattle" /></td>
				</tr>
				<tr>
					<tr>
					<td>reg date</td>
					<td><input type="text" name="date" /></td>
				</tr>
				<tr>
					<tr>
					<td>head_no</td>
					<td><input type="text" name="hno" /></td>
				</tr>
			</table>
			<input type="submit" value="Submit" /></form>
</body>
</html>