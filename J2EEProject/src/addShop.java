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

@WebServlet("/addShop")
public class addShop extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public addShop() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{

		//getting input values from jsp page
		String no = request.getParameter("num");
		String city = request.getParameter("city");
		String inch = request.getParameter("inch");
		String name = request.getParameter("name");
		String add = request.getParameter("add");
		String bid = request.getParameter("bid");
		
		Connection con = null;
 		String url = "jdbc:postgresql://localhost:5432/library"; //PostgreSQL URL and followed by the database name
 		String username = "librarian"; //PostgreSQL username
 		String password = "123"; //PostgreSQL password
		
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection(url, username, password); //attempting to connect to PostgreSQL database
 		System.out.println("Printing connection object "+con);

		PreparedStatement st = con .prepareStatement("select buyer_id from shoptable where buyer_id = ?");
 		st.setString(1,bid);
		ResultSet rs=st.executeQuery();
		if (!rs.isBeforeFirst() && rs.getRow() == 0) {
		st = con .prepareStatement("insert into shoptable values(?, ?,?,?,?, ?)");
 		st.setString(1,no);
		st.setString(2,city);
		st.setString(3,inch);
		st.setString(4,name);
		st.setString(5,add);
		st.setString(6,bid);
		int result=st.executeUpdate();	
		
		st = con .prepareStatement("insert into users values(?, ?,?)");
 		st.setString(1,no);
		st.setString(2,"123");
		st.setString(3,"Buyer");
		
		int result1=st.executeUpdate();
		
		if(result>0 && result1>0)		
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