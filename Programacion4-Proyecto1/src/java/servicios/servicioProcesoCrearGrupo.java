/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Estudiantes;
import modelo.Grupo;
import modelo.dao.GestorEstudiante;
import modelo.dao.GestorGrupo;
import org.json.JSONObject;

/**
 *
 * @author Evis
 */
public class servicioProcesoCrearGrupo extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            JSONObject r = new JSONObject();
            Enumeration<String> e = request.getParameterNames();
            String nombre = request.getParameter("nombreGrupo");
            Grupo com;
            com = new Grupo(nombre);

            GestorGrupo.obtenerInstancia().creaGrupo(com);
            com.setId(GestorGrupo.obtenerInstancia().obtenerIDGrupoPorNombre(nombre));
            int id = com.getId();

            //--------- obtener datos de usuario
            HttpSession sesionActual = request.getSession(true);
            Object usuario = sesionActual.getAttribute("usuario");
            String idUsuario = usuario.toString();
            GestorEstudiante GE = GestorEstudiante.obtenerInstancia();
            Estudiantes est = GE.getEstudiante(idUsuario);
            int grupo_id_antiguo = est.getGrupo_id();
            r.put("grupo_id_antiguo", grupo_id_antiguo);
            //--------- obtener datos de usuario
            //--------- actualizar grupo de estudiante
            GE.Actualizar_id_grupo(idUsuario, String.valueOf(id));
            //--------- actualizar grupo de estudiante
            r.put("grupoNombre", com.getNombre());
            r.put("grupoID", com.getId());
            r.put("estId", est.getId());
            r.put("estNombre", est.getNombre());
            r.put("estApellidos", est.getApellidos());

            r.put("nombre", est.getNombre());
            r.put("apellidos", est.getApellidos());
            r.put("idUsuario", idUsuario);
            
            out.println(r);

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
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(servicioProcesoCrearGrupo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(servicioProcesoCrearGrupo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(servicioProcesoCrearGrupo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(servicioProcesoCrearGrupo.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(servicioProcesoCrearGrupo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(servicioProcesoCrearGrupo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(servicioProcesoCrearGrupo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(servicioProcesoCrearGrupo.class.getName()).log(Level.SEVERE, null, ex);
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
