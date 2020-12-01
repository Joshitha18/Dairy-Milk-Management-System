import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat; 

@WebServlet("/updatePass")
public class updatePass extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public updatePass() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{

		//getting input values from jsp page
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		
		Connection con = null;
 		String url = "jdbc:postgresql://localhost:5432/library"; //PostgreSQL URL and followed by the database name
 		String username = "librarian"; //PostgreSQL username
 		String password = "123"; //PostgreSQL password
		
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection(url, username, password); //attempting to connect to PostgreSQL database
 		System.out.println("Printing connection object "+con);

		PreparedStatement st = con .prepareStatement("select user_id from users where user_id = ?");
 		st.setString(1,id);
		ResultSet rs=st.executeQuery();
		if (!rs.isBeforeFirst() && rs.getRow() == 0) {
		}
		else {	
	
		st = con .prepareStatement("update users set users password=? where user_id=?");
 		st.setString(1,pass);
		st.setString(2,id);
		
		int result1=st.executeUpdate();
		
		if(result1>0)
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