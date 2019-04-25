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

    private String estudiante_id;
    private String estudiante_nombre;
    private String estudiante_apellidos;
    private Integer estudiante_nrc;
    private Integer estudiante_secuencia;
    private String estudiante_clave;
    private Date estudiante_ultimo_acceso;
    private Integer estudiante_grupo_id;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public Estudiantes() {
        estudiante_ultimo_acceso = new Date();
    }

    public Estudiantes(String estudiante_id, String estudiante_nombre, String estudiante_apellidos, Integer estudiante_nrc, Integer estudiante_secuencia, String estudiante_clave, Date estudiante_ultimo_acceso, Integer estudiante_grupo_id) {
        this.estudiante_id = estudiante_id;
        this.estudiante_nombre = estudiante_nombre;
        this.estudiante_apellidos = estudiante_apellidos;
        this.estudiante_nrc = estudiante_nrc;
        this.estudiante_secuencia = estudiante_secuencia;
        this.estudiante_clave = estudiante_clave;
        this.estudiante_ultimo_acceso = estudiante_ultimo_acceso;
        this.estudiante_grupo_id = estudiante_grupo_id;
    }

    public String getId() {
        return estudiante_id;
    }

    public void setId(String estudiante_id) {
        this.estudiante_id = estudiante_id;
    }

    public String getNombre() {
        return estudiante_nombre;
    }

    public void setNombre(String estudiante_nombre) {
        this.estudiante_nombre = estudiante_nombre;
    }

    public String getApellidos() {
        return estudiante_apellidos;
    }

    public void setApellidos(String estudiante_apellidos) {
        this.estudiante_apellidos = estudiante_apellidos;
    }

    public Integer getNrc() {
        return estudiante_nrc;
    }

    public void setNrc(Integer estudiante_nrc) {
        this.estudiante_nrc = estudiante_nrc;
    }

    public Integer getSecuencia() {
        return estudiante_secuencia;
    }

    public void setSecuencia(Integer estudiante_secuencia) {
        this.estudiante_secuencia = estudiante_secuencia;
    }

    public String getClave() {
        return estudiante_clave;
    }

    public void setClave(String estudiante_clave) {
        this.estudiante_clave = estudiante_clave;
    }

    public Date getUltimo_acceso() {
        return estudiante_ultimo_acceso;
    }

    public void setUltimo_acceso(Date estudiante_ultimo_acceso) {
        this.estudiante_ultimo_acceso = estudiante_ultimo_acceso;
    }

    public Integer getGrupo_id() {
        return estudiante_grupo_id;
    }

    public void setGrupo_id(Integer estudiante_grupo_id) {
        this.estudiante_grupo_id = estudiante_grupo_id;
    }

    public String nombreCompleto() {
        String nom = this.estudiante_nombre + " " + this.estudiante_apellidos;
        return nom;
    }

    public static Estudiantes fromArray(ArrayList<String> datos) throws ParseException {
        String idUsuario = datos.get(0);
        String estudiante_nombre = datos.get(1);
        String estudiante_apellidos = datos.get(2);
        String estudiante_nrc = datos.get(3);
        String estudiante_secuencia = datos.get(4);
        String password = datos.get(5);
        String estudiante_ultimo_acceso = datos.get(6);
        String grupo_Id = datos.get(7);

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        Date acceso = formatter.parse(estudiante_ultimo_acceso);

        Integer nrc1 = Integer.parseInt(estudiante_nrc);
        Integer sec = Integer.parseInt(estudiante_secuencia);
        Integer grupo = Integer.parseInt(grupo_Id);

        return new Estudiantes(idUsuario, estudiante_nombre, estudiante_apellidos, nrc1,
                sec, password, acceso, grupo);
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

    public String dateToString(Date d) {
        String string = sdf.format(d);

        return string;
    }

    private static final String FORMATO_REGISTRO_HTML
            = "<tr><td class=\"etiqueta\">Id:</td><td class=\"datos\">%s</td></tr>"
            + "<tr><td class=\"etiqueta\">Nombre:</td><td class=\"datos\">%s</td></tr>"
            + "<tr><td class=\"etiqueta\">Ultimo acceso:</td><td class=\"datos\">%s</td></tr>"
            + "<tr><td class=\"etiqueta\">Grupo:</td><td class=\"datos\">%s</td></tr>";

    public String toHTMLString() {
        String m = estudiante_nombre + " " + estudiante_apellidos;
        String d = this.dateToString(estudiante_ultimo_acceso);
        String g = String.valueOf(this.estudiante_grupo_id);
        return String.format(FORMATO_REGISTRO_HTML,
                StringEscapeUtils.builder(ESCAPE_HTML4).escape(estudiante_id),
                StringEscapeUtils.builder(ESCAPE_HTML4).escape(m),
                StringEscapeUtils.builder(ESCAPE_HTML4).escape(d),
                StringEscapeUtils.builder(ESCAPE_HTML4).escape(g)
        );
    }

    public static String getTablaUsuarioHTML(List<Estudiantes> estudiantesActivos) {
        StringBuilder r = new StringBuilder();
        r.append("<tr>\n"
                + "<th onclick=\"ordenarTabla(0,'listaUsuariosActivos')\">ID</th>\n"
                + "<th onclick=\"ordenarTabla(1,'listaUsuariosActivos')\">Nombre</th>\n"
                + "<th onclick=\"ordenarTabla(2,'listaUsuariosActivos')\">NCR</th>\n"
                + "<th onclick=\"ordenarTabla(3,'listaUsuariosActivos')\">Ultimo acceso</th>\n"
                + "</tr>");

        for (Estudiantes usuario : estudiantesActivos) {
            r.append("<tr>");
            r.append(String.format(
                    "<td>%s</td>"
                    + "<td>%s</td>"
                    + "<td>%d</td>"
                    + "<td>%s</td>",
                    usuario.getId(),
                    usuario.nombreCompleto(),
                    usuario.getNrc(),
                    sdf.format(usuario.getUltimo_acceso())
            )
            );
            r.append("</tr>");
        }
        return r.toString();
    }
    
    public String toHTML(){
          
        StringBuilder r = new StringBuilder();
      
        r.append("<tr class=numeroGrupo id=").append(estudiante_id).append(" >");
        r.append("<td>");
        r.append(estudiante_apellidos);
        r.append("</td>");

        r.append("<td>");
        r.append(estudiante_nombre);
        r.append("</td>");
        r.append("</tr>");


        return r.toString();
    }
}
