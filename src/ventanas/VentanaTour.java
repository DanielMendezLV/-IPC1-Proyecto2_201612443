package ventanas;

import constantes.Const;
import manejador.MTour;
import nodo.Tour;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by danie on 08/11/2017.
 */
public class VentanaTour extends JFrame{
    MTour mTour;
    JTable table;
    JScrollPane jspane;
    Tour TourEdit;
    String tipo;
    JComboBox  cmbSeleccionUsuarioCodigo;


    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public VentanaTour(MTour mTour, String tipo){
        this.mTour = mTour;
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

        //Compartidos (Dstinos turisticos)
        JLabel  lblNombre = new JLabel("Nombre",SwingConstants.LEFT);
        JLabel  lblDescripcion= new JLabel("Descripcion: ", SwingConstants.LEFT);
        JLabel  lblPais= new JLabel("País: ", SwingConstants.LEFT);
        JLabel  lblCiudad= new JLabel("Ciudad: ", JLabel.LEFT);
        JLabel  lblDireccion= new JLabel("Direccion: ", JLabel.LEFT);
        JLabel  lblRecomendaciones= new JLabel("Recomendaciones: ", JLabel.LEFT);


        //Espectaulo y entretenimiento
        JLabel  lblMinimoEdidad= new JLabel("Minimo edad: ", JLabel.LEFT);
        JLabel  lblFecha= new JLabel("Fecha: ", JLabel.LEFT);
        JLabel  lblHorarios= new JLabel("Horarios: ", JLabel.LEFT);

        JTextField txtNombre = new JTextField(6);
        JTextField txtDescripcion = new JTextField(6);
        JTextField txtPais = new JTextField(6);
        JTextField txtCiudad = new JTextField(6);
        JTextField txtDireccion = new JTextField(6);
        JTextField txtRecomendaciones = new JTextField(6);


        JTextField txtMinimoEdad = new JTextField(6);
        JTextField txtFecha = new JTextField(6);
        JTextField txtHorarios = new JTextField(6);

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
        cmbSeleccionUsuarioCodigo = new JComboBox(mTour.obtenerListaID());

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


        pnlV.add(lblNombre);
        pnlV.add(txtNombre);
        pnlV.add(lblDescripcion);
        pnlV.add(txtDescripcion);
        pnlV.add(lblPais);
        pnlV.add(txtPais);
        pnlV.add(lblCiudad);
        pnlV.add(txtCiudad);
        pnlV.add(lblDireccion);
        pnlV.add(txtDireccion);
        pnlV.add(lblRecomendaciones);
        pnlV.add(txtRecomendaciones);

        if(Const.ESPECENTRET.equals(tipo)){

            pnlV.add(lblMinimoEdidad);
            pnlV.add(txtMinimoEdad);
            pnlV.add(lblFecha);
            pnlV.add(txtFecha);
            pnlV.add(lblHorarios);
            pnlV.add(txtHorarios);

        }

        pnlV.add(btnAgregar);

        panelMedio.add(pnlV);
        contentPane.add(panelMedio, BorderLayout.LINE_START);
        contentPane.add(panelFondo, BorderLayout.PAGE_END);
        this.pintarTabla(this.getContentPane());




        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tour us = mTour.obtenerUSRXIdentificador(cmbSeleccionUsuarioCodigo.getSelectedItem().toString());
                TourEdit = us;

                txtNombre.setText(us.getNombre());
                txtDescripcion.setText(us.getDescripcion().toString());
                txtPais.setText(us.getPais().toString());
                txtCiudad.setText(us.getCiudad().toString());
                txtDireccion.setText(us.getDireccion().toString());
                txtRecomendaciones.setText(us.getRecomendacionesSeguridad().toString());


                DateTimeFormatter hora = DateTimeFormat.forPattern("HH:mm");
                DateTimeFormatter fecha = DateTimeFormat.forPattern("dd/MM/yyyy");

                String f = fecha.print(us.getFecha());
                String h = hora.print(us.getHorarios());
                if(tipo.equals(Const.ESPECENTRET)){
                    txtMinimoEdad.setText(us.getMinimoEdadPermitida().toString());
                    txtFecha.setText(f);
                    txtHorarios.setText(h);
                }
            }
        });

        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mTour.eliminarXIdentificador(cmbSeleccionUsuarioCodigo.getSelectedItem().toString());
                pintarTabla(contentPane);
                cmbSeleccionUsuarioCodigo = new JComboBox(mTour.obtenerListaID());
                Const.msjCola("Tour eliminado exitosamente");
            }
        });

        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(TourEdit!=null) {

                    Tour ts = TourEdit;
                    ts.setNombre(txtNombre.getText());
                    ts.setPais(txtPais.getText());
                    ts.setCiudad(txtCiudad.getText());
                    ts.setDireccion(txtDireccion.getText());
                    ts.setRecomendacionesSeguridad(txtRecomendaciones.getText());

                    if(Const.ESPECENTRET.equals(tipo)){

                        ts.setMinimoEdadPermitida(Integer.parseInt(txtMinimoEdad.getText()));
                        String[] fecha = txtFecha.getText().split("/");
                        ts.setFecha(new DateTime(Integer.parseInt(fecha[2]),
                                Integer.parseInt(fecha[1]), Integer.parseInt(fecha[0]),
                                0,0,0));

                        Integer hora = Integer.parseInt(txtHorarios.getText().split(":")[0]);
                        Integer minuto = Integer.parseInt((txtHorarios.getText().split(":")[1]));
                        ts.setHorarios(new DateTime(Integer.parseInt(fecha[2]),
                                Integer.parseInt(fecha[1]), Integer.parseInt(fecha[0]),
                                hora,minuto,0));
                    }
                    pintarTabla(contentPane);
                    Const.msjCola("Tour editado exitosamente");

                }



            }
        });



        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                    Tour ts = new Tour();
                    ts.setNombre(txtNombre.getText());
                    ts.setPais(txtPais.getText());
                    ts.setCiudad(txtCiudad.getText());
                    ts.setDireccion(txtDireccion.getText());
                    ts.setRecomendacionesSeguridad(txtRecomendaciones.getText());

                    if(Const.ESPECENTRET.equals(tipo)){

                        ts.setMinimoEdadPermitida(Integer.parseInt(txtMinimoEdad.getText()));
                        String[] fecha = txtFecha.getText().split("/");
                        ts.setFecha(new DateTime(Integer.parseInt(fecha[2]),
                                Integer.parseInt(fecha[1]), Integer.parseInt(fecha[0]),
                                0,0,0));

                        Integer hora = Integer.parseInt(txtHorarios.getText().split(":")[0]);
                        Integer minuto = Integer.parseInt((txtHorarios.getText().split(":")[1]));
                        ts.setHorarios(new DateTime(Integer.parseInt(fecha[2]),
                                Integer.parseInt(fecha[1]), Integer.parseInt(fecha[0]),
                                hora,minuto,0));
                        ts.setTipo(Const.ESPECENTRET);
                    }else{
                        ts.setTipo(Const.DESTINOTURIS);
                    }

                    Const.msjCola("Tour agregado exitosamente");
                    mTour.agregarCliente(ts);
                pintarTabla(contentPane);
            }
        });
    }


    public void pintarTabla(Container contentPane){
        //<editor-fold defaultstate="collapsed" desc="Mostrar tabla de usuarios ">

        String[] columnsDestino = new String[] {
                "Codigo","Nombre",
                "Descripcion", "Pais",
                "Ciudad", "Direccion", "Medidas seguridad"
        };

        String[] columnsEspect = new String[] {"Codigo","Nombre",
                "Descripcion", "Pais",
                "Ciudad", "Direccion", "Medidas seguridad", "Minimo edad",
                "Fecha", "Horarios"
        };


        Tour[] lsCliente = mTour.getListaTour();

        if(table==null){
            String[][] sl = new String[1][1];
            sl[0][0] = "";
            DefaultTableModel model;
            if(tipo.equals(Const.DESTINOTURIS)){
                model = new DefaultTableModel(sl,columnsDestino);
            }else{
                model = new DefaultTableModel(sl,columnsEspect);
            }
            table = new JTable(model);
            jspane = new JScrollPane(table);
        }

        if(lsCliente!=null){
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            for(int fil = 0; fil < lsCliente.length ; fil++){
                if(lsCliente[fil]!=null){
                    if(tipo.equals(Const.ESPECENTRET)){
                        if(lsCliente[fil].getTipo().equals(Const.ESPECENTRET)){
                            DateTimeFormatter hora = DateTimeFormat.forPattern("HH:mm");
                            DateTimeFormatter fecha = DateTimeFormat.forPattern("dd/MM/yyyy");

                            model.addRow(new Object[]{
                                    lsCliente[fil].getCodUnico()!=null?lsCliente[fil].getCodUnico().toString():"",
                                    lsCliente[fil].getNombre()!=null?lsCliente[fil].getNombre():"",
                                    lsCliente[fil].getDescripcion()!=null?lsCliente[fil].getDescripcion():"",
                                    lsCliente[fil].getPais()!=null?lsCliente[fil].getPais():"",
                                    lsCliente[fil].getCiudad()!=null?lsCliente[fil].getCiudad():"",
                                    lsCliente[fil].getDireccion()!=null?lsCliente[fil].getDireccion():"",
                                    lsCliente[fil].getRecomendacionesSeguridad()!=null?lsCliente[fil].getRecomendacionesSeguridad():"",
                                    lsCliente[fil].getMinimoEdadPermitida()!=null?lsCliente[fil].getMinimoEdadPermitida().toString():"",
                                    fecha.print(lsCliente[fil].getFecha()),
                                    hora.print(lsCliente[fil].getHorarios()),


                            });
                        }
                    } else{
                        if(lsCliente[fil].getTipo().equals(Const.DESTINOTURIS)){

                            model.addRow(new Object[]{
                                    lsCliente[fil].getCodUnico()!=null?lsCliente[fil].getCodUnico():"",
                                    lsCliente[fil].getNombre()!=null?lsCliente[fil].getNombre():"",
                                    lsCliente[fil].getDescripcion()!=null?lsCliente[fil].getDescripcion():"",
                                    lsCliente[fil].getPais()!=null?lsCliente[fil].getPais():"",
                                    lsCliente[fil].getCiudad()!=null?lsCliente[fil].getCiudad():"",
                                    lsCliente[fil].getDireccion()!=null?lsCliente[fil].getDireccion():"",
                                    lsCliente[fil].getRecomendacionesSeguridad()!=null?lsCliente[fil].getRecomendacionesSeguridad():""
                            });
                        }

                    }

                }
            }
            contentPane.add(jspane, BorderLayout.CENTER);
        }
    }
}
