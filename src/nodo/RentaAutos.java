package nodo;

import org.joda.time.DateTime;

/**
 * Created by danie on 04/11/2017.
 */
public class RentaAutos extends Nodo{
    private Integer codigoEmpresaRenta;
    private Integer codCliente;
    private Integer cantidadPasajeros;
    private String tipoTerreno;
    private Integer diaUtilizar;
    private DateTime fechaEntrega;
    private DateTime fechaDevolucion;
    private String medidasSeguridad;

    public Integer getCodigoEmpresaRenta() {
        return codigoEmpresaRenta;
    }

    public void setCodigoEmpresaRenta(Integer codigoEmpresaRenta) {
        this.codigoEmpresaRenta = codigoEmpresaRenta;
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public Integer getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void setCantidadPasajeros(Integer cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public String getTipoTerreno() {
        return tipoTerreno;
    }

    public void setTipoTerreno(String tipoTerreno) {
        this.tipoTerreno = tipoTerreno;
    }

    public Integer getDiaUtilizar() {
        return diaUtilizar;
    }

    public void setDiaUtilizar(Integer diaUtilizar) {
        this.diaUtilizar = diaUtilizar;
    }

    public DateTime getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(DateTime fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public DateTime getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(DateTime fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getMedidasSeguridad() {
        return medidasSeguridad;
    }

    public void setMedidasSeguridad(String medidasSeguridad) {
        this.medidasSeguridad = medidasSeguridad;
    }
}
