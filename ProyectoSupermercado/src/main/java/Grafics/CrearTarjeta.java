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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jcanarte
 */
public class CrearTarjeta extends javax.swing.JFrame {

    /**
     * Creates new form CrearTarjeta
     */
    
    public InterfazUsuario3 frameLlamando2;
    
    public CrearTarjeta() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public CrearTarjeta(InterfazUsuario3 frame) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setFrameLlamando2(frame);
    }

    public InterfazUsuario3 getFrameLlamando2() {
        return frameLlamando2;
    }

    public void setFrameLlamando2(InterfazUsuario3 frameLlamando2) {
        this.frameLlamando2 = frameLlamando2;
    }
    
    
    
    public JTextField getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(JTextField fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public JTextField getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(JTextField numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public JComboBox getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(JComboBox tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public JTextField getTitularTarjeta() {
        return titularTarjeta;
    }

    public void setTitularTarjeta(JTextField titularTarjeta) {
        this.titularTarjeta = titularTarjeta;
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
        botonCancelar = new javax.swing.JButton();
        numeroTarjeta = new javax.swing.JTextField();
        fechaCaducidad = new javax.swing.JTextField();
        titularTarjeta = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tipoTarjeta = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        botonGuardar = new javax.swing.JButton();
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
        setMaximumSize(new java.awt.Dimension(398, 331));
        setMinimumSize(new java.awt.Dimension(398, 331));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(398, 331));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        getContentPane().add(botonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 110, 40));
        getContentPane().add(numeroTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 200, -1));

        fechaCaducidad.setText("MM/YY");
        getContentPane().add(fechaCaducidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 70, -1));
        getContentPane().add(titularTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 230, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Número");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fecha caducidad");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre titular");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tipo tarjeta");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        tipoTarjeta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Visa", "Mastercard", "American Express" }));
        getContentPane().add(tipoTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 120, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Guardar Tarjeta");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 300, 40));

        botonGuardar.setBackground(new java.awt.Color(102, 102, 102));
        botonGuardar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        botonGuardar.setForeground(new java.awt.Color(255, 255, 255));
        botonGuardar.setText("Guardar");
        botonGuardar.setMaximumSize(new java.awt.Dimension(75, 23));
        botonGuardar.setMinimumSize(new java.awt.Dimension(75, 23));
        botonGuardar.setPreferredSize(new java.awt.Dimension(75, 23));
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(botonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 240, 110, 40));

        fondo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Green-Wallpaper-5.jpg"))); // NOI18N
        getContentPane().add(fondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
    if(numeroTarjeta.getText().isEmpty() || titularTarjeta.getText().isEmpty() || fechaCaducidad.getText().isEmpty()){
        JOptionPane.showMessageDialog(this, "META SUS DATOS", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        numeroTarjeta.setText("");
        titularTarjeta.setText("");
        fechaCaducidad.setText("");
        numeroTarjeta.requestFocus();
        titularTarjeta.requestFocus();
        fechaCaducidad.requestFocus();
        tipoTarjeta.requestFocus();
    } else {
            PreparedStatement query=null;
            try {
                query=Herramientas.getConexion().prepareStatement(
                "Select COUNT(Numero_tarjeta) from TARJETA_CLIENTE where Numero_tarjeta=?");
                query.setString(1, this.getNumeroTarjeta().getText());
                ResultSet resultado=query.executeQuery();
                resultado.next();
                if(resultado.getInt(1) >= 1){
                    JOptionPane.showMessageDialog(this, "ESTA TARJETA YA EXISTE" , "Informacion", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    Tarjeta.añadirTarjeta(this.getNumeroTarjeta().getText(), this.getTitularTarjeta().getText(), 
                    this.getFechaCaducidad().getText(), this.getTipoTarjeta().getSelectedItem().toString());
                    numeroTarjeta.setText("");
                    titularTarjeta.setText("");
                    fechaCaducidad.setText("");
                    numeroTarjeta.requestFocus();
                    titularTarjeta.requestFocus();
                    fechaCaducidad.requestFocus();
                    if (this.getFrameLlamando2()!=null){
                        ElegirTarjeta elegir=new ElegirTarjeta(this.getFrameLlamando2());
                    } else{
                        JOptionPane.showMessageDialog(this, "LOS DATOS HAN SIGO GUARDADOS CORRECTAMENTE");
                    }
                    this.dispose();
                }
            }catch (SQLException ex){
                Herramientas.aviso("Ha ocurrido un error al guardar su tarjeta");
                Excepciones.pasarExcepcionLog("Ha ocurrido un error al guardar su tarjeta", ex);
            }
            finally{
                try {
                    query.close();
                } catch (SQLException ex) {
                    Herramientas.aviso("Ha ocurrido un error al guardar su tarjeta");
                    Excepciones.pasarExcepcionLog("Ha ocurrido un error al guardar su tarjeta", ex);
                }
            }
        }          
    }//GEN-LAST:event_botonGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JTextField fechaCaducidad;
    private javax.swing.JLabel fondo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField numeroTarjeta;
    private javax.swing.JComboBox tipoTarjeta;
    private javax.swing.JTextField titularTarjeta;
    // End of variables declaration//GEN-END:variables


}
