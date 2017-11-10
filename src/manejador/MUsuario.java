package manejador;

import constantes.Const;
import nodo.Usuario;
import org.joda.time.DateTime;

/**
 * Created by danie on 05/11/2017.
 */
public class MUsuario {

    private Usuario[] listaUsr;
    private Integer contador = 1;
    private Integer contadorGlobal = 1;
    private Usuario usrLogueado;

    public Usuario[] getListaUsr() {
        return listaUsr;
    }

    public void setListaUsr(Usuario[] listaUsr) {
        this.listaUsr = listaUsr;
    }

    public Usuario getUsrLogueado() {
        return usrLogueado;
    }

    public void setUsrLogueado(Usuario usrLogueado) {
        this.usrLogueado = usrLogueado;
    }

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }

    public MUsuario(){

        // Creates DateTime object with information like year, month,
        // day, hour, minute, second and milliseconds

        Usuario usrAdmin = new Usuario();
        Usuario usrEmpleado = new Usuario();
        Usuario usrCliente = new Usuario();

        usrAdmin.setNombre("Daniel");
        usrAdmin.setApellidos("Mendez");
        usrAdmin.setPass("dan");
        usrAdmin.setUsername("dan");
        usrAdmin.setCodigoUnico(1);
        usrAdmin.setDireccion("Ciudad");
        usrAdmin.setDPI("2008201170101");
        usrAdmin.setTarjetaCredito(null);
        DateTime dtFechaNac = new DateTime(2017,5,22,0,0,0,0);
        usrAdmin.setFechaNacimiento(dtFechaNac);
        usrAdmin.setNoTelefono(42469320);
        usrAdmin.setNoMovil(42469320);
        usrAdmin.setSaldoActual(null);
        usrAdmin.setRol(Const.ADM);
        usrCliente.setClasificacionPorFrecuencia("ANUAL");
        usrCliente.setClasificacionPorMonto(Const.ECONO);

        listaUsr = new Usuario[contador];
        listaUsr[0] = usrAdmin;

    }

    public Boolean verificarCliente(String username, String pass){
        for(int i=0; i<listaUsr.length; i++){
            if(listaUsr[i].getUsername().equals(username) && listaUsr[i].getPass().equals(pass)){
                this.usrLogueado = listaUsr[i];
                return true;
            }
        }
        return false;
    }

    public Boolean verifircarUsuarioSiYaExiste(String username){
        for(int i=0; i<listaUsr.length; i++){
            if(listaUsr[i].getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }


    public Usuario obtenerClienteXUsername(String username){
        for(int i=0; i<listaUsr.length; i++){
            if(listaUsr[i].getUsername().equals(username)){
                return listaUsr[i];
            }
        }
        return null;
    }

    public Usuario obtenerUSRXIdentificador(String id){
        for(int i=0; i<listaUsr.length; i++){
            if(listaUsr[i].getCodigoUnico() == Integer.parseInt(id)){
                return listaUsr[i];
            }
        }
        return null;
    }

    public void eliminarXIdentificador(String id){
        Usuario[] listaClientesFlotante = this.getListaUsr();
        for(int i=0; i<listaUsr.length; i++){
            if(listaUsr[i].getCodigoUnico() == Integer.parseInt(id)){
                listaClientesFlotante[i] = null;
                contador--;
            }
        }
        listaUsr = new Usuario[contador];
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


    public void agregarCliente(Usuario cl){
        Usuario[] listaClientesFlotante = this.getListaUsr();
        if(listaClientesFlotante==null){
            listaUsr[contador] =  cl;
        }else{
            contador++;
            contadorGlobal++;
            listaUsr = new Usuario[contador];
            cl.setCodigoUnico(contadorGlobal);
            for(int o=0;  o< (listaUsr.length-1) ; o++){
                listaUsr[o] = listaClientesFlotante[o];
            }
            listaUsr[contador-1] =  cl;
        }
    }

    public String[] obtenerListaID(){
        Usuario[] listaClientesFlotante = this.getListaUsr();
        String id ="";
        for(int s=0; s<listaClientesFlotante.length; s++){
            if(id.isEmpty()){
                id = ""+listaClientesFlotante[s].getCodigoUnico();
            }else{
                id = id + "," +listaClientesFlotante[s].getCodigoUnico();
            }
        }
        return id.split(",");
    }



}
