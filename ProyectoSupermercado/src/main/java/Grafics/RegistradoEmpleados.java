/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafics;


//import codigo.Excepciones;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.InputMismatchException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author jaume
 */
public class RegistradoEmpleados extends javax.swing.JFrame {
    
    
    //private Biblioteca biblioteca;
    /**
     * Creates new form Registrador
     */
    public RegistradoEmpleados(/*Biblioteca b*/) {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        //this.setBiblioteca(b);
    }
    

    public JTextField getCodigoPostal() {
        return CodigoPostal;
    }

    public JTextField getDireccion() {
        return Direccion;
    }

    public JTextField getLocalidad() {
        return Localidad;
    }

    public JTextField getNIF() {
        return NIF;
    }

    public JTextField getApellido1() {
        return apellido1;
    }

    public JTextField getApellido2() {
        return apellido2;
    }

    public JComboBox<String> getComunidadAutonoma() {
        return comunidadAutonoma;
    }

    public JTextField getContrasena() {
        return contrasena;
    }

    public JTextField getEdad() {
        return edad;
    }

    public JTextField getEmail() {
        return email;
    }

    public JTextField getNombre() {
        return nombre;
    }

    public JTextField getRepetirContrasena() {
        return repetirContrasena;
    }

    public JTextField getTelefono() {
        return telefono;
    }

    public JTextField getCodigoSupermercado() {
        return codigoSupermercado;
    }

    public JComboBox<String> getPuestoTrabajo() {
        return puestoTrabajo;
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

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        edad = new javax.swing.JTextField();
        nombre = new javax.swing.JTextField();
        apellido1 = new javax.swing.JTextField();
        apellido2 = new javax.swing.JTextField();
        comunidadAutonoma = new javax.swing.JComboBox<>();
        NIF = new javax.swing.JTextField();
        contrasena = new javax.swing.JTextField();
        repetirContrasena = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        telefono = new javax.swing.JTextField();
        Localidad = new javax.swing.JTextField();
        CodigoPostal = new javax.swing.JTextField();
        Direccion = new javax.swing.JTextField();
        codigoSupermercado = new javax.swing.JTextField();
        puestoTrabajo = new javax.swing.JComboBox<>();
        botonRegistro = new javax.swing.JButton();
        botonAtras = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("  METRADONA©");
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Email:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, -1, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Primer Apellido:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 100, 130, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Segundo Apellido:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 140, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Edad:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 50, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Direccion:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 180, -1, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Repite contraseña:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(316, 300, -1, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Contraseña:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 260, -1, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("REGISTRO EMPLEADOS");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 450, 50));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("NIF:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 220, -1, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Telefono:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, 30));

        edad.setBackground(new java.awt.Color(0, 51, 0));
        edad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        edad.setForeground(new java.awt.Color(255, 255, 255));
        edad.setToolTipText("");
        getContentPane().add(edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 130, 30));

