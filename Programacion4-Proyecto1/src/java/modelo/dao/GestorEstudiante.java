/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package modelo.dao;

import java.io.Serializable;
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
import java.util.Iterator;
import java.util.List;
import modelo.EstudianteXGrupo;
import modelo.Estudiantes;

/**
 *
 * @author fiore
 */
public class GestorEstudiante implements Serializable{
    
    private static GestorEstudiante instancia = null;
    
    private List<Estudiantes> estudiantesActivos = new ArrayList<>();
    
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";
    private static final String CONEXION = "jdbc:mysql://localhost/proy_progra4?useSSL=false";
    
    private static final String CMD_LISTAR
            = "SELECT estudiante_id,estudiante_nrc,estudiante_apellidos,estudiante_nombre,estudiante_secuencia,estudiante_clave,estudiante_ultimo_acceso,estudiante_grupo_id "
            + "FROM estudiante ORDER BY estudiante_id ";
    
    private static final String CMD_VERIFICAR
            = "SELECT estudiante_id FROM estudiante "
            + "WHERE estudiante_id=? AND estudiante_clave=? ";
    private static final String OBTENER_USUARIO
            = "SELECT * FROM estudiante "
            + "WHERE estudiante_id=?";
    private static final String MODIFICAR_USUARIO_CONTRASENNA
            = "UPDATE `proy_progra4`.`estudiante` "
            + "SET `estudiante_clave`=? WHERE `estudiante_id`=?";
    
    private static final String MODIFICAR_USUARIO_FECHA
            = "UPDATE `proy_progra4`.`estudiante` "
            + "SET `estudiante_ultimo_acceso`=? WHERE `estudiante_id`=?";
    
    private static final String LISTA_DE_USUARIOS
            = "SELECT * FROM proy_progra4.estudiantes_x_grupo;";
    
    private static final String ACTUALIZAR_GRUPO = "UPDATE proy_progra4.estudiante SET estudiante_grupo_id = '%s' WHERE estudiante_id = '%s';";

    private static final String GET_ESTUDIANTE= "SELECT estudiante_nombre,estudiante_apellidos,"
            + "estudiante_grupo_id FROM proy_progra4.estudiante WHERE estudiante_id = '%s';";
    
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
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
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
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
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
            
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
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
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
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
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection cnx = DriverManager.getConnection(CONEXION, LOGIN, PASSWORD);
            
            try (PreparedStatement stm = cnx.prepareStatement(OBTENER_USUARIO)) {
                stm.clearParameters();
                stm.setString(1, usuario);
                ResultSet rs = stm.executeQuery();
                
                while (rs.next()) {
                    String id = rs.getString("estudiante_id");
                    Integer nrc = rs.getInt("estudiante_nrc");
                    String apellidos = rs.getString("estudiante_apellidos");
                    String nombre = rs.getString("estudiante_nombre");
                    Integer secuencia = rs.getInt("estudiante_secuencia");
                    String clave = rs.getString("estudiante_clave");
                    Date ultimo_acceso = rs.getTimestamp("estudiante_ultimo_acceso");
                    Integer grupo_id = rs.getInt("estudiante_grupo_id");
                    est = new Estudiantes(id, nombre, apellidos, nrc, secuencia, clave, ultimo_acceso, grupo_id);
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return est;
    }
    
    public ArrayList<EstudianteXGrupo> obtenerTodosLosUsuarios() {
        ArrayList<EstudianteXGrupo> usuarios = new ArrayList<>();
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection cnx = DriverManager.getConnection(CONEXION, LOGIN, PASSWORD);
            
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(LISTA_DE_USUARIOS);
            while (rs.next()) {
                Integer grupoId = rs.getInt("grupo_id");
                String grupo_nombre = rs.getString("grupo_nombre");
                String estudiante_id = rs.getString("estudiante_id");
                Integer estudiante_nrc = rs.getInt("estudiante_nrc");
                String estudiante_apellidos = rs.getString("estudiante_apellidos");
                String estudiante_nombre = rs.getString("estudiante_nombre");
                
                EstudianteXGrupo est = new EstudianteXGrupo(grupoId, grupo_nombre, estudiante_id, estudiante_nrc, estudiante_nombre, estudiante_apellidos);
                usuarios.add(est);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
        
        return usuarios;
    }
    
    public static String listarTodosLosUsuariosHTML() {
        StringBuilder r = new StringBuilder();
        ArrayList<EstudianteXGrupo> usuarios = obtenerInstancia().obtenerTodosLosUsuarios();
        if (usuarios.size() > 0) {
            for (EstudianteXGrupo registro : usuarios) {
                r.append(registro.toHTMLString());
            }
        } else {
            r.append("<tr><td colspan=\"5\">(No hay registros en la base de datos.)</td></tr>");
        }
        
        return r.toString();
    }
    
    public String imprimirUsuario(String usuario) {
        Estudiantes e = obtenerUsuario(usuario);
        String text = String.format(IMPRIMIR_DATOS, e.getId(), e.nombreCompleto(),
                e.getClave(), dateToString(e.getUltimo_acceso()));
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
    
    public String dateToString(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String string = sdf.format(d);
        
        return string;
    }

    public List<Estudiantes> getEstudiantesActivos() {
        return estudiantesActivos;
    }

    public void setEstudiantesActivos(List<Estudiantes> estudiantesActivos) {
        this.estudiantesActivos = estudiantesActivos;
    }
    
    public void agregarUsuarioActivo(Estudiantes nuevoUsuario){
        estudiantesActivos.add(nuevoUsuario);
    }
    
    public void borrarUsuarioActivo(String usuario){
        Iterator itr = estudiantesActivos.iterator(); 
        while (itr.hasNext()) 
        { 
            Estudiantes x = (Estudiantes)itr.next(); 
            if (x.getId() == null ? usuario == null : x.getId().equals(usuario)) 
                itr.remove(); 
        }
    }
    
    public String imprimirTablaUsuarioHTML(){
        return Estudiantes.getTablaUsuarioHTML(estudiantesActivos);
    }
    
    public boolean Actualizar_id_grupo(String id_est, String id_grupo){
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection cnx = DriverManager.getConnection(CONEXION, LOGIN, PASSWORD);

            Statement stm = cnx.createStatement();
            String aux=String.format(ACTUALIZAR_GRUPO,Integer.parseInt(id_grupo),id_est);
            stm.executeUpdate(aux);

        }catch(Exception ex){
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return false;
        }
        return true;
    }

    public Estudiantes getEstudiante(String id){
        Estudiantes est = new Estudiantes();
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection cnx = DriverManager.getConnection(CONEXION, LOGIN, PASSWORD);

            Statement stm = cnx.createStatement();
            String aux=String.format(GET_ESTUDIANTE,id);
            ResultSet estudiante = stm.executeQuery(aux);
            
            estudiante.next();
            String apellidos=estudiante.getString("estudiante_apellidos");
            String nombre=estudiante.getString("estudiante_nombre");
            String grupo_id= estudiante.getString("estudiante_grupo_id");
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
