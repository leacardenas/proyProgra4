/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

/**
 *
 * @author fiore
 */
public class GestorEstudiante {
    private static GestorEstudiante instancia = null;
    
    private GestorEstudiante(){
        
    }
    
    public static GestorEstudiante obtenerInstancia(){
        if (instancia == null) {
            instancia = new GestorEstudiante();
        }
        return instancia;
    }
}
