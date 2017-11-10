package constantes;

import javax.swing.*;

/**
 * Created by danie on 04/11/2017.
 */
public class Const {
//    Roles
    public static String ADM = "admin";
    public static String GER = "gerente";
    public static String CLIE = "cliente";
    public static String EMPL = "empleado";
    public static String SELCT = "seleccione";
//    Aerelíneas y buses
    public static String AER = "aereolinea";
    public static String BUS = "bus";
    public static String CRUZ = "cruzero";
//  Categorias
    public static String ECONO = "Básico";
    public static String LUJO = "Premium";
    public static String NEGO = "Platino";
//  Tipo Tour
    public static String ESPECENTRET = "Espectaculo y entretenimiento";
    public static String DESTINOTURIS = "Destino turistico";
//  Mapeo de pojos
    private static String HOTEL = "Hotel";
    private static String RENTAAUTO = "Renta Auto";
    private static String TOUR = "Tour";
    private static String TRANSPORTE = "Transporte";
    private static String USUARIO = "Usuario";
    public static String[] LISTAARCHIVOS = {"01 AerolineasBuses.csv",
                                            "02 HotelesResorts.csv","03 Cruceros.csv","05 Clientes.csv",
                                            "06 DestinosTuristicos.csv",  "07 LugaresE_E.csv","10 RentaAutos.csv"
                                            };
    private static String USUARIOARCHIVO = "danie";
    public static String RUTAARCHIVOSCARGA = "C:/Users/"+ USUARIOARCHIVO + "/Desktop/Proyecto_2_L_201612443/src/archivoscvs/Carga/";
    public static String RUTAARCHIVOSDES = "C:/Users/"+ USUARIOARCHIVO + "/Desktop/Proyecto_2_L_201612443/src/archivoscvs/Descarga/";


    public static void msjCola(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }

    public static Boolean isNumber(String text){
        Boolean bandera = false;
        try{
            Float.parseFloat(text);
            bandera = true;
        }catch(Exception e){
        }
        return bandera;
    }

    public static String[] obtener2Transportes(){
        String[] liTipoTransporte = {Const.SELCT,Const.BUS, Const.AER};
        return liTipoTransporte;
    }

    public static String[] obtener1Transportes(){
        String[] liTipoTransporte = {Const.SELCT,Const.CRUZ};
        return liTipoTransporte;
    }

}
