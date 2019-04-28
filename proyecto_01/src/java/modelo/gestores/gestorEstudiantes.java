/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.gestores;

import cr.ac.database.managers.DBManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.entidades.Estudiante;
import modelo.entidades.Grupo;
import modelo.entidades.Totalidad_De_Grupos;

/**
 *
 * @author Evis
 */
public class gestorEstudiantes {
     private String URL_Servidor = "localhost";
    private static final String BASE_DATOS = "eif209_1901_p01";

    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";
    

//    private static final String LISTAR
//            = "SELECT g.id ,g.secuencia ,g.nombre AS nomGrupo ,g.cupo ,g.activo ,e.apellidos ,e.nombre "
//            + "FROM eif209_1901_p01.grupo g, eif209_1901_p01.estudiante e WHERE e.grupo_id=g.id";

        private static final String ACTUALIZAR_GRUPO = "UPDATE eif209_1901_p01.estudiante SET grupo_id = '%s' WHERE id = '%s';";
//            = "UPDATE estudiante "
//            + "SET grupo_id= %d "
//            + "WHERE id= '%s';";
        private static final String GET_ESTUDIANTE= "SELECT nombre,apellidos,grupo_id FROM eif209_1901_p01.estudiante WHERE id='%s';";
    private static gestorEstudiantes instancia = null;
    public static gestorEstudiantes obtenerInstancia(){
        if(instancia == null)
            instancia = new gestorEstudiantes();
        return instancia;
    }

    public gestorEstudiantes() {}
    
    
public boolean Actualizar_id_grupo(String id_est, String id_grupo){
        DBManager bd = null;
        try {
            bd = DBManager.getDBManager(DBManager.DB_MGR.MYSQL_SERVER, URL_Servidor);
            Connection cnx = bd.getConnection(BASE_DATOS, LOGIN, PASSWORD);

            Statement stm = cnx.createStatement();
            String aux=String.format(ACTUALIZAR_GRUPO,Integer.parseInt(id_grupo),id_est);
            stm.executeUpdate(aux);

        }catch(Exception ex){
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return false;
        }
        return true;
    }

    public Estudiante getEstudiante(String id){
                DBManager bd = null;
                Estudiante est = new Estudiante();
        try {
            bd = DBManager.getDBManager(DBManager.DB_MGR.MYSQL_SERVER, URL_Servidor);
            Connection cnx = bd.getConnection(BASE_DATOS, LOGIN, PASSWORD);

            Statement stm = cnx.createStatement();
            String aux=String.format(GET_ESTUDIANTE,id);
            ResultSet estudiante = stm.executeQuery(aux);
            
            estudiante.next();
            String apellidos=estudiante.getString("apellidos");
            String nombre=estudiante.getString("nombre");
            String grupo_id= estudiante.getString("grupo_id");
            est.setNombre(nombre);
            est.setApellidos(apellidos);
            est.setGrupo_id(Integer.parseInt(grupo_id));
            
        }catch(Exception ex){
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return null;
        }
        return est;

    }
}
