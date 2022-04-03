/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.sql.*;
import javax.servlet.ServletConfig;
/**
 *
 * @author Alumno
 */
public class ConsultarAlumnos extends HttpServlet {
    
    private Connection con;
    private Statement set;
    private ResultSet rs;
    
    
    
    public void init(ServletConfig cfg) throws ServletException{
        
        String URL = "jdbc:mysql:3306//localhost/alumno";
        
        String userName = "root";
        String password = "n0m3l0";
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            
            URL = "jdbc:mysql://localhost/alumno";
            
            con = DriverManager.getConnection(URL, userName, password);
            set = con.createStatement();
            
            System.out.println("Se conecto a la BD *w* ");
        }catch(Exception e){
            
            System.out.println("No se conecto, solo juguito contigo");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        
        }
    
    }
    
    
    
    
    
    
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Lista de Alumnos de Batiz</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Tabla de la Lista de Alumnos</h1>"
                    + "<table border=2>"
                        + "<tr>"
                            + "<th>Boleta</th>"
                            + "<th>Nombre del Alumno</th>"
                            + "<th>Telefono</th>"
                        + "</tr>");
            try{
                int boleta;
                String nombre, apellidopaterno, apellidomaterno, tel;
                
                //establecer la querry
                String q = "select * from alumnobatiz";
                
                set = con.createStatement();
                rs = set.executeQuery(q);
                
                while(rs.next()){
                    boleta = rs.getInt("boleta");
                    nombre = rs.getString("nombre");
                    apellidopaterno = rs.getString("appat");
                    apellidomaterno = rs.getString("apmat");
                    tel = rs.getString("telefono");
                    
                    out.println("<tr>"
                                + "<td>"+boleta+"</td>"
                                + "<td>"+nombre+" "+apellidopaterno+" "
                                +apellidomaterno+"</td>"
                                + "<td>"+tel+"</td>"
                            + "</tr>");
                }
                
                //hay que cerrar conexiones
                rs.close();
                set.close();
            
            }catch(Exception e){
                System.out.println("Error al conectar a la tabla");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
            
            }
            
            
            out.println("</table>");
            out.println("<a href='index.html' >Pagina principal</a>");
            out.println("</body>");
            out.println("</html>");
        }
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
    
    //creamos el destructor
    public void destroy(){
        try{
            con.close();
        }catch(Exception e){
            super.destroy();
        }
    }

}