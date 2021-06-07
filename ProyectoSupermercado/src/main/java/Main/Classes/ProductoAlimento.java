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
    
    public static ProductoAlimento crearProductoAlimento(int caducidad, Categoria categoria, String nombreProd, double precioProd, String descripcionProd) throws SQLException {
        int ultimoCodigoProd = ProductoAlimento.ultimoNumero();
        ProductoAlimento pa1 = new ProductoAlimento(caducidad, categoria, ultimoCodigoProd, nombreProd, precioProd, descripcionProd);
        return pa1;
    }
    
    public static void añadirAlimento(ProductoAlimento pa1) throws SQLException{
        Connection conexion = Herramientas.getConexion();
        try{
            conexion.setAutoCommit(false);
            PreparedStatement query = conexion.prepareStatement("INSERT INTO producto VALUES(?,?,?,?,?)");
            query.setInt(1, pa1.getCodigoProd());
            query.setString(2, pa1.getNombreProd());
            query.setDouble(3, pa1.getPrecioProd());
            query.setString(4, pa1.getDescripcionProd());
            query.setString(5, "Alimento");
            query.executeUpdate();
            query = conexion.prepareStatement("INSERT INTO producto_alimento VALUES(?,?,?)");
            query.setInt(1, pa1.getCodigoProd());
            query.setInt(2, pa1.getCaducidad());
            query.setString(3, String.valueOf(pa1.getCategoria()));
            query.executeUpdate();
            query=conexion.prepareStatement("INSERT INTO stock_supermercado "+
            "SELECT DISTINCT(Codigo_supermercado),?,0 FROM stock_supermercado;");
            query.setInt(1, pa1.getCodigoProd());
            query.executeUpdate();
            conexion.commit();
            conexion.setAutoCommit(true);
            query.close();
        }catch (SQLException sqlException){
            Herramientas.aviso("Ha fallado la transacción de añadir Alimento");
            Excepciones.pasarExcepcionLog("Ha fallado la transacción de añadir Alimento", sqlException);
            conexion.rollback();
            conexion.setAutoCommit(true);
        }
        
        
        /*Forma de hacerlo con herramientas (antigua):
                
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
        }*/
    }
    
    public static void eliminarAlimento(int codigoProd) throws SQLException{
        Connection conexion = Herramientas.getConexion();
        try{
            conexion.setAutoCommit(false);
            PreparedStatement query = conexion.prepareStatement("DELETE FROM producto_alimento WHERE Codigo_producto = ?");
            query.setInt(1, codigoProd);
            query.executeUpdate();
            query = conexion.prepareStatement("DELETE FROM producto WHERE Codigo_producto = ?");
            query.setInt(1, codigoProd);
            query.executeUpdate();
            query= conexion.prepareStatement("DELETE FROM stock_supermercado WHERE Codigo_producto = ?");
            query.setInt(1, codigoProd);
            query.executeUpdate();
            query= conexion.prepareStatement("DELETE FROM linea_carrito WHERE codigo_producto=?");
            query.setInt(1, codigoProd);
            query.executeUpdate();
            conexion.commit();
            query.close();
            conexion.setAutoCommit(true);
        } catch (SQLException sqlException){
            Herramientas.aviso("Ha fallado la transacción de eliminar Alimento");
            Excepciones.pasarExcepcionLog("Ha fallado la transacción de eliminar Alimento", sqlException);
            conexion.rollback();
            conexion.setAutoCommit(true);
        }
        
        
        
        /*Forma de hacerlo con herramientas (antigua):
        
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
            //error.printStackTrace();
        }*/
    }
    
    public static ProductoAlimento recogerAlimento(int buscar){
        Connection conexion = Herramientas.getConexion();
        try{
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
            query.close();
            return pa1;
        } catch (SQLException sqlException){
            Herramientas.aviso("Ha fallado al intentar recoger el Alimento de la bbdd");
            Excepciones.pasarExcepcionLog("Ha fallado al intentar recoger el Alimento de la bbdd", sqlException);
            return null;
        }
        
       
    }
}