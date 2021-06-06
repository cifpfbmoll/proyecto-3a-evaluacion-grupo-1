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

public class ProductoLimpieza extends Producto {
    private Superficie superficie;
    public enum Superficie{
        madera,
        marmol,
        cristal,
        metal,
        varios
    }

    public ProductoLimpieza(Superficie superficie, int codigoProd, String nombreProd, double precioProd, String descripcionProd) {
        super(codigoProd, nombreProd, precioProd, descripcionProd);
        this.superficie = superficie;
    }

    public Superficie getSuperficie() {
        return superficie;
    }
    
    public void setSuperficie(ProductoLimpieza.Superficie superficie) {
        switch(superficie){
            case madera -> this.superficie = superficie;
            case marmol -> this.superficie = superficie;
            case cristal -> this.superficie = superficie;
            case metal -> this.superficie = superficie;
            case varios -> this.superficie = superficie;
        }
    }
    
    public static ProductoLimpieza crearProductoLimpieza(Superficie superficie, String nombreProd, double precioProd, String descripcionProd) throws SQLException {
        int ultimoCodigoProd = ProductoLimpieza.ultimoNumero();
        ProductoLimpieza pl1 = new ProductoLimpieza(superficie, ultimoCodigoProd, nombreProd, precioProd, descripcionProd);
        return pl1;
    }
    
    public static void añadirLimpieza(ProductoLimpieza pl1) throws SQLException{
        Connection conexion = Herramientas.getConexion();
        try{
            conexion.setAutoCommit(false);
            PreparedStatement query = conexion.prepareStatement("INSERT INTO producto VALUES(?,?,?,?,?)");
            query.setInt(1, pl1.getCodigoProd());
            query.setString(2, pl1.getNombreProd());
            query.setDouble(3, pl1.getPrecioProd());
            query.setString(4, pl1.getDescripcionProd());
            query.setString(5, "Limpieza");
            query.executeUpdate();
            conexion.commit();
            query = conexion.prepareStatement("INSERT INTO producto_limpieza VALUES(?,?)");
            query.setInt(1, pl1.getCodigoProd());
            query.setString(2, String.valueOf(pl1.getSuperficie()));
            query.executeUpdate();
            conexion.commit();
            conexion.setAutoCommit(true);
            query.close();
        }catch (SQLException sqlException){
            Herramientas.aviso("Ha fallado la transacción de añadir Limpieza");
            Excepciones.pasarExcepcionLog("Ha fallado la transacción de añadir Limpieza", sqlException);
            conexion.rollback();
            conexion.setAutoCommit(true);
        }
        
//        try{
//            Herramientas.modificarDatosTabla("INSERT INTO producto VALUES("+pl1.getCodigoProd()+",'"+pl1.getNombreProd()+"',"+pl1.getPrecioProd()+",'"+pl1.getDescripcionProd()+"','Limpieza')",false);
//            Herramientas.modificarDatosTabla("INSERT INTO producto_limpieza VALUES("+pl1.getCodigoProd()+",'"+pl1.getSuperficie()+"')",false);
//            Herramientas.cerrarStatementResult();
//            Herramientas.getConexion().setAutoCommit(true);
//            Herramientas.cerrarStatementResult();
//        } catch (SQLException error){
//            Herramientas.getConexion().rollback();
//            Herramientas.getConexion().setAutoCommit(true);
//            Herramientas.aviso("Ha habido un error");
//            //error.printStackTrace();
//        }        
    }
    
    public static void eliminarLimpieza(int codigoProd) throws SQLException{
        Connection conexion = Herramientas.getConexion();
        try{
            conexion.setAutoCommit(false);
            PreparedStatement query = conexion.prepareStatement("DELETE FROM producto_limpieza WHERE Codigo_producto = ?");
            query.setInt(1, codigoProd);
            query.executeUpdate();
            conexion.commit();
            query = conexion.prepareStatement("DELETE FROM producto WHERE Codigo_producto = ?");
            query.setInt(1, codigoProd);
            query.executeUpdate();
            conexion.commit();
            query.close();
            conexion.setAutoCommit(true);
        } catch (SQLException sqlException){
            Herramientas.aviso("Ha fallado la transacción de eliminar Limpieza");
            Excepciones.pasarExcepcionLog("Ha fallado la transacción de eliminar Limpieza", sqlException);
            conexion.rollback();
            conexion.setAutoCommit(true);
        }
        
//        Metodo antiguo con Herramientas
//        try{
//            Herramientas.modificarDatosTabla("DELETE FROM producto_limpieza WHERE Codigo_producto = "+codigoProd,false);
//            Herramientas.modificarDatosTabla("DELETE FROM producto WHERE Codigo_producto = "+codigoProd,false);
//            Herramientas.getConexion().commit();
//            Herramientas.getConexion().setAutoCommit(true);
//            Herramientas.cerrarStatementResult();
//        } catch (SQLException error){
//            Herramientas.getConexion().rollback();
//            Herramientas.getConexion().setAutoCommit(true);
//            Herramientas.aviso("Ha habido un error");
//            error.printStackTrace();
//        }
    }
    
    public static ProductoLimpieza recogerLimpieza(int buscar) throws SQLException{
        Connection conexion = Herramientas.getConexion();
        try{
            PreparedStatement query = conexion.prepareStatement("SELECT * FROM producto_limpieza WHERE Codigo_producto = ?");
            query.setInt(1, buscar);
            ResultSet resultado = query.executeQuery();
            resultado.next();
            Superficie superficie = Superficie.valueOf(resultado.getString("Superficie"));
            query = conexion.prepareStatement("SELECT * FROM producto WHERE Codigo_producto = ?");
            query.setInt(1, buscar);
            resultado = query.executeQuery();
            resultado.next();
            String name = resultado.getString("Nombre_producto");
            double precio = resultado.getDouble("Precio_producto");
            String descri = resultado.getString("descripcionProd");
            ProductoLimpieza pl1 = new ProductoLimpieza(superficie, buscar, name, precio, descri);
            query.close();
            return pl1;
        } catch (SQLException sqlException){
            Herramientas.aviso("Ha fallado al intentar recoger la Limpieza de la bbdd");
            Excepciones.pasarExcepcionLog("Ha fallado al intentar recoger la Limpieza de la bbdd", sqlException);
            return null;
        }
    }
}
