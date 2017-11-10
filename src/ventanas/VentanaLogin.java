package ventanas;

import manejador.*;

import javax.swing.*;
import java.awt.*;

/**
 * Created by daniel mendez on 04/11/2017.
 */
public class VentanaLogin extends JFrame{

    MUsuario mUsuario;
    MTransporte mTransporte;
    MHotel mHotel;
    MRentaAutos mRentaAutos;
    MTour mTour;

    public VentanaLogin(MUsuario mUsuario, MTransporte mTransporte, MHotel mHotel, MRentaAutos mRenta, MTour mTour){
        this.mUsuario = mUsuario;
        this.mTransporte =mTransporte;
        this.mHotel = mHotel;
        this.mRentaAutos = mRenta;
        this.mTour = mTour;
        this.configurarPantalla();
    }

    public VentanaLogin() {
        this.mUsuario = new MUsuario();
        this.mTransporte = new MTransporte();
        this.mHotel = new MHotel();
        this.mRentaAutos = new MRentaAutos();
        this.mTour = new MTour();
        this.configurarPantalla();
    }


    public void configurarPantalla(){
        this.agregarComponentes(this.getContentPane());
        //Configuraciones
        setSize(540,320);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Proyecto 2");
        setLocationRelativeTo(null);
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Image miIcono = miPantalla.getImage("src/imagenes/icono1.png");
        setIconImage(miIcono);
    }


    public void agregarComponentes(Container contentPane){
        contentPane.setLayout(new BorderLayout(5,5));
        JLabel headerLabel = new JLabel();

        headerLabel.setText("                                                         ! Bienvenido ! Ingrese sus credenciales");
        headerLabel.setPreferredSize(new Dimension(200, 50));
        contentPane.add(headerLabel, BorderLayout.PAGE_START);

        JLabel  lblNombre= new JLabel("Usuario: ", JLabel.RIGHT);
        JLabel  lblPass = new JLabel("Password: ", JLabel.CENTER);
        JTextField txtUsuario = new JTextField(6);
        JPasswordField txtPass = new JPasswordField(6);

        JPanel pnlV = new JPanel();
        JPanel panelMedio = new JPanel();

        pnlV.setSize(300,300);

        BoxLayout boxlayoutPedazo = new BoxLayout(pnlV, BoxLayout.Y_AXIS);

        JButton loginButton = new JButton("Login");
        pnlV.setLayout(boxlayoutPedazo);

        pnlV.add(lblNombre);
        pnlV.add(txtUsuario);
        pnlV.add(lblPass);
        pnlV.add(txtPass);
        pnlV.add(loginButton);
        panelMedio.add(pnlV);

        contentPane.add(panelMedio, BorderLayout.CENTER);

        JButton btnLoguear = new JButton();
        btnLoguear.setText("Logueate!");
        btnLoguear.setToolTipText("Loguear usuario");

        JLabel logo1 = new JLabel();
        JLabel logo2 = new JLabel();
        ImageIcon iconoEmpresa1 = new ImageIcon("src/imagenes/logoavianca.png");
        ImageIcon iconoEmpresa2 = new ImageIcon("src/imagenes/viajero.png");
        logo1.setIcon(iconoEmpresa1);
        logo2.setIcon(iconoEmpresa2);

        JPanel panelBotones = new JPanel();
        panelBotones.setSize(60,60);
        FlowLayout layout = new FlowLayout();
        layout.setHgap(5);/////
        layout.setVgap(1);///

        panelBotones.setLayout(layout);
        panelBotones.add(logo1);
        panelBotones.add(logo2);

        contentPane.add(panelBotones, BorderLayout.PAGE_END);


        txtPass.setText("dan");
        txtUsuario.setText("dan");

        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(mUsuario.verificarCliente(txtUsuario.getText(), txtPass.getText())){
                    VentanaMenus vm = new VentanaMenus(mUsuario, mTransporte, mHotel,mRentaAutos, mTour);
                    JOptionPane.showMessageDialog(null, "Usuario logueado exitosamente");
                    setVisible(false); //you can't see me!
                    dispose(); //Destroy the JFrame object
                }else{
                    JOptionPane.showMessageDialog(null, "Verifique sus credenciales");
                }
            }
        });
    }



}
