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
        Herramientas.modificarDatosTabla("INSERT INTO ProductoAlimento VALUES("+pa1.getCaducidad()+","+pa1.getCategoria()+","+pa1.getCodigoProd()+","+pa1.getNombreProd()+","+pa1.getPrecioProd()+","+pa1.getDescripcionProd()+")");
    }
    
    public static void EliminarAlimento(ProductoAlimento pa1) throws SQLException{
        Herramientas.modificarDatosTabla("DELETE FROM ProductoAlimento WHERE codigo_producto = "+pa1.getCodigoProd());
    }
    
    public static void BuscarAlimento(String buscar) throws SQLException{
        Herramientas.modificarDatosTabla("SELECT * FROM ProductoAlimento WHERE nombre_productoAlimento LIKE '%"+buscar+"%'");
    }    
}


//test constructor comida que iria dentro del metodo main
//      float myNum = 5.1f;
//      int cadu = 30;
//      int codigo = ProductoAlimento.UltimoNumero();
//      ProductoAlimento pipas = new ProductoAlimento(cadu, Categoria.vegano, codigo, "pipas" , myNum ,  "pipas saladas");
//      System.out.println(pipas.getCodigoProd());
//      System.out.println(pipas.UltimoNumero);  
