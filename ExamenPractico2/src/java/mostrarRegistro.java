/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 *
 * @author PC
 */
public class mostrarRegistro extends HttpServlet {

    private Connection con;
    private Statement set;
    private ResultSet rs;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void init(ServletConfig cfg) throws ServletException {

        String userName = "root";
        String password = "n0m3l0";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String URL = "jdbc:mysql://localhost/registroa";
            con = DriverManager.getConnection(URL, userName, password);
            set = con.createStatement();

            System.out.println("Se conecto con la BD");
        } catch (Exception e) {
            System.out.println("No se conecto");
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
            out.println("<title>Registro" + request.getParameter("boleta") + "</title>");
            out.println("</head>");
            out.println("<body>");

            int bol = Integer.parseInt(request.getParameter("boleta"));

            try {
                bol = Integer.parseInt(request.getParameter("boleta"));
                int boleta;
                String nombre, apellidopaterno, apellidomaterno, img, grupo, turno;

                String q = "select * from alumno";

                set = con.createStatement();
                rs = set.executeQuery(q);

                boleta = rs.getInt("bol_al");
                nombre = rs.getString("nom_al");
                apellidopaterno = rs.getString("appat_al");
                apellidomaterno = rs.getString("apmat_al");
                grupo = rs.getString("grupo_al");
                turno = rs.getString("turno_al");
                img = rs.getString("img_al");

                out.println("<div id='datos'>"
                        + "<h1>Hola: " + nombre + "</h1>"
                        + "<br>"
                        + "<p>Nombre del alumno: " + nombre + " " + apellidopaterno + " " + apellidomaterno
                        + "<br>"
                        + "Boleta: " + boleta
                        + "<br>"
                        + "Grupo: " + grupo
                        + "<br>"
                        + "Turno: " + turno + "/<p>"
                        + "</div>");

                out.println("<div id='imagen'>"
                        + "<img id='fotoa' src='imagen/" + img + "'>"
                        + "</div>");
                rs.close();
                set.close();
            } catch (Exception e) {
                out.println("<h1>Error de consulta</hi>");
                System.out.println("Error al conectar a la tabla");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());

            }

            /*try {
                int boleta;
                int id_data, id_lab, nom_lab, id_uni, turno;
                String nom_uni, mac, des;
                Date fecha_rep;

                //establecer la querry
                String q = "select * from data where bol_al= " + bol;

                set = con.createStatement();
                rs = set.executeQuery(q);
                while (rs.next()) {
                    id_data = rs.getInt("id_data");
                    id_lab = rs.getInt("id_lab");

                    String w = "select * from laboratorio where id_lab= " + id_lab;
                    set = con.createStatement();
                    rs = set.executeQuery(w);
                    
                    nom_lab = rs.getInt("nom_lab");
                    id_uni = rs.getInt("id_uni");
                    
                    String x = "select * from unidad where id_uni= " + id_uni;
                    set = con.createStatement();
                    rs = set.executeQuery(x);
                    nom_uni = rs.getString("nom_uni");
                    
                    String y = "select * from reporte where id_data= " + id_data;
                    set = con.createStatement();
                    rs = set.executeQuery(y);
                    fecha_rep = rs.getDate("fecha_rep");
                    mac = rs.getString("mac_rep");
                    des = rs.getString("des_rep");

                    out.println("<div class='reporte'>"
                            + "<br>"
                            + "<p> Reporte de maquinas"
                            + "<br>"
                            + "Fecha del reporte: " + fecha_rep
                            + "<br>"
                            + "Laboratorio: " + nom_lab
                            + "<br>"
                            + "Materia: "+nom_uni+""
                            + "<br>"
                            + "Maquina: " + mac
                            + "<br>"
                            + "Descripción del problema: " + des
                            + "<br>"
                            + "</p>"
                            + "</div>");

                }

                rs.close();
                set.close();

            } catch (Exception e) {
                out.println("<h1>Error de consulta</hi>");
                System.out.println("Error al conectar a la tabla");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());

            }*/
            
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

    public void destroy() {
        try {
            con.close();
        } catch (Exception e) {
            super.destroy();
        }
    }

}
