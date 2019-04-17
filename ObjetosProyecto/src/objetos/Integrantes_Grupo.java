/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

/**
 *
 * @author fiore
 */
public class Integrantes_Grupo {
    private int id;
    private int id_estudiante;
    private int id_grupo;

    public Integrantes_Grupo(int id, int id_estudiante, int id_grupo) {
        this.id = id;
        this.id_estudiante = id_estudiante;
        this.id_grupo = id_grupo;
    }

    public Integrantes_Grupo() {
        this(0,0,0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }
    
    
}
