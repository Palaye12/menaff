/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author palaye
 */
public class test2 extends HttpServlet {
    
        
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
            out.println("<title>Servlet test2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet test2 at " + request.getContextPath() + "</h1>");
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
    
         resultat = statement.executeQuery( "SELECT *  FROM user ;" );
         
         ArrayList<User> users = new ArrayList<User>();
         
            while ( resultat.next() ) {
            int id = resultat.getInt( "id_user" );
            String pr = resultat.getString( "prenom" );
            String nm = resultat.getString( "nom" );
            int tele = resultat.getInt( "telephone" );
            /* Formatage des données pour affichage dans la JSP finale. */
            
            User u = new User(id,pr,nm,tele);
            users.add(u);
            
           }
            request.setAttribute("users", users);
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
               
   RequestDispatcher rd =  request.getRequestDispatcher("/newjsp2.jsp");
        
        rd.forward(request, response);
    
       
       
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
