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

@WebServlet("/addCenter")
public class addCenter extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public addCenter() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{


		//getting input values from jsp page
		String cno = request.getParameter("cno");
		String city = request.getParameter("city");
		String hid = request.getParameter("hid");

		Connection con = null;
 		String url = "jdbc:postgresql://localhost:5432/library"; //PostgreSQL URL and followed by the database name
 		String username = "librarian"; //PostgreSQL username
 		String password = "123"; //PostgreSQL password
		
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection(url, username, password); //attempting to connect to PostgreSQL database
 		System.out.println("Printing connection object "+con);

		PreparedStatement st = con .prepareStatement("select center_no from centertable where center_no = ?");
 		st.setString(1,cno);
		ResultSet rs=st.executeQuery();
		if (!rs.isBeforeFirst() && rs.getRow() == 0) {
		st = con .prepareStatement("insert into centertable values(?, ?,?)");
 		st.setString(1,cno);
		st.setString(2,city);
		st.setString(3,hid);
		int result=st.executeUpdate();	


		
		if(result>0 )
		{
			
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