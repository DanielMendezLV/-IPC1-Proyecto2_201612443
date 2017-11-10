package nodo;

import org.joda.time.DateTime;

/**
 * Created by danie on 04/11/2017.
 */
public class Usuario {
    private Integer codigoUnico;
    private String DPI;
    private String nombre;
    private String apellidos;
    private Integer tarjetaCredito;
    private DateTime fechaNacimiento;
    private Integer noTelefono;
    private Integer noMovil;
    private String direccion;
    private Integer saldoActual;
    private String rol;
    private String username;
    private String pass;
    private String clasificacionPorFrecuencia;
    private String clasificacionPorMonto;

    public String getClasificacionPorFrecuencia() {
        return clasificacionPorFrecuencia;
    }

    public void setClasificacionPorFrecuencia(String clasificacionPorFrecuencia) {
        this.clasificacionPorFrecuencia = clasificacionPorFrecuencia;
    }

    public String getClasificacionPorMonto() {
        return clasificacionPorMonto;
    }

    public void setClasificacionPorMonto(String clasificacionPorMonto) {
        this.clasificacionPorMonto = clasificacionPorMonto;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Integer getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(Integer codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public String  getDPI() {
        return DPI;
    }

    public void setDPI(String DPI) {
        this.DPI = DPI;
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

    public Integer getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(Integer tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public DateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(DateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getNoTelefono() {
        return noTelefono;
    }

    public void setNoTelefono(Integer noTelefono) {
        this.noTelefono = noTelefono;
    }

    public Integer getNoMovil() {
        return noMovil;
    }

    public void setNoMovil(Integer noMovil) {
        this.noMovil = noMovil;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(Integer saldoActual) {
        this.saldoActual = saldoActual;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
