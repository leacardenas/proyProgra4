/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import cr.ac.database.managers.DBManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Estudiantes;
/**
 *
 * @author fiore
 */
public class GestorEstudiante {
    
    private static GestorEstudiante instancia = null;
//--------------------------------------------------------------------------------------------------------------------------------------------
    private DBManager db = null;
    private static final String BASE_DATOS = "datosProyecto";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";
    String CMD_LISTAR_INTEGRANTES="SELECT e.nombre, e.apellidos FROM estudiante e, grupo g WHERE "
    + "e.FK_id=g.PK_id AND e.FK_id=?;";
//--------------------------------------------------------------------------------------------------------------------------------------------   
    public GestorEstudiante(){
        
    }
    
    public static GestorEstudiante obtenerInstancia(){
        if (instancia == null) {
            instancia = new GestorEstudiante();
        }
        return instancia;
    }
    
//--------------------------------------------------------------------------------------------------------------------------------------------
public List<Estudiantes> miembros_Grupo(String id) throws InstantiationException, ClassNotFoundException, SQLException{
        List<Estudiantes> miembros = new ArrayList<>();
        try {
            db = DBManager.getDBManager(DBManager.DB_MGR.MYSQL_SERVER);
            Connection cnx
                    = db.getConnection(BASE_DATOS, LOGIN, PASSWORD);
            
            try (PreparedStatement stm = cnx.prepareStatement(CMD_LISTAR_INTEGRANTES)) {
                stm.clearParameters();
                stm.setString(1, id);
                ResultSet rs = stm.executeQuery();
                while(rs.next()){
                    String nombre= rs.getString("nombre");
                    String apellidos = rs.getString("apellidos");
                    String ident = rs.getString("id");
                    miembros.add(new Estudiantes(nombre,apellidos,ident));
                }
            }
            
        } catch (ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException e) {
            e.printStackTrace(System.err);
        }
        return miembros;
    }
//--------------------------------------------------------------------------------------------------------------------------------------------    
}
