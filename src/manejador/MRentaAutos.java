package manejador;

import constantes.Const;
import nodo.RentaAutos;
import org.joda.time.DateTime;

/**
 * Created by danie on 05/11/2017.
 */
public class MRentaAutos {
    private RentaAutos[] listaRentaAutos;
    private Integer contador = 1;
    private Integer contadorGlobal = 1;
    private String tipoAMostrar;


    public RentaAutos[] getListaRentaAutos() {
        return listaRentaAutos;
    }

    public void setListaRentaAutos(RentaAutos[] listaRentaAutos) {
        this.listaRentaAutos = listaRentaAutos;
    }

    public String getTipoAMostrar() {
        return tipoAMostrar;
    }

    public void setTipoAMostrar(String tipoAMostrar) {
        this.tipoAMostrar = tipoAMostrar;
    }

    public Integer getContadorGlobal() {
        return contadorGlobal;
    }

    public void setContadorGlobal(Integer contadorGlobal) {
        this.contadorGlobal = contadorGlobal;
    }



    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }

    public MRentaAutos(){

        // Creates DateTime object with information like year, month,
        // day, hour, minute, second and milliseconds
        listaRentaAutos = new RentaAutos[contador];

    }



    public Boolean verifircarRentaAutosSiYaExiste(String descripcion){
        for(int i = 0; i< listaRentaAutos.length; i++){
            if(listaRentaAutos[i].getStrDescripcion().equals(descripcion)){
                return true;
            }
        }
        return false;
    }


    public RentaAutos obtenerUSRXIdentificador(String id){
        for(int i = 0; i< listaRentaAutos.length; i++){
            if(listaRentaAutos[i].getCodUnico() == Integer.parseInt(id)){
                return listaRentaAutos[i];
            }
        }
        return null;
    }

    public void eliminarXIdentificador(String id){
        RentaAutos[] listaClientesFlotante = this.getListaRentaAutos();
        for(int i = 0; i< listaRentaAutos.length; i++){
            if(listaRentaAutos[i].getCodUnico() == Integer.parseInt(id)){
                listaClientesFlotante[i] = null;
                contador--;
            }
        }
        listaRentaAutos = new RentaAutos[contador];
        Integer contadorIncersiones = 0;
        for(int i=0; i<listaClientesFlotante.length; i++){
            if(listaClientesFlotante[i]!=null){
                listaRentaAutos[contadorIncersiones] = listaClientesFlotante[i];
                if(contadorIncersiones==(contador-1)){
                    return;
                }
                contadorIncersiones++;
            }
        }

    }


    public void agregarCliente(RentaAutos cl){
        RentaAutos[] listaClientesFlotante = this.getListaRentaAutos();
        if(listaClientesFlotante==null){
            listaRentaAutos[contador] =  cl;
        }else{
            contador++;
            contadorGlobal++;
            listaRentaAutos = new RentaAutos[contador];
            cl.setCodUnico(contadorGlobal);
            for(int o = 0; o< (listaRentaAutos.length-1) ; o++){
                listaRentaAutos[o] = listaClientesFlotante[o];
            }
            listaRentaAutos[contador-1] =  cl;
        }
    }

    public String[] obtenerListaID(){
        RentaAutos[] listaClientesFlotante = this.getListaRentaAutos();
        String id ="";
        for(int s=0; s<listaClientesFlotante.length; s++){
            if(id.isEmpty()){
                id = ""+listaClientesFlotante[s].getCodUnico();
            }else{
                id = id + "," +listaClientesFlotante[s].getCodUnico();
            }
        }
        return id.split(",");
    }

}
