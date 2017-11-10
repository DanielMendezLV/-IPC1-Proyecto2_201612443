package manejador;

import constantes.Const;
import nodo.Tour;
import nodo.Tour;
import org.joda.time.DateTime;

/**
 * Created by danie on 05/11/2017.
 */
public class MTour {
    private Tour[] listaTour;
    private Integer contador = 2;
    private Integer contadorGlobal = 2;
    private String tipoAMostrar;


    public Tour[] getListaTour() {
        return listaTour;
    }

    public void setListaTour(Tour[] listaTour) {
        this.listaTour = listaTour;
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

    public MTour(){

        // Creates DateTime object with information like year, month,
        // day, hour, minute, second and milliseconds
//
//        Tour basico = new Tour();
//
//        basico.setCodUnico(2);
//        basico.setTipo(Const.ESPECENTRET);
//        basico.setNombre("Tikal");
//        basico.setDescripcion("Peten grande");
//        basico.setPais("Guatemala");
//        basico.setCiudad("Penten");
//        basico.setDireccion("Ciudad GT");
//        basico.setMinimoEdadPermitida(10);
//        basico.setFecha(new DateTime(2016,3,10,0,0,0));
//        basico.setHorarios(new DateTime(2016,3,10,11,10,0));
//        basico.setRecomendacionesSeguridad("Sea consistente");

        listaTour = new Tour[contador];
//        listaTour[1] = basico;

    }



    public Boolean verifircarTourSiYaExiste(String descripcion){
        for(int i = 0; i< listaTour.length; i++){
            if(listaTour[i].getStrDescripcion().equals(descripcion)){
                return true;
            }
        }
        return false;
    }


    public Tour obtenerUSRXIdentificador(String id){
        for(int i = 0; i< listaTour.length; i++){
            if(listaTour[i].getCodUnico() == Integer.parseInt(id)){
                return listaTour[i];
            }
        }
        return null;
    }

    public void eliminarXIdentificador(String id){
        Tour[] listaClientesFlotante = this.getListaTour();
        for(int i = 0; i< listaTour.length; i++){
            if(listaTour[i].getCodUnico() == Integer.parseInt(id)){
                listaClientesFlotante[i] = null;
                contador--;
            }
        }
        listaTour = new Tour[contador];
        Integer contadorIncersiones = 0;
        for(int i=0; i<listaClientesFlotante.length; i++){
            if(listaClientesFlotante[i]!=null){
                listaTour[contadorIncersiones] = listaClientesFlotante[i];
                if(contadorIncersiones==(contador-1)){
                    return;
                }
                contadorIncersiones++;
            }
        }

    }


    public void agregarCliente(Tour cl){
        Tour[] listaClientesFlotante = this.getListaTour();
        if(listaClientesFlotante==null){
            listaTour[contador] =  cl;
        }else{
            contador++;
            contadorGlobal++;
            listaTour = new Tour[contador];
            cl.setCodUnico(contadorGlobal);
            for(int o = 0; o< (listaTour.length-1) ; o++){
                listaTour[o] = listaClientesFlotante[o];
            }
            listaTour[contador-1] =  cl;
        }
    }

    public String[] obtenerListaID(){
        Tour[] listaClientesFlotante = this.getListaTour();
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
