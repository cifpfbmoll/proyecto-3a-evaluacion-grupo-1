/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafics;

import Main.Classes.Excepciones;
import Main.Classes.Herramientas;
import Main.Classes.Main;
import Main.Classes.Producto;
import Main.Classes.ProductoAlimento;
import Main.Classes.ProductoBebida;
import Main.Classes.ProductoHigiene;
import Main.Classes.ProductoLimpieza;
import Main.Classes.Tarjeta;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author PC
 */
public class EliminarProducto extends javax.swing.JFrame {

    /**
     * Creates new form EliminarTarjeta
     */
    ArrayList <Producto> listaProductos;
        
    public EliminarProducto() {
        initComponents();
        añadirProductos();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
    
    public Image getIconImage(){
        Image miIcono=Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/logo1.png"));
        return miIcono;
    }
    
    public void borrarSeleccion() throws SQLException{
        Connection conexion = Herramientas.getConexion();
        try{
            String texto = String.valueOf(this.ProductoComboBox.getSelectedItem()).split(" ")[0];
            int codigo = Integer.parseInt(texto);
            PreparedStatement query = conexion.prepareStatement("SELECT * FROM producto WHERE Codigo_producto = ?");
            query.setInt(1, codigo);
            ResultSet resultado = query.executeQuery();
            resultado.next();
            String tipoProducto = resultado.getString(5);
            switch(tipoProducto){
                case "Alimento":
                    ProductoAlimento.eliminarAlimento(codigo);
                    this.dispose();
                    Herramientas.aviso("Producto borrado de la base datos");
                    break;
                case "Bebida":
                    ProductoBebida.eliminarBebida(codigo);
                    this.dispose();
                    Herramientas.aviso("Producto borrado de la base datos");
                    break;
                case "Higiene":
                    ProductoHigiene.eliminarHigiene(codigo);
                    this.dispose();
                    Herramientas.aviso("Producto borrado de la base datos");
                    break;
                case "Limpieza":
                    ProductoLimpieza.eliminarLimpieza(codigo);
                    this.dispose();
                    Herramientas.aviso("Producto borrado de la base datos");
                    break;
                default:
                    System.out.println("No hemos podido encontrar el producto seleccionado");
                    this.dispose();
                    break;
            }
            query.close();
        } catch (SQLException sqlException){
            Herramientas.aviso("No se ha podido borrar el producto seleccionado");
            Excepciones.pasarExcepcionLog("No se ha podido borrar el producto seleccionado", sqlException);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ProductoComboBox = new javax.swing.JComboBox<>();
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

        ProductoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        getContentPane().add(ProductoComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 270, 40));

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
        jLabel2.setText("ELIGE El PRODUCTO A ELIMINAR");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Green-Wallpaper-5.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 220));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConfirmarActionPerformed
        try {
            borrarSeleccion();
        } catch (SQLException ex) {
            Herramientas.aviso("No se ha podido borrar el producto seleccionado");
            Excepciones.pasarExcepcionLog("No se ha podido borrar el producto seleccionado", ex);
        }
        this.dispose();
    }//GEN-LAST:event_botonConfirmarActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed
    
    public void añadirProductos(){
        this.setListaProductos(Producto.recogerProducto());
        String[] listaProductos=new String[this.getListaProductos().size()];
        for(int i=0;i<this.getListaProductos().size();i++){
            listaProductos[i]=String.valueOf(this.getListaProductos().get(i).getCodigoProd()) + " " + this.getListaProductos().get(i).getNombreProd();
        }
        ProductoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(listaProductos));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ProductoComboBox;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
