package objetos;

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
}
