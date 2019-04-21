package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    private String id;
    private String nombre;
    private String apellidos;
    private Integer nrc;
    private Integer secuencia;
    private String clave;
    private Date ultimo_acceso;
    private Integer grupo_id;

    public Estudiantes() {
        ultimo_acceso = new Date();
    }

    public Estudiantes(String id, String nombre, String apellidos, Integer nrc, Integer secuencia, String clave, Date ultimo_acceso, Integer grupo_id) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nrc = nrc;
        this.secuencia = secuencia;
        this.clave = clave;
        this.ultimo_acceso = ultimo_acceso;
        this.grupo_id = grupo_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Integer getNrc() {
        return nrc;
    }

    public void setNrc(Integer nrc) {
        this.nrc = nrc;
    }

    public Integer getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(Integer secuencia) {
        this.secuencia = secuencia;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Date getUltimo_acceso() {
        return ultimo_acceso;
    }

    public void setUltimo_acceso(Date ultimo_acceso) {
        this.ultimo_acceso = ultimo_acceso;
    }

    public Integer getGrupo_id() {
        return grupo_id;
    }

    public void setGrupo_id(Integer grupo_id) {
        this.grupo_id = grupo_id;
    }
    
    public String nombreCompleto(){
        String nom = this.nombre + " " + this.apellidos;
        return nom;
    }
    
    public static Estudiantes fromArray(ArrayList<String> datos) throws ParseException{
        String idUsuario = datos.get(0);
        String nombre = datos.get(1);
        String apellidos = datos.get(2);
        String nrc = datos.get(3);
        String secuencia = datos.get(4);
        String password = datos.get(5);
        String ultimo_acceso = datos.get(6);
        String grupo_Id = datos.get(7);
        
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        Date acceso = formatter.parse(ultimo_acceso);

        Integer nrc1 = Integer.parseInt(nrc);
        Integer sec = Integer.parseInt(secuencia);
        Integer grupo = Integer.parseInt(grupo_Id);
        
        
        
        return new Estudiantes(idUsuario,nombre,apellidos,nrc1,
        sec,password,acceso,grupo);
    }
    
    public List<Object> toArray() {
        List<Object> r = new ArrayList<>();
        r.add(this.getId());
        r.add(this.getNombre());
        r.add(String.valueOf(this.getNrc()));
        r.add(String.valueOf(this.getSecuencia()));
        r.add(this.getClave());
        r.add(this.dateToString(this.getUltimo_acceso()));
        r.add(String.valueOf(this.getGrupo_id()));
        
        return r;
    }
    
    public String dateToString(Date d){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String string = sdf.format(d);
        
        return string;
    }
    
    private static final String FORMATO_REGISTRO_HTML
            = "<tr><td class=\"etiqueta\">Id:</td><td class=\"datos\">%s</td></tr>"
            + "<tr><td class=\"etiqueta\">Nombre:</td><td class=\"datos\">%s</td></tr>"
            + "<tr><td class=\"etiqueta\">Ultimo acceso:</td><td class=\"datos\">%s</td></tr>"
            + "<tr><td class=\"etiqueta\">Grupo:</td><td class=\"datos\">%s</td></tr>";
     
    public String toHTMLString() {
        String m = nombre + " " + apellidos;
        String d = this.dateToString(ultimo_acceso);
        String g = String.valueOf(this.grupo_id);
            return String.format(FORMATO_REGISTRO_HTML,
                    StringEscapeUtils.builder(ESCAPE_HTML4).escape(id),
                    StringEscapeUtils.builder(ESCAPE_HTML4).escape(m),
                    StringEscapeUtils.builder(ESCAPE_HTML4).escape(d),
                    StringEscapeUtils.builder(ESCAPE_HTML4).escape(g)
            );    
    }
     
    
}
