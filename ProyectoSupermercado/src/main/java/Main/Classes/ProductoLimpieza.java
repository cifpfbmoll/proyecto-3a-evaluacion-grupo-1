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
        Herramientas.modificarDatosTabla("INSERT INTO ProductoLimpieza VALUES("+pl1.getSuperficie()+","+pl1.getCodigoProd()+","+pl1.getNombreProd()+","+pl1.getPrecioProd()+","+pl1.getDescripcionProd()+")");
    }
    
    public static void EliminarLimpieza(ProductoLimpieza pl1) throws SQLException{
        Herramientas.modificarDatosTabla("DELETE FROM ProductoLimpieza WHERE codigo_producto = "+pl1.getCodigoProd());
    }
    
    public static void BuscarLimpieza(String buscar) throws SQLException{
        Herramientas.modificarDatosTabla("SELECT * FROM ProductoLimpieza WHERE nombre_productoLimpieza LIKE '%"+buscar+"%'");
    }
}
