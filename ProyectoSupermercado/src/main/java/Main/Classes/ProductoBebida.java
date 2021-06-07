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

public final class ProductoBebida extends Producto {
    private int caducidad;
    private Boolean alcoholica;

    public ProductoBebida(int caducidad, Boolean alcoholica, int codigoProd, String nombreProd, double precioProd, String descripcionProd) {
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
    
    /**
     * Método para instanciar un ProductoBebida usando el método ultimoNumero y así asignarle directamente el código correcto, retorna un ProductoBebida.
     * @param caducidad
     * @param alcoholica
     * @param nombreProd
     * @param precioProd
     * @param descripcionProd
     * @return
     * @throws SQLException 
     */
    public static ProductoBebida crearProductoBebida(int caducidad, Boolean alcoholica, String nombreProd, double precioProd, String descripcionProd) throws SQLException {
        int ultimoCodigoProd = ProductoBebida.ultimoNumero();
        ProductoBebida pb1 = new ProductoBebida(caducidad, alcoholica, ultimoCodigoProd, nombreProd, precioProd, descripcionProd);
        return pb1;
    }
    
    /**
     * Método que nos añade el productoBebida a la base de datos.
     * @param pb1
     * @throws SQLException 
     */
    public static void añadirBebida(ProductoBebida pb1) throws SQLException{
        Connection conexion = Herramientas.getConexion();
        try{
            conexion.setAutoCommit(false);
            PreparedStatement query = conexion.prepareStatement("INSERT INTO producto VALUES(?,?,?,?,?)");
            query.setInt(1, pb1.getCodigoProd());
            query.setString(2, pb1.getNombreProd());
            query.setDouble(3, pb1.getPrecioProd());
            query.setString(4, pb1.getDescripcionProd());
            query.setString(5, "Bebida");
            query.executeUpdate();
            query = conexion.prepareStatement("INSERT INTO producto_bebida VALUES(?,?,?)");
            query.setInt(1, pb1.getCodigoProd());
            query.setInt(2, pb1.getCaducidad());
            query.setBoolean(3, pb1.getAlcoholica());
            query.executeUpdate();
            query=conexion.prepareStatement("INSERT INTO stock_supermercado "+
            "SELECT DISTINCT(Codigo_supermercado),?,0 FROM stock_supermercado;");
            query.setInt(1, pb1.getCodigoProd());
            query.executeUpdate();
            conexion.commit();
            conexion.setAutoCommit(true);
            query.close();
        }catch (SQLException sqlException){
            Herramientas.aviso("Ha fallado la transacción de añadir Bebida");
            Excepciones.pasarExcepcionLog("Ha fallado la transacción de añadir Bebida", sqlException);
            conexion.rollback();
            conexion.setAutoCommit(true);
        }   
    }
    
    /**
     * Método que nos permite eliminar de la base de datos el productoBebida con el código que le pasamos.
     * @param codigoProd
     * @throws SQLException 
     */
    public static void eliminarBebida(int codigoProd) throws SQLException{
        Connection conexion = Herramientas.getConexion();
        try{
            conexion.setAutoCommit(false);
            PreparedStatement query = conexion.prepareStatement("DELETE FROM producto_bebida WHERE Codigo_producto = ?");
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
            Herramientas.aviso("Ha fallado la transacción de eliminar Bebida");
            Excepciones.pasarExcepcionLog("Ha fallado la transacción de eliminar Bebida", sqlException);
            conexion.rollback();
            conexion.setAutoCommit(true);
        }
    }
    
    /**
     * Método que nos permite recoger un productoBebida, nos retorna el objeto.
     * @param buscar
     * @return
     * @throws SQLException 
     */
    public static ProductoBebida recogerBebida(int buscar) throws SQLException{
        Connection conexion = Herramientas.getConexion();        
        try{
            PreparedStatement query = conexion.prepareStatement("SELECT * FROM producto_bebida WHERE Codigo_producto = ?");
            query.setInt(1, buscar);
            ResultSet resultado = query.executeQuery();
            resultado.next();
            int cadu = resultado.getInt("Caducidad");
            boolean alcohol = resultado.getBoolean("Alcoholica");
            query = conexion.prepareStatement("SELECT * FROM producto WHERE Codigo_producto = ?");
            query.setInt(1, buscar);
            resultado = query.executeQuery();
            resultado.next();
            String name = resultado.getString("Nombre_producto");
            double precio = resultado.getDouble("Precio_producto");
            String descri = resultado.getString("descripcionProd");
            ProductoBebida pb1 = new ProductoBebida(cadu, alcohol, buscar, name, precio, descri);
            query.close();
            return pb1;
        } catch (SQLException sqlException){
            Herramientas.aviso("Ha fallado al intentar recoger la Bebida de la bbdd");
            Excepciones.pasarExcepcionLog("Ha fallado al intentar recoger la Bebida de la bbdd", sqlException);
            return null;
        }
        
    }    
}
