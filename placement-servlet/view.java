import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Search extends HttpServlet {
 public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException {
	 response.setContentType("text/html; charset= UTF-8");
	 PrintWriter pw = response.getWriter();
	 
	 try 
	 { 
	  Class.forName ("com.mysql.jdbc.Driver");
	  Connection con = DriverManager.getConnection("jdbc:mysql://localhost/servlet","root","1234");
	  PreparedStatement ps = con.prepareStatement("select * from placement ");
	 
	  pw.println("<table>");
	  ResultSet rs = ps.executeQuery();
	  ResultSetMetaData rsmd = rs.getMetaData();
	  int i = rsmd.getColumnCount();
	  pw.print("<tr>");
	  
	  for (int j =1; j<=i ; j++)
	  {
		   pw.print("<th>"+rsmd.getColumnName(j)+"</th>");
	  }
      	pw.print("</tr>");
		
		while(rs.next())
		{ pw.print("<tr><td>" + rs.getString(1)+"</td><td>"+
	"<tr><td>" + rs.getString(1)+"</td><td>"+
	"<tr><td>" + rs.getString(2)+"</td><td>"+
	"<tr><td>" + rs.getString(3)+"</td><td>"+
	"<tr><td>" + rs.getString(4)+"</td><td>"+
	"<tr><td>" + rs.getString(5)+"</td><td>"+
	"<tr><td>" + rs.getString(6)+"</td><td>"+
	"<tr><td>" + rs.getString(7)+"</td><td>"+
	"<tr><td>" + rs.getString(8)+"</td><td>"+
	"<tr><td>" + rs.getString(9)+"</td><td>");
			
	}
	pw.print("</table>");
	
	 }
	 catch (Exception e2)
	 {e2.printStackTrace();}
		finally{pw.close();}
 }
}
	
	 
	 
		
		
	  
	  
		 
	 
