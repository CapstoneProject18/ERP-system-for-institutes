/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courses_servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author Shashank
 */
public class Add_course extends HttpServlet {

    private String course_name,course_incharge,course_id = "123",status = "newly_created";
    private int no_credits,no_students = 0;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      course_name = request.getParameter("Course_name");
      course_incharge = request.getParameter("course_incharge");
      no_credits = Integer.parseInt(request.getParameter("credits"));
      
      String query = "Insert into courses values('" + course_id + "','" + course_name + "','" + course_incharge + "','" + no_credits + "','" + no_students + "','" + status + "'";                        
      
      try{
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ERP","root","pandu1089");
      Statement st = con.createStatement();
      st.executeUpdate(query);
      
              }
      catch(Exception e){
          e.printStackTrace(); 
      }
      //finally{
         
      //}
    }

    
   // @Override
    //protected void doPost(HttpServletRequest request, HttpServletResponse response)
      //      throws ServletException, IOException {
        
    //}

    
    

}
