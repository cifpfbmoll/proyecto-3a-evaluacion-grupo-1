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
    
    public static ProductoBebida CrearProductoBebida(int caducidad, Boolean alcoholica, String nombreProd, double precioProd, String descripcionProd) throws SQLException {
        int ultimoCodigoProd = ProductoBebida.UltimoNumero();
        ProductoBebida pb1 = new ProductoBebida(caducidad, alcoholica, ultimoCodigoProd, nombreProd, precioProd, descripcionProd);
        return pb1;
    }
    
    public static void AñadirBebida(ProductoBebida pb1) throws SQLException{
        try{
            Herramientas.modificarDatosTabla("INSERT INTO producto VALUES("+pb1.getCodigoProd()+",'"+pb1.getNombreProd()+"',"+pb1.getPrecioProd()+",'"+pb1.getDescripcionProd()+"','Bebida')",false);
            Herramientas.modificarDatosTabla("INSERT INTO producto_bebida VALUES("+pb1.getCodigoProd()+","+pb1.getCaducidad()+","+pb1.getAlcoholica()+")",false);
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
    
    public static void EliminarBebida(int codigoProd) throws SQLException{
        try{
            Herramientas.modificarDatosTabla("DELETE FROM producto_bebida WHERE Codigo_producto = "+codigoProd,false);
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
    
    public static void RecogerBebida(Connection conexion, int buscar) throws SQLException{
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
        System.out.println(pb1.toString());
        //int caducidad, Categoria categoria, String nombreProd, double precioProd, String descripcionProd
    }
    
//    public static void main(String[] args) throws SQLException {
//        Herramientas.crearConexion();
//        ProductoBebida.RecogerBebida(Herramientas.getConexion(), 8);
//        Herramientas.cerrarConexion();
//    }
    
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
