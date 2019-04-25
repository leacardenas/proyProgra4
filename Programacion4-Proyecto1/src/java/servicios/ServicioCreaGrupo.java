/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Estudiantes;
import modelo.dao.GestorEstudiante;
import org.json.JSONObject;

/**
 *
 * @author Evis
 */
@WebServlet
@MultipartConfig

public class ServicioCreaGrupo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    
            try (PrintWriter out = response.getWriter()) {
                Enumeration<String> e = request.getParameterNames();
                JSONObject r = new JSONObject();
                String id = e.nextElement();
                String id_tablaClickeada = request.getParameter(id);

                String Accion = e.nextElement();
                String Accion_por_realizar= request.getParameter(Accion);

                HttpSession sesionActual = request.getSession(true);
                Object usuario = sesionActual.getAttribute("usuario");
                String idUsuario= usuario.toString();

                GestorEstudiante GE = GestorEstudiante.obtenerInstancia();
                Estudiantes est= GE.getEstudiante(idUsuario);
                int grupo_id_antiguo = est.getGrupo_id();
                if(GE.Actualizar_id_grupo(idUsuario, id_tablaClickeada)){
 
                    r.put("nombre", est.getNombre());
                    r.put("apellidos", est.getApellidos());
                    r.put("grupo_id_antiguo",grupo_id_antiguo);
                    r.put("idUsuario", idUsuario);
                }
                else{}


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
