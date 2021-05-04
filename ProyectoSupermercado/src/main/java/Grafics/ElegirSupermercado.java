/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafics;

import Main.Classes.Herramientas;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author jaume
 */
public class ElegirSupermercado extends javax.swing.JFrame {
    
    private InicioSesion login;
    /**
     * Creates new form ElegirSupermercado
     */
    public ElegirSupermercado() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    
    public ElegirSupermercado(InicioSesion login) {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.login=login;
    }

    public JList<String> getListaSupermercados() {
        return listaSupermercados;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollSupermercados = new javax.swing.JScrollPane();
        listaSupermercados = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        Elegir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        listaSupermercados.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        listaSupermercados.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Metradona Barcelona", "Metradona Las Plamas de Gran Canaria", "Metradona Madrid", "Metradona Mallorca", "Metradona Sevilla" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaSupermercados.setSelectionBackground(new java.awt.Color(51, 153, 0));
        scrollSupermercados.setViewportView(listaSupermercados);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Elige un supermercado");

        Elegir.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Elegir.setText("Elegir");
        Elegir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ElegirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollSupermercados, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(Elegir, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(scrollSupermercados, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Elegir, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ElegirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ElegirActionPerformed
        String supermercado=this.getListaSupermercados().getSelectedValue();
        if (supermercado==null){
            Herramientas.aviso("Elige un supermercado primero");
        }
        else{
            switch (supermercado){
                case "Metradona Barcelona":
                    System.out.println(supermercado);
                    //copiar datos de supermercado en supermercado activo
                    //iniciar frame principal cliente
                    login.dispose();
                    this.dispose();
                    break;
                    
                case "Metradona Las Plamas de Gran Canaria":
                    System.out.println(supermercado);
                    //copiar datos de supermercado en supermercado activo
                    //iniciar frame principal cliente
                    login.dispose();
                    this.dispose();
                    break;
                    
                case "Metradona Madrid":
                    System.out.println(supermercado);
                    //copiar datos de supermercado en supermercado activo
                    //iniciar frame principal cliente
                    login.dispose();
                    this.dispose();
                    break;
                    
                case "Metradona Mallorca":
                    System.out.println(supermercado);
                    //copiar datos de supermercado en supermercado activo
                    //iniciar frame principal cliente
                    login.dispose();
                    this.dispose();
                    break;
                    
                case "Metradona Sevilla":
                    System.out.println(supermercado);
                    //copiar datos de supermercado en supermercado activo
                    //iniciar frame principal cliente
                    login.dispose();
                    this.dispose();
                    break;
            }
        }
    }//GEN-LAST:event_ElegirActionPerformed
    
    
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
            java.util.logging.Logger.getLogger(ElegirSupermercado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ElegirSupermercado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ElegirSupermercado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ElegirSupermercado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ElegirSupermercado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Elegir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> listaSupermercados;
    private javax.swing.JScrollPane scrollSupermercados;
    // End of variables declaration//GEN-END:variables
}
