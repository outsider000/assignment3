/*
 * reviewMessage.java
 *
 * Created on February 28, 2007, 12:58 PM
 */

package mbs;

import java.io.*;
import java.net.*;
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
public class submitMessage2 extends HttpServlet {
    
    private Connection conn;
    private Statement st;
  
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int bytesread;
        char[] cbuf = new char[128];
        ResultSet rs=null;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        
        try{
             Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/ss_message";
            conn = DriverManager.getConnection(connectionURL, "TEST", "TEST");
            st = conn.createStatement();
            String q1 = new String("DELETE  FROM ss_message WHERE username = '"+
                    request.getParameter("username")+"'");
            st.execute(q1);
        }       
        catch (SQLException se)
        {
            se.printStackTrace();  
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(reviewMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /* TODO output your page here */
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>User Page</h3>");
        out.println("</tr><td>User Deleted </td><tr>");
        out.println("</textarea></td>");
        out.println("</tr> <tr> <td></td>");
        out.println("<h3><a href =\"index.jsp\">Back to home</a></h3>");    
        out.println(" </tr> </tbody></table> </form>");
        out.println("</body>");
        out.println("</html>");
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
