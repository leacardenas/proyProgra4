package objetos;

import java.util.ArrayList;
import org.apache.commons.text.StringEscapeUtils;
import static org.apache.commons.text.StringEscapeUtils.ESCAPE_HTML4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fiore
 */
public class Estudiantes {
    private int id;
    private  String nombre;
    private String apellidos;
    private String identificacion;
    private String password;
    private int tiene_grupo;
    
    public Estudiantes(int id, String nombre, String apellidos, String identificacion, String password, int tiene_grupo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
        this.password = password;
        this.tiene_grupo = tiene_grupo;
    }

    public Estudiantes() {
        this(0,null,null,null,null,0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTiene_grupo() {
        return tiene_grupo;
    }

    public void setTiene_grupo(int tiene_grupo) {
        this.tiene_grupo = tiene_grupo;
    }
    
    public String nombreCompleto(){
        String nom = this.nombre + this.apellidos;
        return nom;
    }
    
    public static Estudiantes fromArray(ArrayList<String> datos){
        String idUsuario = datos.get(0);
        String nombre = datos.get(1);
        String apellidos = datos.get(2);
        String identificacion = datos.get(3);
        String password = datos.get(4);
        String tiene_grupo = datos.get(5);
        
        

        return new Estudiantes(Integer.parseInt(idUsuario),nombre,apellidos,
                identificacion,password,Integer.parseInt(tiene_grupo));
    }
    
    private static final String FORMATO_REGISTRO_HTML
            = "<tr><td class=\"etiqueta\">Id:</td><td class=\"datos\">%s</td></tr>"
            + "<tr><td class=\"etiqueta\">Nombre:</td><td class=\"datos\">%s</td></tr>";
    
    
    public String toHTMLString() {
        String m = nombre + " " + apellidos;
       
            return String.format(FORMATO_REGISTRO_HTML,
                    StringEscapeUtils.builder(ESCAPE_HTML4).escape(identificacion),
                    StringEscapeUtils.builder(ESCAPE_HTML4).escape(m)
            );    
    }
}
