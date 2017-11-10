package manejador;

import constantes.Const;
import nodo.Transporte;
import nodo.Transporte;
import org.joda.time.DateTime;

/**
 * Created by danie on 05/11/2017.
 */
public class MTransporte {
    private Transporte[] listaUsr;
    private Integer contador = 3;
    private Integer contadorGlobal = 3;
    private String tipoAMostrar;


    public Transporte[] getListaUsr() {
        return listaUsr;
    }

    public void setListaUsr(Transporte[] listaUsr) {
        this.listaUsr = listaUsr;
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

    public MTransporte(){

        // Creates DateTime object with information like year, month,
        // day, hour, minute, second and milliseconds
        Transporte aereolinea= new Transporte();
        Transporte crucero = new Transporte();
        Transporte bus = new Transporte();

        aereolinea.setCodUnico(1);
        aereolinea.setCantidadPasajeros(10);
        aereolinea.setHoraEntrada(new DateTime(2015,5,5,10,50,0,0));
        aereolinea.setHoraSalida(new DateTime(2015,5,5,11,50,0,0));
        aereolinea.setNoDiasDuracion(20);
        aereolinea.setNoAsiento(10);
        aereolinea.setTipoTransporte(Const.AER);
        aereolinea.setCosto(50000);
        aereolinea.setTipoCAT(Const.LUJO);
        aereolinea.setStrDescripcion("Avion al ESPANA");

        crucero.setCodUnico(2);
        crucero.setCantidadPasajeros(20);
        crucero.setHoraEntrada(new DateTime(2015,5,5,14,50,0,0));
        crucero.setHoraSalida(new DateTime(2015,5,5,15,50,0,0));
        crucero.setNoDiasDuracion(30);
        crucero.setNoAsiento(20);
        crucero.setTipoTransporte(Const.CRUZ);
        crucero.setCosto(2000);
        crucero.setTipoCAT(Const.ECONO);
        crucero.setStrDescripcion("Crucero al SALVADOR");

        bus.setCodUnico(3);
        bus.setCantidadPasajeros(50);
        bus.setHoraEntrada(new DateTime(2015,5,5,16,50,0,0));
        bus.setHoraSalida(new DateTime(2015,5,5,17,50,0,0));
        bus.setNoDiasDuracion(25);
        bus.setNoAsiento(10);
        bus.setTipoTransporte(Const.BUS);
        bus.setCosto(150);
        bus.setTipoCAT(Const.ECONO);
        bus.setStrDescripcion("Bus al SALVADOR");


        listaUsr = new Transporte[contador];
        listaUsr[0] = aereolinea;
        listaUsr[1] = crucero;
        listaUsr[2] = bus;
    }



    public Boolean verifircarTransporteSiYaExiste(String descripcion){
        for(int i=0; i<listaUsr.length; i++){
            if(listaUsr[i].getStrDescripcion().equals(descripcion)){
                return true;
            }
        }
        return false;
    }


    public Transporte obtenerUSRXIdentificador(String id){
        for(int i=0; i<listaUsr.length; i++){
            if(listaUsr[i].getCodUnico() == Integer.parseInt(id)){
                return listaUsr[i];
            }
        }
        return null;
    }

    public void eliminarXIdentificador(String id){
        Transporte[] listaClientesFlotante = this.getListaUsr();
        for(int i=0; i<listaUsr.length; i++){
            if(listaUsr[i].getCodUnico() == Integer.parseInt(id)){
                listaClientesFlotante[i] = null;
                contador--;
            }
        }
        listaUsr = new Transporte[contador];
        Integer contadorIncersiones = 0;
        for(int i=0; i<listaClientesFlotante.length; i++){
            if(listaClientesFlotante[i]!=null){
                listaUsr[contadorIncersiones] = listaClientesFlotante[i];
                if(contadorIncersiones==(contador-1)){
                    return;
                }
                contadorIncersiones++;
            }
        }

    }


    public void agregarCliente(Transporte cl){
        Transporte[] listaClientesFlotante = this.getListaUsr();
        if(listaClientesFlotante==null){
            listaUsr[contador] =  cl;
        }else{
            contador++;
            contadorGlobal++;
            listaUsr = new Transporte[contador];
            cl.setCodUnico(contadorGlobal);
            for(int o=0;  o< (listaUsr.length-1) ; o++){
                listaUsr[o] = listaClientesFlotante[o];
            }
            listaUsr[contador-1] =  cl;
        }
    }

    public String[] obtenerListaID(){
        Transporte[] listaClientesFlotante = this.getListaUsr();
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
