package nodo;

/**
 * Created by danie on 04/11/2017.
 */
public class Hotel extends Nodo{
    private String direccion;
    private Integer noCuartosDisponibles;
    private Integer cantidadPersonasxCuarto;
    private Integer codigoDestino;
    private Hotel siguiente;

    public Integer getCodigoDestino() {
        return codigoDestino;
    }

    public void setCodigoDestino(Integer codigoDestino) {
        this.codigoDestino = codigoDestino;
    }

    public Hotel getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Hotel siguiente) {
        this.siguiente = siguiente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getNoCuartosDisponibles() {
        return noCuartosDisponibles;
    }

    public void setNoCuartosDisponibles(Integer noCuartosDisponibles) {
        this.noCuartosDisponibles = noCuartosDisponibles;
    }

    public Integer getCantidadPersonasxCuarto() {
        return cantidadPersonasxCuarto;
    }

    public void setCantidadPersonasxCuarto(Integer cantidadPersonasxCuarto) {
        this.cantidadPersonasxCuarto = cantidadPersonasxCuarto;
    }



}
