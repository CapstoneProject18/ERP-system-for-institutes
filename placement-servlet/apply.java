import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Apply extends HttpServlet  {
	public void doPost(HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException {
	 response.setContentType("text/html;charset=UTF-8 ");
     PrintWriter pw = response.getWriter();
		String name = request.getParameter("name");
		String enrollment = request.getParameter("enrollment");
		String  ref= request.getParameter("ref");
		String job_prefe = request.getParameter("job_prefe");
		
		
	       try{
			    Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://Localhost/placement_add","root","1234");
				PreparedStatement ps = con.prepareStatement("insert into details values(?,?,?,?)");
				ps.setString(1,name);
				ps.setString(2,enrollment);
				ps.setString(3,ref);
				ps.setString(4,job_prefe);
				
				
				int i = ps.executeUpdate();
				
				if(i>0)
				{   pw.println("sucessfully applyed");
					RequestDispatcher rd=request.getRequestDispatcher("Home.html");
			            rd.forward(request,response);
				}
		   }
		   catch(Exception se)
		   {
			   se.printStackTrace();
		   }
	}
}
				
			    
			   