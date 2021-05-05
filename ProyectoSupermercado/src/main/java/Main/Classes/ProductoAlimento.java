/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Classes;

import java.util.Scanner;
import java.sql.*;

/**
 *
 * @author josep
 */

public final class ProductoAlimento extends Producto {
    public static Scanner lectorLibro = new Scanner(System.in);
    private int caducidad;
    private Categoria categoria;
    boolean UltimoNumero;
    
    public enum Categoria{
        vegano,
        vegetariano,
        carnivoro
    }

    public ProductoAlimento(int caducidad, Categoria categoria, int codigoProd, String nombreProd, float precioProd, String descripcionProd) {
        super(codigoProd, nombreProd, precioProd,descripcionProd);
        this.setCaducidad(caducidad);
        this.setCategoria(categoria);
    }
    
    public int getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(int caducidad) {
        this.caducidad = caducidad;
    }

    public Categoria getCategoria() {
        return categoria;
    }
        
    public void setCategoria(Categoria categoria) {
        switch(categoria){
            case vegano -> this.categoria = categoria;
            case vegetariano -> this.categoria = categoria;
            case carnivoro -> this.categoria = categoria;
        }
    }
    
    public static void CrearProductoAlimento(int caducidad, Categoria categoria, String nombreProd, float precioProd, String descripcionProd) throws SQLException {
        int ultimoCodigoProd = ProductoAlimento.UltimoNumero();
        ProductoAlimento pa1 = new ProductoAlimento(caducidad, categoria, ultimoCodigoProd, nombreProd, precioProd, descripcionProd);
    }
    
    public static void AñadirAlimento(ProductoAlimento pa1) throws SQLException{
        Herramientas.modificarDatosTabla("INSERT INTO producto VALUES("+pa1.getCodigoProd()+","+pa1.getNombreProd()+","+pa1.getPrecioProd()+","+pa1.getDescripcionProd()+")",true);
        Herramientas.modificarDatosTabla("INSERT INTO producto_alimento VALUES("+pa1.getCodigoProd()+","+pa1.getCaducidad()+","+pa1.getCategoria()+")",true);
        Herramientas.cerrarStatementResult();
    }
    
    public static void EliminarAlimento(int codigoProd) throws SQLException{
        Herramientas.modificarDatosTabla("DELETE FROM producto WHERE Codigo_producto = "+codigoProd,true);
        Herramientas.modificarDatosTabla("DELETE FROM producto_alimento WHERE Codigo_producto = "+codigoProd,true);
        Herramientas.cerrarStatementResult();
    }
    
    //falta añadir que a parte del nombre te digo que tipo de producto es
    public static void BuscarAlimento(String buscar) throws SQLException{
        Herramientas.modificarDatosTabla("SELECT * FROM producto WHERE Nombre_producto LIKE '%"+buscar+"%'",true);
        Herramientas.cerrarStatementResult();
    }    
}


//test constructor comida que iria dentro del metodo main
//      float myNum = 5.1f;
//      int cadu = 30;
//      int codigo = ProductoAlimento.UltimoNumero();
//      ProductoAlimento pipas = new ProductoAlimento(cadu, Categoria.vegano, codigo, "pipas" , myNum ,  "pipas saladas");
//      System.out.println(pipas.getCodigoProd());
//      System.out.println(pipas.UltimoNumero);  
