/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Classes;

import static Main.Classes.ProductoHigiene.TipoHigiene.mascarilla;
import static Main.Classes.ProductoLimpieza.Superficie.cristal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
* @author josep
*/

public class Producto {
    private int codigoProd;
    private String nombreProd;
    private double precioProd;   
    private String descripcionProd;

    public Producto(int codigoProd, String nombreProd, double precioProd, String descripcionProd) {
        this.setCodigoProd(codigoProd);
        this.setNombreProd(nombreProd);
        this.setPrecioProd (precioProd);
        this.setDescripcionProd(descripcionProd);
    }

    public int getCodigoProd() {
        return codigoProd;
    }

    public void setCodigoProd(int codigoProd) {
        this.codigoProd = codigoProd;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public double getPrecioProd() {
        return precioProd;
    }

    public void setPrecioProd(double precioProd) {
        this.precioProd = precioProd;
    }

    public String getDescripcionProd() {
        return descripcionProd;
    }

    public void setDescripcionProd(String descripcionProd) {
        this.descripcionProd = descripcionProd;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigoProd=" + codigoProd + ", nombreProd=" + nombreProd + ", precioProd=" + precioProd + ", descripcionProd=" + descripcionProd + '}';
    }
    
    public static int ultimoNumero() throws SQLException{
        int ultimo;
        try (PreparedStatement query = Herramientas.getConexion().prepareStatement("SELECT MAX(Codigo_producto) FROM producto"); 
        ResultSet result = query.executeQuery()) {
            result.next();
            ultimo = result.getInt(1)+1;
        }
        return ultimo;
    }
    
    public static ArrayList recogerProducto(){
        ArrayList <Producto> listaProductos = new ArrayList();
        try{
            Connection conexion = Herramientas.getConexion();
            conexion.setAutoCommit(false);
            PreparedStatement query = conexion.prepareStatement("SELECT * FROM producto");
            ResultSet resultado = query.executeQuery();
            resultado = query.executeQuery();
            while(resultado.next()){
                System.out.println(resultado.toString());
                int codigo = resultado.getInt("Codigo_producto");
                String nombre = resultado.getString("Nombre_producto");
                Double precio = resultado.getDouble("Precio_producto");
                String descri = resultado.getString("descripcionProd");
                Producto producto = new Producto(codigo,nombre,precio,descri);
                listaProductos.add(producto);
            }
            conexion.commit();
            conexion.setAutoCommit(true);
            query.close();
        } catch (SQLException sqlException){
            Herramientas.aviso("Ha fallado al intentar recoger los productos de la bbdd");
            Excepciones.pasarExcepcionLog("Ha fallado al intentar recoger los productos de la bbdd", sqlException);
        } 
        return listaProductos;
    }
}

