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

    public ProductoLimpieza(Superficie superficie, int codigoProd, String nombreProd, float precioProd, String descripcionProd) {
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
    
    public static void CrearProductoLimpieza(Superficie superficie, int codigoProd, String nombreProd, float precioProd, String descripcionProd) {
        ProductoLimpieza pl1 = new ProductoLimpieza(superficie, codigoProd, nombreProd, precioProd, descripcionProd);
    }
    
    public static void AñadirLimpieza(ProductoLimpieza pl1) throws SQLException{
        Herramientas.modificarDatosTabla("INSERT INTO producto VALUES("+pl1.getCodigoProd()+","+pl1.getNombreProd()+","+pl1.getPrecioProd()+","+pl1.getDescripcionProd()+")",true);
        Herramientas.modificarDatosTabla("INSERT INTO producto_limpieza VALUES("+pl1.getCodigoProd()+","+pl1.getSuperficie()+")",true);
        Herramientas.cerrarStatementResult();
    }
    
    public static void EliminarLimpieza(int codigoProd) throws SQLException{
        Herramientas.modificarDatosTabla("DELETE FROM producto WHERE Codigo_producto = "+codigoProd,true);
        Herramientas.modificarDatosTabla("DELETE FROM producto_limpieza WHERE Codigo_producto = "+codigoProd,true);
        Herramientas.cerrarStatementResult();
    }
    
    //falta añadir que a parte del nombre te digo que tipo de producto es
    public static void BuscarLimpieza(String buscar) throws SQLException{
        Herramientas.modificarDatosTabla("SELECT * FROM producto WHERE Nombre_producto LIKE '%"+buscar+"%'",true);
        Herramientas.cerrarStatementResult();
    }
}
