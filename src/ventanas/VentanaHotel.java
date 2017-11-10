package ventanas;

import constantes.Const;
import manejador.MHotel;
import nodo.Hotel;
import nodo.Transporte;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by danie on 07/11/2017.
 */
public class VentanaHotel extends JFrame {
    MHotel mHotel;
    JTable table;
    JScrollPane jspane;
    Hotel hotelEdit;
    String tipo;
    JComboBox  cmbSeleccionHotelCodigo;


    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public VentanaHotel(MHotel mHotel){
        this.mHotel = mHotel;
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
        JLabel  lblDireccion = new JLabel("Dirección",SwingConstants.LEFT);
        JLabel  lblNoCuartosDisponibles= new JLabel("No cuartos disponibles: ", SwingConstants.LEFT);
        JLabel  lblCantidadPersonasxCuarto= new JLabel("Cantidad personas x cuarto: ", SwingConstants.LEFT);
        JLabel  lblCosto= new JLabel("Costo : ", JLabel.LEFT);
        JLabel  lblCategoria= new JLabel("Categoria: ", JLabel.LEFT);
        JLabel  lblCodigoDestino= new JLabel("Codigo destino: ", JLabel.LEFT);

        JTextField txtDireccion = new JTextField(6);
        JTextField txtNoCuartosDisponibles = new JTextField(6);
        JTextField txtCantidadPersonasxCuarto = new JTextField(6);
        JTextField txtCosto = new JTextField(6);
        String[] liCategoria = {Const.SELCT,Const.ECONO, Const.LUJO, Const.NEGO};
        JTextField txtCodigoDestino = new JTextField(6);
        JComboBox cmbCategoria = new JComboBox(liCategoria);

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



        JLabel lblSeleccione = new JLabel("Seleccione un hotel");
        cmbSeleccionHotelCodigo = new JComboBox(mHotel.obtenerListaID());

        JButton btnCargar = new JButton("Cargar");
        JButton btnEditar = new JButton("Editar");
        JButton btnEliminar = new JButton("Eliminar");

        panelHorizontal.add(lblSeleccione);
        panelHorizontal.add(Box.createRigidArea(new Dimension(10,0)));
        panelHorizontal.add(cmbSeleccionHotelCodigo);
        panelHorizontal.add(Box.createRigidArea(new Dimension(10,0)));
        panelHorizontal.add(btnCargar);
        panelHorizontal.add(Box.createRigidArea(new Dimension(10,0)));
        panelHorizontal.add(btnEditar);
        panelHorizontal.add(Box.createRigidArea(new Dimension(10,0)));
        panelHorizontal.add(btnEliminar);


        panelFondo.add(panelHorizontal);
        panelFondo.add(panelHorizontal);


        pnlV.add(lblDireccion);
        pnlV.add(txtDireccion);
        pnlV.add(lblNoCuartosDisponibles);
        pnlV.add(txtNoCuartosDisponibles);
        pnlV.add(lblCantidadPersonasxCuarto);
        pnlV.add(txtCantidadPersonasxCuarto);
        pnlV.add(lblCosto);
        pnlV.add(txtCosto);
        pnlV.add(lblCategoria);
        pnlV.add(cmbCategoria);
        pnlV.add(lblCodigoDestino);
        pnlV.add(txtCodigoDestino);

        pnlV.add(btnAgregar);

        panelMedio.add(pnlV);
        contentPane.add(panelMedio, BorderLayout.LINE_START);
        contentPane.add(panelFondo, BorderLayout.PAGE_END);
        this.pintarTabla(this.getContentPane());




        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Hotel us = mHotel.obtenerUSRXIdentificador(cmbSeleccionHotelCodigo.getSelectedItem().toString());
                hotelEdit = us;

                txtDireccion.setText(us.getDireccion());
                txtNoCuartosDisponibles.setText(us.getNoCuartosDisponibles().toString());
                txtCantidadPersonasxCuarto.setText(us.getCantidadPersonasxCuarto().toString());
                txtCosto.setText(us.getCosto().toString());
                txtCodigoDestino.setText(us.getCodigoDestino().toString());
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
                mHotel.eliminarXIdentificador(cmbSeleccionHotelCodigo.getSelectedItem().toString());
                pintarTabla(contentPane);
                cmbSeleccionHotelCodigo = new JComboBox(mHotel.obtenerListaID());
                Const.msjCola("Hotel eliminado exitosamente");
            }
        });

        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(hotelEdit !=null) {
                    if(!cmbCategoria.getSelectedItem().toString().equals(Const.SELCT)){
                        Hotel ts = hotelEdit;
                        if(Const.isNumber(txtNoCuartosDisponibles.getText())
                                && Const.isNumber(txtCantidadPersonasxCuarto.getText())
                                && Const.isNumber(txtCosto.getText())
                                ){

                            ts.setTipoCAT(cmbCategoria.getSelectedItem().toString());
                            ts.setStrDescripcion(txtDireccion.getText());
                            ts.setDireccion(txtDireccion.getText());
                            ts.setNoCuartosDisponibles(Integer.parseInt(txtCantidadPersonasxCuarto.getText()));
                            ts.setCantidadPersonasxCuarto(Integer.parseInt(txtCantidadPersonasxCuarto.getText()));
                            ts.setCosto(Integer.parseInt(txtCosto.getText()));
                            ts.setCodigoDestino(Integer.parseInt(txtCodigoDestino.getText()));
                            pintarTabla(contentPane);
                            Const.msjCola("Hotel editado exitosamente");
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


//        txtDireccion.setText(us.getStrDescripcion());
//        txtNoCuartosDisponibles.setText(us.getNoCuartosDisponibles().toString());
//        txtCantidadPersonasxCuarto.setText(us.getCantidadPersonasxCuarto().toString());
//        txtCosto.setText(us.getCosto().toString());
//
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(!cmbCategoria.getSelectedItem().toString().equals(Const.SELCT)){
                    Hotel ts = new Hotel();
                    if(Const.isNumber(txtNoCuartosDisponibles.getText())
                            && Const.isNumber(txtCantidadPersonasxCuarto.getText())
                            && Const.isNumber(txtCosto.getText())
                            ){


                        ts.setTipoCAT(cmbCategoria.getSelectedItem().toString());
                        ts.setStrDescripcion(txtDireccion.getText());
                        ts.setDireccion(txtDireccion.getText());
                        ts.setNoCuartosDisponibles(Integer.parseInt(txtCantidadPersonasxCuarto.getText()));
                        ts.setCantidadPersonasxCuarto(Integer.parseInt(txtCantidadPersonasxCuarto.getText()));
                        ts.setCosto(Integer.parseInt(txtCosto.getText()));
                        ts.setCodigoDestino(Integer.parseInt(txtCodigoDestino.getText()));

                        mHotel.agregarCliente(ts);
                        pintarTabla(contentPane);
                        cmbSeleccionHotelCodigo = new JComboBox(mHotel.obtenerListaID());
                        Const.msjCola("Hotel agregado exitosamente");
                    }else{
                        Const.msjCola("Debe de tener un no cuarto, cantidad personas, costo y estos campos deben ser númericos");
                        return;
                    }
                }else{
                    Const.msjCola("Seleccione una categoria valida");
                }

            }
        });
    }


    public void pintarTabla(Container contentPane){
        //<editor-fold defaultstate="collapsed" desc="Mostrar tabla de usuarios ">

        String[] columns = new String[] {
                "Codigo","Dirección",
                "No cuartos disponibles", "Cantidad de personas por cuarto",
                "Costo de habitación",
                "Categoria", "Codigo destino"
        };

        Hotel[] lsCliente = mHotel.getListaHotel();

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
                            model.addRow(new Object[]{
                                    lsCliente[fil].getCodUnico()!=null?lsCliente[fil].getCodUnico().toString():"",
                                    lsCliente[fil].getDireccion()!=null?lsCliente[fil].getDireccion():"",
                                    lsCliente[fil].getNoCuartosDisponibles()!=null?lsCliente[fil].getNoCuartosDisponibles().toString():"",
                                    lsCliente[fil].getCantidadPersonasxCuarto()!=null?lsCliente[fil].getCantidadPersonasxCuarto().toString():"",
                                    lsCliente[fil].getCosto()!=null?lsCliente[fil].getCosto().toString():"",
                                    lsCliente[fil].getTipoCAT()!=null?lsCliente[fil].getTipoCAT():"",
                                    lsCliente[fil].getCodigoDestino()!=null?lsCliente[fil].getCodigoDestino():"",
                            });

                    }

                }
            }
            contentPane.add(jspane, BorderLayout.CENTER);
        }
    }

