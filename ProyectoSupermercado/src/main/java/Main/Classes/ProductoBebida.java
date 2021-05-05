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

public final class ProductoBebida extends Producto {
    private int caducidad;
    private Boolean alcoholica;

    public ProductoBebida(int caducidad, Boolean alcoholica, int codigoProd, String nombreProd, float precioProd, String descripcionProd) {
        super(codigoProd, nombreProd, precioProd,descripcionProd);
        this.setCaducidad(caducidad);
        this.setAlcoholica(alcoholica);
    }

    public int getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(int caducidad) {
        this.caducidad = caducidad;
    }

    public Boolean getAlcoholica() {
        return alcoholica;
    }

    public void setAlcoholica(Boolean alcoholica) {
        this.alcoholica = alcoholica;
    } 
    
    public static void CrearProductoBebida(int caducidad, Boolean alcoholica, String nombreProd, float precioProd, String descripcionProd) throws SQLException {
        int ultimoCodigoProd = ProductoAlimento.UltimoNumero();
        ProductoBebida pb1 = new ProductoBebida(caducidad, alcoholica, ultimoCodigoProd, nombreProd, precioProd, descripcionProd);
    }
    
    public static void AñadirBebida(ProductoBebida pb1) throws SQLException{
        Herramientas.modificarDatosTabla("INSERT INTO producto VALUES("+pb1.getCodigoProd()+","+pb1.getNombreProd()+","+pb1.getPrecioProd()+","+pb1.getDescripcionProd()+")",true);
        Herramientas.modificarDatosTabla("INSERT INTO producto_bebida VALUES("+pb1.getCodigoProd()+","+pb1.getCaducidad()+","+pb1.getAlcoholica()+")",true);
        Herramientas.cerrarStatementResult();
    }
    
    public static void EliminarBebida(int codigoProd) throws SQLException{
        Herramientas.modificarDatosTabla("DELETE FROM producto WHERE Codigo_producto = "+codigoProd,true);
        Herramientas.modificarDatosTabla("DELETE FROM producto_bebida WHERE Codigo_producto = "+codigoProd,true);
        Herramientas.cerrarStatementResult();
    }
    
    //falta añadir que a parte del nombre te digo que tipo de producto es
    public static void BuscarBebida(String buscar) throws SQLException{
        Herramientas.modificarDatosTabla("SELECT * FROM producto WHERE Nombre_producto LIKE '%"+buscar+"%'",true);
        Herramientas.cerrarStatementResult();
    } 
}

//Prueba añadir bebida
//Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse("02/01/2020");
//ProductoBebida bebida = new ProductoBebida(fecha, true, 1, "Test", 3, "si");
//System.out.println(bebida.getCaducidad());
