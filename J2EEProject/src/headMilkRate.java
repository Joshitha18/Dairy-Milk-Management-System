import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/headMilkRate")
public class headMilkRate extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public headMilkRate() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{

		//getting input values from jsp page
		String date = request.getParameter("date");
		String cno = request.getParameter("cno");
		String city = request.getParameter("city");
		float cow_qty = Float.parseFloat(request.getParameter("cow_qty"));
		float buf_qty = Float.parseFloat(request.getParameter("buf_qty"));
		float cow_fat = Float.parseFloat(request.getParameter("cow_fat"));
		float buf_fat = Float.parseFloat(request.getParameter("buf_fat"));

		Connection con = null;
 		String url = "jdbc:postgresql://localhost:5432/library"; //PostgreSQL URL and followed by the database name
 		String username = "librarian"; //PostgreSQL username
 		String password = "123"; //PostgreSQL password
		
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection(url, username, password); //attempting to connect to PostgreSQL database
 		System.out.println("Printing connection object "+con);


		PreparedStatement st = con .prepareStatement("insert into milk_rate_table values(?, ?,?,?,?,?,?)");
 		st.setDate(1,java.sql.Date.valueOf(date));
		st.setString(2,cno);
		st.setString(3,city);
		st.setFloat(4,cow_qty);
		st.setFloat(5,buf_qty);
		st.setFloat(6,cow_fat);
		st.setFloat(7,buf_fat);
		int result=st.executeUpdate();	
		
		if(result>0)
		{
			
			RequestDispatcher rd = request.getRequestDispatcher("Added.jsp");
			rd.forward(request, response);
		}

		}
		 catch (Exception e) 
 		{
 			e.printStackTrace();
 		}
	}
}