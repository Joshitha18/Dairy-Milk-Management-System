import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/staff_DailyMilk")
public class staff_DailyMilk extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public staff_DailyMilk() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{

		//getting input values from jsp page
		String date = request.getParameter("date");
		String cattle = request.getParameter("cattle");
		int qty = Integer.parseInt(request.getParameter("qty"));
		String s_code = request.getParameter("s_code");
		float fat = Float.parseFloat(request.getParameter("fat"));
		String user_id = request.getParameter("user_id");

		Connection con = null;
 		String url = "jdbc:postgresql://localhost:5432/library"; //PostgreSQL URL and followed by the database name
 		String username = "librarian"; //PostgreSQL username
 		String password = "123"; //PostgreSQL password
		
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection(url, username, password); //attempting to connect to PostgreSQL database
 		System.out.println("Printing connection object "+con);

 		ServletContext context=getServletContext();  
 		String cno=(String)context.getAttribute("staff_center");
 		
		PreparedStatement st = con .prepareStatement("insert into dairy_milk_sell_table values(?, ?,?,?,?,?,?)");
 		st.setString(1,user_id);
		st.setString(2,s_code);
		st.setFloat(3,fat);
		st.setInt(4,qty);
		st.setString(5,cattle);
		st.setDate(6,java.sql.Date.valueOf(date));
		st.setString(7,cno);
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