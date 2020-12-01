<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sell Milk Table</title>
</head>
<body>
<h1>Milk Sell Details </h1>
<form action="staff_DailyMilk" method="post">
			<table style="with: 50%">
				</tr>
					<tr>
					<td>s_code</td>
					<td><input type="text" name="s_code" /></td>
				</tr>
				<tr>
					<td>user_id</td>
					<td><input type="text" name="user_id" /></td>
				</tr>
				<tr>
					<td>date</td>
					<td><input type="text" name="date" /></td>
				</tr>

				<tr>
					<td>cattle type</td>
					<td><input type="text" name="cattle" /></td>
				</tr>
					<tr>
					<td>qty</td>
					<td><input type="text" name="qty" /></td>
				<tr>
					<td>fat</td>
					<td><input type="text" name="fat" /></td>
				</tr>


		</table>
			<input type="submit" value="Submit" /></form>
</body>
</html>