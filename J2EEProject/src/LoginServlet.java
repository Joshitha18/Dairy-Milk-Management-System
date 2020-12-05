


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
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{

		//getting input values from jsp page
		String id = request.getParameter("user");
		String pass = request.getParameter("pass");


		Connection con = null;
 		String url = "jdbc:postgresql://localhost:5432/library"; //PostgreSQL URL and followed by the database name
 		String username = "librarian"; //PostgreSQL username
 		String password = "123"; //PostgreSQL password
		
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection(url, username, password); //attempting to connect to PostgreSQL database
 		System.out.println("Printing connection object "+con);

 		
		PreparedStatement st = con .prepareStatement("select role from users where user_id = ? and password = ?");
 		st.setString(1,id);
 		st.setString(2,pass);
		ResultSet rs=st.executeQuery();
		String role="";
		if (!rs.isBeforeFirst() && rs.getRow() == 0) {
		        System.out.printf("no user");
		      } else {
		    	  while (rs.next()) {
		    		  role=rs.getString("role");
		    		} 
		    
		    if(role.equals("Admin")) {
		    RequestDispatcher rd = request.getRequestDispatcher("adminDashboard.jsp");
			rd.forward(request, response);
		    }
		    if(role.equals("Head")) {
		    RequestDispatcher rd = request.getRequestDispatcher("head.jsp");
			rd.forward(request, response);
		    }
		    if(role.equals("Staff")) {
		    RequestDispatcher rd = request.getRequestDispatcher("staff.jsp");
			rd.forward(request, response);
		    }
		    if(role.equals("Seller")) {
		    	  ServletContext context=getServletContext();  
		      	  context.setAttribute("seller_id",id);
		    RequestDispatcher rd = request.getRequestDispatcher("seller.jsp");
			rd.forward(request, response);
		    }
		    if(role.equals("Buyer")) {
		    	ServletContext context=getServletContext();  
		      	  context.setAttribute("shop_no",id);
		      	st = con .prepareStatement("select buyer_id from shoptable where shopno = ?");
		 		st.setString(1,id);
				rs=st.executeQuery();
				String bid="";
				while (rs.next()) {
		    		  bid=rs.getString("buyer_id");
		    		}
				context.setAttribute("buyer_id",bid);
		    RequestDispatcher rd = request.getRequestDispatcher("buyer.jsp");
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