        nombre.setBackground(new java.awt.Color(0, 51, 0));
        nombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nombre.setForeground(new java.awt.Color(255, 255, 255));
        nombre.setToolTipText("");
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 130, 30));

        apellido1.setBackground(new java.awt.Color(0, 51, 0));
        apellido1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        apellido1.setForeground(new java.awt.Color(255, 255, 255));
        apellido1.setToolTipText("");
        getContentPane().add(apellido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 130, 30));

        apellido2.setBackground(new java.awt.Color(0, 51, 0));
        apellido2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        apellido2.setForeground(new java.awt.Color(255, 255, 255));
        apellido2.setToolTipText("");
        getContentPane().add(apellido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 130, 30));

        comunidadAutonoma.setBackground(new java.awt.Color(0, 51, 0));
        comunidadAutonoma.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        comunidadAutonoma.setForeground(new java.awt.Color(255, 255, 255));
        comunidadAutonoma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Andalucía", "Aragón", "Canarias", "Cantabria", "Castilla-LM", "Castilla y León", "Cataluña", "Ceuta", "Madrid", "C.Valenciana", "Extremadura", "Galicia", "Baleares", "La Rioja", "Melilla", "Navarra", "País Vasco", "Asturias", "Murcia" }));
        comunidadAutonoma.setToolTipText("");
        comunidadAutonoma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comunidadAutonomaActionPerformed(evt);
            }
        });
        getContentPane().add(comunidadAutonoma, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 130, 30));

        NIF.setBackground(new java.awt.Color(0, 51, 0));
        NIF.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        NIF.setForeground(new java.awt.Color(255, 255, 255));
        NIF.setToolTipText("");
        getContentPane().add(NIF, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 130, 30));

        contrasena.setBackground(new java.awt.Color(0, 51, 0));
        contrasena.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        contrasena.setForeground(new java.awt.Color(255, 255, 255));
        contrasena.setToolTipText("");
        getContentPane().add(contrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, 130, 30));

        repetirContrasena.setBackground(new java.awt.Color(0, 51, 0));
        repetirContrasena.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        repetirContrasena.setForeground(new java.awt.Color(255, 255, 255));
        repetirContrasena.setToolTipText("");
        getContentPane().add(repetirContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, 130, 30));

        email.setBackground(new java.awt.Color(0, 51, 0));
        email.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        email.setForeground(new java.awt.Color(255, 255, 255));
        email.setToolTipText("");
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 130, 30));

        telefono.setBackground(new java.awt.Color(0, 51, 0));
        telefono.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        telefono.setForeground(new java.awt.Color(255, 255, 255));
        telefono.setToolTipText("");
        getContentPane().add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 130, 30));

        Localidad.setBackground(new java.awt.Color(0, 51, 0));
        Localidad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Localidad.setForeground(new java.awt.Color(255, 255, 255));
        Localidad.setToolTipText("");
        getContentPane().add(Localidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 130, 30));

        CodigoPostal.setBackground(new java.awt.Color(0, 51, 0));
        CodigoPostal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CodigoPostal.setForeground(new java.awt.Color(255, 255, 255));
        CodigoPostal.setToolTipText("");
        getContentPane().add(CodigoPostal, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 130, 30));

        Direccion.setBackground(new java.awt.Color(0, 51, 0));
        Direccion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Direccion.setForeground(new java.awt.Color(255, 255, 255));
        Direccion.setToolTipText("");
        getContentPane().add(Direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, 130, 30));

        codigoSupermercado.setBackground(new java.awt.Color(0, 51, 0));
        codigoSupermercado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        codigoSupermercado.setForeground(new java.awt.Color(255, 255, 255));
        codigoSupermercado.setToolTipText("");
        getContentPane().add(codigoSupermercado, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 130, 30));

        puestoTrabajo.setBackground(new java.awt.Color(0, 51, 0));
        puestoTrabajo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        puestoTrabajo.setForeground(new java.awt.Color(255, 255, 255));
        puestoTrabajo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dependiente", "Supervisor", "RRHH", "Director" }));
        getContentPane().add(puestoTrabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 130, 30));

        botonRegistro.setBackground(new java.awt.Color(102, 102, 102));
        botonRegistro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonRegistro.setForeground(new java.awt.Color(255, 255, 255));
        botonRegistro.setText("REGISTRARSE");
        botonRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistroActionPerformed(evt);
            }
        });
        getContentPane().add(botonRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, 160, 30));

        botonAtras.setBackground(new java.awt.Color(102, 102, 102));
        botonAtras.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonAtras.setForeground(new java.awt.Color(255, 255, 255));
        botonAtras.setText("ATRAS");
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed(evt);
            }
        });
        getContentPane().add(botonAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 80, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Codigo Postal:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, -1, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Localidad:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, -1, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Comunidad Autonoma:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Puesto trabajo:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 340, -1, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Codigo supermercado:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, -1, 30));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Green-Wallpaper-5.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonAtrasActionPerformed

    private void botonRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistroActionPerformed
        /*try{
            MainGrafic.crearBibliotecario(this.getBiblioteca(), this);
            this.aviso("HAS SIDO REGISTRADO");
            InicioSesion login=new InicioSesion(this.getBiblioteca());
            this.dispose();
        }
        catch(Excepciones e){
            this.aviso(e.getMessage());
        }
        catch(NumberFormatException excepcion){
            this.aviso("La edad tiene que ser un numero");
        }*/
    }//GEN-LAST:event_botonRegistroActionPerformed

    private void comunidadAutonomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comunidadAutonomaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comunidadAutonomaActionPerformed

    public void aviso (String mensaje){
        JOptionPane.showMessageDialog(null,mensaje); 
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistradoEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistradoEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistradoEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistradoEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistradoEmpleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CodigoPostal;
    private javax.swing.JTextField Direccion;
    private javax.swing.JTextField Localidad;
    private javax.swing.JTextField NIF;
    private javax.swing.JTextField apellido1;
    private javax.swing.JTextField apellido2;
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonRegistro;
    private javax.swing.JTextField codigoSupermercado;
    private javax.swing.JComboBox<String> comunidadAutonoma;
    private javax.swing.JTextField contrasena;
    private javax.swing.JTextField edad;
    private javax.swing.JTextField email;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField nombre;
    private javax.swing.JComboBox<String> puestoTrabajo;
    private javax.swing.JTextField repetirContrasena;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}
