
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.*;  
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/staffServlet")
public class staffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public staffServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{


		//getting input values from jsp page
		String Id = request.getParameter("id");

		Connection con = null;
 		String url = "jdbc:postgresql://localhost:5432/library"; //PostgreSQL URL and followed by the database name
 		String username = "librarian"; //PostgreSQL username
 		String password = "123"; //PostgreSQL password
		
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection(url, username, password); //attempting to connect to PostgreSQL database
 		System.out.println("Printing connection object "+con);

		PreparedStatement st = con .prepareStatement("select head_ID from stafftable where st_id = ?");
 		st.setString(1,Id);
		ResultSet rs=st.executeQuery();
		String staff_headID="";
		
		    	  while (rs.next()) {
		    		  staff_headID=rs.getString("head_ID");
		    		} 
		    	
		    	st = con .prepareStatement("select center_no from headtable where ID = ?");
		   		st.setString(1,staff_headID);
		  		rs=st.executeQuery();
		  		String staff_center="";
		  		
		  		    	  while (rs.next()) {
		  		    		  staff_center=rs.getString("center_no");
		  		    		}
  	  ServletContext context=getServletContext();  
  	  context.setAttribute("staff_headID",staff_headID);
  	  context.setAttribute("staff_center",staff_center);
  	  context.setAttribute("staff_ID",Id);
  	  
		    RequestDispatcher rd = request.getRequestDispatcher("staffDashboard.jsp");
			rd.forward(request, response);

		}
		 catch (Exception e) 
 		{
 			e.printStackTrace();
 		}

	
	}



}
