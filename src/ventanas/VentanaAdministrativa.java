/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;


import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import constantes.Const;
import manejador.MUsuario;
import nodo.Usuario;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author danie
 */
public class VentanaAdministrativa extends JFrame{
    MUsuario mUsuario;
    JTable table;
    JScrollPane jspane;
    Usuario usuarioEdit;
    JComboBox  cmbSeleccionUsuarioCodigo;


    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public VentanaAdministrativa(MUsuario mUsuario){
        this.mUsuario = mUsuario;
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

        JLabel  lblDPI = new JLabel("DPI",SwingConstants.LEFT);
//        lblDPI.hag
        JLabel  lblUsuario= new JLabel("Usuario: ", SwingConstants.LEFT);
        JLabel  lblNombre= new JLabel("Nombres: ", SwingConstants.LEFT);
        JLabel  lblApellido= new JLabel("Apellido: ", JLabel.LEFT);
        JLabel  lblNoTarjeta= new JLabel("No. Tarjeta : ", JLabel.LEFT);
        JLabel  lblFechaNAC= new JLabel("Fecha Nacimiento dd/mm/yyyy : ", JLabel.LEFT);
        JLabel  lblNoTelefono= new JLabel("No Telefono : ", JLabel.LEFT);
        JLabel  lblNoMovil= new JLabel("No Movil : ", JLabel.LEFT);
        JLabel  lblDireccion= new JLabel("Dirección: ", JLabel.LEFT);
        JLabel  lblSaldoTarjeta= new JLabel("Saldo : ", JLabel.LEFT);
        JLabel  lblContrasena = new JLabel("Pass", JLabel.LEFT);
        JLabel  lblRol = new JLabel("Rol", JLabel.LEFT);

        JTextField txtUsuario = new JTextField(6);
        JTextField txtDPI = new JTextField(6);
        JTextField txtNombre = new JTextField(6);
        JTextField txtApellido = new JTextField(6);
        JTextField txtNoTarjeta = new JTextField(6);
        JTextField txtFechaNAC = new JTextField(6);
        JTextField txtTelefono = new JTextField(6);
        JTextField txtMovil = new JTextField(6);
        JTextField txtDireccion = new JTextField(6);
        JTextField txtSaldoTarjeta = new JTextField(6);
        JPasswordField txtContrasena = new JPasswordField(6);
        String[] li = {Const.SELCT,Const.ADM, Const.EMPL, Const.CLIE};
        JComboBox  cmbRol = new JComboBox(li);

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
        cmbSeleccionUsuarioCodigo = new JComboBox(mUsuario.obtenerListaID());

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


        pnlV.add(lblDPI);
        pnlV.add(txtDPI);
        pnlV.add(lblUsuario);
        pnlV.add(txtUsuario);
        pnlV.add(lblNombre);
        pnlV.add(txtNombre);
        pnlV.add(lblApellido);
        pnlV.add(txtApellido);
        pnlV.add(lblNoTarjeta);
        pnlV.add(txtNoTarjeta);
        pnlV.add(lblFechaNAC);
        pnlV.add(txtFechaNAC);
        pnlV.add(lblNoTelefono);
        pnlV.add(txtTelefono);
        pnlV.add(lblNoMovil);
        pnlV.add(txtMovil);
        pnlV.add(lblDireccion);
        pnlV.add(txtDireccion);
        pnlV.add(lblSaldoTarjeta);
        pnlV.add(txtSaldoTarjeta);
        pnlV.add(lblContrasena);
        pnlV.add(txtContrasena);
        pnlV.add(lblRol);
        pnlV.add(cmbRol);

        pnlV.add(btnAgregar);

        panelMedio.add(pnlV);
        contentPane.add(panelMedio, BorderLayout.LINE_START);
        contentPane.add(panelFondo, BorderLayout.PAGE_END);
        this.pintarTabla(this.getContentPane());




        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Usuario us = mUsuario.obtenerUSRXIdentificador(cmbSeleccionUsuarioCodigo.getSelectedItem().toString());
                usuarioEdit = us;
                txtDPI.setText(us.getDPI());
                txtUsuario.setText(us.getUsername());
                txtNombre.setText(us.getNombre());
                txtApellido.setText(us.getApellidos());
                txtNoTarjeta.setText(us.getTarjetaCredito()!=null?us.getTarjetaCredito().toString():"");


                DateTimeFormatter fmt = DateTimeFormat.forPattern("dd/MM/yyyy");
                String str = fmt.print(us.getFechaNacimiento());

                txtFechaNAC.setText(str);
                txtTelefono.setText(us.getNoTelefono().toString());
                txtMovil.setText(us.getNoTelefono()!=null?us.getNoMovil().toString():"");
                txtDireccion.setText(us.getDireccion());
                txtSaldoTarjeta.setText(us.getSaldoActual()!=null?us.getSaldoActual().toString():"");
                txtContrasena.setText(us.getPass());
                if(us.getRol().equals(Const.CLIE)){
                    cmbRol.setSelectedIndex(3);
                }
                if(us.getRol().equals(Const.ADM)){
                    cmbRol.setSelectedIndex(1);
                }
                if(us.getRol().equals(Const.EMPL)){
                    cmbRol.setSelectedIndex(2);
                }
            }
        });

        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 mUsuario.eliminarXIdentificador(cmbSeleccionUsuarioCodigo.getSelectedItem().toString());
                 pintarTabla(contentPane);
