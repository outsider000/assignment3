/*
 * Hello.java
 *
 * Created on February 27, 2007, 12:39 PM
 */

package mbs;

import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.regex.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author spring
 * @version
 */
public class submitMessage1 extends HttpServlet {
    private Connection conn;
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       
        Date start=null, connection = null, process =null, cclose =null;
        java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Boolean valid = false;
        String clean_username, clean_password;
        Statement st;
        Matcher matcher;
         
        //clean the inputs using regular expressions
        // Compile regular expression
        Pattern pattern = Pattern.compile("[;:,#&'\".!?]");
        // Replace all occurrences of pattern in input
        matcher = pattern.matcher(request.getParameter ("username"));
        clean_username = matcher.replaceAll("|");
        matcher = pattern.matcher(request.getParameter ("password"));
        clean_password = matcher.replaceAll("|");
        //open the DBMS and insert the record
        try{
            start = new Date();            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/ss_message";
            conn = DriverManager.getConnection(connectionURL, "TEST", "TEST");
            //conn=DriverManager.getConnection(database, "","");
            connection = new Date();
            st = conn.createStatement();
            String q1 = new String("INSERT INTO ss_message (username, password)"+
                " VALUES ('" +
                clean_username+"','"+
                clean_password+ "')");
                System.out.println(q1);
                st.execute(q1);
                process = new Date();
                conn.close();
                cclose  = new Date();
                valid=true;
        }        
        catch (SQLException se)
        {
            se.printStackTrace();  
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(submitMessage1.class.getName()).log(Level.SEVERE, null, ex);
        }
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        if (valid)
        {
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Creat</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("</tr><td>Welcome " + clean_username+ ". </td><tr>");     
        out.println("</tr><td>User Created.</td><tr>");     
            out.println("<h3><a href =\"index.jsp\">Back to home</a></h3>");    
        out.println("</body>");
        out.println("</html>");
        }
        else
        {
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Message Storage Problem</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>We were unable to creat user</p><ol><p>"); 
            out.println("<h3><a href =\"index.jsp\">Back to home</a></h3>");    
        out.println("</body>");
        out.println("</html>");   
        }
        out.close();
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
