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

@WebServlet("/headaddStaff")
public class headaddStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public headaddStaff() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{


		//getting input values from jsp page
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int sal = Integer.parseInt(request.getParameter("sal"));
		String phno = request.getParameter("phno");

		Connection con = null;
 		String url = "jdbc:postgresql://localhost:5432/library"; //PostgreSQL URL and followed by the database name
 		String username = "librarian"; //PostgreSQL username
 		String password = "123"; //PostgreSQL password
		
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection(url, username, password); //attempting to connect to PostgreSQL database
 		System.out.println("Printing connection object "+con);
 		
 		ServletContext context=getServletContext();  
 		String hno=(String)context.getAttribute("headID");
 		
		PreparedStatement st = con .prepareStatement("select st_id from stafftable where st_id = ?");
 		st.setString(1,id);
		ResultSet rs=st.executeQuery();
		if (!rs.isBeforeFirst() && rs.getRow() == 0) {
		st = con .prepareStatement("insert into stafftable values(?, ?,?,?,?)");
 		st.setString(1,id);
		st.setString(2,name);
		st.setInt(3,sal);
		st.setString(4,phno);
		st.setString(5,hno);
		int result=st.executeUpdate();	
		
		
		st = con .prepareStatement("insert into users values(?, ?,?)");
 		st.setString(1,id);
		st.setString(2,"123");
		st.setString(3,"Staff");
		
		int result1=st.executeUpdate();
		
		if(result>0 && result1>0)		{
			
			RequestDispatcher rd = request.getRequestDispatcher("Added.jsp");
			rd.forward(request, response);
		}
		}

		}
		 catch (Exception e) 
 		{
 			e.printStackTrace();
 		}

	
	}


}
