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
import java.util.List;
import modelo.entidades.Estudiante;
import modelo.entidades.Grupo;
import modelo.entidades.Totalidad_De_Grupos;

/**
 *
 * @author Evis
 */
public class gestorGrupos {
    private String URL_Servidor = "localhost";
    private static final String BASE_DATOS = "eif209_1901_p01";

    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";
    

//    private static final String LISTAR
//            = "SELECT g.id ,g.secuencia ,g.nombre AS nomGrupo ,g.cupo ,g.activo ,e.apellidos ,e.nombre "
//            + "FROM eif209_1901_p01.grupo g, eif209_1901_p01.estudiante e WHERE e.grupo_id=g.id";

        private static final String LISTAR_GRUPOS
            = "SELECT id,nombre "
            + "FROM grupo;";
    private static final String LISTAR_EST_POR_GRUPO
            = "SELECT nombre, apellidos, id "
            + "FROM eif209_1901_p01.estudiante WHERE grupo_id='%d';";
    private static gestorGrupos instancia = null;
//    
//    private static final String CURSOS_NO_MATRICULADOS = "SELECT id,secuencia,nombre,cupo,activo FROM grupo AS grupo "
//            + "LEFT JOIN matricula AS matricula ON curso_codigo = curso.codigo AND estudiante_id = '%s' "
//            + "WHERE curso_codigo IS NULL ORDER BY codigo;";
    
    public static gestorGrupos obtenerInstancia(){
        if(instancia == null)
            instancia = new gestorGrupos();
        return instancia;
    }

    public gestorGrupos() {}
    
    
public String listaGrupos(){
        DBManager bd = null;
        Totalidad_De_Grupos tg = new Totalidad_De_Grupos();
        ArrayList<Grupo> gruposLista=new ArrayList<Grupo>();
        try {
            bd = DBManager.getDBManager(DBManager.DB_MGR.MYSQL_SERVER, URL_Servidor);
            Connection cnx = bd.getConnection(BASE_DATOS, LOGIN, PASSWORD);

            Statement stm = cnx.createStatement();
            ResultSet grupos = stm.executeQuery(String.format(LISTAR_GRUPOS));
              while(grupos.next()){
                int id = grupos.getInt("id");
                String nomGrupo = grupos.getString("nombre");
                Grupo g1=new Grupo() ;
                g1.setNombre(nomGrupo);
                g1.setId(id);
                gruposLista.add(g1); 
              }
              for(int i=0;i<gruposLista.size();i++){
                int id= gruposLista.get(i).getId();
                ResultSet estudiantes = stm.executeQuery(String.format(LISTAR_EST_POR_GRUPO,id));
                while(estudiantes.next()){
                    String apellidos=estudiantes.getString("apellidos");
                    String nombre=estudiantes.getString("nombre");
                    String id_est = estudiantes.getString("id");
                    Estudiante est = new Estudiante();
                    est.setNombre(nombre);
                    est.setApellidos(apellidos);
                    est.setId(id_est);
                    gruposLista.get(i).insert(est);
                }
                }
                tg.setGrupos(gruposLista);
            
        }catch(Exception ex){
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        
        return tg.toHTML();
    }
}
