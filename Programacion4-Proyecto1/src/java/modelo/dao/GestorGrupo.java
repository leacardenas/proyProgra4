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
public class GestorGrupo {
    private static GestorGrupo instancia = null;
    
    private GestorGrupo(){
        
    }
    
    public static GestorGrupo obtenerInstancia(){
        if (instancia == null) {
            instancia = new GestorGrupo();
        
        }
        return instancia;
    }
    
}
