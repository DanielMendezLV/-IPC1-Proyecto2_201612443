package ventanas;

import constantes.Const;
import manejador.MTransporte;
import nodo.Transporte;
import nodo.Usuario;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by danie on 06/11/2017.
 */
public class VentanaTransporte extends JFrame {
    MTransporte mTransporte;
    JTable table;
    JScrollPane jspane;
    Transporte transporteEdit;
    String tipo;
    JComboBox  cmbSeleccionUsuarioCodigo;


    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public VentanaTransporte(MTransporte mTransporte, String tipo){
        this.mTransporte = mTransporte;
        this.tipo = tipo;
        this.configurarPantalla();
    }

    public void configurarPantalla(){
        this.agregarComponentes(this.getContentPane());
        //Configuraciones
        setSize(1200,600);
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
        contentPane.setLayout(new BorderLayout(5,5));

        JLabel  lblDescripcion = new JLabel("Descripcion",SwingConstants.LEFT);
        JLabel  lblCantidadPasajero= new JLabel("Cantidad pasajeros: ", SwingConstants.LEFT);
        JLabel  lblHoraEntrada= new JLabel("Hora entrada: ", SwingConstants.LEFT);
        JLabel  lblHoraSalida= new JLabel("Hora salida: ", JLabel.LEFT);
        JLabel  lblDiaDuracion= new JLabel("No. dias duracion : ", JLabel.LEFT);
        JLabel  lblNoAsiento= new JLabel("No asiento: ", JLabel.LEFT);
        JLabel  lblTipoTrans= new JLabel("Tipo transporte : ", JLabel.LEFT);
        JLabel  lblCosto= new JLabel("Costo : ", JLabel.LEFT);
        JLabel  lblCategoria= new JLabel("Categoria: ", JLabel.LEFT);

        //CAMPOS DE CRUZERO
        JLabel  lblFechaSalida = new JLabel("Fecha salida:", JLabel.LEFT);
        JLabel  lblFechaLlegada = new JLabel("Fecha llegada:", JLabel.LEFT);
        JLabel  lblCodigoDestino = new JLabel("Codigo destino:", JLabel.LEFT);


        JTextField txtDescripcion = new JTextField(6);
        JTextField txtCantidadPasajero = new JTextField(6);
        JTextField txtHoraEntrada = new JTextField(6);
        JTextField txtHoraSalida = new JTextField(6);
        JTextField txtDiaDuracion = new JTextField(6);
        JTextField txtNoAsiento = new JTextField(6);
        JTextField txtCosto = new JTextField(6);

        //CAMPOS DE CRUZERO
        JTextField txtFechaSalida = new JTextField(6);
        JTextField txtFechaLlegada = new JTextField(6);
        JTextField txtCodigoDestino = new JTextField(6);


        String[] liCategoria = {Const.SELCT,Const.ECONO, Const.LUJO, Const.NEGO};
        String[] liTipoTransporte;

        if(tipo.equals(Const.AER)){
            liTipoTransporte = Const.obtener2Transportes();

        } else{
            liTipoTransporte = Const.obtener1Transportes();
        }

        JComboBox cmbCategoria = new JComboBox(liCategoria);
        JComboBox cmbTipoTrans = new JComboBox(liTipoTransporte);


        JButton btnAgregar = new JButton();
        btnAgregar.setSize(50, 50);
        btnAgregar.setText("Agregar");

        JPanel pnlV = new JPanel();
        JPanel panelMedio = new JPanel();

        pnlV.setSize(150,150);
        BoxLayout boxlayoutPedazo = new BoxLayout(pnlV, BoxLayout.Y_AXIS);
        pnlV.setLayout(boxlayoutPedazo);


        //Combo y botones para cargar/editar y eliminar;
        JPanel panelHorizontal = new JPanel();
        BoxLayout boxLayoutHorizontal = new BoxLayout(panelHorizontal, BoxLayout.X_AXIS);
        panelHorizontal.setLayout(boxLayoutHorizontal);
        JPanel panelFondo = new JPanel();



        JLabel lblSeleccione = new JLabel("Seleccione un usuario");
        cmbSeleccionUsuarioCodigo = new JComboBox(mTransporte.obtenerListaID());

        JButton btnCargar = new JButton("Cargar");
        JButton btnEditar = new JButton("Editar");
        JButton btnEliminar = new JButton("Eliminar");

        panelHorizontal.add(lblSeleccione);
        panelHorizontal.add(Box.createRigidArea(new Dimension(10,0)));
        panelHorizontal.add(cmbSeleccionUsuarioCodigo);
        panelHorizontal.add(Box.createRigidArea(new Dimension(10,0)));
        panelHorizontal.add(btnCargar);
        panelHorizontal.add(Box.createRigidArea(new Dimension(10,0)));
        panelHorizontal.add(btnEditar);
        panelHorizontal.add(Box.createRigidArea(new Dimension(10,0)));
        panelHorizontal.add(btnEliminar);


        panelFondo.add(panelHorizontal);
        panelFondo.add(panelHorizontal);


        pnlV.add(lblDescripcion);
        pnlV.add(txtDescripcion);

        pnlV.add(lblCantidadPasajero);
        pnlV.add(txtCantidadPasajero);

        if(tipo.equals(Const.AER)){
            pnlV.add(lblHoraEntrada);
            pnlV.add(txtHoraEntrada);
            pnlV.add(lblHoraSalida);
            pnlV.add(txtHoraSalida);
        }else{
            pnlV.add(lblFechaLlegada);
            pnlV.add(txtFechaLlegada);
            pnlV.add(lblFechaSalida);
            pnlV.add(txtFechaSalida);
            pnlV.add(lblCodigoDestino);
            pnlV.add(txtCodigoDestino);
        }

        pnlV.add(lblDiaDuracion);
        pnlV.add(txtDiaDuracion);
        pnlV.add(lblNoAsiento);
        pnlV.add(txtNoAsiento);
        pnlV.add(lblTipoTrans);
        pnlV.add(lblCosto);
        pnlV.add(txtCosto);
        pnlV.add(lblCategoria);
        pnlV.add(cmbCategoria);
        pnlV.add(lblTipoTrans);
        pnlV.add(cmbTipoTrans);


        pnlV.add(btnAgregar);

        panelMedio.add(pnlV);
        contentPane.add(panelMedio, BorderLayout.LINE_START);
        contentPane.add(panelFondo, BorderLayout.PAGE_END);
        this.pintarTabla(this.getContentPane());




        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Transporte us = mTransporte.obtenerUSRXIdentificador(cmbSeleccionUsuarioCodigo.getSelectedItem().toString());
                transporteEdit = us;


                txtDescripcion.setText(us.getStrDescripcion());
                txtCantidadPasajero.setText(us.getCantidadPasajeros().toString());
                txtDiaDuracion.setText(us.getNoDiasDuracion().toString());
                txtNoAsiento.setText(us.getNoAsiento().toString());
                txtCosto.setText(us.getCosto().toString());

                if(tipo.equals(Const.AER)){
                    DateTimeFormatter fmt = DateTimeFormat.forPattern("HH:mm");
                    String str = fmt.print(us.getHoraEntrada());
                    txtHoraEntrada.setText(str);
                    txtHoraSalida.setText(fmt.print(us.getHoraSalida()));
                }else{
                    DateTimeFormatter fecha = DateTimeFormat.forPattern("dd/MM/yyyy");
                    String f = fecha.print(us.getFechaLlegada());
                    txtFechaLlegada.setText(f);
                    txtFechaSalida.setText(fecha.print(us.getFechaSalida()));
                    txtCodigoDestino.setText(us.getCodigoDestino().toString());
                }


                if(us.getTipoTransporte().equals(Const.BUS)){
                    cmbTipoTrans.setSelectedIndex(1);
                }

                if(us.getTipoTransporte().equals(Const.AER)){
                    cmbTipoTrans.setSelectedIndex(2);
                }

                if(us.getTipoTransporte().equals(Const.CRUZ)){
                    cmbTipoTrans.setSelectedIndex(1);
                }

                //Const.SELCT,Const.ECONO, Const.LUJO, Const.NEGO

                if(us.getTipoCAT().equals(Const.ECONO)){
                    cmbCategoria.setSelectedIndex(1);
                }

                if(us.getTipoCAT().equals(Const.LUJO)){
                    cmbCategoria.setSelectedIndex(2);
                }

                if(us.getTipoCAT().equals(Const.NEGO)){
                    cmbCategoria.setSelectedIndex(3);
                }
            }
        });

        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mTransporte.eliminarXIdentificador(cmbSeleccionUsuarioCodigo.getSelectedItem().toString());
                pintarTabla(contentPane);
                cmbSeleccionUsuarioCodigo = new JComboBox(mTransporte.obtenerListaID());
                Const.msjCola("Transporte eliminado exitosamente");
            }
        });

        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               if(transporteEdit!=null) {
                   if(!cmbCategoria.getSelectedItem().toString().equals(Const.SELCT) && !cmbTipoTrans.getSelectedItem().toString().equals(Const.SELCT)){
                       Transporte ts = transporteEdit;
                       if(Const.isNumber(txtCantidadPasajero.getText())
                               && Const.isNumber(txtDiaDuracion.getText())
                               && Const.isNumber(txtNoAsiento.getText())
                               && Const.isNumber(txtCosto.getText())
                               ){

                           ts.setTipoTransporte(cmbTipoTrans.getSelectedItem().toString());
                           ts.setTipoCAT(cmbCategoria.getSelectedItem().toString());
                           ts.setStrDescripcion(txtDescripcion.getText());
                           ts.setCantidadPasajeros(Integer.parseInt(txtCantidadPasajero.getText()));
                           if(tipo.equals(Const.AER)){

                               ts.setHoraEntrada(new DateTime(2015,5,5,Integer.parseInt(txtHoraEntrada.getText().split(":")[0])
                                       ,Integer.parseInt(txtHoraEntrada.getText().split(":")[1]),0,0));
                               ts.setHoraSalida(new DateTime(2015,5,5,Integer.parseInt(txtHoraSalida.getText().split(":")[0])
                                       ,Integer.parseInt(txtHoraSalida.getText().split(":")[1]),0,0));

                           }else{
                               String[] fecha = txtFechaLlegada.getText().split("/");
                               ts.setFechaLlegada(new DateTime(Integer.parseInt(fecha[2]),
                                       Integer.parseInt(fecha[1]), Integer.parseInt(fecha[0]),
                                       0,0,0));
                               fecha = txtFechaSalida.getText().split("/");
                               ts.setFechaLlegada(new DateTime(Integer.parseInt(fecha[2]),
                                       Integer.parseInt(fecha[1]), Integer.parseInt(fecha[0]),
                                       0,0,0));
                               ts.setCodigoDestino(Integer.parseInt(txtCodigoDestino.getText()));
                           }
                           ts.setNoDiasDuracion(Integer.parseInt(txtDiaDuracion.getText()));
                           ts.setNoAsiento(Integer.parseInt(txtNoAsiento.getText()));
                           ts.setCosto(Integer.parseInt(txtCosto.getText()));
                           pintarTabla(contentPane);
                           Const.msjCola("Transporte editado exitosamente");
                       }else{
                           Const.msjCola("Debe de tener una cantidad, dia, no asiento y costo valido y deben ser númericos");
                           return;
                       }
                   }else{
                       Const.msjCola("Seleccione una categoria, servicio valido");
                   }
               }else{
                   Const.msjCola("Cargue un transporte existente");
               }
            }
        });



        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(!cmbCategoria.getSelectedItem().toString().equals(Const.SELCT) && !cmbTipoTrans.getSelectedItem().toString().equals(Const.SELCT)){
                    Transporte ts = new Transporte();
                    if(Const.isNumber(txtCantidadPasajero.getText())
                            && Const.isNumber(txtDiaDuracion.getText())
                            && Const.isNumber(txtNoAsiento.getText())
                            && Const.isNumber(txtCosto.getText())
                            ){

                            ts.setTipoTransporte(cmbTipoTrans.getSelectedItem().toString());
                            ts.setTipoCAT(cmbCategoria.getSelectedItem().toString());
                            ts.setStrDescripcion(txtDescripcion.getText());
                            ts.setCantidadPasajeros(Integer.parseInt(txtCantidadPasajero.getText()));

                            if(tipo.equals(Const.AER)){

                                ts.setHoraEntrada(new DateTime(2015,5,5,Integer.parseInt(txtHoraEntrada.getText().split(":")[0])
                                        ,Integer.parseInt(txtHoraEntrada.getText().split(":")[1]),0,0));
                                ts.setHoraSalida(new DateTime(2015,5,5,Integer.parseInt(txtHoraSalida.getText().split(":")[0])
                                        ,Integer.parseInt(txtHoraSalida.getText().split(":")[1]),0,0));

                            }else{
                                String[] fecha = txtFechaLlegada.getText().split("/");
                                ts.setFechaLlegada(new DateTime(Integer.parseInt(fecha[2]),
                                        Integer.parseInt(fecha[1]), Integer.parseInt(fecha[0]),
                                        0,0,0));
                                fecha = txtFechaSalida.getText().split("/");
                                ts.setFechaLlegada(new DateTime(Integer.parseInt(fecha[2]),
                                        Integer.parseInt(fecha[1]), Integer.parseInt(fecha[0]),
                                        0,0,0));
                                ts.setCodigoDestino(Integer.parseInt(txtCodigoDestino.getText()));
                            }

                            ts.setNoDiasDuracion(Integer.parseInt(txtDiaDuracion.getText()));
                            ts.setNoAsiento(Integer.parseInt(txtNoAsiento.getText()));
                            ts.setCosto(Integer.parseInt(txtCosto.getText()));
                            mTransporte.agregarCliente(ts);
                            pintarTabla(contentPane);
                            cmbSeleccionUsuarioCodigo = new JComboBox(mTransporte.obtenerListaID());
                            Const.msjCola("Transporte agregado exitosamente");
                    }else{
                        Const.msjCola("Debe de tener una cnatidad, dia, no asiento y costo valido y deben ser númericos");
                        return;
                    }
                }else{
                    Const.msjCola("Seleccione una categoria, servicio valido");
                }

            }
        });
    }


    public void pintarTabla(Container contentPane){
        //<editor-fold defaultstate="collapsed" desc="Mostrar tabla de usuarios ">
        String[] columns;
        if(tipo.equals(Const.AER)){
            columns = new String[] {
                    "Codigo","Descripcion",
                    "Cantidad pasajeros", "Hora entrada",
                    "Hora salida", "No. dias duracion", "No asiento",
                    "Tipo transporte", "Costo",
                    "Categoria"
            };

        }else{

            columns = new String[] {
                    "Codigo","Descripcion",
                    "Cantidad pasajeros", "Fecha entrada",
                    "Fecha salida", "No. dias duracion", "No asiento",
                    "Tipo transporte", "Costo",
                    "Categoria", "Codigo destino"
            };

        }


        Transporte[] lsCliente = mTransporte.getListaUsr();

        if(table==null){
            String[][] sl = new String[1][1];
            sl[0][0] = "";
            DefaultTableModel model = new DefaultTableModel(sl,columns);
            table = new JTable(model);
            jspane = new JScrollPane(table);
        }

        if(lsCliente!=null){
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            for(int fil = 0; fil < lsCliente.length ; fil++){
                if(lsCliente[fil]!=null){
                    if(tipo.equals(Const.AER)){
                        if(lsCliente[fil].getTipoTransporte().equals(Const.AER) || lsCliente[fil].getTipoTransporte().equals(Const.BUS)){
                            DateTimeFormatter fmt = DateTimeFormat.forPattern("HH:mm");
                            String hEntrada = fmt.print(lsCliente[fil].getHoraEntrada());
                            String hSalida = fmt.print(lsCliente[fil].getHoraSalida());
                            model.addRow(new Object[]{
                                    lsCliente[fil].getCodUnico()!=null?lsCliente[fil].getCodUnico():"",
                                    lsCliente[fil].getStrDescripcion()!=null?lsCliente[fil].getStrDescripcion():"",
                                    lsCliente[fil].getCantidadPasajeros()!=null?lsCliente[fil].getCantidadPasajeros():"",
                                    hEntrada,
                                    hSalida,
                                    lsCliente[fil].getNoDiasDuracion()!=null?lsCliente[fil].getNoDiasDuracion():"",
                                    lsCliente[fil].getNoAsiento()!=null?lsCliente[fil].getNoAsiento().toString():"",
                                    lsCliente[fil].getTipoTransporte()!=null?lsCliente[fil].getTipoTransporte():"",
                                    lsCliente[fil].getCosto()!=null?lsCliente[fil].getCosto():"",
                                    lsCliente[fil].getTipoCAT()!=null?lsCliente[fil].getTipoCAT():"",
                            });
                        }
                    } else{
                        if(lsCliente[fil].getTipoTransporte().equals(Const.CRUZ)){
                            DateTimeFormatter fmt = DateTimeFormat.forPattern("dd/MM/yyyy");
                            String fechaE = fmt.print(lsCliente[fil].getFechaLlegada());
                            String fechaSal = fmt.print(lsCliente[fil].getFechaSalida());
                            model.addRow(new Object[]{
                                    lsCliente[fil].getCodUnico()!=null?lsCliente[fil].getCodUnico():"",
                                    lsCliente[fil].getStrDescripcion()!=null?lsCliente[fil].getStrDescripcion():"",
                                    lsCliente[fil].getCantidadPasajeros()!=null?lsCliente[fil].getCantidadPasajeros():"",
                                    fechaE,
                                    fechaSal,
                                    lsCliente[fil].getNoDiasDuracion()!=null?lsCliente[fil].getNoDiasDuracion():"",
                                    lsCliente[fil].getNoAsiento()!=null?lsCliente[fil].getNoAsiento().toString():"",
                                    lsCliente[fil].getTipoTransporte()!=null?lsCliente[fil].getTipoTransporte():"",
                                    lsCliente[fil].getCosto()!=null?lsCliente[fil].getCosto():"",
                                    lsCliente[fil].getTipoCAT()!=null?lsCliente[fil].getTipoCAT():"",
                                    lsCliente[fil].getCodigoDestino()!=null?lsCliente[fil].getCodigoDestino():"",
                            });
                        }
                    }

                }
            }
            contentPane.add(jspane, BorderLayout.CENTER);
        }
    }
}
