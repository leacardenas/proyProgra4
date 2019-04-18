/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

//deberia quedar el cambio
/**
 *
 * @author fiore
 */
public class Grupo {
    private Integer id;
    private Integer secuencia;
    private String nombre;
    private Integer cupo;
    private Boolean activo;

    public Grupo() {
    }

    public Grupo(Integer id, Integer secuencia, String nombre, Integer cupo, Boolean activo) {
        this.id = id;
        this.secuencia = secuencia;
        this.nombre = nombre;
        this.cupo = cupo;
        this.activo = activo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(Integer secuencia) {
        this.secuencia = secuencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCupo() {
        return cupo;
    }

    public void setCupo(Integer cupo) {
        this.cupo = cupo;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    
}
