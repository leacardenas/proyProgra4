/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.estudiante;

import cr.ac.database.managers.DBManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author fiore
 */
public class GestorEstudiante {
    private static GestorEstudiante instancia = null;
    private static final String BASE_DATOS = "proy_progra4";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";
    
    private static final String CMD_LISTAR
            = "SELECT id,nombre,apellidos,identificacion,contraseña,"
            + "tiene_grupo "
            + "FROM estudiante ORDER BY id ";
    
    private static final String CMD_VERIFICAR
            = "SELECT id FROM estudiante "
            + "WHERE identificacion=? AND contraseña=? ";
    
    private String UserLogin = " ";
    
    private GestorEstudiante(){
        
    }
    
    public static GestorEstudiante obtenerInstancia(){
        if (instancia == null) {
            instancia = new GestorEstudiante();
        }
        return instancia;
    }
    
    public ArrayList<Object[]> obtenerLista() {
        ArrayList<Object[]> usuarios = new ArrayList<>();

        // Abre una conexión a la base de datos y carga la lista de usuarios.
        DBManager bd = null;
        try {
            bd = DBManager.getDBManager(DBManager.DB_MGR.MYSQL_SERVER);
            Connection cnx = bd.getConnection(BASE_DATOS, LOGIN, PASSWORD);

            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(CMD_LISTAR);
            int maxCols = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                Object[] registro = new Object[maxCols];
                for (int i = 0; i < maxCols; i++) {
                    registro[i] = rs.getObject(i + 1);
                }
                usuarios.add(registro);
            }
        } catch (ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            bd.closeConnection();
        }

        return usuarios;
    }
    
    public static String listaUsuariosHTML(GestorEstudiante g) {
        StringBuilder r = new StringBuilder();
        ArrayList<Object[]> usuarios = g.obtenerLista();
        if (usuarios.size() > 0) {
            for (Object[] registro : usuarios) {
                r.append("<tr>");
                for (Object e : registro) {
                    r.append("<td>");
                    if (e != null) {
                        r.append(e.toString());
                    }else {
                        r.append("(null)");
                    }
                    r.append("</td>");
                }
                r.append("</tr>");
            }
        } else {
            r.append("<tr><td colspan=\"5\">(No hay registros en la base de datos.)</td></tr>");
        }

        return r.toString();
    }
    
    public boolean verificarUsuario(String usuario, String clave) {

        boolean encontrado = false;
        DBManager bd = null;
        try {
            bd = DBManager.getDBManager(DBManager.DB_MGR.MYSQL_SERVER);
            Connection cnx
                    = bd.getConnection(BASE_DATOS, LOGIN, PASSWORD);

            try (PreparedStatement stm = cnx.prepareStatement(CMD_VERIFICAR)) {
                stm.clearParameters();
                stm.setString(1, usuario);
                stm.setString(2, clave);
                ResultSet rs = stm.executeQuery();
                encontrado = rs.next();
            }

        } catch (ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            if (bd != null) {
                bd.closeConnection();
            }
        }
        return encontrado;
    }
    
    public String getUserLogin() {
        return UserLogin;
    }

    public void setUserLogin(String UserLogin) {
        this.UserLogin = UserLogin;
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
    
}
