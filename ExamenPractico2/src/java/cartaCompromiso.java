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
public class cartaCompromiso extends HttpServlet {

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
            out.println("<title>Carta Compromiso</title>");
            out.println("<link rel='stylesheet' href='media/style4.css'>");
            out.println("<script src='media/logica.js'></script>");
            out.println("</head>");
            out.println("<body>"
                    + "<form method='post' name='formulario2' id='formualrio2' action='verRegistro'>"
                    + "        <div class='fecha'>"
                    + "            <p>Ciudad de México, a"
                    + "                <select name='dia' id='dia'>"
                    + "                    <option value=1> 1 </option>"
                    + "                    <option value=2> 2 </option>"
                    + "                    <option value=3> 3 </option>"
                    + "                    <option value=4> 4 </option>"
                    + "                    <option value=5> 5 </option>"
                    + "                    <option value=6> 6 </option>"
                    + "                    <option value=7> 7 </option>"
                    + "                    <option value=8> 8 </option>"
                    + "                    <option value=9> 9 </option>"
                    + "                    <option value=10> 10 </option>"
                    + "                    <option value=11> 11 </option>"
                    + "                    <option value=12> 12 </option>"
                    + "                    <option value=13> 13 </option>"
                    + "                    <option value=14> 14 </option>"
                    + "                    <option value=15> 15 </option>"
                    + "                    <option value=16> 16 </option>"
                    + "                    <option value=17> 17 </option>"
                    + "                    <option value=18> 18 </option>"
                    + "                    <option value=19> 19 </option>"
                    + "                    <option value=20> 20 </option>"
                    + "                    <option value=21> 21 </option>"
                    + "                    <option value=22> 22 </option>"
                    + "                    <option value=23> 23 </option>"
                    + "                    <option value=24> 24 </option>"
                    + "                    <option value=25> 25 </option>"
                    + "                    <option value=26> 26 </option>"
                    + "                    <option value=27> 27 </option>"
                    + "                    <option value=28> 28 </option>"
                    + "                    <option value=29> 29 </option>"
                    + "                    <option value=30> 30 </option>"
                    + "                    <option value=31> 31 </option>"
                    + "                </select>"
                    + "                de"
                    + "                <select name='mes' id='mes'>"
                    + "                    <option value=01> Enero </option>"
                    + "                    <option value=02> Febrero </option>"
                    + "                    <option value=03> Marzo </option>"
                    + "                    <option value=04> Abril </option>"
                    + "                    <option value=05> Mayo </option>"
                    + "                    <option value=06> Junio </option>"
                    + "                    <option value=07> Julio </option>"
                    + "                    <option value=08> Agosto </option>"
                    + "                    <option value=09> Septiembre </option>"
                    + "                    <option value=10> Octubre </option>"
                    + "                    <option value=11> Noviembre </option>"
                    + "                    <option value=12> Diciembre </option>"
                    + "                </select>"
                    + " del 2022"
                    + "            </p>"
                    + "        </div>"
                    + "        <div class='asunto'>"
                    + "            <p> <b>Asunto:</b>"
                    + "                <br>"
                    + "                Carta Compromiso"
                    + "            </p>"
                    + "        </div>"
                    + "        <p>ING. María de Lourdes Hernández Mendoza"
                    + "            <br>"
                    + "            Presidente de la academia de programación"
                    + "            <br>"
                    + "            CECyT 9 'Juan De Dios Bátiz'"
                    + "            <br>"
                    + "            Presente"
                    + "        </p>"
                    + "        <br>"
                    + "<p>Por medio de la presente yo"
                    + "            <input type='text' name='nombre' placeholder='Nombre' onkeypress='return validardata(event)'>"
                    + "            <input type='text' name='appat' placeholder='Apellido Paterno' onkeypress='return validardata(event)'>"
                    + "            <input type='text' name='apmat' placeholder='Apellido Materno'onkeypress='return validardata(event)'>"
                    + "            Alumno(a) del CECyT 9 'Juan De Dios Bátiz', del turno " + request.getParameter("turno") + " inscrito(a) en el grupo ");
            if ((request.getParameter("turno")).equals("matutino") && (request.getParameter("semestre")).equals("tercero")) {
                out.println("<select name='grupo' id='grupo'>"
                        + "<option value='3IM7'>3IM7</option>"
                        + "<option value='3IM8'>3IM8</option>"
                        + "<option value='3IM9'>3IM9</option>"
                        + "<option value='3IM10'>3IM10</option>"
                        + "</select>");
            } else {
                if ((request.getParameter("turno")).equals("matutino") && (request.getParameter("semestre")).equals("cuarto")) {
                    out.println("<select name='grupo' id='grupo'>"
                            + "<option value='4IM7'>4IM7</option>"
                            + "<option value='4IM8'>4IM8</option>"
                            + "<option value='4IM9'>4IM9</option>"
                            + "<option value='4IM10'>4IM10</option>"
                            + "</select>");
                } else {
                    if ((request.getParameter("turno")).equals("matutino") && (request.getParameter("semestre")).equals("quinto")) {
                        out.println("<select name='grupo' id='grupo'>"
                                + "<option value='5IM7'>5IM7</option>"
                                + "<option value='5IM8'>5IM8</option>"
                                + "<option value='5IM9'>5IM9</option>"
                                + "<option value='5IM10'>5IM10</option>"
                                + "</select>");
                    } else {
                        if ((request.getParameter("turno")).equals("matutino") && (request.getParameter("semestre")).equals("sexto")) {
                            out.println("<select name='grupo' id='grupo'>"
                                    + "<option value='6IM7'>6IM7</option>"
                                    + "<option value='6IM8'>6IM8</option>"
                                    + "<option value='6IM9'>6IM9</option>"
                                    + "<option value='6IM10'>6IM10</option>"
                                    + "</select>");
                        }
                    }
                }
            }
            if ((request.getParameter("turno")).equals("vespertino") && (request.getParameter("semestre")).equals("tercero")) {
                out.println("<select name='grupo' id='grupo'>"
                        + "<option value='3IV7'>3IV7</option>"
                        + "<option value='3IV8'>3IV8</option>"
                        + "<option value='3IV9'>3IV9</option>"
                        + "<option value='3IV10'>3IV10</option>"
                        + "</select>");
            } else {
                if ((request.getParameter("turno")).equals("vespertino") && (request.getParameter("semestre")).equals("cuarto")) {
                    out.println("<select name='grupo' id='grupo'>"
                            + "<option value='4IV7'>4IV7</option>"
                            + "<option value='4IV8'>4IV8</option>"
                            + "<option value='4IV9'>4IV9</option>"
                            + "<option value='4IV10'>4IV10</option>"
                            + "</select>");
                } else {
                    if ((request.getParameter("turno")).equals("vespertino") && (request.getParameter("semestre")).equals("quinto")) {
                        out.println("<select name='grupo' id='grupo'>"
                                + "<option value='5IV7'>5IV7</option>"
                                + "<option value='5IV8'>5IV8</option>"
                                + "<option value='5IV9'>5IV9</option>"
                                + "<option value='5IV10'>5IV10</option>"
                                + "</select>");
                    } else {
                        if ((request.getParameter("turno")).equals("vespertino") && (request.getParameter("semestre")).equals("sexto")) {
                            out.println("<select name='grupo' id='grupo'>"
                                    + "<option value='6IV7'>6IV7</option>"
                                    + "<option value='6IV8'>6IV8</option>"
                                    + "<option value='6IV9'>6IV9</option>"
                                    + "<option value='6IV10'>6IV10</option>"
                                    + "</select>");
                        }
                    }
                }
            }
            String materia1 = "", materia2 = "", materia3 = "", materia4 = "";
            int bandera = 0;
            if ((request.getParameter("semestre")).equals("tercero")) {
                materia1 = "Programación Orientada a objetos";
                materia2 = "Laboratorio de proyectos de tecnologías de la información I";
                materia3 = "Administración de proyectos";
                bandera = 3;
            } else {
                if ((request.getParameter("semestre")).equals("cuarto")) {
                    materia1 = "Base de datos";
                    materia2 = "Programacion y servicios web";
                    materia3 = "Técnicas de programación personal con calidad";
                    materia4 = "Laboratorio de proyectos de tecnologías de la información II";
                    bandera = 4;
                } else {
                    if ((request.getParameter("semestre")).equals("quinto")) {
                        materia1 = "Seguridad web y aplicaciones";
                        materia2 = "Ingeniería de pruebas";
                        materia3 = "Sistemas distribuidos";
                        materia4 = "Laboratorio de proyectos de tecnologías de la información III";
                        bandera = 4;
                    } else {
                        if ((request.getParameter("semestre")).equals("sexto")) {
                            materia1 = "Métodos ágiles de programación";
                            materia2 = "Soporte de software";
                            materia3 = "Ingeniería de software";
                            materia4 = "Laboratorio de proyectos de tecnologías de la información IV";
                            bandera = 4;
                        }
                    }
                }
            }

