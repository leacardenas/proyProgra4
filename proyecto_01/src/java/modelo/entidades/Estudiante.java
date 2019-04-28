/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;


import java.security.Timestamp;


public class Estudiante {
    String id;
    String nrc;
    String apellidos;
    String nombre;
    int secuencia;
    String clave;
    Timestamp ultimo_acceso;
    int grupo_id;

    
        public String toHTML(){
          
        StringBuilder r = new StringBuilder();
      
        r.append("<tr class=numeroGrupo id="+id+" >");
        r.append("<td>");
        r.append(apellidos);
        r.append("</td>");

        r.append("<td>");
        r.append(nombre);
        r.append("</td>");
        r.append("</tr>");


        return r.toString();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public Estudiante(String id, String nrc, String apellidos, String nombre, int secuencia, String clave, Timestamp ultimo_acceso, int grupo_id) {
        this.id = id;
        this.nrc = nrc;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.secuencia = secuencia;
        this.clave = clave;
        this.ultimo_acceso = ultimo_acceso;
        this.grupo_id = grupo_id;
    }

    public Estudiante() {
    }

    public String getId() {
        return id;
    }

    public String getNrc() {
        return nrc;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSecuencia() {
        return secuencia;
    }

    public String getClave() {
        return clave;
    }

    public Timestamp getUltimo_acceso() {
        return ultimo_acceso;
    }

    public int getGrupo_id() {
        return grupo_id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSecuencia(int secuencia) {
        this.secuencia = secuencia;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setUltimo_acceso(Timestamp ultimo_acceso) {
        this.ultimo_acceso = ultimo_acceso;
    }

    public void setGrupo_id(int grupo_id) {
        this.grupo_id = grupo_id;
    }
    
    
}
