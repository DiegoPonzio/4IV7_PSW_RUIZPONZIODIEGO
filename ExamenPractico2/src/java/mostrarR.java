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
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
public class mostrarR extends HttpServlet {

    private Connection con;
    private Statement set;
    private ResultSet rs;
    private ResultSet rt;
    private ResultSet rq;
    private ResultSet rp;
    private ResultSet ry;

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

        String URL = "jdbc:mysql:3306//localhost/registroa";

        String userName = "root";
        String password = "n0m3l0";

        try {

            Class.forName("com.mysql.jdbc.Driver");

            URL = "jdbc:mysql://localhost/registroa";

            con = DriverManager.getConnection(URL, userName, password);
            set = con.createStatement();

            System.out.println("Se conecto a la BD *w* ");
        } catch (Exception e) {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Alumno: " + request.getParameter("boleta") + "</title>");
            out.println("<link rel='stylesheet' href='media/style3.css'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Tabla del Alumno</h1>"
                    + "<table border=1 align= 'center'>"
                    + "<tr>"
                    + "<th>Boleta</th>"
                    + "<th>Nombre del Alumno</th>"
                    + "<th>Grupo</th>"
                    + "<th>Turno</th>"
                    + "<td>Foto</td>"
                    + "</tr>");
            try {
                int boleta;
                String nombre, apellidopaterno, apellidomaterno, grupo, turno, img;
                int bol = Integer.parseInt(request.getParameter("boleta"));

                //establecer la querry
                String q = "select * from alumno where bol_al=" + bol;

                set = con.createStatement();
                rs = set.executeQuery(q);

                while (rs.next()) {
                    boleta = rs.getInt("bol_al");
                    nombre = rs.getString("nom_al");
                    apellidopaterno = rs.getString("appat_al");
                    apellidomaterno = rs.getString("apmat_al");
                    grupo = rs.getString("grupo_al");
                    turno = rs.getString("turno_al");
                    img = rs.getString("img_al");

                    out.println("<tr>"
                            + "<td>" + boleta + "</td>"
                            + "<td>" + nombre + " " + apellidopaterno + " "
                            + apellidomaterno + "</td>"
                            + "<td>" + grupo + "</td>"
                            + "<td>" + turno + "</td>"
                            + "<td><img src='imagen/" + img + "'  height='100' width='70'></td>"
                            + "</tr>");
                }

                //hay que cerrar conexiones
                rs.close();
                set.close();

            } catch (Exception e) {
                System.out.println("Error al conectar a la tabla");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());

            }

            out.println("</table>");
            out.println("<h1>Datos</h1>"
                    + "<table border='1' align= 'center'>"
                    + "<tr>"
                    + "<th>Fecha</th>"
                    + "<th>Materia</th>"
                    + "<th>Laboratorio</th>"
                    + "<th>Maquina</th>"
                    + "<th>Descripción</th>"
                    + "</tr>");
            try {
                int boleta = 0;
                ArrayList<Integer> id_data = new ArrayList();
                ArrayList<Integer> id_lab = new ArrayList();
                ArrayList<Integer> id_uni = new ArrayList();
                ArrayList<String> materia = new ArrayList();
                ArrayList<String> nom_lab = new ArrayList();
                ArrayList<String> des = new ArrayList();
                ArrayList<String> maquina = new ArrayList();
                ArrayList<Date> fecha = new ArrayList();

                int bol = Integer.parseInt(request.getParameter("boleta"));

                //establecer la querry
                String q = "select * from data where bol_al=" + bol;

                set = con.createStatement();
                ry = set.executeQuery(q);

                while (ry.next()) {
                    id_data.add(ry.getInt("id_data"));
                    boleta = ry.getInt("bol_al");
                    id_lab.add(ry.getInt("id_lab"));

                    /*out.println("<tr>"
                            + "<td>" + boleta + "</td>"
                            + "<td>" + id_data + "</td>"
                            + "<td>" + nom_lab + "</td>"
                            + "<td>" + id_uni + "</td>"
                            + "<td>holi</td>"
                            + "</tr>");*/
                }
                for (int i : id_lab) {
                    String w = "select * from laboratorio where id_lab=" + i;
                    set = con.createStatement();
                    rt = set.executeQuery(w);
                    while (rt.next()) {
                        nom_lab.add(rt.getString("nom_lab"));
                        id_uni.add(rt.getInt("id_uni"));

                        /*out.println("<tr>"
                            + "<td>"+boleta+"</td>"
                            + "<td>"+id_data+"</td>"
                            + "<td>" + nom_lab + "</td>"
                            + "<td>" + id_uni + "</td>"
                            + "<td>holi</td>"
                            + "</tr>");*/
                    }
                }
                for (int i : id_uni) {
                    String y = "select * from unidad where id_uni=" + i;
                    set = con.createStatement();
                    rp = set.executeQuery(y);
                    while (rp.next()) {
                        materia.add(rp.getString("nom_uni"));
                        /*out.println("<tr>"
                            + "<td>"+boleta+"</td>"
                            + "<td>"+materia+"</td>"
                            + "<td>" + nom_lab + "</td>"
                            + "<td>" + id_uni + "</td>"
                            + "<td>holi</td>"
                            + "</tr>");*/
                    }
                }
                int k = 0;
                for (int i : id_data) {
                    String t = "select * from reporte where id_data=" + i;
                    set = con.createStatement();
                    rq = set.executeQuery(t);
                    while (rq.next()) {
                        fecha.add(rq.getDate("fecha_rep"));
                        maquina.add(rq.getString("mac_rep"));
                        des.add(rq.getString("des_rep"));
                        out.println("<tr>"
                                + "<td>" + fecha.get(k) + "</td>"
                                + "<td>" + materia.get(k) + "</td>"
                                + "<td>" + nom_lab.get(k) + "</td>"
                                + "<td>" + maquina.get(k) + "</td>"
                                + "<td>" + des.get(k) + "</td>"
                                + "</tr>");
                    }
                    k++;
                }
                /*for (Date i : fecha){
                    out.println("<tr>"
                                + "<td>" + fecha + "</td>");
                    for (String j : materia){
                        out.println()
                    }
                }*/

                //hay que cerrar conexiones
                rs.close();
                rp.close();
                rq.close();
                ry.close();
                rt.close();
                set.close();

            } catch (Exception e) {
                System.out.println("Error al conectar a la tabla");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());

            }
            out.println("</table>");
            out.println("<br>"
                    + "        <br>"
                    + "        <br>"
                    + "        <br>"
                    + "        <br>"
                    + "        <footer id='footer'>"
                    + "            <h1>Centro de Estudios Cientificos y Tecnologicos No. 9 'Juan de dios batiz'</h1>"
                    + "            <br>"
                    + "            <ul class='icons'>"
                    + "                <li>Nombre: Ruiz Ponzio Diego</li>"
                    + "                <li>Materia: Programación y servicios web</li>"
                    + "                <li>Tema: Examen Practico 2</li>"
                    + "                <li>Fecha de entrega: 18/04/2022</li>"
                    + "                <li><a href='index.html'>Regresar a Principal</a></li>"
                    + "            </ul>"
                    + "        </footer>");
            out.println("</body>");
            out.println("</html>");
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

    public void destroy() {
        try {
            con.close();
        } catch (Exception e) {
            super.destroy();
        }
    }

}
