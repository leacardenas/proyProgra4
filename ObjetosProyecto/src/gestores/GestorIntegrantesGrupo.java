/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

/**
 *
 * @author fiore
 */
public class GestorIntegrantesGrupo {
     private static GestorIntegrantesGrupo instancia = null;
    
    private GestorIntegrantesGrupo(){
        
    }
    
    public static GestorIntegrantesGrupo obtenerInstancia(){
        if (instancia == null) {
            instancia = new GestorIntegrantesGrupo();
        
        }
        return instancia;
    }
}
