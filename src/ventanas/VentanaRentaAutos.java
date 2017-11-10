package ventanas;

import constantes.Const;
import manejador.MRentaAutos;
import manejador.MRentaAutos;
import nodo.RentaAutos;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by danie on 07/11/2017.
 */
public class VentanaRentaAutos extends JFrame {
    MRentaAutos mRentaAutos;
    JTable table;
    JScrollPane jspane;
    RentaAutos RentaAutosEdit;
    String tipo;
    JComboBox  cmbSeleccionRentaAutosCodigo;


    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public VentanaRentaAutos(MRentaAutos mRentaAutos){
        this.mRentaAutos = mRentaAutos;
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
        JLabel  lblCodigoEmpresaRenta = new JLabel("Código de empresa renta",SwingConstants.LEFT);
        JLabel  lblCodigoCliente= new JLabel("Código de cliente: ", SwingConstants.LEFT);
        JLabel  lblCantidadPasajero= new JLabel("Cantidad pasajero: ", SwingConstants.LEFT);
        JLabel  lblTipoTerreno= new JLabel("Tipo de terreno: ", JLabel.LEFT);
        JLabel  lblCosto= new JLabel("Costo: ", JLabel.LEFT);
        JLabel  lblDiaUtilizar= new JLabel("Dias a utilizar: ", JLabel.LEFT);
        JLabel  lblFechaEntrega= new JLabel("Fecha entrega: ", JLabel.LEFT);
        JLabel  lblFechaDevolucion = new JLabel("Fecha devolución: ", JLabel.LEFT);
        JLabel  lblMedidas = new JLabel("Medidas de seguridad", JLabel.LEFT);


        JTextField txtCodigoEmpresaRenta = new JTextField(6);
        JTextField txtCodigoCliente = new JTextField(6);
        JTextField txtCantidadPasajero = new JTextField(6);
        JTextField txtTipoTerreno = new JTextField(6);
        JTextField txtCosto = new JTextField(6);
        JTextField txtDiaUtilizar= new JTextField(6);
        JTextField txtFechaEntrega = new JTextField(6);
        JTextField txtFechaDevolucion = new JTextField(6);
        JTextField txtMedidas = new JTextField(6);


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



        JLabel lblSeleccione = new JLabel("Seleccione una renta de autos");
        cmbSeleccionRentaAutosCodigo = new JComboBox(mRentaAutos.obtenerListaID());

        JButton btnCargar = new JButton("Cargar");
        JButton btnEditar = new JButton("Editar");
        JButton btnEliminar = new JButton("Eliminar");

        panelHorizontal.add(lblSeleccione);
        panelHorizontal.add(Box.createRigidArea(new Dimension(10,0)));
        panelHorizontal.add(cmbSeleccionRentaAutosCodigo);
        panelHorizontal.add(Box.createRigidArea(new Dimension(10,0)));
        panelHorizontal.add(btnCargar);
        panelHorizontal.add(Box.createRigidArea(new Dimension(10,0)));
        panelHorizontal.add(btnEditar);
        panelHorizontal.add(Box.createRigidArea(new Dimension(10,0)));
        panelHorizontal.add(btnEliminar);


        panelFondo.add(panelHorizontal);
        panelFondo.add(panelHorizontal);



        pnlV.add(lblCodigoEmpresaRenta);
        pnlV.add(txtCodigoEmpresaRenta);
        pnlV.add(lblCodigoCliente);
        pnlV.add(txtCodigoCliente);
        pnlV.add(lblCantidadPasajero);
        pnlV.add(txtCantidadPasajero);
        pnlV.add(lblTipoTerreno);
        pnlV.add(txtTipoTerreno);
        pnlV.add(lblCosto);
        pnlV.add(txtCosto);
        pnlV.add(lblDiaUtilizar);
        pnlV.add(txtDiaUtilizar);
        pnlV.add(lblFechaEntrega);
        pnlV.add(txtFechaEntrega);
        pnlV.add(lblFechaDevolucion);
        pnlV.add(txtFechaDevolucion);
        pnlV.add(lblMedidas);
        pnlV.add(txtMedidas);


        pnlV.add(btnAgregar);

        panelMedio.add(pnlV);
        contentPane.add(panelMedio, BorderLayout.LINE_START);
        contentPane.add(panelFondo, BorderLayout.PAGE_END);
        this.pintarTabla(this.getContentPane());




        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RentaAutos us = mRentaAutos.obtenerUSRXIdentificador(cmbSeleccionRentaAutosCodigo.getSelectedItem().toString());
                RentaAutosEdit = us;
                txtCodigoEmpresaRenta.setText(us.getCodigoEmpresaRenta().toString());
                txtCodigoCliente.setText(us.getCodCliente().toString());
                txtCantidadPasajero.setText(us.getCantidadPasajeros().toString());
                txtTipoTerreno.setText(us.getTipoTerreno().toString());
                txtCosto.setText(us.getCosto().toString());
                txtDiaUtilizar.setText(us.getDiaUtilizar().toString());
                DateTimeFormatter fmt = DateTimeFormat.forPattern("dd/MM/yyyy");
                txtFechaEntrega.setText(fmt.print(us.getFechaEntrega()));
                txtFechaDevolucion.setText(fmt.print(us.getFechaDevolucion()));
                txtMedidas.setText(us.getMedidasSeguridad().toString());

            }
        });

        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mRentaAutos.eliminarXIdentificador(cmbSeleccionRentaAutosCodigo.getSelectedItem().toString());
                pintarTabla(contentPane);
                cmbSeleccionRentaAutosCodigo = new JComboBox(mRentaAutos.obtenerListaID());
                Const.msjCola("RentaAutos eliminado exitosamente");
            }
        });

        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(RentaAutosEdit !=null) {

                    RentaAutos ts = RentaAutosEdit;
                    if(Const.isNumber(txtCodigoEmpresaRenta.getText())
                            && Const.isNumber(txtCodigoCliente.getText())
                            && Const.isNumber(txtCantidadPasajero.getText())
                            && Const.isNumber(txtDiaUtilizar.getText())
                            && Const.isNumber(txtCosto.getText())
                            ){

                        ts.setCodigoEmpresaRenta(Integer.parseInt(txtCodigoEmpresaRenta.getText()));
                        ts.setCodCliente(Integer.parseInt(txtCodigoCliente.getText()));
                        ts.setCantidadPasajeros(Integer.parseInt(txtCantidadPasajero.getText()));
                        ts.setTipoTerreno(txtTipoTerreno.getText());
                        ts.setDiaUtilizar(Integer.parseInt(txtDiaUtilizar.getText()));
                        ts.setCosto(Integer.parseInt(txtCosto.getText()));
                        ts.setMedidasSeguridad(txtMedidas.getText());

                        String[] fecha = txtFechaEntrega.getText().split("/");
                        ts.setFechaEntrega(new DateTime(Integer.parseInt(fecha[2]),
                                Integer.parseInt(fecha[1]), Integer.parseInt(fecha[0]),
                                0,0,0));

                        fecha = txtFechaDevolucion.getText().split("/");
                        ts.setFechaDevolucion(new DateTime(Integer.parseInt(fecha[2]),
                                Integer.parseInt(fecha[1]), Integer.parseInt(fecha[0]),
                                0,0,0));
                        pintarTabla(contentPane);
                        cmbSeleccionRentaAutosCodigo = new JComboBox(mRentaAutos.obtenerListaID());
                        Const.msjCola("RentaAutos editado exitosamente");
                    }else{
                        Const.msjCola("Debe de tener un codigo empresa, cliente, cantidad pasajeros, dia utilizar y costo...  estos campos deben ser númericos");
                        return;
                    }

                }else{
                    Const.msjCola("Cargue un transporte existente");
                }
            }
        });

        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RentaAutos ts = new RentaAutos();
                if(Const.isNumber(txtCodigoEmpresaRenta.getText())
                        && Const.isNumber(txtCodigoCliente.getText())
                        && Const.isNumber(txtCantidadPasajero.getText())
                        && Const.isNumber(txtDiaUtilizar.getText())
                        && Const.isNumber(txtCosto.getText())
                        ){

                        ts.setCodigoEmpresaRenta(Integer.parseInt(txtCodigoEmpresaRenta.getText()));
                        ts.setCodCliente(Integer.parseInt(txtCodigoCliente.getText()));
                        ts.setCantidadPasajeros(Integer.parseInt(txtCantidadPasajero.getText()));
                        ts.setTipoTerreno(txtTipoTerreno.getText());
                        ts.setDiaUtilizar(Integer.parseInt(txtDiaUtilizar.getText()));
                        ts.setCosto(Integer.parseInt(txtCosto.getText()));

                        String[] fecha = txtFechaEntrega.getText().split("/");
                        ts.setFechaEntrega(new DateTime(Integer.parseInt(fecha[2]),
                            Integer.parseInt(fecha[1]), Integer.parseInt(fecha[0]),
                            0,0,0));

                        fecha = txtFechaDevolucion.getText().split("/");
                        ts.setFechaDevolucion(new DateTime(Integer.parseInt(fecha[2]),
                            Integer.parseInt(fecha[1]), Integer.parseInt(fecha[0]),
                            0,0,0));
                        mRentaAutos.agregarCliente(ts);
                        pintarTabla(contentPane);
                        cmbSeleccionRentaAutosCodigo = new JComboBox(mRentaAutos.obtenerListaID());
                        Const.msjCola("RentaAutos agregado exitosamente");
                }else{
                    Const.msjCola("Debe de tener un codigo empresa, cliente, cantidad pasajeros, dia utilizar y costo...  estos campos deben ser númericos");
                    return;
                }
            }
        });
    }


    public void pintarTabla(Container contentPane){
        //<editor-fold defaultstate="collapsed" desc="Mostrar tabla de usuarios ">

        String[] columns = new String[] {
                "Codigo","Código de empresa",
                "Código de cliente", "Cantidad de pasajeros",
                "Tipo de terreno", "Costo",
                "Dias a utilizar", "Fecha entrega", "Fecha devolucion", "Medidas seguridad"
        };

        RentaAutos[] lsCliente = mRentaAutos.getListaRentaAutos();

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
                            lsCliente[fil].getCodigoEmpresaRenta()!=null?lsCliente[fil].getCodigoEmpresaRenta().toString():"",
                            lsCliente[fil].getCodCliente()!=null?lsCliente[fil].getCodCliente().toString():"",
                            lsCliente[fil].getCantidadPasajeros()!=null?lsCliente[fil].getCantidadPasajeros().toString():"",
                            lsCliente[fil].getTipoTerreno()!=null?lsCliente[fil].getTipoTerreno():"",
                            lsCliente[fil].getCosto()!=null?lsCliente[fil].getCosto().toString():"",
                            lsCliente[fil].getDiaUtilizar()!=null?lsCliente[fil].getDiaUtilizar().toString():"",
                            lsCliente[fil].getFechaEntrega()!=null?lsCliente[fil].getFechaEntrega().toString():"",
                            lsCliente[fil].getFechaDevolucion()!=null?lsCliente[fil].getFechaDevolucion().toString():"",
                            lsCliente[fil].getMedidasSeguridad()!=null?lsCliente[fil].getMedidasSeguridad().toString():"",

                    });

                }

            }
        }
        contentPane.add(jspane, BorderLayout.CENTER);
    }
}