//                 cmbSeleccionUsuarioCodigo.set
//                 DefaultTableModel model = (DefaultTableModel) cmbSeleccionUsuarioCodigo.getModel();
//                 model.setRowCount(0);
//                 model.addRow(cmbSeleccionUsuarioCodigo.getItem);


                 Const.msjCola("Usuario eliminado exitosamente");
             }
        });

        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(usuarioEdit!=null){
                    Usuario usr = usuarioEdit;
                    if(Const.isNumber(txtDPI.getText()) && Const.isNumber(txtTelefono.getText())
                            ){

                        //Solo un cliente tiene tarjeta JOVEN
                        if(cmbRol.getSelectedItem().toString().equals(Const.CLIE)){
                            if(!Const.isNumber(txtNoTarjeta.getText()) && !Const.isNumber(txtSaldoTarjeta.getText())){
                                Const.msjCola("Debe ingresar un no. tarjeta y un saldo valido");
                                return;
                            }else{
                                usr.setSaldoActual(Integer.parseInt(txtSaldoTarjeta.getText()));
                                usr.setTarjetaCredito(Integer.parseInt(txtNoTarjeta.getText()));
                            }
                        }

                    }else{
                        Const.msjCola("Debe de tener un DPI y un Telefono valido");
                    }


                    String[] fecha = txtFechaNAC.getText().split("/");

                    usr.setDPI(txtDPI.getText());
                    usr.setNombre(txtNombre.getText());
                    usr.setApellidos(txtApellido.getText());
                    usr.setUsername(txtUsuario.getText());
                    usr.setPass(txtContrasena.getText());
                    usr.setFechaNacimiento(new DateTime(Integer.parseInt(fecha[2]),
                            Integer.parseInt(fecha[1]), Integer.parseInt(fecha[0]),
                            0,0,0));
                    usr.setNoTelefono(Integer.parseInt(txtTelefono.getText()));
                    if(!txtMovil.getText().isEmpty()){
                        usr.setNoMovil(Integer.parseInt(txtMovil.getText()));
                    }
                    usr.setDireccion(txtDireccion.getText());
                    usr.setRol(cmbRol.getSelectedItem().toString());
                    pintarTabla(contentPane);
                    Const.msjCola("Usuario editado exitosamente");


                }else{
                    Const.msjCola("Cargue un usuario existente");
                }
            }
        });



        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(!mUsuario.verifircarUsuarioSiYaExiste(txtUsuario.getText())){
                    if(!cmbRol.getSelectedItem().toString().equals(Const.SELCT)){
                        Usuario usr = new Usuario();
                        if(Const.isNumber(txtDPI.getText()) && Const.isNumber(txtTelefono.getText())

                        ){
                            //Solo un cliente tiene tarjeta JOVEN
                            if(cmbRol.getSelectedItem().toString().equals(Const.CLIE)){
                                if(!Const.isNumber(txtNoTarjeta.getText()) && !Const.isNumber(txtSaldoTarjeta.getText())){
                                    Const.msjCola("Debe ingresar un no. tarjeta y un saldo valido");
                                    return;
                                }else{
                                    usr.setSaldoActual(Integer.parseInt(txtSaldoTarjeta.getText()));
                                    usr.setTarjetaCredito(Integer.parseInt(txtNoTarjeta.getText()));
                                }
                            }

                        }else{
                            Const.msjCola("Debe de tener un DPI y un Telefono valido");
                            return;
                        }


                        String[] fecha = txtFechaNAC.getText().split("/");

                        usr.setDPI(txtDPI.getText());
                        usr.setNombre(txtNombre.getText());
                        usr.setApellidos(txtApellido.getText());
                        usr.setPass(txtContrasena.getText());
                        usr.setFechaNacimiento(new DateTime(Integer.parseInt(fecha[2]),
                                Integer.parseInt(fecha[1]), Integer.parseInt(fecha[0]),
                                0,0,0));
                        usr.setNoTelefono(Integer.parseInt(txtTelefono.getText()));
                        if(!txtMovil.getText().isEmpty()){
                            usr.setNoMovil(Integer.parseInt(txtMovil.getText()));
                        }
                        usr.setDireccion(txtDireccion.getText());
                        usr.setRol(cmbRol.getSelectedItem().toString());
                        mUsuario.agregarCliente(usr);
                        cmbSeleccionUsuarioCodigo = new JComboBox(mUsuario.obtenerListaID());
                        pintarTabla(contentPane);
                        Const.msjCola("Usuario agregado exitosamente");

                    }else{
                        Const.msjCola("Seleccione un rol valido");
                    }
                }else{
                   Const.msjCola("Ingrese un usuario que no exista");
                }
            }
        });
    }


    public void pintarTabla(Container contentPane){
        //<editor-fold defaultstate="collapsed" desc="Mostrar tabla de usuarios ">
        String[] columns = new String[] {
                "Codigo","Usuario",
                "DPI", "Nombres",
                "Apellidos", "Numero tarjeta crédito", "Fecha Nacimiento",
                "Número telefono", "Numero de móvil",
                "Dirección habitacion", "Saldo tarjeta", "Rol" , "Clasificacion por frecuencia", "Clasificacion por monto"
        };

        Usuario[] lsCliente = mUsuario.getListaUsr();

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
                            lsCliente[fil].getCodigoUnico()!=null?lsCliente[fil].getCodigoUnico():"",
                            lsCliente[fil].getUsername()!=null?lsCliente[fil].getUsername():"",
                            lsCliente[fil].getDPI()!=null?lsCliente[fil].getDPI():"",
                            lsCliente[fil].getNombre()!=null?lsCliente[fil].getNombre():"",
                            lsCliente[fil].getApellidos()!=null?lsCliente[fil].getApellidos():"",
                            lsCliente[fil].getTarjetaCredito()!=null?lsCliente[fil].getTarjetaCredito():"",
                            lsCliente[fil].getFechaNacimiento()!=null?lsCliente[fil].getFechaNacimiento().toString():"",
                            lsCliente[fil].getNoTelefono()!=null?lsCliente[fil].getNoTelefono():"",
                            lsCliente[fil].getNoMovil()!=null?lsCliente[fil].getNoMovil():"",
                            lsCliente[fil].getDireccion()!=null?lsCliente[fil].getDireccion():"",
                            lsCliente[fil].getSaldoActual()!=null?lsCliente[fil].getSaldoActual():"",
                            lsCliente[fil].getRol()!=null?lsCliente[fil].getRol():"",
                            lsCliente[fil].getClasificacionPorFrecuencia()!=null?lsCliente[fil].getClasificacionPorFrecuencia():"",
                            lsCliente[fil].getClasificacionPorMonto()!=null?lsCliente[fil].getClasificacionPorMonto():""
                    });
                }
            }
            contentPane.add(jspane, BorderLayout.CENTER);
        }
    }

}
