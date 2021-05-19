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
    
    public enum Categoria{
        vegano,
        vegetariano,
        carnivoro
    }

    public ProductoAlimento(int caducidad, Categoria categoria, int codigoProd, String nombreProd, double precioProd, String descripcionProd) {
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

    @Override
    public String toString() {
        return super.toString()+ "ProductoAlimento{" + "caducidad=" + caducidad + ", categoria=" + categoria + '}';
        
    }
    
    public static ProductoAlimento CrearProductoAlimento(int caducidad, Categoria categoria, String nombreProd, double precioProd, String descripcionProd) throws SQLException {
        int ultimoCodigoProd = ProductoAlimento.UltimoNumero();
        ProductoAlimento pa1 = new ProductoAlimento(caducidad, categoria, ultimoCodigoProd, nombreProd, precioProd, descripcionProd);
        return pa1;
    }
    
    public static void AñadirAlimento(ProductoAlimento pa1) throws SQLException{
        try{
            Herramientas.modificarDatosTabla("INSERT INTO producto VALUES("+pa1.getCodigoProd()+",'"+pa1.getNombreProd()+"',"+pa1.getPrecioProd()+",'"+pa1.getDescripcionProd()+"','Alimento')",false);
            Herramientas.modificarDatosTabla("INSERT INTO producto_alimento VALUES("+pa1.getCodigoProd()+","+pa1.getCaducidad()+",'"+pa1.getCategoria()+"')",false);
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
    
    public static void EliminarAlimento(int codigoProd) throws SQLException{
        try{
            Herramientas.modificarDatosTabla("DELETE FROM producto_alimento WHERE Codigo_producto = "+codigoProd,false);
            Herramientas.modificarDatosTabla("DELETE FROM producto WHERE Codigo_producto = "+codigoProd,false);
            Herramientas.getConexion().commit();
            Herramientas.getConexion().setAutoCommit(true);
            Herramientas.cerrarStatementResult();
            Herramientas.cerrarStatementResult();  
        } catch (SQLException error){
            Herramientas.getConexion().rollback();
            Herramientas.getConexion().setAutoCommit(true);
            Herramientas.aviso("Ha habido un error");
            error.printStackTrace();
        }

    }
    
    public static void RecogerAlimento(Connection conexion, int buscar) throws SQLException{
        PreparedStatement query = conexion.prepareStatement("SELECT * FROM producto_alimento WHERE Codigo_producto = ?");
        query.setInt(1, buscar);
        ResultSet resultado = query.executeQuery();
        resultado.next();
        int cadu = resultado.getInt("Caducidad");
        Categoria cat = Categoria.valueOf(resultado.getString("Categoria"));
        query = conexion.prepareStatement("SELECT * FROM producto WHERE Codigo_producto = ?");
        query.setInt(1, buscar);
        resultado = query.executeQuery();
        resultado.next();
        String name = resultado.getString("Nombre_producto");
        double precio = resultado.getDouble("Precio_producto");
        String descri = resultado.getString("descripcionProd");
        ProductoAlimento pa1 = new ProductoAlimento(cadu, cat, buscar, name, precio, descri);
        System.out.println(pa1.toString());
        //int caducidad, Categoria categoria, String nombreProd, double precioProd, String descripcionProd
    }
    
    //falta añadir que a parte del nombre te digo que tipo de producto es
    public static void BuscarAlimento(String buscar) throws SQLException{
        Herramientas.modificarDatosTabla("SELECT * FROM producto WHERE Nombre_producto LIKE '%"+buscar+"%'",true);
        Herramientas.cerrarStatementResult();
    }    
    
    public static void main(String[] args) throws SQLException {
        Herramientas.crearConexion();
        ProductoAlimento.RecogerAlimento(Herramientas.getConexion(), 3);
        Herramientas.cerrarConexion();
    }
}



//test constructor comida que iria dentro del metodo main
//      float myNum = 5.1f;
//      int cadu = 30;
//      int codigo = ProductoAlimento.UltimoNumero();
//      ProductoAlimento pipas = new ProductoAlimento(cadu, Categoria.vegano, codigo, "pipas" , myNum ,  "pipas saladas");
//      System.out.println(pipas.getCodigoProd());
//      System.out.println(pipas.UltimoNumero);  
