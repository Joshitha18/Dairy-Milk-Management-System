<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%
Connection con = null;
	String url = "jdbc:postgresql://localhost:5432/library"; //PostgreSQL URL and followed by the database name
	String username = "librarian"; //PostgreSQL username
	String password = "123"; //PostgreSQL password

Class.forName("org.postgresql.Driver");
con = DriverManager.getConnection(url, username, password); //attempting to connect to PostgreSQL database
	System.out.println("Printing connection object "+con);
	
	ServletContext context=getServletContext();  
	String id=(String)context.getAttribute("staff_headID");

	PreparedStatement st = con .prepareStatement("select * from sellertable natural join users where head_ID = ?");
		st.setString(1,id);
	ResultSet resultSet=st.executeQuery();
%>
<!DOCTYPE html>
<html>
<body>
<h1>Staff View Sellers</h1>
<table border="1">
<tr>
<td>code</td>
<td>id</td>
<td>name</td>
<td>cattle type</td>
<td>reg date</td>
</tr>
<%
try{
while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getString("s_code") %></td>
<td><%=resultSet.getString("user_id") %></td>
<td><%=resultSet.getString("s_name") %></td>
<td><%=resultSet.getString("cattle_type") %></td>
<td><%=resultSet.getString("r_date") %></td>
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