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
	String code=(String)context.getAttribute("buyer_id");
	String date = request.getParameter("date");

	PreparedStatement st = con .prepareStatement("select * from deliver_milk_details where buyer_id = ? and date=?");
		st.setString(1,code);
		st.setDate(2, java.sql.Date.valueOf(date));
	ResultSet resultSet=st.executeQuery();
	
%>
<!DOCTYPE html>
<html>
<body>
<table border="1">
<tr>
<td>fat</td>
<td>qty</td>
<td>date</td>
<td>price</td>
</tr>
<%
try{
while(resultSet.next()){
	 float f = resultSet.getFloat("fat");
	 int q = resultSet.getInt("quantity");
	 float p = f*q*10;
%>
<tr>
<td><%=resultSet.getFloat("fat") %></td>
<td><%=resultSet.getInt("quantity") %></td>
<td><%=resultSet.getString("date") %></td>
<td><%=p %></td>
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