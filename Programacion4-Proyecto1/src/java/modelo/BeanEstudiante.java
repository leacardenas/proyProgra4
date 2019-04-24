/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author fiore
 */
public class BeanEstudiante implements Serializable{
    private String id;

    public BeanEstudiante(String id) {
        this.id = id;
    }

    public BeanEstudiante(){
        this(null);
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
 
}
