/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author josep
 */

public class ProductoHigiene extends Producto {
    private TipoHigiene tipoHigiene;
    public enum TipoHigiene{
        crema,
        serum,
        maquillaje,
        mascarilla,
        champu,
        gel,
        desorodante,
        jabon,
        mascarillas,
        toallitas,
        otros
    }

    public ProductoHigiene(TipoHigiene tipoHigiene, int codigoProd, String nombreProd, double precioProd, String descripcionProd) {
        super(codigoProd, nombreProd, precioProd, descripcionProd);
        this.tipoHigiene = tipoHigiene;
    }

    public TipoHigiene getTipoHigiene() {
        return tipoHigiene;
    }
    
    public void setTipoCategoria(ProductoHigiene.TipoHigiene tipoHigiene) {
        switch(tipoHigiene){
            case crema -> this.tipoHigiene = tipoHigiene;
            case serum -> this.tipoHigiene = tipoHigiene;
            case maquillaje -> this.tipoHigiene = tipoHigiene;
            case mascarilla -> this.tipoHigiene = tipoHigiene;
            case champu -> this.tipoHigiene = tipoHigiene;
            case gel -> this.tipoHigiene = tipoHigiene;
            case desorodante -> this.tipoHigiene = tipoHigiene;
            case jabon -> this.tipoHigiene = tipoHigiene;
            case mascarillas -> this.tipoHigiene = tipoHigiene;
            case toallitas -> this.tipoHigiene = tipoHigiene;
            case otros -> this.tipoHigiene = tipoHigiene;
        }
    }
    
    public static ProductoHigiene crearProductoHigiene(TipoHigiene tipoHigiene, String nombreProd, double precioProd, String descripcionProd) throws SQLException {
        int ultimoCodigoProd = ProductoHigiene.ultimoNumero();
        ProductoHigiene ph1 = new ProductoHigiene(tipoHigiene, ultimoCodigoProd, nombreProd, precioProd, descripcionProd);
        return ph1;
    }
    
    public static void añadirHigiene(ProductoHigiene ph1) throws SQLException{
        Connection conexion = Herramientas.getConexion();
        try{
            conexion.setAutoCommit(false);
            PreparedStatement query = conexion.prepareStatement("INSERT INTO producto VALUES(?,?,?,?,?)");
            query.setInt(1, ph1.getCodigoProd());
            query.setString(2, ph1.getNombreProd());
            query.setDouble(3, ph1.getPrecioProd());
            query.setString(4, ph1.getDescripcionProd());
            query.setString(5, "Higiene");
            query.executeUpdate();
            query = conexion.prepareStatement("INSERT INTO producto_higiene VALUES(?,?)");
            query.setInt(1, ph1.getCodigoProd());
            query.setString(2, String.valueOf(ph1.getTipoHigiene()));
            query.executeUpdate();
            query=conexion.prepareStatement("INSERT INTO stock_supermercado "+
            "SELECT DISTINCT(Codigo_supermercado),?,0 FROM stock_supermercado;");
            query.setInt(1, ph1.getCodigoProd());
            query.executeUpdate();
            conexion.commit();
            conexion.setAutoCommit(true);
            query.close();
        }catch (SQLException sqlException){
            Herramientas.aviso("Ha fallado la transacción de añadir Higiene");
            Excepciones.pasarExcepcionLog("Ha fallado la transacción de añadir Higiene", sqlException);
            conexion.rollback();
            conexion.setAutoCommit(true);
        }
        
//        Metodo antiguo con la clase Herramientas
//        try{
//            Herramientas.modificarDatosTabla("INSERT INTO producto VALUES("+ph1.getCodigoProd()+",'"+ph1.getNombreProd()+"',"+ph1.getPrecioProd()+",'"+ph1.getDescripcionProd()+"','Higiene')",false);
//            Herramientas.modificarDatosTabla("INSERT INTO producto_higiene VALUES("+ph1.getCodigoProd()+",'"+ph1.getTipoHigiene()+"')",false);
//            Herramientas.getConexion().commit();
//            Herramientas.getConexion().setAutoCommit(true);
//            Herramientas.cerrarStatementResult();
//        } catch (SQLException error){
//            Herramientas.getConexion().rollback();
//            Herramientas.getConexion().setAutoCommit(true);
//            Herramientas.aviso("Ha habido un error");
//            //error.printStackTrace();
//        }
    }
    
    public static void eliminarHigiene(int codigoProd) throws SQLException{
        Connection conexion = Herramientas.getConexion();
        try{
            conexion.setAutoCommit(false);
            PreparedStatement query = conexion.prepareStatement("DELETE FROM producto_higiene WHERE Codigo_producto = ?");
            query.setInt(1, codigoProd);
            query.executeUpdate();
            query = conexion.prepareStatement("DELETE FROM producto WHERE Codigo_producto = ?");
            query.setInt(1, codigoProd);
            query.executeUpdate();
            query= conexion.prepareStatement("DELETE FROM stock_supermercado WHERE Codigo_producto = ?");
            query.setInt(1, codigoProd);
            query.executeUpdate();
            conexion.commit();
            query.close();
            conexion.setAutoCommit(true);
        } catch (SQLException sqlException){
            Herramientas.aviso("Ha fallado la transacción de eliminar Higiene");
            Excepciones.pasarExcepcionLog("Ha fallado la transacción de eliminar Higiene", sqlException);
            conexion.rollback();
            conexion.setAutoCommit(true);
        }

//        Metodo Antiguo con clase Herramientas
//        try{
//            Herramientas.modificarDatosTabla("DELETE FROM producto_higiene WHERE Codigo_producto = "+codigoProd,false);
//            Herramientas.modificarDatosTabla("DELETE FROM producto WHERE Codigo_producto = "+codigoProd,false);
//            Herramientas.getConexion().commit();
//            Herramientas.getConexion().setAutoCommit(true);
//            Herramientas.cerrarStatementResult();
//        } catch (SQLException error){
//            Herramientas.getConexion().rollback();
//            Herramientas.getConexion().setAutoCommit(true);
//            Herramientas.aviso("Ha habido un error");
//            //error.printStackTrace();
//        }
    }
    
    public static ProductoHigiene recogerHigiene(int buscar) throws SQLException{
        Connection conexion = Herramientas.getConexion();
        try{
            PreparedStatement query = conexion.prepareStatement("SELECT * FROM producto_higiene WHERE Codigo_producto = ?");
            query.setInt(1, buscar);
            ResultSet resultado = query.executeQuery();
            resultado.next();
            TipoHigiene tipo = TipoHigiene.valueOf(resultado.getString("Tipo_higiene"));
            query = conexion.prepareStatement("SELECT * FROM producto WHERE Codigo_producto = ?");
            query.setInt(1, buscar);
            resultado = query.executeQuery();
            resultado.next();
            String name = resultado.getString("Nombre_producto");
            double precio = resultado.getDouble("Precio_producto");
            String descri = resultado.getString("descripcionProd");
            ProductoHigiene ph1 = new ProductoHigiene(tipo, buscar, name, precio, descri);
            query.close();
            return ph1;
        }catch (SQLException sqlException){
            Herramientas.aviso("Ha fallado al intentar recoger la Higiene de la bbdd");
            Excepciones.pasarExcepcionLog("Ha fallado al intentar recoger la Higiene de la bbdd", sqlException);
            conexion.rollback();
            return null;
        }
    } 
}
