/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author palaye
 */
public class NewServlet extends HttpServlet {

     
        String cp="con.mysql.jdbc.Driver";
        String cc="jdbc:mysql://localhost:3306/employer";
         String wu="root";
         String wp="";
        Connection connexion= null ;
        Statement statement=null ;
    ResultSet resultat=null ;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     request.getRequestDispatcher("/newjsp1.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String lg=request.getParameter("login");
        String pw=request.getParameter("pwd");
        
           try {
    Class.forName( cp );
              } 
          catch ( ClassNotFoundException e ) {
   
           }   
          
          try {
    connexion = DriverManager.getConnection( cc, wu,wp );
    statement=connexion.createStatement();
    /* Ici, nous placerons nos requêtes vers la BDD */
    /* ... */
         resultat = statement.executeQuery( "SELECT *  FROM connexion ;" );
         boolean verif;
            while ( resultat.next() ) {
            int id = resultat.getInt( "id_log" );
            String lg1 = resultat.getString( "login" );
            String pw1 = resultat.getString( "password" );
           
            request.setAttribute("login", lg1);
            
            verif=lg.equals(lg1) && pw.equals(pw1);
            
            if(verif == true){
                
                request.setAttribute("login", lg1);
                
                
                             
   RequestDispatcher rd =  request.getRequestDispatcher("/newjsp3.jsp");
        
        rd.forward(request, response);
            }
            if(verif == false){
                
                System.out.println("login or mot de passe incorrect");
               
            }
         
          
                       
  
        }
           } 
          catch ( SQLException e ) {
    /* Gérer les éventuelles erreurs ici */
          }
           finally {
       
        if ( resultat != null ) {
            try {
                resultat.close();
            } catch ( SQLException ignore ) {
            }
        }
        
        if ( statement != null ) {
            try {
                statement.close();
            } catch ( SQLException ignore ) {
            }
        }
        
        if ( connexion != null ) {
            try {
                connexion.close();
            } catch ( SQLException ignore ) {
            }
        }
        
          }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