            out.println(
                    "            </select> de la carrera Técnico en Programación, con número de boleta <input type='number' name='boleta'"
                    + "                placeholder='Boleta' min='0' onkeypress='return validarbol(event)'>"
                    + "            , y con fundamento en lo expresado en el artículo 107, fracciones <i>IX y X</i>, y en el artículo 108"
                    + "            <i>fracción IX</i> del"
                    + "            <i>Reglamento Interno del Instituto Politécnico Nacional</i>, , manifiesto mi compromiso de cuidar y hacer"
                    + "            buen"
                    + "            uso de los equipos de cómputo (CPU, monitor, teclado, mouse y demas componentes del mismo),"
                    + "            que me han sido asignados en los laboratorios del área. Así mismo me compromento a reportar con el"
                    + "            profesor(a)"
                    + "            responsable, cualquier irregularidad o anomalía dentro de los 10 primeros minutos de cada clase, siendo"
                    + "            consciente de que, de"
                    + "            no ser así, puedo ser acreedor de alguna de las sanciones establecidas en el artículo 110 del citado"
                    + "            reglamento."
                    + "            <br>"
                    + "            El o los equipos de cómputo que tengo asignados y que utilizo en mis clases son:"
                    + "        </p>"
                    + "        <table border='1' align='center'>"
                    + "            <tr align='center'>"
                    + "                <td rowspan='2'>Unidad de aprendizaje</td>"
                    + "                <td colspan='2'>LBD</td>"
                    + "                <td colspan='2'>LNV</td>"
                    + "                <td colspan='2'>LDS</td>"
                    + "                <td colspan='2'>4.0</td>"
                    + "            </tr>"
                    + "            <tr align='center'>"
                    + "                <td>Maquina</TD>"
                    + "                <td>Descripción</td>"
                    + "                <td>Maquina</TD>"
                    + "                <td>Descripción</td>"
                    + "                <td>Maquina</TD>"
                    + "                <td>Descripción</td>"
                    + "                <td>Maquina</TD>"
                    + "                <td>Descripción</td>"
                    + "            </tr>"
                    + "            <tr>"
                    + "                <td>" + materia1 + "</td>"
                    + "                <td><input type='text' name='bdm1' onkeypress='return validarmac(event)'></td>'"
                    + "                <td><textarea name='bdd1' id='bdd1' cols='20' rows='2' maxlength='35'"
                    + "                        placeholder='No menos de 35 caracteres' onkeypress='return validardata(event)'></textarea></td>"
                    + "                <td><input type='text' name='bdm2' onkeypress='return validarmac(event)'></td>"
                    + "                <td><textarea name='bdd2' id='bdd2' cols='20' rows='2' maxlength='35'"
                    + "                        placeholder='No menos de 35 caracteres' onkeypress='return validardata(event)'></textarea></td>"
                    + "                <td><input type='text' name='bdm3' onkeypress='return validarmac(event)'></td>"
                    + "                <td><textarea name='bdd2' id='bdd3' cols='20' rows='2' maxlength='35'"
                    + "                        placeholder='No menos de 35 caracteres' onkeypress='return validardata(event)'></textarea></td>"
                    + "                <td><input type='text' name='bdm4' onkeypress='return validarmac(event)'></td>"        
                    + "                <td><textarea name='bdd4' id='bdd4' cols='20' rows='2' maxlength='35'"
                    + "                        placeholder='No menos de 35 caracteres' onkeypress='return validardata(event)'></textarea></td>"
                    + "            </tr>"
                    + "            <tr>"
                    + "                <td>" + materia2 + "</td>"
                    + "                <td><input type='text' name='pswm1' onkeypress='return validarmac(event)'></td>"
                    + "                <td><textarea name='pswd1' id='pswd1' cols='20' rows='2' maxlength='35'"
                    + "                        placeholder='No menos de 35 caracteres' onkeypress='return validardata(event)'></textarea></td>"
                    + "                <td><input type='text' name='pswm2' onkeypress='return validarmac(event)'></td>"
                    + "                <td><textarea name='pswd2' id='pswd2' cols='20' rows='2' maxlength='35'"
                    + "                        placeholder='No menos de 35 caracteres' onkeypress='return validardata(event)'></textarea></td>"
                    + "                <td><input type='text' name='pswm3' onkeypress='return validarmac(event)'></td>"
                    + "                <td><textarea name='pswd3' id='pswd3' cols='20' rows='2' maxlength='35'"
                    + "                        placeholder='No menos de 35 caracteres' onkeypress='return validardata(event)'></textarea></td>"
                    + "                <td><input type='text' name='pwsm4' onkeypress='return validarmac(event)'></td>"        
                    + "                <td><textarea name='pswd4' id='pswd4' cols='20' rows='2' maxlength='35'"
                    + "                        placeholder='No menos de 35 caracteres' onkeypress='return validardata(event)'></textarea></td>"
                    + "            </tr>"
                    + "            <tr>"
                    + "                <td>" + materia3 + "</td>"
                    + "                <td><input type='text' name='tpm1' onkeypress='return validarmac(event)'></td>"
                    + "                <td><textarea name='tpd1' id='tpd1' cols='20' rows='2' maxlength='35'"
                    + "                        placeholder='No menos de 35 caracteres' onkeypress='return validardata(event)'></textarea></td>"
                    + "                <td><input type='text' name='tpm2' onkeypress='return validarmac(event)'></td>"
                    + "                <td><textarea name='tpd2' id='tpd2' cols='20' rows='2' maxlength='35'"
                    + "                        placeholder='No menos de 35 caracteres' onkeypress='return validardata(event)'></textarea></td>"
                    + "                <td><input type='text' name='tpm3' onkeypress='return validarmac(event)'></td>"
                    + "                <td><textarea name='tpd3' id='tpd3' cols='20' rows='2' maxlength='35'"
                    + "                        placeholder='No menos de 35 caracteres' onkeypress='return validardata(event)'></textarea></td>"
                    + "                <td><input type='text' name='tpm4' onkeypress='return validarmac(event)'></td>"        
                    + "                <td><textarea name='tpd4' id='tpd4' cols='20' rows='2' maxlength='35'"
                    + "                        placeholder='No menos de 35 caracteres' onkeypress='return validardata(event)'></textarea></td>"
                    + "            </tr>");
            if (bandera == 4) {
                out.println("            <tr>"
                        + "                <td>"+materia4+"</td>"
                        + "                <td><input type='text' name='labm1' onkeypress='return validarmac(event)'></td>"
                        + "                <td><textarea name='labd1' id='labd1' cols='20' rows='2' maxlength='35'"
                        + "                        placeholder='No menos de 35 caracteres' onkeypress='return validardata(event)'></textarea></td>"
                        + "                <td><input type='text' name='labm2' onkeypress='return validarmac(event)'></td>"
                        + "                <td><textarea name='labd2' id='labd2' cols='20' rows='2' maxlength='35'"
                        + "                        placeholder='No menos de 35 caracteres' onkeypress='return validardata(event)'></textarea></td>"
                        + "                <td><input type='text' name='labm3' onkeypress='return validarmac(event)'></td>"
                        + "                <td><textarea name='labd3' id='labd3' cols='20' rows='2' maxlength='35'"
                        + "                        placeholder='No menos de 35 caracteres' onkeypress='return validardata(event)'></textarea></td>"
                        + "                <td><input type='text' name='labm4' onkeypress='return validarmac(event)'></td>"        
                        + "                <td><textarea name='labd4' id='labd4' cols='20' rows='2' maxlength='35'"
                        + "                        placeholder='No menos de 35 caracteres' onkeypress='return validardata(event)'></textarea></td>"
                        + "            </tr>");
            }
            out.println("        </table>"
                    + "        <h3>Ingresa una foto tuya</h3>"
                    + "        <div clas='botones'>"
                    + "            <input type='file' id='foto' name='foto' accept='image/png, image/jpeg'>"
                    + "            <br>"
                    + "            <p id='nomid'></p>"
                    + "            <input id='subir' type='submit' name='subirdatos' value='Subir los Datos'>"
                    + "        </div>"
                    + "    </form>");

            out.println("  <br>"
                    + "    <br>"
                    + "    <br>"
                    + "    <footer id='footer'>"
                    + "        <h1>Centro de Estudios Cientificos y Tecnologicos No. 9 'Juan de dios batiz'</h1>"
                    + "        <br>"
                    + "        <ul class='icons'>"
                    + "            <li>Nombre: Ruiz Ponzio Diego</li>"
                    + "            <li>Materia: Programación y servicios web</li>"
                    + "            <li>Tema: Examen Practico 2</li>"
                    + "            <li>Fecha de entrega: 18/04/2022</li>"
                    + "            <li><a href='index.html'>Regresar a Principal</a></li>"
                    + "        </ul>"
                    + "    </footer>"
            );
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

}
