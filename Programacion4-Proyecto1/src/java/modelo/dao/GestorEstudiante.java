/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import modelo.Estudiantes;

/**
 *
 * @author fiore
 */
public class GestorEstudiante {

    private static GestorEstudiante instancia = null;

    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";
    private static final String CONEXION = "jdbc:mysql://localhost/proy_progra4?useSSL=false";

    private static final String CMD_LISTAR
            = "SELECT id, nrc,apellidos,nombre,secuencia,clave,ultimo_acceso,grupo_id "
            + "FROM estudiante ORDER BY id ";

    private static final String CMD_VERIFICAR
            = "SELECT id FROM estudiante "
            + "WHERE id=? AND clave=? ";
    private static final String OBTENER_USUARIO
            = "SELECT * FROM estudiante "
            + "WHERE id=?";
    private static final String MODIFICAR_USUARIO_CONTRASENNA
            = "UPDATE `proy_progra4`.`estudiante` "
            + "SET `clave`=? WHERE `id`=?";
    
    private static final String MODIFICAR_USUARIO_FECHA
            = "UPDATE `proy_progra4`.`estudiante` "
            + "SET `ultimo_acceso`=? WHERE `id`=?";

    private static final String IMPRIMIR_DATOS = "<table>\n"
            + "<tr>\n"
            + "<th>Identificacion:</th>\n"
            + "<td>%s</td>\n"
            + "</tr>\n"
            + "<tr>\n"
            + "<th>Nombre:</th>\n"
            + "<td>%s</td>\n"
            + "</tr>\n"
            + "<tr>\n"
            + "<th>\n"
            + "Clave:\n"
            + "</th>\n"
            + "<td>\n"
            + "<form name=\"FormPassword\" action = \"EditarConstrasennaServicio\" method=\"GET\">\n"
            + "<input name=\"clave\" type=\"password\" value=\"%s\" id=\"myPassword\">\n"
            + "<input class=\"check\" type=\"checkbox\" onclick=\"showPassword()\">Mostrar constraseña\n"
            + "<button class=\"save-btn\">Cambiar constraseña</button> \n"
            + "</form>\n"
            + "</td>\n"
            + "</tr>\n"
            + "<tr>\n"
            + "<th>Ultimo Acceso:</th>\n"
            + "<td>%s</td>\n"
            + "</tr>\n"
            + "</table>";

    private String UserLogin = " ";

    private GestorEstudiante() {

    }

    public static GestorEstudiante obtenerInstancia() {
        if (instancia == null) {
            instancia = new GestorEstudiante();
        }
        return instancia;
    }

    public ArrayList<Object[]> obtenerLista() {
        ArrayList<Object[]> usuarios = new ArrayList<>();
        try {
            DriverManager.registerDriver (new com.mysql.jdbc.Driver());
            Connection cnx = DriverManager.getConnection(CONEXION, LOGIN, PASSWORD);

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
        } catch (SQLException e) {
            e.printStackTrace(System.err);
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
                    } else {
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
        try {
            DriverManager.registerDriver (new com.mysql.jdbc.Driver());
            Connection cnx = DriverManager.getConnection(CONEXION, LOGIN, PASSWORD);

            try (PreparedStatement stm = cnx.prepareStatement(CMD_VERIFICAR)) {
                stm.clearParameters();
                stm.setString(1, usuario);
                stm.setString(2, clave);
                ResultSet rs = stm.executeQuery();
                encontrado = rs.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return encontrado;
    }
    
    public void cambiarUltimoAcceso(String estudiante) {
        try {
            java.sql.Timestamp dateDB = new Timestamp(System.currentTimeMillis());
            
            DriverManager.registerDriver (new com.mysql.jdbc.Driver());
            Connection cnx = DriverManager.getConnection(CONEXION, LOGIN, PASSWORD);

            try (PreparedStatement stm = cnx.prepareStatement(MODIFICAR_USUARIO_FECHA)) {
                stm.clearParameters();
                stm.setTimestamp(1, dateDB);
                stm.setString(2, estudiante);
                stm.execute();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void cambiarContrasenna(String estudiante, String contrasenna) {
        try {
            DriverManager.registerDriver (new com.mysql.jdbc.Driver());
            Connection cnx = DriverManager.getConnection(CONEXION, LOGIN, PASSWORD);

            try (PreparedStatement stm = cnx.prepareStatement(MODIFICAR_USUARIO_CONTRASENNA)) {
                stm.clearParameters();
                stm.setString(1, contrasenna);
                stm.setString(2, estudiante);
                stm.execute();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Estudiantes obtenerUsuario(String usuario) {
        Estudiantes est = new Estudiantes();
        try {
            DriverManager.registerDriver (new com.mysql.jdbc.Driver());
            Connection cnx = DriverManager.getConnection(CONEXION, LOGIN, PASSWORD);

            try (PreparedStatement stm = cnx.prepareStatement(OBTENER_USUARIO)) {
                stm.clearParameters();
                stm.setString(1, usuario);
                ResultSet rs = stm.executeQuery();

                while (rs.next()) {
                    String id = rs.getString("id");
                    Integer nrc = rs.getInt("nrc");
                    String apellidos = rs.getString("apellidos");
                    String nombre = rs.getString("nombre");
                    Integer secuencia = rs.getInt("secuencia");
                    String clave = rs.getString("clave");
                    Date ultimo_acceso = rs.getTimestamp("ultimo_acceso");
                    Integer grupo_id = rs.getInt("grupo_id");
                    est = new Estudiantes(id, nombre, apellidos, nrc, secuencia, clave, ultimo_acceso, grupo_id);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return est;
    }
    
    public String imprimirUsuario(String usuario){
        Estudiantes e = obtenerUsuario(usuario);
        String text = String.format(IMPRIMIR_DATOS, e.getId(),e.nombreCompleto(),
                e.getClave(),dateToString(e.getUltimo_acceso()));
        return text;
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

    public String dateToString(Date d){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String string = sdf.format(d);
        
        return string;
    }
}
