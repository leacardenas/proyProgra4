/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author fiore
 */
public class Grupo {

    private Integer grupo_id;
    private String grupo_nombre;
    private ArrayList<Estudiantes> estudiantes;

    public Grupo() {
    }

    public Grupo(Integer grupo_id, String grupo_nombre) {
        this.grupo_id = grupo_id;
        this.grupo_nombre = grupo_nombre;
    }

    public Integer getId() {
        return grupo_id;
    }

    public void setId(Integer grupo_id) {
        this.grupo_id = grupo_id;
    }

    public String getNombre() {
        return grupo_nombre;
    }

    public void setNombre(String grupo_nombre) {
        this.grupo_nombre = grupo_nombre;
    }

    public ArrayList<Estudiantes> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiantes> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public String toHTML() {

        StringBuilder r = new StringBuilder();
        r.append("<table class=\"tablaInfoGrupo\" id=\"Grupo").append(grupo_id).append("\" onclick=\"crearGrupo(").append(grupo_id).append(");\">");
        r.append("<tbody id=tbodyGrupo").append(grupo_id).append(">");
        r.append("<tr class=numeroGrupo>");
        r.append("<td colspan=\"2\">");
        r.append("Grupo ").append(Integer.toString(grupo_id));
        r.append("</td>");
        r.append("</tr>");

        r.append("<tr class=integrantes>");
        r.append("<td colspan=\"2\">");
        r.append(grupo_nombre);
        r.append("</td>");
        r.append("</tr>");

        for (int i = 0; i < estudiantes.size(); i++) {
            r.append(estudiantes.get(i).toHTML());

        }
        r.append("</tbody>");
        r.append("</table>");
        return r.toString();
    }

    public void insert(Estudiantes e) {
        estudiantes.add(e);
    }
    
    public Grupo(String nombre) {
        this.grupo_nombre = nombre;
    }
}
