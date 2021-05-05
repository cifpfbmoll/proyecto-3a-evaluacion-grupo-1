/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Classes;

import Grafics.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author josep
 */



public class Main {
    
    private static Cliente clienteActivo;
    private static Empleado empleadoActivo;
    private static Supermercado supermercadoActivo;

    public static Cliente getClienteActivo() {
        return clienteActivo;
    }

    public static void setClienteActivo(Cliente clienteActivo) {
        Main.clienteActivo = clienteActivo;
    }

    public static Empleado getEmpleadoActivo() {
        return empleadoActivo;
    }

    public static void setEmpleadoActivo(Empleado empleadoActivo) {
        Main.empleadoActivo = empleadoActivo;
    }

    public static Supermercado getSupermercadoActivo() {
        return supermercadoActivo;
    }

    public static void setSupermercadoActivo(Supermercado supermercadoActivo) {
        Main.supermercadoActivo = supermercadoActivo;
    }
    
    public static void main(String[] args) throws Excepciones, SQLException{
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
            java.util.logging.Logger.getLogger(Registrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    Herramientas.crearConexion();
//                } catch (SQLException ex) {
//                    Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                InicioSesion login=new InicioSesion();
//            }
//        });
        Herramientas.crearConexion();
        Empleado.eliminarPersona(Herramientas.getConexion(), 25);
        Empleado.añadirPersona("Manolo", "Martinez", "sol", 20, "43213528T", "Balears", "Palma", "07006", "Calle Aragon", "manolo@gmail.com", "sisi123", "sisi123", "3687465736", 1, "Dependiente", 1, Herramientas.getConexion());
        Herramientas.cerrarConexion();
    }
}
