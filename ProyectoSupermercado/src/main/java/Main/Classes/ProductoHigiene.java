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

    public ProductoHigiene(TipoHigiene tipoHigiene, int codigoProd, String nombreProd, float precioProd, String descripcionProd) {
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
    
    public static void CrearProductoHigiene(TipoHigiene tipoHigiene, int codigoProd, String nombreProd, float precioProd, String descripcionProd) {
        ProductoHigiene ph1 = new ProductoHigiene(tipoHigiene, codigoProd, nombreProd, precioProd, descripcionProd);
    }
    
    public static void AñadirHigiene(ProductoHigiene ph1) throws SQLException{
        Herramientas.modificarDatosTabla("INSERT INTO producto VALUES("+ph1.getCodigoProd()+","+ph1.getNombreProd()+","+ph1.getPrecioProd()+","+ph1.getDescripcionProd()+")",true);
        Herramientas.modificarDatosTabla("INSERT INTO producto_higiene VALUES("+ph1.getCodigoProd()+","+ph1.getTipoHigiene()+")",true);
        Herramientas.cerrarStatementResult();
    }
    
    public static void EliminarHigiene(int codigoProd) throws SQLException{
        Herramientas.modificarDatosTabla("DELETE FROM producto WHERE Codigo_producto = "+codigoProd,true);
        Herramientas.modificarDatosTabla("DELETE FROM producto_higiene WHERE Codigo_producto = "+codigoProd,true);
        Herramientas.cerrarStatementResult();
    }
    
    //falta añadir que a parte del nombre te digo que tipo de producto es
    public static void BuscarHigiene(String buscar) throws SQLException{
        Herramientas.modificarDatosTabla("SELECT * FROM producto WHERE Nombre_producto LIKE '%"+buscar+"%'",true);
        Herramientas.cerrarStatementResult();
    }
}
