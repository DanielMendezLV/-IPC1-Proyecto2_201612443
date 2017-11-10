package manejador;

import constantes.Const;
import nodo.Hotel;

/**
 * Created by danie on 04/11/2017.
 */
public class MHotel {
    private Hotel[] listaHotel;
    private Integer contador = 2;
    private Integer contadorGlobal = 2;
    private String tipoAMostrar;


    public Hotel[] getListaHotel() {
        return listaHotel;
    }

    public void setListaHotel(Hotel[] listaHotel) {
        this.listaHotel = listaHotel;
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

    public MHotel(){

        // Creates DateTime object with information like year, month,
        // day, hour, minute, second and milliseconds
        Hotel lujo= new Hotel();
        Hotel basico = new Hotel();

        lujo.setCodUnico(1);
        lujo.setDireccion("Panajachel ribiera maya");
        lujo.setNoCuartosDisponibles(10);
        lujo.setCantidadPersonasxCuarto(2);
        lujo.setCosto(2000);
        lujo.setTipoCAT(Const.LUJO);

        basico.setCodUnico(2);
        basico.setDireccion("Posada Carlos");
        basico.setNoCuartosDisponibles(4);
        basico.setCantidadPersonasxCuarto(8);
        basico.setCosto(500);
        basico.setTipoCAT(Const.ECONO);



        listaHotel = new Hotel[contador];
        listaHotel[0] = lujo;
        listaHotel[1] = basico;

    }



    public Boolean verifircarHotelSiYaExiste(String descripcion){
        for(int i = 0; i< listaHotel.length; i++){
            if(listaHotel[i].getStrDescripcion().equals(descripcion)){
                return true;
            }
        }
        return false;
    }


    public Hotel obtenerUSRXIdentificador(String id){
        for(int i = 0; i< listaHotel.length; i++){
            if(listaHotel[i].getCodUnico() == Integer.parseInt(id)){
                return listaHotel[i];
            }
        }
        return null;
    }

    public void eliminarXIdentificador(String id){
        Hotel[] listaClientesFlotante = this.getListaHotel();
        for(int i = 0; i< listaHotel.length; i++){
            if(listaHotel[i].getCodUnico() == Integer.parseInt(id)){
                listaClientesFlotante[i] = null;
                contador--;
            }
        }
        listaHotel = new Hotel[contador];
        Integer contadorIncersiones = 0;
        for(int i=0; i<listaClientesFlotante.length; i++){
            if(listaClientesFlotante[i]!=null){
                listaHotel[contadorIncersiones] = listaClientesFlotante[i];
                if(contadorIncersiones==(contador-1)){
                    return;
                }
                contadorIncersiones++;
            }
        }

    }


    public void agregarCliente(Hotel cl){
        Hotel[] listaClientesFlotante = this.getListaHotel();
        if(listaClientesFlotante==null){
            listaHotel[contador] =  cl;
        }else{
            contador++;
            contadorGlobal++;
            listaHotel = new Hotel[contador];
            cl.setCodUnico(contadorGlobal);
            for(int o = 0; o< (listaHotel.length-1) ; o++){
                listaHotel[o] = listaClientesFlotante[o];
            }
            listaHotel[contador-1] =  cl;
        }
    }

    public String[] obtenerListaID(){
        Hotel[] listaClientesFlotante = this.getListaHotel();
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
