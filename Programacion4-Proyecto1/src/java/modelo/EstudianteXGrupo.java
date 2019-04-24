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
public class EstudianteXGrupo {

    private Integer grupo_id;
    private String grupo_nombre;
    private String estudiante_id;
    private Integer estudiante_nrc;
    private String estudiante_apellidos;
    private String estudiante_nombre;

    public EstudianteXGrupo() {
    }

    public EstudianteXGrupo(Integer grupo_id, String grupo_nombre, String estudiante_id, Integer estudiante_nrc, String estudiante_apellidos, String estudiante_nombre) {
        this.grupo_id = grupo_id;
        if(grupo_nombre == null)
            this.grupo_nombre = "";
        else
            this.grupo_nombre = grupo_nombre;
        this.estudiante_id = estudiante_id;
        this.estudiante_nrc = estudiante_nrc;
        this.estudiante_apellidos = estudiante_apellidos;
        this.estudiante_nombre = estudiante_nombre;
    }

    public Integer getGrupo_id() {
        return grupo_id;
    }

    public void setGrupo_id(Integer grupo_id) {
        this.grupo_id = grupo_id;
    }

    public String getGrupo_nombre() {
        return grupo_nombre;
    }

    public void setGrupo_nombre(String grupo_nombre) {
        this.grupo_nombre = grupo_nombre;
    }

    public String getEstudiante_id() {
        return estudiante_id;
    }

    public void setEstudiante_id(String estudiante_id) {
        this.estudiante_id = estudiante_id;
    }

    public Integer getEstudiante_nrc() {
        return estudiante_nrc;
    }

    public void setEstudiante_nrc(Integer estudiante_nrc) {
        this.estudiante_nrc = estudiante_nrc;
    }

    public String getEstudiante_apellidos() {
        return estudiante_apellidos;
    }

    public void setEstudiante_apellidos(String estudiante_apellidos) {
        this.estudiante_apellidos = estudiante_apellidos;
    }

    public String getEstudiante_nombre() {
        return estudiante_nombre;
    }

    public void setEstudiante_nombre(String estudiante_nombre) {
        this.estudiante_nombre = estudiante_nombre;
    }

    public static EstudianteXGrupo fromArray(ArrayList<String> datos) throws ParseException {
        String grupoId = datos.get(0);
        String grupoNombre = datos.get(1);
        String estudianteId = datos.get(2);
        String estudianteNCR = datos.get(3);
        String estudianteNombre = datos.get(4);
        String estudianteApellido = datos.get(5);

        Integer nrc1 = Integer.parseInt(estudianteNCR);
        Integer grupo = Integer.parseInt(grupoId);

        return new EstudianteXGrupo(grupo, grupoNombre, estudianteId, nrc1, estudianteNombre, estudianteApellido);
    }

    public List<Object> toArray() {
        List<Object> r = new ArrayList<>();
        r.add(String.valueOf(this.getGrupo_id()));
        r.add(this.getGrupo_nombre());
        r.add(this.getEstudiante_id());
        r.add(String.valueOf(this.getEstudiante_nrc()));
        r.add(this.getEstudiante_nombre());
        r.add(this.getEstudiante_apellidos());

        return r;
    }

    public String dateToString(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String string = sdf.format(d);

        return string;
    }

    private static final String FORMATO_REGISTRO_HTML
            = "<tr>\n"
            + "<td>%s</td>\n"
            + "<td>%s</td>\n"
            + "<td>%s</td>\n"
            + "<td>%s</td>\n"
            + "</tr>";

    public String toHTMLString() {
        String m = estudiante_nombre + " " + estudiante_apellidos;
        return String.format(FORMATO_REGISTRO_HTML,
                StringEscapeUtils.builder(ESCAPE_HTML4).escape(estudiante_id),
                StringEscapeUtils.builder(ESCAPE_HTML4).escape(m),
                StringEscapeUtils.builder(ESCAPE_HTML4).escape(String.valueOf(estudiante_nrc)),
                StringEscapeUtils.builder(ESCAPE_HTML4).escape(grupo_nombre)
        );
    }

}
