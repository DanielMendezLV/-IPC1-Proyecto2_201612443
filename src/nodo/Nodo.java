package nodo;

/**
 * Created by danie on 04/11/2017.
 */
public class Nodo {
    private String miTipoClase;
    private String tipoCAT;
    private Integer costo;
    private Integer codUnico;
    private String strDescripcion;

    public String getStrDescripcion() {
        return strDescripcion;
    }

    public void setStrDescripcion(String strDescripcion) {
        this.strDescripcion = strDescripcion;
    }

    public Integer getCodUnico() {
        return codUnico;
    }

    public void setCodUnico(Integer codUnico) {
        this.codUnico = codUnico;
    }

    public String getTipoCAT() {
        return tipoCAT;
    }

    public void setTipoCAT(String tipoCAT) {
        this.tipoCAT = tipoCAT;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public String getMiTipoClase() {
        return miTipoClase;
    }

    public void setMiTipoClase(String miTipoClase) {
        this.miTipoClase = miTipoClase;
    }

}
