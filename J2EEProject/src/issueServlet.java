


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
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
@WebServlet("/issueServlet")
public class issueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public issueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{

			ServletContext context=getServletContext();  
			String n=(String)context.getAttribute("company");
			System.out.println("Welcome to "+n);  

//		//getting input values from jsp page
//		String id = request.getParameter("book_id");
//		String sid = request.getParameter("id");
//		String issue = request.getParameter("issue_date");
//		String due = request.getParameter("due");
//
//		Connection con = null;
// 		String url = "jdbc:postgresql://localhost:5432/library"; //PostgreSQL URL and followed by the database name
// 		String username = "librarian"; //PostgreSQL username
// 		String password = "123"; //PostgreSQL password
//		
//		Class.forName("org.postgresql.Driver");
//		con = DriverManager.getConnection(url, username, password); //attempting to connect to PostgreSQL database
// 		System.out.println("Printing connection object "+con);
//
//		//Prepared Statement to add student data
//		PreparedStatement st = con .prepareStatement("select student_id from student where student_id = ?");
// 		st.setString(1,sid);
//		ResultSet rs=st.executeQuery();
//		if (!rs.isBeforeFirst() && rs.getRow() == 0) {
//		        System.out.printf("Student is not present");
//		      } else {
//		st = con .prepareStatement("insert into issue values(?, ?,?,?)");
// 		st.setString(1,id);
//		st.setString(2,sid);
//		st.setString(3,issue);
//		st.setString(4,due);
//		int result=st.executeUpdate();
//
//		//Checks if insert is successful.If yes,then redirects to Result.jsp page 
//		if(result>0)
//		{
//			
//			RequestDispatcher rd = request.getRequestDispatcher("issueResult.jsp");
//			rd.forward(request, response);
//		}
//		
//		}

		}
		 catch (Exception e) 
 		{
 			e.printStackTrace();
 		}

	
	}


}

