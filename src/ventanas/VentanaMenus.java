package ventanas;

import constantes.Const;
import manejador.*;
import nodo.Transporte;

import javax.swing.*;
import java.awt.*;

/**
 * Created by danie on 05/11/2017.
 */
public class VentanaMenus extends JFrame {
    MUsuario mUsuario =null;
    MTransporte mTransporte = null;
    MHotel mHotel = null;
    MRentaAutos mRentaAutos = null;
    MTour mTour = null;

    public VentanaMenus(MUsuario mUsuario, MTransporte mTransporte, MHotel mHotel, MRentaAutos mRentaAutos, MTour mTour){
        this.mUsuario = mUsuario;
        this.mTransporte = mTransporte;
        this.mHotel = mHotel;
        this.mRentaAutos = mRentaAutos;
        this.mTour = mTour;
        agregarComponentesPanel(this.getContentPane());
        setSize(1000,525);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Ventana Menus");
        setLocationRelativeTo(null);
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Image miIcono = miPantalla.getImage("src/imagenes/icono1.png");
        setIconImage(miIcono);
    }

    public  void agregarComponentesPanel(Container contentPane) {
        contentPane.setLayout(new BorderLayout(5,5));

        JPanel pnlPrincipal = new JPanel();
        BoxLayout boxlayoutPrincipal = new BoxLayout(pnlPrincipal, BoxLayout.Y_AXIS);

        JPanel pnlBotones = new JPanel();
        pnlBotones.setSize(200,200);
        FlowLayout layoutBotones = new FlowLayout();
        layoutBotones.setHgap(5);
        layoutBotones.setVgap(10);

        JPanel pnlCuadricula3x3 = new JPanel();
        pnlCuadricula3x3.setSize(100,100);
        GridLayout layout3x3 = new GridLayout(4, 3);
        layout3x3.setHgap(10);
        layout3x3.setVgap(10);

        JButton btnClientesYUsuarios = new JButton("Clientes y usuarios");
        btnClientesYUsuarios.setIcon(  new ImageIcon("src/imagenes/cliente.png"));

        JButton btnAereolineasBuses = new JButton("Aereolineas y buses");
        btnAereolineasBuses.setIcon(  new ImageIcon("src/imagenes/busae.png"));

        JButton btnHotelResort = new JButton("Hoteles y Resorts");
        btnHotelResort.setIcon(  new ImageIcon("src/imagenes/hotel.png"));

        JButton btnCrucero = new JButton("Cruceros");
        btnCrucero.setIcon(  new ImageIcon("src/imagenes/cruceros.png"));

        JButton btnRentaAuto = new JButton("Renta de autos");
        btnRentaAuto.setIcon(  new ImageIcon("src/imagenes/car.png"));

        JButton btnDestinosTuristicos = new JButton("Destinos turisticos");
        btnDestinosTuristicos.setIcon(  new ImageIcon("src/imagenes/destinos.png"));

        JButton btnEspectaculoEntretenimiento = new JButton("Espectaculo y entretenimiento");
        btnEspectaculoEntretenimiento.setIcon(  new ImageIcon("src/imagenes/espect.png"));

        JButton btnCargaYDescarga = new JButton("Carga y descarga de archivos CSV");
        btnCargaYDescarga.setIcon(  new ImageIcon("src/imagenes/upload.png"));

        JButton btnLogo = new JButton("Logout");
        btnLogo.setIcon(  new ImageIcon("src/imagenes/lo.png"));



            float[] hsb = null;
            float[] hsbP = null;
            float hP;
            float sP;
            float bP;

            hsb = Color.RGBtoHSB(211, 211, 211, hsb);
            hsbP = Color.RGBtoHSB(211, 154, 154, hsbP);
                hP = hsb[0];
                sP = hsb[1];
                bP = hsb[2];
                this.getContentPane().setBackground(Color.getHSBColor(hP, sP, bP));
//            }
            float h = hsb[0];
            float s = hsb[1];
            float b = hsb[2];

            btnClientesYUsuarios.setBackground(Color.getHSBColor(h, s, b));
            btnAereolineasBuses.setBackground(Color.getHSBColor(h, s, b));
            btnHotelResort.setBackground(Color.getHSBColor(h, s, b));
            btnRentaAuto.setBackground(Color.getHSBColor(h, s, b));
            btnCrucero.setBackground(Color.getHSBColor(h, s, b));
            btnDestinosTuristicos.setBackground(Color.getHSBColor(h, s, b));
            btnEspectaculoEntretenimiento.setBackground(Color.getHSBColor(h, s, b));
            btnCargaYDescarga.setBackground(Color.getHSBColor(h, s, b));
            btnLogo.setBackground(Color.getHSBColor(h,s,b));


         pnlCuadricula3x3.setLayout(layout3x3);

        if(mUsuario.getUsrLogueado().getRol().equals(Const.ADM)){
            pnlCuadricula3x3.add(btnClientesYUsuarios);
            pnlCuadricula3x3.add(btnAereolineasBuses);
            pnlCuadricula3x3.add(btnHotelResort);
            pnlCuadricula3x3.add(btnCrucero);
            pnlCuadricula3x3.add(btnRentaAuto);
            pnlCuadricula3x3.add(btnDestinosTuristicos);
            pnlCuadricula3x3.add(btnEspectaculoEntretenimiento);
            pnlCuadricula3x3.add(btnCargaYDescarga);
        }

        if(mUsuario.getUsrLogueado().getRol().equalsIgnoreCase(Const.EMPL)){
//            pnlCuadricula3x3.add(btnModuloAdmon);
//            pnlCuadricula3x3.add(btnAsignarListaAlumnos);
//            pnlCuadricula3x3.add(btnAsignarDenominaciones);
//            pnlCuadricula3x3.add(btnVerExistencia);
        }

        pnlCuadricula3x3.add(btnLogo);

        pnlBotones.setLayout(layoutBotones);
        pnlBotones.add(pnlCuadricula3x3);

        pnlPrincipal.setLayout(boxlayoutPrincipal);

        JLabel logo = new JLabel();
        pnlPrincipal.add(logo);


        pnlPrincipal.add(pnlBotones);

        //Agregando a Panel principal
        contentPane.add(pnlPrincipal);

        btnLogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mUsuario.setUsrLogueado(null);
                VentanaLogin vm = new VentanaLogin(mUsuario,mTransporte,mHotel,mRentaAutos, mTour);
                setVisible(false); //you can't see me!
                dispose(); //Destroy the JFrame object
            }
        });

        btnClientesYUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VentanaAdministrativa va = new VentanaAdministrativa(mUsuario);
//                setVisible(false); //you can't see me!
//                dispose(); //Destroy the JFrame object
            }
        });

        btnAereolineasBuses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VentanaTransporte va = new VentanaTransporte(mTransporte, Const.AER);
            }
        });

        btnCrucero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VentanaTransporte va = new VentanaTransporte(mTransporte, Const.CRUZ);
            }
        });

        btnHotelResort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VentanaHotel vh = new VentanaHotel(mHotel);
            }
        });

        btnRentaAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VentanaRentaAutos vh = new VentanaRentaAutos(mRentaAutos);
            }
        });

        btnDestinosTuristicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VentanaTour vh = new VentanaTour(mTour, Const.DESTINOTURIS);
            }
        });

        btnEspectaculoEntretenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VentanaTour vh = new VentanaTour(mTour, Const.ESPECENTRET);
            }
        });

        btnCargaYDescarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VentanaCargaDescarga vh = new VentanaCargaDescarga(mHotel, mRentaAutos, mTour, mTransporte, mUsuario);
            }
        });
    }

}
