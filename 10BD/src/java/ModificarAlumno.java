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

/**
 *
 * @author PC
 */
public class ModificarAlumno extends HttpServlet {

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
        String URL = "jdbc:mysql:3306//localhost/alumno";
        String userName = "root";
        String password = "n0m3l0";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            URL = "jdbc:mysql://localhost/alumno";
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
            String cambio = request.getParameter("modificador");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Modificar Alumno</title>");
            out.println("</head>");
            out.println("<body>");

            double bol;
            String nom, appat, apmat, tel;

            try {
                bol = Double.parseDouble(request.getParameter("modificar"));

                String q = "select * from alumnobatiz where boleta like " + bol;

                set = con.createStatement();
                rs = set.executeQuery(q);

                //set.executeUpdate(q);
                while (rs.next()) {
                    bol = rs.getInt("boleta");
                    nom = rs.getString("nombre");
                    appat = rs.getString("appat");
                    apmat = rs.getString("apmat");
                    tel = rs.getString("telefono");

                    try {
                        q = "delete from alumnobatiz where boleta =" + bol;
                        set.executeUpdate(q);
                        System.out.println("se elimino el registro");

                    } catch (Exception e) {
                        System.out.println("NO se elimino el registro");
                        System.out.println(e.getMessage());
                        System.out.println(e.getStackTrace());
                        out.println("<h1>No se pudo eliminar al alumno</h1>");
                    }
                    if ((request.getParameter("dato")).equals("nom")) {
                        try {
                            q = "insert into alumnobatiz "
                                    + "values (" + bol + ", '" + cambio + "', '" + appat + "', '" + apmat + "', '" + tel + "')";

                            set.executeUpdate(q);

                            System.out.println("Se registro un nuevo alumno");

                        } catch (Exception e) {

                            System.out.println("Error al registrar al alumno");
                            System.out.println(e.getMessage());
                            System.out.println(e.getStackTrace());
                        }
                        out.println("<h1>Los nuevos datos del alumno son</h1>");
                        out.println("<p>"
                                + "Boleta: " + bol + "<br>"
                                + "Nombre: " + cambio + " " + appat + " " + apmat + "<br>"
                                + "Telefono: " + tel + "<br>"
                                + "</p>");
                    } else {
                        if ((request.getParameter("dato")).equals("appat")) {
                            try {
                                q = "insert into alumnobatiz "
                                        + "values (" + bol + ", '" + nom + "', '" + cambio + "', '" + apmat + "', '" + tel + "')";

                                set.executeUpdate(q);

                                System.out.println("Se registro un nuevo alumno");

                            } catch (Exception e) {

                                System.out.println("Error al registrar al alumno");
                                System.out.println(e.getMessage());
                                System.out.println(e.getStackTrace());
                            }
                            out.println("<h1>Los nuevos datos del alumno son</h1>");
                            out.println("<p>"
                                    + "Boleta: " + bol + "<br>"
                                    + "Nombre: " + nom + " " + cambio + " " + apmat + "<br>"
                                    + "Telefono: " + tel + "<br>"
                                    + "</p>");
                        } else {
                            if ((request.getParameter("dato")).equals("apmat")) {
                                try {
                                    q = "insert into alumnobatiz "
                                            + "values (" + bol + ", '" + nom + "', '" + appat + "', '" + cambio + "', '" + tel + "')";

                                    set.executeUpdate(q);

                                    System.out.println("Se registro un nuevo alumno");

                                } catch (Exception e) {

                                    System.out.println("Error al registrar al alumno");
                                    System.out.println(e.getMessage());
                                    System.out.println(e.getStackTrace());
                                }
                                out.println("<h1>Los nuevos datos del alumno son</h1>");
                                out.println("<p>"
                                        + "Boleta: " + bol + "<br>"
                                        + "Nombre: " + nom + " " + appat + " " + cambio + "<br>"
                                        + "Telefono: " + tel + "<br>"
                                        + "</p>");
                            } else {
                                if ((request.getParameter("dato")).equals("bol")) {
                                    try {
                                        int id = Integer.parseInt(cambio);
                                        q = "insert into alumnobatiz "
                                                + "values (" + id + ", '" + nom + "', '" + appat + "', '" + apmat + "', '" + tel + "')";

                                        set.executeUpdate(q);

                                        System.out.println("Se registro un nuevo alumno");

                                    } catch (Exception e) {

                                        System.out.println("Error al registrar al alumno");
                                        System.out.println(e.getMessage());
                                        System.out.println(e.getStackTrace());
                                    }
                                    out.println("<h1>Los nuevos datos del alumno son</h1>");
                                    out.println("<p>"
                                            + "Boleta: " + cambio + "<br>"
                                            + "Nombre: " + nom + " " + appat + " " + apmat + "<br>"
                                            + "Telefono: " + tel + "<br>"
                                            + "</p>");
                                } else {
                                    try {
                                        q = "insert into alumnobatiz "
                                                + "values (" + bol + ", '" + nom + "', '" + appat + "', '" + apmat + "', '" + cambio + "')";

                                        set.executeUpdate(q);

                                        System.out.println("Se registro un nuevo alumno");

                                    } catch (Exception e) {

                                        System.out.println("Error al registrar al alumno");
                                        System.out.println(e.getMessage());
                                        System.out.println(e.getStackTrace());
                                    }
                                    out.println("<h1>Los nuevos datos del alumno son</h1>");
                                    out.println("<p>"
                                            + "Boleta: " + bol + "<br>"
                                            + "Nombre: " + nom + " " + appat + " " + apmat + "<br>"
                                            + "Telefono: " + cambio + "<br>"
                                            + "</p>");
                                }
                            }
                        }
                    }

                }

                /*rs.close();
                set.close();*/
                System.out.println("Se registro un nuevo alumno");

            } catch (Exception e) {
                System.out.println("Error al registrar al alumno");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
            }
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

    public void destroy() {
        try {

            con.close();

        } catch (Exception e) {

            super.destroy();

        }
    }
}
