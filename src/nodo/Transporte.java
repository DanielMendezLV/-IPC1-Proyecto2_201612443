package nodo;

import org.joda.time.DateTime;

/**
 * Created by danie on 04/11/2017.
 */
public class Transporte extends Nodo{
    //Aereolineas, Cruceros, Buses (
    private DateTime horaSalida;
    private DateTime horaEntrada;
    private Integer cantidadPasajeros;
    private Integer noAsiento;
    private String tipoTransporte;
    private Integer noDiasDuracion;
    private Transporte siguiente;

    //Campos crusero

    private DateTime fechaSalida;
    private DateTime fechaLlegada;
    private Integer codigoDestino;


    public DateTime getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(DateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public DateTime getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(DateTime fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Integer getCodigoDestino() {
        return codigoDestino;
    }

    public void setCodigoDestino(Integer codigoDestino) {
        this.codigoDestino = codigoDestino;
    }

    public Integer getNoDiasDuracion() {
        return noDiasDuracion;
    }

    public void setNoDiasDuracion(Integer noDiasDuracion) {
        this.noDiasDuracion = noDiasDuracion;
    }

    public Transporte getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Transporte siguiente) {
        this.siguiente = siguiente;
    }

    public DateTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(DateTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public DateTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(DateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Integer getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void setCantidadPasajeros(Integer cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public Integer getNoAsiento() {
        return noAsiento;
    }

    public void setNoAsiento(Integer noAsiento) {
        this.noAsiento = noAsiento;
    }



    public String getTipoTransporte() {
        return tipoTransporte;
    }

    public void setTipoTransporte(String tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }
}
