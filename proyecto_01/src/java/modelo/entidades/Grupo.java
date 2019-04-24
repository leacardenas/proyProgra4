/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.util.ArrayList;

public class Grupo {
    private int id;
    private String nombre;
    private ArrayList<Estudiante> estudiantes ;
    
      public String toHTML(){
          
        StringBuilder r = new StringBuilder();
        r.append("<table class=\"tablaInfoGrupo\" id=\"Grupo"+id+"\" onclick=\"crearGrupo("+id+");\">");
        r.append("<tbody id=tbodyGrupo"+id+">");
        r.append("<tr class=numeroGrupo>");
        r.append("<td colspan=\"2\">");
        r.append("Grupo "+Integer.toString(id));
        r.append("</td>");
        r.append("</tr>");
        
        r.append("<tr class=integrantes>");
        r.append("<td colspan=\"2\">");
        r.append(nombre);
        r.append("</td>");
        r.append("</tr>");
        
        for (int i=0;i< estudiantes.size();i++){
            r.append(estudiantes.get(i).toHTML());
        
        }
        r.append("</tbody>");
        r.append("</table>");
        return r.toString();
    }
    
    
    
    
    
    public Grupo(int id, int secuancia, String nombre, int cupo, boolean activo) {
        this.id = id;
        this.nombre = nombre;

        estudiantes= new ArrayList<Estudiante>();
    }

    public Grupo(String nombre) {
        this.nombre = nombre;
    }

    public Grupo() {
        estudiantes= new ArrayList<Estudiante>();
    }
    public void insert(Estudiante e){estudiantes.add(e);}
    
    public int getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
