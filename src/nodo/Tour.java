package nodo;

import org.joda.time.DateTime;

/**
 * Created by danie on 04/11/2017.
 */
public class Tour extends Nodo{
    //Destinos turisticos
    private String nombre;
    private String descripcion;
    private String pais;
    private String ciudad;
    private String direccion;

    //Entretenimiento
    private Integer minimoEdadPermitida;
    private DateTime fecha;
    private DateTime horarios;
    private Boolean especial; //Puede o no serlo, tu sabes.
    private String recomendacionesSeguridad;

    //Division
    private String tipo; //Lugar Espectaculo, Lugar Entretenimiento, Sitio turistico


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getMinimoEdadPermitida() {
        return minimoEdadPermitida;
    }

    public void setMinimoEdadPermitida(Integer minimoEdadPermitida) {
        this.minimoEdadPermitida = minimoEdadPermitida;
    }

    public DateTime getFecha() {
        return fecha;
    }

    public void setFecha(DateTime fecha) {
        this.fecha = fecha;
    }

    public DateTime getHorarios() {
        return horarios;
    }

    public void setHorarios(DateTime horarios) {
        this.horarios = horarios;
    }

    public Boolean getEspecial() {
        return especial;
    }

    public void setEspecial(Boolean especial) {
        this.especial = especial;
    }

    public String getRecomendacionesSeguridad() {
        return recomendacionesSeguridad;
    }

    public void setRecomendacionesSeguridad(String recomendacionesSeguridad) {
        this.recomendacionesSeguridad = recomendacionesSeguridad;
    }
}
