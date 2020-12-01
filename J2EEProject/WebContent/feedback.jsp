 <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
Connection con = null;
	String url = "jdbc:postgresql://localhost:5432/library"; //PostgreSQL URL and followed by the database name
	String username = "librarian"; //PostgreSQL username
	String password = "123"; //PostgreSQL password

Class.forName("org.postgresql.Driver");
con = DriverManager.getConnection(url, username, password); //attempting to connect to PostgreSQL database
	System.out.println("Printing connection object "+con);

	Statement st = con.createStatement();
	ResultSet resultSet = st.executeQuery("select * from feedback");
%>
<!DOCTYPE html>
<html>
<body>
<h1>feedback</h1>
<table border="1">
<tr>
<td>feedback</td>
<td>role</td>
<td>name</td>
<td>id</td>
<td>date</td>
</tr>
<%
try{
while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getString("feedback") %></td>
<td><%=resultSet.getString("role") %></td>
<td><%=resultSet.getString("name") %></td>
<td><%=resultSet.getString("id") %></td>
<td><%=resultSet.getString("date") %></td>
</tr>
<%
}
} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
</body>
</html>

