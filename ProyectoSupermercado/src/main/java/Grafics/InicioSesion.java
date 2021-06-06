/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafics;



import Main.Classes.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author jaume
 */
public class InicioSesion extends javax.swing.JFrame {

    
    public InicioSesion() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    
    

    public Image getIconImage(){
        Image miIcono=Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/logo1.png"));
        return miIcono;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        contraseña = new javax.swing.JPasswordField();
        botonSalir = new javax.swing.JButton();
        botonLogin = new javax.swing.JButton();
        botonRegistro = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("  METRADONA©");
        setIconImage(getIconImage());
        setMaximumSize(new java.awt.Dimension(700, 376));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("METRADONA");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoSinFondo.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, -1, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, -1, -1));

        usuario.setBackground(new java.awt.Color(0, 51, 0));
        usuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        usuario.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 190, 30));

        contraseña.setBackground(new java.awt.Color(0, 51, 0));
        contraseña.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        contraseña.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 190, 30));

        botonSalir.setBackground(new java.awt.Color(102, 102, 102));
        botonSalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonSalir.setForeground(new java.awt.Color(255, 255, 255));
        botonSalir.setText("SALIR");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(botonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 80, -1));

        botonLogin.setBackground(new java.awt.Color(102, 102, 102));
        botonLogin.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonLogin.setForeground(new java.awt.Color(255, 255, 255));
        botonLogin.setText("INICIAR SESION");
        botonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLoginActionPerformed(evt);
            }
        });
        getContentPane().add(botonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, 170, 30));

        botonRegistro.setBackground(new java.awt.Color(102, 102, 102));
        botonRegistro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonRegistro.setForeground(new java.awt.Color(255, 255, 255));
        botonRegistro.setText("REGISTRARSE");
        botonRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistroActionPerformed(evt);
            }
        });
        getContentPane().add(botonRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 170, 30));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Green-Wallpaper-5.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
         
    private void botonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLoginActionPerformed
        try {
            this.inicioSesion();
        } catch (SQLException ex) {
            Herramientas.aviso("Algo ha fallado en el inicio de Sesion");
            Excepciones.pasarExcepcionLog("Algo ha fallado en el inicio de Sesion", ex);
        }
    }//GEN-LAST:event_botonLoginActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistroActionPerformed
        Registrador registro=new Registrador();
        this.dispose();
    }//GEN-LAST:event_botonRegistroActionPerformed

    public JButton getBotonLogin() {
        return botonLogin;
    }

    public JButton getBotonSalir() {
        return botonSalir;
    }

    public JPasswordField getContraseña() {
        return contraseña;
    }

    public JTextField getUsuario() {
        return usuario;
    }
    
    public void salir() {                                           
        try {
            Herramientas.cerrarConexion();
        } catch (SQLException ex) {
            Excepciones.pasarExcepcionLog("Problema al cerrar la conexion", ex);
        }
        System.exit(0);
    }   

    public void inicioSesion() throws SQLException{
        boolean clienteLogeado=this.inicioSesionCliente();
        boolean empleadoLogeado=false;
        if (!clienteLogeado){
            empleadoLogeado=this.inicioSesionEmpleado();
        }
        if(!empleadoLogeado && !clienteLogeado){
            Herramientas.aviso("El usuario o contraseña son incorrectos");
        }
        else if(empleadoLogeado){
            InterfazEmpleado frame=new InterfazEmpleado();
            this.dispose();
        }
        else if(clienteLogeado){
            if(Main.getClienteActivo().getCestaCompra().isEmpty()){
                ElegirSupermercado eleccion=new ElegirSupermercado(this);
            } else{
                Main.setSupermercadoActivo(Supermercado.instantiateSupermarketFromDB(Main.getClienteActivo().getSupermercadoCesta()));
                InterfazUsuario3 programa=new InterfazUsuario3();
                Herramientas.aviso("Se ha entrado directamente al supermercado de "+Main.getSupermercadoActivo().getLocalitat()+
                "\nporque habia productos guardados en su carrito de ese supermercado. "
                + "\nSi desea entrar a otro supermercado elimine todos los productos de su cesta, "
                + "\ncierre el programa y vuelva a logearse");
                this.dispose();
            }
        }
    }
    
    public boolean inicioSesionCliente() throws SQLException {        
        String usuario=this.getUsuario().getText();
        char[] aContrasena=this.getContraseña().getPassword();
        String contrasena=String.valueOf(aContrasena);
        boolean coincide;
        try (PreparedStatement query = Herramientas.getConexion().prepareStatement("SELECT * FROM cliente "); 
        ResultSet resultadoClientes = query.executeQuery()) {
            boolean encontrado=false;
            coincide = false;
            while(resultadoClientes.next() && !encontrado){
                if(resultadoClientes.getString("DNI_cliente").equals(usuario)){
                    encontrado=true;
                    if(resultadoClientes.getString("contraseña").equals(contrasena)){
                        coincide=true;
                        Cliente c1=Cliente.recogerCliente(Herramientas.getConexion(), usuario); 
                        Main.setClienteActivo(c1);
                    }
                }
            }          
        }
        return coincide;
    }

    public boolean inicioSesionEmpleado() throws SQLException {        
        String usuario=this.getUsuario().getText();
        char[] aContrasena=this.getContraseña().getPassword();
        String contrasena=String.valueOf(aContrasena);
        boolean coincide;
        try (PreparedStatement query = Herramientas.getConexion().prepareStatement("SELECT * FROM empleado "); 
        ResultSet resultadoEmpleados = query.executeQuery()) {
            boolean encontrado=false;
            coincide = false;
            while(resultadoEmpleados.next() && !encontrado){
                if(Integer.toString(resultadoEmpleados.getInt("ID_empleado")).equals(usuario)){
                    encontrado=true;
                    if(resultadoEmpleados.getString("contraseña").equals(contrasena)){
                        coincide=true;
                        Empleado e1=Empleado.recogerEmpleado(Herramientas.getConexion(), resultadoEmpleados.getInt("ID_empleado"));
                        Main.setEmpleadoActivo(e1);
                        Main.setSupermercadoActivo(Supermercado.instantiateSupermarketFromDB(e1.getCodigoSupermercado()));
                    }
                }
            }          }
        return coincide;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonLogin;
    private javax.swing.JButton botonRegistro;
    private javax.swing.JButton botonSalir;
    private javax.swing.JPasswordField contraseña;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
