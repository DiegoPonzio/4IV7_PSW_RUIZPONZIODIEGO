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

/**
 *
 * @author PC
 */
public class Parametros extends HttpServlet {

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
           String nombre = "";
           String telefono = "";
           String correo = "";
           double tel = 0;
           
           String ip, nombremaquina, ip2;
           int puerto;
           
           nombre = request.getParameter("nombre");
           telefono = request.getParameter("telefono");
           tel = Double.parseDouble(telefono);
           correo = request.getParameter("correo");
           
           ip = request.getLocalAddr();
           nombremaquina = request.getLocalName();
           puerto = request.getLocalPort();
           ip2 = request.getRemoteAddr();
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Parametros</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Hola mundo, tu nombre es: " + nombre + "</h1>"
                    + "<br>"
                    + "<h1>Tu telefono es: "+ telefono +"</h1>"
                    + "<br>"
                    + "<h1>Tu correo es: "+ correo +"</h1>"
                    + "<br>"
                    + "<h1>El nombre de tu equipo es: "+ nombremaquina +"</h1>"
                    + "<br>"
                    + "<h1>IP local(servidor) es: "+ ip +"</h1>"
                    + "<br>"
                    + "<h1>Tu puerto es: "+ puerto +"</h1>" 
                    + "<br>"
                    + "<h1>Tu IP remota es: "+ ip2 +"</h1>");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
