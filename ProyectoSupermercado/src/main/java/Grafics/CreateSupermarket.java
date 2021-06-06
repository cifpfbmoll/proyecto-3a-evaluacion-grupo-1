/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafics;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Main.Classes.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Main.Classes.*;
import Main.Classes.ProductoAlimento.Categoria;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jcanarte
 */
public class CreateSupermarket extends javax.swing.JFrame {

    /**
     * Creates new form CrearTarjeta
     */
    
    public InterfazUsuario3 frameLlamando2;

    public CreateSupermarket() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public JTextField getAddressTextField() {
        return addressTextField;
    }

    public JTextField getAreaTextField() {
        return areaTextField;
    }

    public JTextField getCcaaTextField() {
        return ccaaTextField;
    }

    public JTextField getEmailTextField() {
        return emailTextField;
    }

    public JTextField getLocalidadTextField() {
        return localidadTextField;
    }

    public JTextField getNifTextField() {
        return nifTextField;
    }

    public JTextField getPhoneNumTextField() {
        return phoneNumTextField;
    }

    public JTextField getZipCodeTextField() {
        return zipCodeTextField;
    }
    
    
    
    
    public InterfazUsuario3 getFrameLlamando2() {
        return frameLlamando2;
    }

    public void setFrameLlamando2(InterfazUsuario3 frameLlamando2) {
        this.frameLlamando2 = frameLlamando2;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        botonAñadir = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        nifTextField = new javax.swing.JTextField();
        ccaaTextField = new javax.swing.JTextField();
        localidadTextField = new javax.swing.JTextField();
        zipCodeTextField = new javax.swing.JTextField();
        addressTextField = new javax.swing.JTextField();
        phoneNumTextField = new javax.swing.JTextField();
        emailTextField = new javax.swing.JTextField();
        areaTextField = new javax.swing.JTextField();
        fondo1 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("  METRADONA©");
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(398, 331));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonAñadir.setBackground(new java.awt.Color(102, 102, 102));
        botonAñadir.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        botonAñadir.setForeground(new java.awt.Color(255, 255, 255));
        botonAñadir.setText("Añadir");
        botonAñadir.setToolTipText("");
        botonAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAñadirActionPerformed(evt);
            }
        });
        getContentPane().add(botonAñadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 110, 40));

        botonCancelar.setBackground(new java.awt.Color(102, 102, 102));
        botonCancelar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        botonCancelar.setForeground(new java.awt.Color(255, 255, 255));
        botonCancelar.setText("Cancelar");
        botonCancelar.setToolTipText("");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(botonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, 110, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NIF");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("E-Mail");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Localidad");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Dirección");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("AÑADIR SUPERMERCADO");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 480, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Comunidad Autónoma");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Código Postal");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Area");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Teléfono");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));
        getContentPane().add(nifTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 190, -1));
        getContentPane().add(ccaaTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 190, -1));
        getContentPane().add(localidadTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 190, -1));
        getContentPane().add(zipCodeTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 190, -1));
        getContentPane().add(addressTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 190, -1));
        getContentPane().add(phoneNumTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 190, -1));
        getContentPane().add(emailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 190, -1));
        getContentPane().add(areaTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 190, -1));

        fondo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Green-Wallpaper-5.jpg"))); // NOI18N
        getContentPane().add(fondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAñadirActionPerformed
        try {
            Supermercado.insertSupermarketIntoDB(getNifTextField(), getCcaaTextField(), getLocalidadTextField(), getZipCodeTextField(), getAddressTextField(), getPhoneNumTextField(), getEmailTextField(), getAreaTextField());
            Herramientas.aviso("El supermercado ha sido creado con exito");
        } catch (SQLException throwables) {
            Herramientas.aviso("Ha ocurrido un problema al insertar el supermercado");
            Excepciones.pasarExcepcionLog("Ha ocurrido un problema al insertar el supermercado", throwables);
        }
        this.dispose();
    }//GEN-LAST:event_botonAñadirActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressTextField;
    private javax.swing.JTextField areaTextField;
    private javax.swing.JButton botonAñadir;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JTextField ccaaTextField;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel fondo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField localidadTextField;
    private javax.swing.JTextField nifTextField;
    private javax.swing.JTextField phoneNumTextField;
    private javax.swing.JTextField zipCodeTextField;
    // End of variables declaration//GEN-END:variables


}