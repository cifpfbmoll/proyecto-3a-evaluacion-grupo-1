/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Classes;

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
    
    public static ProductoLimpieza CrearProductoLimpieza(Superficie superficie, String nombreProd, double precioProd, String descripcionProd) throws SQLException {
        int ultimoCodigoProd = ProductoLimpieza.UltimoNumero();
        ProductoLimpieza pl1 = new ProductoLimpieza(superficie, ultimoCodigoProd, nombreProd, precioProd, descripcionProd);
        return pl1;
    }
    
    public static void AñadirLimpieza(ProductoLimpieza pl1) throws SQLException{
        try{
            Herramientas.modificarDatosTabla("INSERT INTO producto VALUES("+pl1.getCodigoProd()+",'"+pl1.getNombreProd()+"',"+pl1.getPrecioProd()+",'"+pl1.getDescripcionProd()+"','Limpieza')",false);
            Herramientas.modificarDatosTabla("INSERT INTO producto_limpieza VALUES("+pl1.getCodigoProd()+",'"+pl1.getSuperficie()+"')",false);
            Herramientas.cerrarStatementResult();
            Herramientas.getConexion().setAutoCommit(true);
            Herramientas.cerrarStatementResult();
        } catch (SQLException error){
            Herramientas.getConexion().rollback();
            Herramientas.getConexion().setAutoCommit(true);
            Herramientas.aviso("Ha habido un error");
            //error.printStackTrace();
        }
        
    }
    
    public static void EliminarLimpieza(int codigoProd) throws SQLException{
        try{
            Herramientas.modificarDatosTabla("DELETE FROM producto_limpieza WHERE Codigo_producto = "+codigoProd,false);
            Herramientas.modificarDatosTabla("DELETE FROM producto WHERE Codigo_producto = "+codigoProd,false);
            Herramientas.getConexion().commit();
            Herramientas.getConexion().setAutoCommit(true);
            Herramientas.cerrarStatementResult();
        } catch (SQLException error){
            Herramientas.getConexion().rollback();
            Herramientas.getConexion().setAutoCommit(true);
            Herramientas.aviso("Ha habido un error");
            //error.printStackTrace();
        }
        
    }
    
    //falta añadir que a parte del nombre te digo que tipo de producto es
    public static void BuscarLimpieza(String buscar) throws SQLException{
        Herramientas.modificarDatosTabla("SELECT * FROM producto WHERE Nombre_producto LIKE '%"+buscar+"%'",true);
        Herramientas.cerrarStatementResult();
    }
}
