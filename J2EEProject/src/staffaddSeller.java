import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat; 

@WebServlet("/staffaddSeller")
public class staffaddSeller extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public staffaddSeller() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{

		//getting input values from jsp page
		String code = request.getParameter("code");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String cattle = request.getParameter("cattle");
		String dat = request.getParameter("date");
 		ServletContext context=getServletContext();  
 		String hno=(String)context.getAttribute("staff_headID");
 		String cno=(String)context.getAttribute("staff_center");
		Connection con = null;
 		String url = "jdbc:postgresql://localhost:5432/library"; //PostgreSQL URL and followed by the database name
 		String username = "librarian"; //PostgreSQL username
 		String password = "123"; //PostgreSQL password
		
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection(url, username, password); //attempting to connect to PostgreSQL database
 		System.out.println("Printing connection object "+con);

		PreparedStatement st = con .prepareStatement("select s_code from sellertable where s_code = ?");
 		st.setString(1,code);
		ResultSet rs=st.executeQuery();
		if (!rs.isBeforeFirst() && rs.getRow() == 0) {
		st = con .prepareStatement("insert into sellertable values(?, ?,?,?,?, ?,?)");
 		st.setString(1,code);
		st.setString(2,id);
		st.setString(3,name);
		st.setString(4,cno);
		st.setString(5,cattle);
		st.setDate(6, java.sql.Date.valueOf(dat));
		st.setString(7,hno);
		int result=st.executeUpdate();	
		
		st = con .prepareStatement("insert into users values(?, ?,?)");
 		st.setString(1,id);
		st.setString(2,"123");
		st.setString(3,"Seller");
		
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