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
public class verRegistro extends HttpServlet {

    private Connection con;
    private Statement set;
    private Statement set1;
    private Statement set2;
    private Statement set3;
    private ResultSet rs;
    private ResultSet rt;

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registro de Datos</title>");
            out.println("</head>");
            out.println("<body>");
            try {
                int bol;
                String nom, appat, apmat, img, grupo;
                String turno = "";

                nom = request.getParameter("nombre");
                appat = request.getParameter("appat");
                apmat = request.getParameter("apmat");
                bol = Integer.parseInt(request.getParameter("boleta"));
                img = request.getParameter("foto");
                grupo = request.getParameter("grupo");
                if (grupo.equals("3IM7") || grupo.equals("3IM8") || grupo.equals("3IM9") || grupo.equals("3IM10") || grupo.equals("4IM7") || grupo.equals("4IM8") || grupo.equals("4IM9") || grupo.equals("4IM10") || grupo.equals("5IM7") || grupo.equals("5IM8") || grupo.equals("5IM9") || grupo.equals("5IM10") || grupo.equals("6IM7") || grupo.equals("6IM8") || grupo.equals("6IM9") || grupo.equals("6IM10")) {
                    turno = "matutino";
                } else {
                    turno = "vespertino";
                }

                String q = "insert into alumno "
                        + "values (" + bol + ", '" + nom + "', '" + appat + "', '" + apmat + "', '" + img + "', '" + grupo + "','" + turno + "')";

                set.executeUpdate(q);
                out.println("<h1>Registro Exitoso</h1>");
                System.out.println("Se registro un nuevo alumno");
                //set.close();

            } catch (Exception e) {
                out.println("<h1>Registro NO Exitoso</h1>");
                System.out.println("Error al registrar al alumno");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
            }
            try {
                int bol, mes, dia;
                String grupo;
                int bandera = 1;

                bol = Integer.parseInt(request.getParameter("boleta"));

                grupo = request.getParameter("grupo");
                mes = Integer.parseInt(request.getParameter("mes"));
                dia = Integer.parseInt(request.getParameter("dia"));

                String data1, data2, data3, data4, data5, data6, data7, data8, data9, data10, data11, data12, data13, data14, data15, data16;
                String datad1, datad2, datad3, datad4, datad5, datad6, datad7, datad8, datad9, datad10, datad11, datad12, datad13, datad14, datad15, datad16;

                data1 = request.getParameter("bdm1");
                data2 = request.getParameter("bdm2");
                data3 = request.getParameter("bdm3");
                data4 = request.getParameter("bdm4");
                data5 = request.getParameter("pswm1");
                data6 = request.getParameter("pswm2");
                data7 = request.getParameter("pswm3");
                data8 = request.getParameter("pswm4");
                data9 = request.getParameter("tpm1");
                data10 = request.getParameter("tpm2");
                data11 = request.getParameter("tpm3");
                data12 = request.getParameter("tpm4");

                datad1 = request.getParameter("bdd1");
                datad2 = request.getParameter("bdd2");
                datad3 = request.getParameter("bdd3");
                datad4 = request.getParameter("bdd4");
                datad5 = request.getParameter("pswd1");
                datad6 = request.getParameter("pswd2");
                datad7 = request.getParameter("pswd3");
                datad8 = request.getParameter("pswd4");
                datad9 = request.getParameter("tpd1");
                datad10 = request.getParameter("tpd2");
                datad11 = request.getParameter("tpd3");
                datad12 = request.getParameter("tpd4");

                int id_data = 0;

                if (grupo.equals("3IM7") || grupo.equals("3IM8") || grupo.equals("3IM9") || grupo.equals("3IM10") || grupo.equals("3IV7") || grupo.equals("3IV8") || grupo.equals("3IV9") || grupo.equals("3IV10")) {
                    while (bandera <= 12) {
                        if (!data1.equals("") && !datad1.equals("")) {
                            String q = "insert into data(id_lab, bol_al) "
                                    + "values (51," + bol + ")";
                            set.executeUpdate(q);

                            set2 = con.createStatement();
                            String w = "select * from data where bol_al =" + bol + " and id_lab =51";

                            rt = set2.executeQuery(w);
                            while (rt.next()) {
                                id_data = rt.getInt("id_data");
                            }

                            String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                    + "values ('22-" + mes + "-" + dia + "', '" + data1 + "', '" + datad1 + "'," + id_data + ")";

                            set.executeUpdate(x);

                            data1 = "";
                        } else {
                            if (!data2.equals("") && !datad2.equals("")) {
                                String q = "insert into data(id_lab, bol_al) "
                                        + "values (36," + bol + ")";
                                set.executeUpdate(q);

                                set2 = con.createStatement();
                                String w = "select * from data where bol_al =" + bol + " and id_lab =36";

                                rs = set2.executeQuery(w);
                                while (rs.next()) {
                                    id_data = rs.getInt("id_data");
                                }

                                String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                        + "values ('22-" + mes + "-" + dia + "', '" + data2 + "', '" + datad2 + "'," + id_data + ")";

                                set.executeUpdate(x);

                                data2 = "";
                            } else {
                                if (!data3.equals("") && !datad3.equals("")) {
                                    String q = "insert into data(id_lab, bol_al) "
                                            + "values (21," + bol + ")";
                                    set.executeUpdate(q);

                                    set2 = con.createStatement();
                                    String w = "select * from data where bol_al =" + bol + " and id_lab =21";

                                    rs = set2.executeQuery(w);
                                    while (rs.next()) {
                                        id_data = rs.getInt("id_data");
                                    }
                                    String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                            + "values ('22-" + mes + "-" + dia + "', '" + data3 + "', '" + datad3 + "'," + id_data + ")";

                                    set.executeUpdate(x);

                                    data3 = "";
                                } else {
                                    if (!data4.equals("") && !datad4.equals("")) {
                                        String q = "insert into data(id_lab, bol_al) "
                                                + "values (6," + bol + ")";
                                        set.executeUpdate(q);

                                        set2 = con.createStatement();
                                        String w = "select * from data where bol_al =" + bol + " and id_lab =6";

                                        rs = set2.executeQuery(w);
                                        while (rs.next()) {
                                            id_data = rs.getInt("id_data");
                                        }
                                        String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                + "'values (22-" + mes + "-" + dia + "', '" + data4 + "', '" + datad4 + "'," + id_data + ")";

                                        set.executeUpdate(x);

                                        data4 = "";
                                    } else {
                                        if (!data5.equals("") && !datad5.equals("")) {
                                            String q = "insert into data(id_lab, bol_al) "
                                                    + "values (53," + bol + ")";
                                            set.executeUpdate(q);

                                            set2 = con.createStatement();
                                            String w = "select * from data where bol_al =" + bol + " and id_lab =53";

                                            rs = set2.executeQuery(w);
                                            while (rs.next()) {
                                                id_data = rs.getInt("id_data");
                                            }
                                            String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                    + "values ('22-" + mes + "-" + dia + "', '" + data5 + "', '" + datad5 + "'," + id_data + ")";

                                            set.executeUpdate(x);

                                            data5 = "";
                                        } else {
                                            if (!data6.equals("") && !datad6.equals("")) {
                                                String q = "insert into data(id_lab, bol_al) "
                                                        + "values (38," + bol + ")";
                                                set.executeUpdate(q);

                                                set2 = con.createStatement();
                                                String w = "select * from data where bol_al =" + bol + " and id_lab =38";

                                                rs = set2.executeQuery(w);
                                                while (rs.next()) {
                                                    id_data = rs.getInt("id_data");
                                                }
                                                String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                        + "values ('22-" + mes + "-" + dia + "', '" + data6 + "', '" + datad6 + "'," + id_data + ")";

                                                set.executeUpdate(x);

                                                data6 = "";
                                            } else {
                                                if (!data7.equals("") && !datad7.equals("")) {
                                                    String q = "insert into data(id_lab, bol_al) "
                                                            + "values (23," + bol + ")";
                                                    set.executeUpdate(q);

                                                    set2 = con.createStatement();
                                                    String w = "select * from data where bol_al =" + bol + " and id_lab =23";

                                                    rs = set2.executeQuery(w);
                                                    while (rs.next()) {
                                                        id_data = rs.getInt("id_data");
                                                    }
                                                    String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                            + "values ('22-" + mes + "-" + dia + "', '" + data7 + "', '" + datad7 + "'," + id_data + ")";

                                                    set.executeUpdate(x);

                                                    data7 = "";
                                                } else {
                                                    if (!data8.equals("") && !datad8.equals("")) {
                                                        String q = "insert into data(id_lab, bol_al) "
                                                                + "values (8," + bol + ")";
                                                        set.executeUpdate(q);

                                                        set2 = con.createStatement();
                                                        String w = "select * from data where bol_al =" + bol + " and id_lab =8";

                                                        rs = set2.executeQuery(w);
                                                        while (rs.next()) {
                                                            id_data = rs.getInt("id_data");
                                                        }
                                                        String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                                + "values ('22-" + mes + "-" + dia + "', '" + data8 + "', '" + datad8 + "'," + id_data + ")";

                                                        set.executeUpdate(x);

                                                        data8 = "";
                                                    } else {
                                                        if (!data9.equals("") && !datad9.equals("")) {
                                                            String q = "insert into data(id_lab, bol_al) "
                                                                    + "values (52," + bol + ")";
                                                            set.executeUpdate(q);

                                                            set2 = con.createStatement();
                                                            String w = "select * from data where bol_al =" + bol + " and id_lab =52";

                                                            rs = set2.executeQuery(w);
                                                            while (rs.next()) {
                                                                id_data = rs.getInt("id_data");
                                                            }
                                                            String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                                    + "'values (22-" + mes + "-" + dia + "', '" + data9 + "', '" + datad9 + "'," + id_data + ")";

                                                            set.executeUpdate(x);

                                                            data9 = "";
                                                        } else {
                                                            if (!data10.equals("") && !datad10.equals("")) {
                                                                String q = "insert into data(id_lab, bol_al) "
                                                                        + "values (37," + bol + ")";
                                                                set.executeUpdate(q);

                                                                set2 = con.createStatement();
                                                                String w = "select * from data where bol_al =" + bol + " and id_lab =37";

                                                                rs = set2.executeQuery(w);
                                                                while (rs.next()) {
                                                                    id_data = rs.getInt("id_data");
                                                                }
                                                                String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                                        + "values ('22-" + mes + "-" + dia + "', '" + data10 + "', '" + datad10 + "'," + id_data + ")";

                                                                set.executeUpdate(x);

                                                                data10 = "";
                                                            } else {
                                                                if (!data11.equals("") && !datad11.equals("")) {
                                                                    String q = "insert into data(id_lab, bol_al) "
                                                                            + "values (22," + bol + ")";
                                                                    set.executeUpdate(q);

                                                                    set2 = con.createStatement();
                                                                    String w = "select * from data where bol_al =" + bol + " and id_lab =22";

                                                                    rs = set2.executeQuery(w);
                                                                    while (rs.next()) {
                                                                        id_data = rs.getInt("id_data");
                                                                    }
                                                                    String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                                            + "values ('22-" + mes + "-" + dia + "', '" + data11 + "', '" + datad11 + "'," + id_data + ")";

                                                                    set.executeUpdate(x);

                                                                    data11 = "";
                                                                } else {
                                                                    if (!data12.equals("") && !datad12.equals("")) {
                                                                        String q = "insert into data(id_lab, bol_al) "
                                                                                + "values (7," + bol + ")";
                                                                        set.executeUpdate(q);

                                                                        set2 = con.createStatement();
                                                                        String w = "select * from data where bol_al =" + bol + " and id_lab =7";
                                                                        while (rs.next()) {
                                                                            rs = set2.executeQuery(w);
                                                                        }
                                                                        id_data = rs.getInt("id_data");

                                                                        String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                                                + "'values (22-" + mes + "-" + dia + "', '" + data12 + "', '" + datad12 + "'," + id_data + ")";

                                                                        set.executeUpdate(x);

                                                                        data12 = "";
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        bandera++;
                    }

                } else {
                    if (grupo.equals("4IM7") || grupo.equals("4IM8") || grupo.equals("4IM9") || grupo.equals("4IM10") || grupo.equals("4IV7") || grupo.equals("4IV8") || grupo.equals("4IV9") || grupo.equals("4IV10")) {
                        bandera = 0;
                        data13 = request.getParameter("labm1");
                        data14 = request.getParameter("labm2");
                        data15 = request.getParameter("labm3");
                        data16 = request.getParameter("labm4");

                        datad13 = request.getParameter("labd1");
                        datad14 = request.getParameter("labd2");
                        datad15 = request.getParameter("labd3");
                        datad16 = request.getParameter("labd4");

                        while (bandera <= 16) {
                            if (!data1.equals("") && !datad1.equals("")) {
                                String q = "insert into data(id_lab, bol_al) "
                                        + "values (47," + bol + ")";
                                set.executeUpdate(q);

                                set2 = con.createStatement();
                                String w = "select * from data where bol_al =" + bol + " and id_lab =47";

                                rs = set2.executeQuery(w);
                                while (rs.next()) {
                                    id_data = rs.getInt("id_data");
                                }
                                String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                        + "values ('22-" + mes + "-" + dia + "', '" + data1 + "', '" + datad1 + "'," + id_data + ")";

                                set.executeUpdate(x);

                                data1 = "";
                            } else {
                                if (!data2.equals("") && !datad2.equals("")) {
                                    String q = "insert into data(id_lab, bol_al) "
                                            + "values (32," + bol + ")";
                                    set.executeUpdate(q);

                                    set2 = con.createStatement();
                                    String w = "select * from data where bol_al =" + bol + " and id_lab =32";

                                    rs = set2.executeQuery(w);
                                    while (rs.next()) {
                                        id_data = rs.getInt("id_data");
                                    }
                                    String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                            + "values ('22-" + mes + "-" + dia + "', '" + data2 + "', '" + datad2 + "'," + id_data + ")";

                                    set.executeUpdate(x);

                                    data2 = "";
                                } else {
                                    if (!data3.equals("") && !datad3.equals("")) {
                                        String q = "insert into data(id_lab, bol_al) "
                                                + "values (17," + bol + ")";
                                        set.executeUpdate(q);

                                        set2 = con.createStatement();
                                        String w = "select * from data where bol_al =" + bol + " and id_lab =17";

                                        rs = set2.executeQuery(w);
                                        while (rs.next()) {
                                            id_data = rs.getInt("id_data");
                                        }
                                        String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                + "values ('22-" + mes + "-" + dia + "', '" + data3 + "', '" + datad3 + "'," + id_data + ")";

                                        set.executeUpdate(x);

                                        data3 = "";
                                    } else {
                                        if (!data4.equals("") && !datad4.equals("")) {
                                            String q = "insert into data(id_lab, bol_al) "
                                                    + "values (2," + bol + ")";
                                            set.executeUpdate(q);

                                            set2 = con.createStatement();
                                            String w = "select * from data where bol_al =" + bol + " and id_lab =2";
                                            while (rs.next()) {
                                                rs = set2.executeQuery(w);
                                            }
                                            id_data = rs.getInt("id_data");

                                            String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                    + "values ('22-" + mes + "-" + dia + "', '" + data4 + "', '" + datad4 + "'," + id_data + ")";

                                            set.executeUpdate(x);

                                            data4 = "";
                                        } else {
                                            if (!data5.equals("") && !datad5.equals("")) {
                                                String q = "insert into data(id_lab, bol_al) "
                                                        + "values (48," + bol + ")";
                                                set.executeUpdate(q);

                                                set2 = con.createStatement();
                                                String w = "select * from data where bol_al =" + bol + " and id_lab =48";

                                                rs = set2.executeQuery(w);
                                                while (rs.next()) {
                                                    id_data = rs.getInt("id_data");
                                                }
                                                String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                        + "values ('22-" + mes + "-" + dia + "', '" + data5 + "', '" + datad5 + "'," + id_data + ")";

                                                set.executeUpdate(x);

                                                data5 = "";
                                            } else {
                                                if (!data6.equals("") && !datad6.equals("")) {
                                                    String q = "insert into data(id_lab, bol_al) "
                                                            + "values (33," + bol + ")";
                                                    set.executeUpdate(q);

                                                    set2 = con.createStatement();
                                                    String w = "select * from data where bol_al =" + bol + " and id_lab =33";

                                                    rs = set2.executeQuery(w);
                                                    while (rs.next()) {
                                                        id_data = rs.getInt("id_data");
                                                    }
                                                    String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                            + "values ('22-" + mes + "-" + dia + "', '" + data6 + "', '" + datad6 + "'," + id_data + ")";

                                                    set.executeUpdate(x);

                                                    data6 = "";
                                                } else {
                                                    if (!data7.equals("") && !datad7.equals("")) {
                                                        String q = "insert into data(id_lab, bol_al) "
                                                                + "values (18," + bol + ")";
                                                        set.executeUpdate(q);

                                                        set2 = con.createStatement();
                                                        String w = "select * from data where bol_al =" + bol + " and id_lab =18";

                                                        rs = set2.executeQuery(w);
                                                        while (rs.next()) {
                                                            id_data = rs.getInt("id_data");
                                                        }
                                                        String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                                + "values ('22-" + mes + "-" + dia + "', '" + data7 + "', '" + datad7 + "'," + id_data + ")";

                                                        set.executeUpdate(x);

                                                        data7 = "";
                                                    } else {
                                                        if (!data8.equals("") && !datad8.equals("")) {
                                                            String q = "insert into data(id_lab, bol_al) "
                                                                    + "values (3," + bol + ")";
                                                            set.executeUpdate(q);

                                                            set2 = con.createStatement();
                                                            String w = "select * from data where bol_al =" + bol + " and id_lab =3";

                                                            rs = set2.executeQuery(w);
                                                            while (rs.next()) {
                                                                id_data = rs.getInt("id_data");
                                                            }
                                                            String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                                    + "'values (22-" + mes + "-" + dia + "', '" + data8 + "', '" + datad8 + "'," + id_data + ")";

                                                            set.executeUpdate(x);

                                                            data8 = "";
                                                        } else {
                                                            if (!data9.equals("") && !datad9.equals("")) {
                                                                String q = "insert into data(id_lab, bol_al) "
                                                                        + "values (49," + bol + ")";
                                                                set.executeUpdate(q);

                                                                set2 = con.createStatement();
                                                                String w = "select * from data where bol_al =" + bol + " and id_lab =49";

                                                                rs = set2.executeQuery(w);
                                                                while (rs.next()) {
                                                                    id_data = rs.getInt("id_data");
                                                                }
                                                                String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                                        + "values ('22-" + mes + "-" + dia + "', '" + data9 + "', '" + datad9 + "'," + id_data + ")";

                                                                set.executeUpdate(x);

                                                                data9 = "";
                                                            } else {
                                                                if (!data10.equals("") && !datad10.equals("")) {
                                                                    String q = "insert into data(id_lab, bol_al) "
                                                                            + "values (34," + bol + ")";
                                                                    set.executeUpdate(q);

                                                                    set2 = con.createStatement();
                                                                    String w = "select * from data where bol_al =" + bol + " and id_lab =34";

                                                                    rs = set2.executeQuery(w);
                                                                    while (rs.next()) {
                                                                        id_data = rs.getInt("id_data");
                                                                    }
                                                                    String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                                            + "values ('22-" + mes + "-" + dia + "', '" + data10 + "', '" + datad10 + "'," + id_data + ")";

                                                                    set.executeUpdate(x);

                                                                    data10 = "";
                                                                } else {
                                                                    if (!data11.equals("") && !datad11.equals("")) {
                                                                        String q = "insert into data(id_lab, bol_al) "
                                                                                + "values (19," + bol + ")";
                                                                        set.executeUpdate(q);

                                                                        set2 = con.createStatement();
                                                                        String w = "select * from data where bol_al =" + bol + " and id_lab =19";

                                                                        rs = set2.executeQuery(w);
                                                                        while (rs.next()) {
                                                                            id_data = rs.getInt("id_data");
                                                                        }
                                                                        String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                                                + "values ('22-" + mes + "-" + dia + "', '" + data11 + "', '" + datad11 + "'," + id_data + ")";

                                                                        set.executeUpdate(x);

                                                                        data11 = "";
                                                                    } else {
                                                                        if (!data12.equals("") && !datad12.equals("")) {
                                                                            String q = "insert into data(id_lab, bol_al) "
                                                                                    + "values (4," + bol + ")";
                                                                            set.executeUpdate(q);

                                                                            set2 = con.createStatement();
                                                                            String w = "select * from data where bol_al =" + bol + " and id_lab =4";

                                                                            rs = set2.executeQuery(w);
                                                                            while (rs.next()) {
                                                                                id_data = rs.getInt("id_data");
                                                                            }
                                                                            String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                                                    + "values ('22-" + mes + "-" + dia + "', '" + data12 + "', '" + datad12 + "'," + id_data + ")";

                                                                            set.executeUpdate(x);

                                                                            data12 = "";
                                                                        } else {
                                                                            if (!data13.equals("") && !datad13.equals("")) {
                                                                                String q = "insert into data(id_lab, bol_al) "
                                                                                        + "values (50," + bol + ")";
                                                                                set.executeUpdate(q);

                                                                                set2 = con.createStatement();
                                                                                String w = "select * from data where bol_al =" + bol + " and id_lab =50";

                                                                                rs = set2.executeQuery(w);
                                                                                while (rs.next()) {
                                                                                    id_data = rs.getInt("id_data");
                                                                                }
                                                                                String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                                                        + "values ('22-" + mes + "-" + dia + "', '" + data13 + "', '" + datad13 + "'," + id_data + ")";

                                                                                set.executeUpdate(x);

                                                                                data13 = "";
                                                                            } else {
                                                                                if (!data14.equals("") && !datad14.equals("")) {
                                                                                    String q = "insert into data(id_lab, bol_al) "
                                                                                            + "values (35," + bol + ")";
                                                                                    set.executeUpdate(q);

                                                                                    set2 = con.createStatement();
                                                                                    String w = "select * from data where bol_al =" + bol + " and id_lab =35";

                                                                                    rs = set2.executeQuery(w);
                                                                                    while (rs.next()) {
                                                                                        id_data = rs.getInt("id_data");
                                                                                    }
                                                                                    String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                                                            + "values ('22-" + mes + "-" + dia + "', '" + data14 + "', '" + datad14 + "'," + id_data + ")";

                                                                                    set.executeUpdate(x);

                                                                                    data14 = "";
                                                                                } else {
                                                                                    if (!data15.equals("") && !datad15.equals("")) {
                                                                                        String q = "insert into data(id_lab, bol_al) "
                                                                                                + "values (20," + bol + ")";
                                                                                        set.executeUpdate(q);

                                                                                        set2 = con.createStatement();
                                                                                        String w = "select * from data where bol_al =" + bol + " and id_lab =20";

                                                                                        rs = set2.executeQuery(w);
                                                                                        while (rs.next()) {
                                                                                            id_data = rs.getInt("id_data");
                                                                                        }
                                                                                        String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                                                                + "values ('22-" + mes + "-" + dia + "', '" + data15 + "', '" + datad15 + "'," + id_data + ")";

                                                                                        set.executeUpdate(x);

                                                                                        data15 = "";
                                                                                    } else {
                                                                                        if (!data16.equals("") && !datad16.equals("")) {
                                                                                            String q = "insert into data(id_lab, bol_al) "
                                                                                                    + "values (1," + bol + ")";
                                                                                            set.executeUpdate(q);

                                                                                            set2 = con.createStatement();
                                                                                            String w = "select * from data where bol_al =" + bol + " and id_lab =1";

                                                                                            rs = set2.executeQuery(w);
                                                                                            while (rs.next()) {
                                                                                                id_data = rs.getInt("id_data");
                                                                                            }
                                                                                            String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                                                                    + "values ('22-" + mes + "-" + dia + "', '" + data16 + "', '" + datad16 + "'," + id_data + ")";

                                                                                            set.executeUpdate(x);

                                                                                            data16 = "";
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            bandera++;
                        }

                    } else {
                        if (grupo.equals("5IM7") || grupo.equals("5IM8") || grupo.equals("5IM9") || grupo.equals("5IM10") || grupo.equals("5IV7") || grupo.equals("5IV8") || grupo.equals("5IV9") || grupo.equals("5IV10")) {
                            bandera = 0;
                            data13 = request.getParameter("labm1");
                            data14 = request.getParameter("labm2");
                            data15 = request.getParameter("labm3");
                            data16 = request.getParameter("labm4");

                            datad13 = request.getParameter("labd1");
                            datad14 = request.getParameter("labd2");
                            datad15 = request.getParameter("labd3");
                            datad16 = request.getParameter("labd4");

                            while (bandera <= 16) {
                                if (!data1.equals("") && !datad1.equals("")) {
                                    String q = "insert into data(id_lab, bol_al) "
                                            + "values (54," + bol + ")";
                                    set.executeUpdate(q);

                                    set2 = con.createStatement();
                                    String w = "select * from data where bol_al =" + bol + " and id_lab =54";

                                    rs = set2.executeQuery(w);
                                    while (rs.next()) {
                                        id_data = rs.getInt("id_data");
                                    }
                                    String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                            + "values ('22-" + mes + "-" + dia + "', '" + data1 + "', '" + datad1 + "'," + id_data + ")";

                                    set.executeUpdate(x);

                                    data1 = "";
                                } else {
                                    if (!data2.equals("") && !datad2.equals("")) {
                                        String q = "insert into data(id_lab, bol_al) "
                                                + "values (39," + bol + ")";
                                        set.executeUpdate(q);

                                        set2 = con.createStatement();
                                        String w = "select * from data where bol_al =" + bol + " and id_lab =39";

                                        rs = set2.executeQuery(w);
                                        while (rs.next()) {
                                            id_data = rs.getInt("id_data");
                                        }
                                        String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                + "values ('22-" + mes + "-" + dia + "', '" + data2 + "', '" + datad2 + "'," + id_data + ")";

                                        set.executeUpdate(x);

                                        data2 = "";
                                    } else {
                                        if (!data3.equals("") && !datad3.equals("")) {
                                            String q = "insert into data(id_lab, bol_al) "
                                                    + "values (24," + bol + ")";
                                            set.executeUpdate(q);

                                            set2 = con.createStatement();
                                            String w = "select * from data where bol_al =" + bol + " and id_lab =24";
                                            while (rs.next()) {
                                                rs = set2.executeQuery(w);
                                            }
                                            id_data = rs.getInt("id_data");

                                            String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                    + "values ('22-" + mes + "-" + dia + "', '" + data3 + "', '" + datad3 + "'," + id_data + ")";

                                            set.executeUpdate(x);

                                            data3 = "";
                                        } else {
                                            if (!data4.equals("") && !datad4.equals("")) {
                                                String q = "insert into data(id_lab, bol_al) "
                                                        + "values (9," + bol + ")";
                                                set.executeUpdate(q);

                                                set2 = con.createStatement();
                                                String w = "select * from data where bol_al =" + bol + " and id_lab =9";

                                                rs = set2.executeQuery(w);
                                                while (rs.next()) {
                                                    id_data = rs.getInt("id_data");
                                                }
                                                String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                        + "values ('22-" + mes + "-" + dia + "', '" + data4 + "', '" + datad4 + "'," + id_data + ")";

                                                set.executeUpdate(x);

                                                data4 = "";
                                            } else {
                                                if (!data5.equals("") && !datad5.equals("")) {
                                                    String q = "insert into data(id_lab, bol_al) "
                                                            + "values (55," + bol + ")";
                                                    set.executeUpdate(q);

                                                    set2 = con.createStatement();
                                                    String w = "select * from data where bol_al =" + bol + " and id_lab =55";

                                                    rs = set2.executeQuery(w);
                                                    while (rs.next()) {
                                                        id_data = rs.getInt("id_data");
                                                    }
                                                    String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                            + "values ('22-" + mes + "-" + dia + "', '" + data5 + "', '" + datad5 + "'," + id_data + ")";

                                                    set.executeUpdate(x);

                                                    data5 = "";
                                                } else {
                                                    if (!data6.equals("") && !datad6.equals("")) {
                                                        String q = "insert into data(id_lab, bol_al) "
                                                                + "values (40," + bol + ")";
                                                        set.executeUpdate(q);

                                                        set2 = con.createStatement();
                                                        String w = "select * from data where bol_al =" + bol + " and id_lab =40";

                                                        rs = set2.executeQuery(w);
                                                        while (rs.next()) {
                                                            id_data = rs.getInt("id_data");
                                                        }
                                                        String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                                + "values ('22-" + mes + "-" + dia + "', '" + data6 + "', '" + datad6 + "'," + id_data + ")";

                                                        set.executeUpdate(x);

                                                        data6 = "";
                                                    } else {
                                                        if (!data7.equals("") && !datad7.equals("")) {
                                                            String q = "insert into data(id_lab, bol_al) "
                                                                    + "values (25," + bol + ")";
                                                            set.executeUpdate(q);

                                                            set2 = con.createStatement();
                                                            String w = "select * from data where bol_al =" + bol + " and id_lab =25";

                                                            rs = set2.executeQuery(w);
                                                            while (rs.next()) {
                                                                id_data = rs.getInt("id_data");
                                                            }
                                                            String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                                    + "values ('22-" + mes + "-" + dia + "', '" + data7 + "', '" + datad7 + "'," + id_data + ")";

                                                            set.executeUpdate(x);

                                                            data7 = "";
                                                        } else {
                                                            if (!data8.equals("") && !datad8.equals("")) {
                                                                String q = "insert into data(id_lab, bol_al) "
                                                                        + "values (10," + bol + ")";
                                                                set.executeUpdate(q);

                                                                set2 = con.createStatement();
                                                                String w = "select * from data where bol_al =" + bol + " and id_lab =10";

                                                                rs = set2.executeQuery(w);
                                                                while (rs.next()) {
                                                                    id_data = rs.getInt("id_data");
                                                                }
                                                                String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                                        + "values ('22-" + mes + "-" + dia + "', '" + data8 + "', '" + datad8 + "'," + id_data + ")";

                                                                set.executeUpdate(x);

                                                                data8 = "";
                                                            } else {
                                                                if (!data9.equals("") && !datad9.equals("")) {
                                                                    String q = "insert into data(id_lab, bol_al) "
                                                                            + "values (57," + bol + ")";
                                                                    set.executeUpdate(q);

                                                                    set2 = con.createStatement();
                                                                    String w = "select * from data where bol_al =" + bol + " and id_lab =57";

                                                                    rs = set2.executeQuery(w);
                                                                    while (rs.next()) {
                                                                        id_data = rs.getInt("id_data");
                                                                    }
                                                                    String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                                            + "values ('22-" + mes + "-" + dia + "', '" + data9 + "', '" + datad9 + "'," + id_data + ")";

                                                                    set.executeUpdate(x);

                                                                    data9 = "";
                                                                } else {
                                                                    if (!data10.equals("") && !datad10.equals("")) {
                                                                        String q = "insert into data(id_lab, bol_al) "
                                                                                + "values (42," + bol + ")";
                                                                        set.executeUpdate(q);

                                                                        set2 = con.createStatement();
                                                                        String w = "select * from data where bol_al =" + bol + " and id_lab =42";

                                                                        rs = set2.executeQuery(w);
                                                                        while (rs.next()) {
                                                                            id_data = rs.getInt("id_data");
                                                                        }
                                                                        String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                                                + "values ('22-" + mes + "-" + dia + "', '" + data10 + "', '" + datad10 + "'," + id_data + ")";

                                                                        set.executeUpdate(x);

                                                                        data10 = "";
                                                                    } else {
                                                                        if (!data11.equals("") && !datad11.equals("")) {
                                                                            String q = "insert into data(id_lab, bol_al) "
                                                                                    + "values (27," + bol + ")";
                                                                            set.executeUpdate(q);

                                                                            set2 = con.createStatement();
                                                                            String w = "select * from data where bol_al =" + bol + " and id_lab =27";

                                                                            rs = set2.executeQuery(w);
                                                                            while (rs.next()) {
                                                                                id_data = rs.getInt("id_data");
                                                                            }
                                                                            String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                                                    + "values ('22-" + mes + "-" + dia + "', '" + data11 + "', '" + datad11 + "'," + id_data + ")";

                                                                            set.executeUpdate(x);

                                                                            data11 = "";
                                                                        } else {
                                                                            if (!data12.equals("") && !datad12.equals("")) {
                                                                                String q = "insert into data(id_lab, bol_al) "
                                                                                        + "values (12," + bol + ")";
                                                                                set.executeUpdate(q);

                                                                                set2 = con.createStatement();
                                                                                String w = "select * from data where bol_al =" + bol + " and id_lab =12";

                                                                                rs = set2.executeQuery(w);
                                                                                while (rs.next()) {
                                                                                    id_data = rs.getInt("id_data");
                                                                                }
                                                                                String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                                                        + "values ('22-" + mes + "-" + dia + "', '" + data12 + "', '" + datad12 + "'," + id_data + ")";

                                                                                set.executeUpdate(x);

                                                                                data12 = "";
                                                                            } else {
                                                                                if (!data13.equals("") && !datad13.equals("")) {
                                                                                    String q = "insert into data(id_lab, bol_al) "
                                                                                            + "values (56," + bol + ")";
                                                                                    set.executeUpdate(q);

                                                                                    set2 = con.createStatement();
                                                                                    String w = "select * from data where bol_al =" + bol + " and id_lab =56";

                                                                                    rs = set2.executeQuery(w);
                                                                                    while (rs.next()) {
                                                                                        id_data = rs.getInt("id_data");
                                                                                    }
                                                                                    String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                                                            + "values ('22-" + mes + "-" + dia + "', '" + data13 + "', '" + datad13 + "'," + id_data + ")";

                                                                                    set.executeUpdate(x);

                                                                                    data13 = "";
                                                                                } else {
                                                                                    if (!data14.equals("") && !datad14.equals("")) {
                                                                                        String q = "insert into data(id_lab, bol_al) "
                                                                                                + "values (41," + bol + ")";
                                                                                        set.executeUpdate(q);

                                                                                        set2 = con.createStatement();
                                                                                        String w = "select * from data where bol_al =" + bol + " and id_lab =41";

                                                                                        rs = set2.executeQuery(w);
                                                                                        while (rs.next()) {
                                                                                            id_data = rs.getInt("id_data");
                                                                                        }
                                                                                        String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                                                                + "values ('22-" + mes + "-" + dia + "', '" + data14 + "', '" + datad14 + "'," + id_data + ")";

                                                                                        set.executeUpdate(x);

                                                                                        data14 = "";
                                                                                    } else {
                                                                                        if (!data15.equals("") && !datad15.equals("")) {
                                                                                            String q = "insert into data(id_lab, bol_al) "
                                                                                                    + "values (26," + bol + ")";
                                                                                            set.executeUpdate(q);

                                                                                            set2 = con.createStatement();
                                                                                            String w = "select * from data where bol_al =" + bol + " and id_lab =26";

                                                                                            rs = set2.executeQuery(w);
                                                                                            while (rs.next()) {
                                                                                                id_data = rs.getInt("id_data");
                                                                                            }
                                                                                            String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                                                                    + "values ('22-" + mes + "-" + dia + "', '" + data15 + "', '" + datad15 + "'," + id_data + ")";

                                                                                            set.executeUpdate(x);

                                                                                            data15 = "";
                                                                                        } else {
                                                                                            if (!data16.equals("") && !datad16.equals("")) {
                                                                                                String q = "insert into data(id_lab, bol_al) "
                                                                                                        + "values (11," + bol + ")";
                                                                                                set.executeUpdate(q);

                                                                                                set2 = con.createStatement();
                                                                                                String w = "select * from data where bol_al =" + bol + " and id_lab =11";

                                                                                                rs = set2.executeQuery(w);
                                                                                                while (rs.next()) {
                                                                                                    id_data = rs.getInt("id_data");
                                                                                                }
                                                                                                String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                                                                        + "values ('22-" + mes + "-" + dia + "', '" + data16 + "', '" + datad16 + "'," + id_data + ")";

                                                                                                set.executeUpdate(x);

                                                                                                data16 = "";
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                bandera++;
                            }
                        } else {
                            bandera = 0;
                            data13 = request.getParameter("labm1");
                            data14 = request.getParameter("labm2");
                            data15 = request.getParameter("labm3");
                            data16 = request.getParameter("labm4");

                            datad13 = request.getParameter("labd1");
                            datad14 = request.getParameter("labd2");
                            datad15 = request.getParameter("labd3");
                            datad16 = request.getParameter("labd4");
                            while (bandera <= 16) {
                                if (!data1.equals("") && !datad1.equals("")) {
                                    String q = "insert into data(id_lab, bol_al) "
                                            + "values (58," + bol + ")";
                                    set.executeUpdate(q);

                                    set2 = con.createStatement();
                                    String w = "select * from data where bol_al =" + bol + " and id_lab =58";

                                    rs = set2.executeQuery(w);
                                    while (rs.next()) {
                                        id_data = rs.getInt("id_data");
                                    }
                                    String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                            + "values ('22-" + mes + "-" + dia + "', '" + data1 + "', '" + datad1 + "'," + id_data + ")";

                                    set.executeUpdate(x);

                                    data1 = "";
                                } else {
                                    if (!data2.equals("") && !datad2.equals("")) {
                                        String q = "insert into data(id_lab, bol_al) "
                                                + "values (43," + bol + ")";
                                        set.executeUpdate(q);

                                        set2 = con.createStatement();
                                        String w = "select * from data where bol_al =" + bol + " and id_lab =43";

                                        rs = set2.executeQuery(w);
                                        while (rs.next()) {
                                            id_data = rs.getInt("id_data");
                                        }
                                        String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                + "values ('22-" + mes + "-" + dia + "', '" + data2 + "', '" + datad2 + "'," + id_data + ")";

                                        set.executeUpdate(x);

                                        data2 = "";
                                    } else {
                                        if (!data3.equals("") && !datad3.equals("")) {
                                            String q = "insert into data(id_lab, bol_al) "
                                                    + "values (28," + bol + ")";
                                            set.executeUpdate(q);

                                            set2 = con.createStatement();
                                            String w = "select * from data where bol_al =" + bol + " and id_lab =28";

                                            rs = set2.executeQuery(w);
                                            while (rs.next()) {
                                                id_data = rs.getInt("id_data");
                                            }
                                            String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                    + "values ('22-" + mes + "-" + dia + "', '" + data3 + "', '" + datad3 + "'," + id_data + ")";

                                            set.executeUpdate(x);

                                            data3 = "";
                                        } else {
                                            if (!data4.equals("") && !datad4.equals("")) {
                                                String q = "insert into data(id_lab, bol_al) "
                                                        + "values (13," + bol + ")";
                                                set.executeUpdate(q);

                                                set2 = con.createStatement();
                                                String w = "select * from data where bol_al =" + bol + " and id_lab =13";

                                                rs = set2.executeQuery(w);
                                                while (rs.next()) {
                                                    id_data = rs.getInt("id_data");
                                                }
                                                String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                        + "values ('22-" + mes + "-" + dia + "', '" + data4 + "', '" + datad4 + "'," + id_data + ")";

                                                set.executeUpdate(x);

                                                data4 = "";
                                            } else {
                                                if (!data5.equals("") && !datad5.equals("")) {
                                                    String q = "insert into data(id_lab, bol_al) "
                                                            + "values (60," + bol + ")";
                                                    set.executeUpdate(q);

                                                    set2 = con.createStatement();
                                                    String w = "select * from data where bol_al =" + bol + " and id_lab =60";

                                                    rs = set2.executeQuery(w);
                                                    while (rs.next()) {
                                                        id_data = rs.getInt("id_data");
                                                    }
                                                    String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                            + "values ('22-" + mes + "-" + dia + "', '" + data5 + "', '" + datad5 + "'," + id_data + ")";

                                                    set.executeUpdate(x);

                                                    data5 = "";
                                                } else {
                                                    if (!data6.equals("") && !datad6.equals("")) {
                                                        String q = "insert into data(id_lab, bol_al) "
                                                                + "values (45," + bol + ")";
                                                        set.executeUpdate(q);

                                                        set2 = con.createStatement();
                                                        String w = "select * from data where bol_al =" + bol + " and id_lab =45";

                                                        rs = set2.executeQuery(w);
                                                        while (rs.next()) {
                                                            id_data = rs.getInt("id_data");
                                                        }
                                                        String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                                + "values ('22-" + mes + "-" + dia + "', '" + data6 + "', '" + datad6 + "'," + id_data + ")";

                                                        set.executeUpdate(x);

                                                        data6 = "";
                                                    } else {
                                                        if (!data7.equals("") && !datad7.equals("")) {
                                                            String q = "insert into data(id_lab, bol_al) "
                                                                    + "values (30," + bol + ")";
                                                            set.executeUpdate(q);

                                                            set2 = con.createStatement();
                                                            String w = "select * from data where bol_al =" + bol + " and id_lab =30";

                                                            rs = set2.executeQuery(w);
                                                            while (rs.next()) {
                                                                id_data = rs.getInt("id_data");
                                                            }
                                                            String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                                    + "values ('22-" + mes + "-" + dia + "', '" + data7 + "', '" + datad7 + "'," + id_data + ")";

                                                            set.executeUpdate(x);

                                                            data7 = "";
                                                        } else {
                                                            if (!data8.equals("") && !datad8.equals("")) {
                                                                String q = "insert into data(id_lab, bol_al) "
                                                                        + "values (15," + bol + ")";
                                                                set.executeUpdate(q);

                                                                set2 = con.createStatement();
                                                                String w = "select * from data where bol_al =" + bol + " and id_lab =15";

                                                                rs = set2.executeQuery(w);
                                                                while (rs.next()) {
                                                                    id_data = rs.getInt("id_data");
                                                                }
                                                                String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                                        + "values ('22-" + mes + "-" + dia + "', '" + data8 + "', '" + datad8 + "'," + id_data + ")";

                                                                set.executeUpdate(x);

                                                                data8 = "";
                                                            } else {
                                                                if (!data9.equals("") && !datad9.equals("")) {
                                                                    String q = "insert into data(id_lab, bol_al) "
                                                                            + "values (61," + bol + ")";
                                                                    set.executeUpdate(q);

                                                                    set2 = con.createStatement();
                                                                    String w = "select * from data where bol_al =" + bol + " and id_lab =61";

                                                                    rs = set2.executeQuery(w);
                                                                    while (rs.next()) {
                                                                        id_data = rs.getInt("id_data");
                                                                    }
                                                                    String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                                            + "values ('22-" + mes + "-" + dia + "', '" + data9 + "', '" + datad9 + "'," + id_data + ")";

                                                                    set.executeUpdate(x);

                                                                    data9 = "";
                                                                } else {
                                                                    if (!data10.equals("") && !datad10.equals("")) {
                                                                        String q = "insert into data(id_lab, bol_al) "
                                                                                + "values (46," + bol + ")";
                                                                        set.executeUpdate(q);

                                                                        set2 = con.createStatement();
                                                                        String w = "select * from data where bol_al =" + bol + " and id_lab =46";

                                                                        rs = set2.executeQuery(w);
                                                                        while (rs.next()) {
                                                                            id_data = rs.getInt("id_data");
                                                                        }
                                                                        String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                                                + "values ('22-" + mes + "-" + dia + "', '" + data10 + "', '" + datad10 + "'," + id_data + ")";

                                                                        set.executeUpdate(x);

                                                                        data10 = "";
                                                                    } else {
                                                                        if (!data11.equals("") && !datad11.equals("")) {
                                                                            String q = "insert into data(id_lab, bol_al) "
                                                                                    + "values (31," + bol + ")";
                                                                            set.executeUpdate(q);

                                                                            set2 = con.createStatement();
                                                                            String w = "select * from data where bol_al =" + bol + " and id_lab =31";

                                                                            rs = set2.executeQuery(w);
                                                                            while (rs.next()) {
                                                                                id_data = rs.getInt("id_data");
                                                                            }
                                                                            String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                                                    + "values ('22-" + mes + "-" + dia + "', '" + data11 + "', '" + datad11 + "'," + id_data + ")";

                                                                            set.executeUpdate(x);

                                                                            data11 = "";
                                                                        } else {
                                                                            if (!data12.equals("") && !datad12.equals("")) {
                                                                                String q = "insert into data(id_lab, bol_al) "
                                                                                        + "values (16," + bol + ")";
                                                                                set.executeUpdate(q);

                                                                                set2 = con.createStatement();
                                                                                String w = "select * from data where bol_al =" + bol + " and id_lab =16";

                                                                                rs = set2.executeQuery(w);
                                                                                while (rs.next()) {
                                                                                    id_data = rs.getInt("id_data");
                                                                                }
                                                                                String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                                                        + "values ('22-" + mes + "-" + dia + "', '" + data12 + "', '" + datad12 + "'," + id_data + ")";

                                                                                set.executeUpdate(x);

                                                                                data12 = "";
                                                                            } else {
                                                                                if (!data13.equals("") && !datad13.equals("")) {
                                                                                    String q = "insert into data(id_lab, bol_al) "
                                                                                            + "values (59," + bol + ")";
                                                                                    set.executeUpdate(q);

                                                                                    set2 = con.createStatement();
                                                                                    String w = "select * from data where bol_al =" + bol + " and id_lab =59";

                                                                                    rs = set2.executeQuery(w);
                                                                                    while (rs.next()) {
                                                                                        id_data = rs.getInt("id_data");
                                                                                    }
                                                                                    String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                                                            + "values ('22-" + mes + "-" + dia + "', '" + data13 + "', '" + datad13 + "'," + id_data + ")";

                                                                                    set.executeUpdate(x);

                                                                                    data13 = "";
                                                                                } else {
                                                                                    if (!data14.equals("") && !datad14.equals("")) {
                                                                                        String q = "insert into data(id_lab, bol_al) "
                                                                                                + "values (44," + bol + ")";
                                                                                        set.executeUpdate(q);

                                                                                        set2 = con.createStatement();
                                                                                        String w = "select * from data where bol_al =" + bol + " and id_lab =44";

                                                                                        rs = set2.executeQuery(w);
                                                                                        while (rs.next()) {
                                                                                            id_data = rs.getInt("id_data");
                                                                                        }
                                                                                        String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                                                                + "values ('22-" + mes + "-" + dia + "', '" + data14 + "', '" + datad14 + "'," + id_data + ")";

                                                                                        set.executeUpdate(x);

                                                                                        data14 = "";
                                                                                    } else {
                                                                                        if (!data15.equals("") && !datad15.equals("")) {
                                                                                            String q = "insert into data(id_lab, bol_al) "
                                                                                                    + "values (29," + bol + ")";
                                                                                            set.executeUpdate(q);

                                                                                            set2 = con.createStatement();
                                                                                            String w = "select * from data where bol_al =" + bol + " and id_lab =29";

                                                                                            rs = set2.executeQuery(w);
                                                                                            while (rs.next()) {
                                                                                                id_data = rs.getInt("id_data");
                                                                                            }
                                                                                            String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                                                                    + "values ('22-" + mes + "-" + dia + "', '" + data15 + "', '" + datad15 + "'," + id_data + ")";

                                                                                            set.executeUpdate(x);

                                                                                            data15 = "";
                                                                                        } else {
                                                                                            if (!data16.equals("") && !datad16.equals("")) {
                                                                                                String q = "insert into data(id_lab, bol_al) "
                                                                                                        + "values (14," + bol + ")";
                                                                                                set.executeUpdate(q);

                                                                                                set2 = con.createStatement();
                                                                                                String w = "select * from data where bol_al =" + bol + " and id_lab =14";

                                                                                                rs = set2.executeQuery(w);
                                                                                                while (rs.next()) {
                                                                                                    id_data = rs.getInt("id_data");
                                                                                                }
                                                                                                String x = "insert into reporte(fecha_rep, mac_rep, des_rep, id_data) "
                                                                                                        + "values ('22-" + mes + "-" + dia + "', '" + data16 + "', '" + datad16 + "'," + id_data + ")";

                                                                                                set.executeUpdate(x);

                                                                                                data16 = "";
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                bandera++;
                            }
                        }
                    }
                }

                rt.close();
                set1.close();
                set2.close();

                //out.println("<h1>Registro Exitoso</h1>");
                System.out.println("Se registro un nuevo alumno");

            } catch (Exception e) {
                //out.println("<h1>Registro NO Exitoso</h1>");
                System.out.println("Error al registrar al alumno");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
            }
            out.println("<h1>Hola tu nombre es: " + request.getParameter("nombre") + request.getParameter("bdm1") + "</h1>");
            out.println("<a href='mostrar.html'>Ver tus datos</a>");
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
