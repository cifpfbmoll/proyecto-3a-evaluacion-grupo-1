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

    public ProductoHigiene(TipoHigiene tipoHigiene, int codigoProd, String nombreProd, double precioProd, String descripcionProd) {
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
    
    public static ProductoHigiene CrearProductoHigiene(TipoHigiene tipoHigiene, String nombreProd, double precioProd, String descripcionProd) throws SQLException {
        int ultimoCodigoProd = ProductoHigiene.UltimoNumero();
        ProductoHigiene ph1 = new ProductoHigiene(tipoHigiene, ultimoCodigoProd, nombreProd, precioProd, descripcionProd);
        return ph1;
    }
    
    public static void AñadirHigiene(ProductoHigiene ph1) throws SQLException{
        try{
            Herramientas.modificarDatosTabla("INSERT INTO producto VALUES("+ph1.getCodigoProd()+",'"+ph1.getNombreProd()+"',"+ph1.getPrecioProd()+",'"+ph1.getDescripcionProd()+"','Higiene')",false);
            Herramientas.modificarDatosTabla("INSERT INTO producto_higiene VALUES("+ph1.getCodigoProd()+",'"+ph1.getTipoHigiene()+"')",false);
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
    
    public static void EliminarHigiene(int codigoProd) throws SQLException{
        try{
            Herramientas.modificarDatosTabla("DELETE FROM producto_higiene WHERE Codigo_producto = "+codigoProd,false);
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
    
    public static void RecogerHigiene(Connection conexion, int buscar) throws SQLException{
        PreparedStatement query = conexion.prepareStatement("SELECT * FROM producto_higiene WHERE Codigo_producto = ?");
        query.setInt(1, buscar);
        ResultSet resultado = query.executeQuery();
        resultado.next();
        TipoHigiene tipo = TipoHigiene.valueOf(resultado.getString("Tipo_higiene"));
        query = conexion.prepareStatement("SELECT * FROM producto WHERE Codigo_producto = ?");
        query.setInt(1, buscar);
        resultado = query.executeQuery();
        resultado.next();
        String name = resultado.getString("Nombre_producto");
        double precio = resultado.getDouble("Precio_producto");
        String descri = resultado.getString("descripcionProd");
        ProductoHigiene ph1 = new ProductoHigiene(tipo, buscar, name, precio, descri);
        System.out.println(ph1.toString());
        //int caducidad, Categoria categoria, String nombreProd, double precioProd, String descripcionProd
    }
    
    //falta añadir que a parte del nombre te digo que tipo de producto es
    public static void BuscarHigiene(String buscar) throws SQLException{
        Herramientas.modificarDatosTabla("SELECT * FROM producto WHERE Nombre_producto LIKE '%"+buscar+"%'",true);
        Herramientas.cerrarStatementResult();
    }
    
//    public static void main(String[] args) throws SQLException {
//        Herramientas.crearConexion();
//        ProductoHigiene.RecogerHigiene(Herramientas.getConexion(), 11);
//        Herramientas.cerrarConexion();
//    }
}
