/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


/**
 *
 * @author fiore
 */
public class Grupo {
    private Integer grupo_id;
    private String grupo_nombre;

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
    
}
