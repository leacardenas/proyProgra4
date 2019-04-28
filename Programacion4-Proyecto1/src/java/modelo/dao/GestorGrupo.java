/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Estudiantes;
import modelo.Grupo;
import modelo.Totalidad_De_Grupos;

/**
 *
 * @author fiore
 */
public class GestorGrupo {
    
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";
    private static final String CONEXION = "jdbc:mysql://localhost/proy_progra4?useSSL=false";
    
//    private static final String LISTAR
//            = "SELECT g.id ,g.secuencia ,g.nombre AS nomGrupo ,g.cupo ,g.activo ,e.apellidos ,e.nombre "
//            + "FROM proy_progra4.grupo g, proy_progra4.estudiante e WHERE e.grupo_id=g.id";
    private static final String LISTAR_GRUPOS
            = "SELECT grupo_id,grupo_nombre "
            + "FROM grupo;";
    private static final String OBTENER_ID
            = "SELECT grupo_id "
            + "FROM proy_progra4.grupo WHERE grupo_nombre='%s';";
    private static final String LISTAR_EST_POR_GRUPO
            = "SELECT estudiante_nombre, estudiante_apellidos, estudiante_id "
            + "FROM proy_progra4.estudiante WHERE estudiante_grupo_id='%d';";
    private static GestorGrupo instancia = null;
//
    private static final String CMD_GRUPO = "INSERT INTO grupo (grupo_nombre) VALUES ('%s');";
    
    private static final String ABANDONAR_GRUPO = "UPDATE proy_progra4.estudiante SET estudiante_grupo_id=null WHERE estudiante_id='%s';";
    
//    private static final String CURSOS_NO_MATRICULADOS = "SELECT id,secuencia,nombre,cupo,activo FROM grupo AS grupo "
//            + "LEFT JOIN matricula AS matricula ON curso_codigo = curso.codigo AND estudiante_id = '%s' "
//            + "WHERE curso_codigo IS NULL ORDER BY codigo;";

    public static GestorGrupo obtenerInstancia() {
        if (instancia == null) {
            instancia = new GestorGrupo();
        }
        return instancia;
    }
    
    public GestorGrupo() {
    }
    
    public String listaGrupos() {
        Totalidad_De_Grupos tg = new Totalidad_De_Grupos();
        ArrayList<Grupo> gruposLista = new ArrayList<Grupo>();
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection cnx = DriverManager.getConnection(CONEXION, LOGIN, PASSWORD);
            
            Statement stm = cnx.createStatement();
            ResultSet grupos = stm.executeQuery(String.format(LISTAR_GRUPOS));
            while (grupos.next()) {
                int id = grupos.getInt("grupo_id");
                String nomGrupo = grupos.getString("grupo_nombre");
                Grupo g1 = new Grupo();
                g1.setNombre(nomGrupo);
                g1.setId(id);
                gruposLista.add(g1);
            }
            for (int i = 0; i < gruposLista.size(); i++) {
                Grupo actual= gruposLista.get(i);
                int id = actual.getId();
                ResultSet estudiantes = stm.executeQuery(String.format(LISTAR_EST_POR_GRUPO, id));
                while (estudiantes.next()) {
                    String apellidos = estudiantes.getString("estudiante_apellidos");
                    String nombre = estudiantes.getString("estudiante_nombre");
                    String id_est = estudiantes.getString("estudiante_id");
                    Estudiantes est = new Estudiantes();
                    est.setNombre(nombre);
                    est.setApellidos(apellidos);
                    est.setId(id_est);
                    actual.insert(est);
                }
            }
            tg.setGrupos(gruposLista);
            
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        
        return tg.toHTML();
    }
    
    public void creaGrupo(Grupo grupo) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection cnx = DriverManager.getConnection(CONEXION, LOGIN, PASSWORD);
            
            Statement stm = cnx.createStatement();
            String aux = String.format(CMD_GRUPO, grupo.getNombre());
            stm.executeUpdate(aux);
            
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            
        }
        
    }
    
    public int obtenerIDGrupoPorNombre(String nombre) throws InstantiationException, ClassNotFoundException, IllegalAccessException, SQLException {
        Totalidad_De_Grupos tg = new Totalidad_De_Grupos();
        
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection cnx = DriverManager.getConnection(CONEXION, LOGIN, PASSWORD);
        
        Statement stm = cnx.createStatement();
        ResultSet grupo = stm.executeQuery(String.format(OBTENER_ID, nombre));
        grupo.next();
        int aux = grupo.getInt("grupo_id");
        return aux;
    }
    
     //-------------------------------------Metodos para desmatricularse-----------------------------------  
    
      public void abandonarGrupo(String estudiante) throws SQLException, InstantiationException, ClassNotFoundException, IllegalAccessException {
          
          try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection cnx = DriverManager.getConnection(CONEXION, LOGIN, PASSWORD);
            
            Statement stm = cnx.createStatement();
            String aux = String.format(ABANDONAR_GRUPO, estudiante);
            stm.executeUpdate(aux);
            
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            
        } 
      }
    
      public int cant_registros_grupo(int idGrupo) throws SQLException, InstantiationException, ClassNotFoundException, IllegalAccessException{
        
          int n= 0;
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection cnx = DriverManager.getConnection(CONEXION, LOGIN, PASSWORD);
        Statement stm = cnx.createStatement();
        
        String aux=String.format("SELECT count(grupo_id) FROM estudiantes WHERE grupo_id='%d';", idGrupo);
        ResultSet rs=stm.executeQuery(aux);
        
        if(rs.next()) {
            
            n= rs.getInt(1);
        }
        
        stm.close();
        cnx.close();
        return n; 
    }
      
    public void salirGrupo(Estudiantes estudiante, int grupoID) throws SQLException, InstantiationException, ClassNotFoundException, IllegalAccessException{
        
        if(estudiante.getGrupo_id()==grupoID){
            
            if(cant_registros_grupo(grupoID)==1){
                //metodo para eliminar el grupo
            }else{
                abandonarGrupo(estudiante.getId());
            }
            
        }else{
            System.out.print("ERROR");
        } 
    }
}
