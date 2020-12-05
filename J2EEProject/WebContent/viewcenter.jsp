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
	ResultSet resultSet = st.executeQuery("select * from centertable");
%>
<!DOCTYPE html>
<html>
<body>
<h1>heads</h1>
<table border="1">
<tr>

<td>center no</td>
<td>city</td>
<td>head id</td>

</tr>
<%
try{
while(resultSet.next()){
%>
<tr>

<td><%=resultSet.getString("center_no") %></td>
<td><%=resultSet.getString("city") %></td>
<td><%=resultSet.getString("head_id") %></td>

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