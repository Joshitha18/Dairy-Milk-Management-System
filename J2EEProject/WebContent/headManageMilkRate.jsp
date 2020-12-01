<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Milk Rate Table</title>
</head>
<body>
<h1>Milk Rate Details </h1>
<form action="head_MilkRate" method="post">
			<table style="with: 50%">
				<tr>
					<td>date</td>
					<td><input type="text" name="date" /></td>
				</tr>
				<tr>
					<td>center no</td>
					<td><input type="text" name="cno" /></td>
				</tr>
				<tr>
					<td>city</td>
					<td><input type="text" name="city" /></td>
				</tr>
					<tr>
					<td>cow_milk_qty</td>
					<td><input type="text" name="cow_qty" /></td>
				</tr>
					<tr>
					<td>buffalo_milk_qty</td>
					<td><input type="text" name="buf_qty" /></td>
				</tr>
				<tr>
					<td>cow_fat</td>
					<td><input type="text" name="cow_fat" /></td>
				</tr>
				<tr>
					<td>buffalo_fat</td>
					<td><input type="text" name="buf_fat" /></td>
				</tr>

		</table>
			<input type="submit" value="Submit" /></form>
</body>
</html>