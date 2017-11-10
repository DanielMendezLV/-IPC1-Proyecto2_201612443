package ventanas;

import constantes.Const;
import manejador.*;
import nodo.*;
import org.joda.time.DateTime;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by danie on 08/11/2017.
 */
public class VentanaCargaDescarga extends JFrame {
    MUsuario mUsuario;
    MTransporte mTransporte;
    MHotel mHotel;
    MRentaAutos mRentaAutos;
    MTour mTour;


    public VentanaCargaDescarga(MHotel mHotel, MRentaAutos mRentaAutos, MTour mTour, MTransporte mTransporte, MUsuario mUsuario){
        this.mUsuario = mUsuario;
        this.mTransporte =mTransporte;
        this.mHotel = mHotel;
        this.mRentaAutos = mRentaAutos;
        this.mTour = mTour;
        this.configurarPantalla();
    }

    public void configurarPantalla(){
        this.agregarComponentes(this.getContentPane());
        //Configuraciones
        setSize(300,100);
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setTitle("Proyecto 1");
        setLocationRelativeTo(null);
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Image miIcono = miPantalla.getImage("src/imagenes/icono1.png");
        setIconImage(miIcono);
    }

    public  void agregarComponentes(Container contentPane) {

        JButton btnDescargarTodos = new JButton();
        btnDescargarTodos.setSize(50, 50);
        btnDescargarTodos.setText("Descargar CVS");

        JButton btnSubir = new JButton();
        btnSubir.setSize(50, 50);
        btnSubir.setText("Importar CVS");

        JPanel pnlV = new JPanel();
        JPanel panelMedio = new JPanel();
        pnlV.setSize(150,150);


        pnlV.add(btnDescargarTodos);
        pnlV.add(btnSubir);

        panelMedio.add(pnlV);
        contentPane.add(panelMedio, BorderLayout.LINE_START);

        btnSubir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                for(int i=0; i< Const.LISTAARCHIVOS.length; i++){

                    try {
                        String rutaTotal = Const.RUTAARCHIVOSCARGA+Const.LISTAARCHIVOS[i];
                        BufferedReader br = new BufferedReader(new FileReader(rutaTotal));
                        StringBuilder sb = new StringBuilder();
                        String line = br.readLine();
                        Integer contadorIngresar=0;

                        while (line != null) {
                            contadorIngresar++;
                            sb.append(line);
                            sb.append("@");
                            line = br.readLine();
                        }

                        String everything = sb.toString();
                        everything =  everything.replace("-","/");
                        String[] array = everything.split("@");

                        if(Const.LISTAARCHIVOS[i].contains("AerolineasBuses")){
                            Transporte[] listaUsr = new Transporte[1];
                            mTransporte.setContador(1);
                            mTransporte.setContadorGlobal(1);
                            Transporte prTrans = new Transporte();

                            //Campos que se cargan
                            prTrans.setCodUnico(Integer.parseInt(array[1].split(",")[0]));
                            prTrans.setCantidadPasajeros(Integer.parseInt(array[1].split(",")[3]));
                            String horaSalida = array[1].split(",")[1];
                            String horaLlegada = array[1].split(",")[2];
                            prTrans.setHoraSalida(new DateTime(2015,5,5,Integer.parseInt(horaSalida.split(":")[0]),Integer.parseInt(horaSalida.split(":")[1]),0,0));
                            prTrans.setHoraEntrada(new DateTime(2015,5,5,Integer.parseInt(horaLlegada.split(":")[0]),Integer.parseInt(horaLlegada.split(":")[1]),0,0));

                            prTrans.setNoDiasDuracion(20);
                            prTrans.setNoAsiento(10);
                            prTrans.setTipoTransporte(Const.BUS);
                            prTrans.setCosto(150);
                            prTrans.setTipoCAT(Const.ECONO);
                            prTrans.setStrDescripcion("BUS");

                            listaUsr[0] = prTrans;
                            mTransporte.setListaUsr(listaUsr);

                            for(int sl =2 ; sl< array.length ; sl++){
                                Transporte pto = new Transporte();
                                //Campos que se cargan
                                pto.setCodUnico(Integer.parseInt(array[sl].split(",")[0]));
                                pto.setCantidadPasajeros(Integer.parseInt(array[sl].split(",")[3]));
                                horaSalida = array[sl].split(",")[1];
                                horaLlegada = array[sl].split(",")[2];
                                pto.setHoraSalida(new DateTime(2015,5,5,Integer.parseInt(horaSalida.split(":")[0]),Integer.parseInt(horaSalida.split(":")[1]),0,0));
                                pto.setHoraEntrada(new DateTime(2015,5,5,Integer.parseInt(horaLlegada.split(":")[0]),Integer.parseInt(horaLlegada.split(":")[1]),0,0));

                                pto.setNoDiasDuracion(20);
                                pto.setNoAsiento(10);
                                pto.setTipoTransporte(Const.BUS);
                                pto.setCosto(150);
                                pto.setTipoCAT(Const.ECONO);
                                pto.setStrDescripcion("BUS");
                                mTransporte.agregarCliente(pto);
                            }
                        }

                        if(Const.LISTAARCHIVOS[i].contains("HotelesResorts")){
                            Hotel[] listaUsr = new Hotel[1];
                            mHotel.setContador(1);
                            mHotel.setContadorGlobal(1);
                            Hotel prTrans = new Hotel();

                            //Campos que si se cargan
                            prTrans.setCodUnico(Integer.parseInt(array[1].split(",")[0]));
                            prTrans.setDireccion(array[1].split(",")[1]);
                            prTrans.setNoCuartosDisponibles(Integer.parseInt(array[1].split(",")[2]));
                            prTrans.setCodigoDestino(Integer.parseInt(array[1].split(",")[3]));
                            //Campos que no se traen de los archivos
                            prTrans.setCantidadPersonasxCuarto(2);
                            prTrans.setCosto(200);
                            prTrans.setTipoCAT(Const.ECONO);

                            listaUsr[0] = prTrans;
                            mHotel.setListaHotel(listaUsr);

                            for(int sl =2 ; sl< array.length ; sl++){
                                Hotel pto = new Hotel();
                                //Campos que se cargan
                                pto.setCodUnico(Integer.parseInt(array[sl].split(",")[0]));
                                pto.setDireccion(array[sl].split(",")[1]);
                                pto.setNoCuartosDisponibles(Integer.parseInt(array[sl].split(",")[2]));
                                pto.setCodigoDestino(Integer.parseInt(array[sl].split(",")[3]));
                                //Campos que no se traen de los archivos
                                pto.setCantidadPersonasxCuarto(2);
                                pto.setCosto(200);
                                pto.setTipoCAT(Const.ECONO);
                                mHotel.agregarCliente(pto);
                            }

                        }

                        if(Const.LISTAARCHIVOS[i].contains("Cruceros")){
                            for(int sl =1 ; sl< array.length ; sl++){
                                Transporte pto = new Transporte();
                                //Campos que se cargan
                                pto.setCantidadPasajeros(Integer.parseInt(array[sl].split(",")[3]));
                                pto.setNoDiasDuracion(Integer.parseInt(array[sl].split(",")[4]));
                                pto.setStrDescripcion(array[sl].split(",")[5]);
                                pto.setCodigoDestino(Integer.parseInt(array[sl].split(",")[6]));

                                String fSalida = array[sl].split(",")[1];
                                String fLlegada= array[sl].split(",")[2];

                                String[] fecha = fSalida.split("/");
                                pto.setFechaSalida(new DateTime(Integer.parseInt(fecha[2]),
                                        Integer.parseInt(fecha[1]), Integer.parseInt(fecha[0]),
                                        0,0,0));
                                fecha = fLlegada.split("/");
                                pto.setFechaLlegada(new DateTime(Integer.parseInt(fecha[2]),
                                        Integer.parseInt(fecha[1]), Integer.parseInt(fecha[0]),
                                        0,0,0));

                                pto.setNoAsiento(10);
                                pto.setTipoTransporte(Const.CRUZ);
                                pto.setCosto(150);
                                pto.setTipoCAT(Const.ECONO);
                                mTransporte.agregarCliente(pto);
                            }
                        }

                        if(Const.LISTAARCHIVOS[i].contains("Clientes")){
                            for(int sl =1 ; sl< array.length ; sl++){
                                Usuario usrAdmin = new Usuario();
                                usrAdmin.setNombre(array[sl].split(",")[1]);
                                usrAdmin.setApellidos(array[sl].split(",")[2]);
                                usrAdmin.setPass("123");
                                usrAdmin.setUsername(array[sl].split(",")[1]);
                                usrAdmin.setTarjetaCredito(Integer.parseInt(array[sl].split(",")[3]));

                                String fNAC = array[sl].split(",")[4];
                                String[] fecha = fNAC.split("/");
                                usrAdmin.setFechaNacimiento(new DateTime(Integer.parseInt(fecha[2]),
                                        Integer.parseInt(fecha[1]), Integer.parseInt(fecha[0]),
                                        0,0,0));
                                usrAdmin.setNoTelefono(Integer.parseInt(array[sl].split(",")[5]));
                                usrAdmin.setNoMovil(Integer.parseInt(array[sl].split(",")[6]));
                                usrAdmin.setDireccion(array[sl].split(",")[7]);
                                usrAdmin.setClasificacionPorFrecuencia(array[sl].split(",")[8]);
                                usrAdmin.setClasificacionPorMonto(array[sl].split(",")[9]);

                                usrAdmin.setDPI("2008201170101");
                                usrAdmin.setSaldoActual(5000);
                                usrAdmin.setRol(Const.CLIE);

                                mUsuario.agregarCliente(usrAdmin);
                            }

                        }

                        if(Const.LISTAARCHIVOS[i].contains("RentaAutos")){
                            RentaAutos[] listaUsr = new RentaAutos[1];
                            mRentaAutos.setContador(1);
                            mRentaAutos.setContadorGlobal(1);
                            RentaAutos prTrans = new RentaAutos();

                            String fNAC = array[1].split(",")[6];
                            String[] fecha = fNAC.split("/");

                            prTrans.setCodUnico(1);
                            prTrans.setCodigoEmpresaRenta(Integer.parseInt(array[1].split(",")[0]));
                            prTrans.setCodCliente(Integer.parseInt(array[1].split(",")[1]));
                            prTrans.setCantidadPasajeros(Integer.parseInt(array[1].split(",")[2]));
                            prTrans.setTipoTerreno(array[1].split(",")[3]);
                            prTrans.setDiaUtilizar(Integer.parseInt(array[1].split(",")[4]));
                            prTrans.setCosto(Integer.parseInt(array[1].split(",")[5]));
                            prTrans.setFechaEntrega(new DateTime(Integer.parseInt(fecha[2]),
                                    Integer.parseInt(fecha[1]), Integer.parseInt(fecha[0]),
                                    0,0,0));
                            fNAC = array[1].split(",")[7];
                            fecha = fNAC.split("/");

                            prTrans.setFechaDevolucion(new DateTime(Integer.parseInt(fecha[2]),
                                    Integer.parseInt(fecha[1]), Integer.parseInt(fecha[0]),
                                    0,0,0));
                            prTrans.setMedidasSeguridad(array[1].split(",")[8]);

                            listaUsr[0] = prTrans;
                            mRentaAutos.setListaRentaAutos(listaUsr);

                            for(int sl =2 ; sl< array.length ; sl++){
                                RentaAutos pto = new RentaAutos();
                                pto.setCodigoEmpresaRenta(Integer.parseInt(array[sl].split(",")[0]));
                                pto.setCodCliente(Integer.parseInt(array[sl].split(",")[1]));
                                pto.setCantidadPasajeros(Integer.parseInt(array[sl].split(",")[2]));
                                pto.setTipoTerreno(array[sl].split(",")[3]);
                                pto.setDiaUtilizar(Integer.parseInt(array[sl].split(",")[4]));
                                pto.setCosto(Integer.parseInt(array[sl].split(",")[5]));
                                pto.setFechaEntrega(new DateTime(Integer.parseInt(fecha[2]),
                                        Integer.parseInt(fecha[1]), Integer.parseInt(fecha[0]),
                                        0,0,0));
                                fNAC = array[sl].split(",")[7];
                                fecha = fNAC.split("/");

                                pto.setFechaDevolucion(new DateTime(Integer.parseInt(fecha[2]),
                                        Integer.parseInt(fecha[1]), Integer.parseInt(fecha[0]),
                                        0,0,0));
                                pto.setMedidasSeguridad(array[sl].split(",")[8]);
                                mRentaAutos.agregarCliente(pto);
                            }

                        }


                        if(Const.LISTAARCHIVOS[i].contains("DestinosTuristicos")){
                            Tour[] listaUsr = new Tour[1];
                            mTour.setContador(1);
                            mTour.setContadorGlobal(1);
                            Tour prTrans = new Tour();

                            prTrans.setCodUnico(1);
                            prTrans.setPais((array[1].split(",")[1]));
                            prTrans.setCiudad((array[1].split(",")[2]));
                            prTrans.setDireccion((array[1].split(",")[3]));
                            prTrans.setNombre((array[1].split(",")[4]));
                            prTrans.setDescripcion((array[1].split(",")[5]));
                            prTrans.setRecomendacionesSeguridad((array[1].split(",")[6]));
                            prTrans.setTipo(Const.DESTINOTURIS);

                            listaUsr[0] = prTrans;
                            mTour.setListaTour(listaUsr);
                            for(int sl =2 ; sl< array.length ; sl++) {
                                Tour pto = new Tour();
                                pto.setPais((array[sl].split(",")[1]));
                                pto.setCiudad((array[sl].split(",")[2]));
                                pto.setDireccion((array[sl].split(",")[3]));
                                pto.setNombre((array[sl].split(",")[4]));
                                pto.setDescripcion((array[sl].split(",")[5]));
                                pto.setRecomendacionesSeguridad((array[sl].split(",")[6]));
                                pto.setTipo(Const.DESTINOTURIS);
                                mTour.agregarCliente(pto);
                            }
                        }

                        if(Const.LISTAARCHIVOS[i].contains("LugaresE_E")){
                            for(int sl =1 ; sl< array.length ; sl++) {
                                Tour pto = new Tour();
                                pto.setNombre((array[sl].split(",")[1]));
                                pto.setDescripcion((array[sl].split(",")[2]));
                                pto.setPais((array[sl].split(",")[3]));
                                pto.setCiudad((array[sl].split(",")[4]));
                                pto.setDireccion((array[sl].split(",")[5]));
                                pto.setMinimoEdadPermitida(Integer.parseInt((array[sl].split(",")[6])));
                                String ns = array[sl].split(",")[7];
                                pto.setHorarios(new DateTime(2017,1,1,Integer.parseInt(ns.split(":")[0]),
                                        Integer.parseInt(ns.split(":")[1])));
                                pto.setRecomendacionesSeguridad((array[sl].split(",")[9]));
                                pto.setTipo(Const.ESPECENTRET);
                                mTour.agregarCliente(pto);
                            }
                        }






                    }catch (IOException e) {

                    }
                }

            }
        });

        btnDescargarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {


            }
        });




    }
}
