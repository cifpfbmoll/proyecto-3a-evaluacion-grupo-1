/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafics;

import Main.Classes.Empleado;
import Main.Classes.Excepciones;
import Main.Classes.Herramientas;
import Main.Classes.Main;
import Main.Classes.Nomina;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author aaron
 */
public class EliminarNomina extends javax.swing.JFrame {

    /**
     * Creates new form EliminarNom
     */
    ArrayList <Nomina> listaNoms;
    
    public EliminarNomina() {
        initComponents();
        añadirNominas();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public void añadirNominas() {
        try {
            this.setListaNomina(Nomina.recogerNomina(Main.getEmpleadoActivo().getId()));
            Nomina[] listaNumerosNomina=new Nomina[this.getListaNomina().size()];
            for(int i=0;i<this.getListaNomina().size();i++){
            numeroTarjeta.addItem(String.valueOf(this.getListaNomina().get(i).getCodigo_nomina()) + ". " + this.getListaNomina().get(i).getFecha_inicio() + " - " + this.getListaNomina().get(i).getFecha_fin());
        }
        } catch (SQLException ex) {
            Herramientas.aviso("Ha ocurrido un error al cargar sus nominas");
            Excepciones.pasarExcepcionLog("Ha ocurrido un error al cargar sus nominas", ex);
            this.dispose();
        }
    }

    public ArrayList<Nomina> getListaNomina() {
        return listaNoms;
    }
    

    public void setListaNomina(ArrayList<Nomina> listaNomina) {
        this.listaNoms = listaNomina;
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

        numeroTarjeta = new javax.swing.JComboBox<>();
        botonCancelar = new javax.swing.JButton();
        botonConfirmar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("  METRADONA©");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(450, 219));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        numeroTarjeta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        getContentPane().add(numeroTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 270, 40));

        botonCancelar.setBackground(new java.awt.Color(102, 102, 102));
        botonCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonCancelar.setForeground(new java.awt.Color(255, 255, 255));
        botonCancelar.setText("CANCELAR");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(botonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 150, 40));

        botonConfirmar.setBackground(new java.awt.Color(102, 102, 102));
        botonConfirmar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        botonConfirmar.setText("CONFIRMAR");
        botonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConfirmarActionPerformed(evt);
            }
        });
        getContentPane().add(botonConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 150, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ELIGE LA NOMINA A ELIMINAR");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Green-Wallpaper-5.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 220));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConfirmarActionPerformed
        try {
            String separador = Pattern.quote(".");
            String[] parts = this.numeroTarjeta.getSelectedItem().toString().split(separador);
            int cod = Integer.parseInt(parts[0]);
            System.out.println(String.valueOf(cod));
            Nomina.eliminarNomina(cod);
            Herramientas.aviso("Nomina eliminada");
        } catch (SQLException ex) {
            Herramientas.aviso("Ha ocurrido un error al eliminar su nomina");
            Excepciones.pasarExcepcionLog("Ha ocurrido un error al eliminar su nomina", ex);
        }
        this.dispose();
    }//GEN-LAST:event_botonConfirmarActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox<String> numeroTarjeta;
    // End of variables declaration//GEN-END:variables
}
