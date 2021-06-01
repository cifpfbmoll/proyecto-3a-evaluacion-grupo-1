/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class LineaCompra {
    
    private int codigo_producto;
    private int cantidad;
    private double precio_linea;

    public LineaCompra() {
    }
    /**
     * Constructor que se utiliza para crear la linea del carrito compra en el 
     * programa. Por eso utilizamos el setter que calcula el precio linea.
     * @param codigo_producto
     * @param cantidad 
     */
    public LineaCompra(int codigo_producto, double precioProducto, int cantidad) {
        this.setCodigo_producto(codigo_producto);
        this.setCantidad(cantidad);
        this.setPrecio_linea(precioProducto, cantidad);
    }
    /**
     * Constructor que se utiliza para copiar una linea de la base de datos, por
     * eso recibe todos los valores directamente.
     * @param codigo_producto int
     * @param cantidad int
     * @param precio_linea double
     */
    public LineaCompra(int codigo_producto, int cantidad, double precio_linea) {
        this.setCodigo_producto(codigo_producto);
        this.setCantidad(cantidad);
        this.setPrecio_linea(precio_linea);
    }

    public LineaCompra(LineaCompra l1) {
        this.setCodigo_producto(l1.getCodigo_producto());
        this.setCantidad(l1.getCantidad());
        this.setPrecio_linea(l1.getPrecio_linea());
    }    

    public int getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(int codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_linea() {
        return precio_linea;
    }
    /**
     * Este setter se utilizara cuando se cojan tickets de la base de datos.
     * @param precio_linea double
     */
    public void setPrecio_linea(double precio_linea) {
        this.precio_linea = precio_linea;
    }
    /**
     * Setter que calcula el precio de la linea a traves del precio de su producto
     * multiplicado por la cantidad de unidades que hay de este. Se utilizara para
     * crear la linea del carrito en el programa.
     * @param precio_producto double
     * @param cantidad int
     */
    public void setPrecio_linea(double precio_producto, int cantidad) {
        double precio_linea=precio_producto*cantidad;
        this.precio_linea = Math.round(precio_linea*100.0)/100.0;
    }

    @Override
    public String toString() {
        return "LineaCompra{" + "codigo_producto=" + codigo_producto + ", cantidad=" + cantidad + ", precio_linea=" + precio_linea + '}';
    }
    /**
     * Metodo de instancia en el cual se inserta toda la informacio de una LineaCompra
     * en la tabla linea carrito de la base de datos.
     * @throws SQLException puede tirar una SQLException ya que trata con la base de datos
     */
    public void insertLineaCarrito() throws SQLException{
        try (PreparedStatement query = Herramientas.getConexion().prepareStatement("INSERT INTO linea_carrito VALUES (?,?,?,?,?)")) {
            query.setString(1, Main.getClienteActivo().getNif());
            query.setInt(2, this.getCodigo_producto());
            query.setInt(3, this.getCantidad());
            query.setDouble(4, this.getPrecio_linea());
            query.setInt(5, Main.getSupermercadoActivo().getCode());
            query.executeUpdate();
        }
    }
    
    /**
     * Metodo que sirve para borrar una fila de la tabla linea_carrito. A este
     * metodo se le pasa por parametro el codigo producto para identificar la linea
     * del carrito, la cual tambien necesita el nif del cliente, que lo coje del
     * main clienteActivo.
     * @param codigoProducto codigoproducto para identificar la linea del carrito
     * @throws SQLException puede tirar una SQLException ya que trata con la base de datos
     */
    public static void borarLineaCarrito(int codigoProducto) throws SQLException{
        try (PreparedStatement query = Herramientas.getConexion().prepareStatement("DELETE FROM linea_carrito WHERE dni_cliente=? AND codigo_producto=?")) {
            query.setString(1, Main.getClienteActivo().getNif());
            query.setInt(2, codigoProducto);
            query.executeUpdate();
        }
    }
    
    /**
     * Modifica la cantidad, y por tanto el precio de la linea, de una linea carrito
     * de la base de datos. Se le pasa el nuevo precio por parametro ya que se calcula
     * fuera de este metodo, los otros atributos se cogen de la instancia en la que se
     * llama a este metodo y del clienteActivo.
     * @param precio double es el nuevo precio de la linea carrito
     * @throws SQLException puede tirar una SQLException ya que trata con la base de datos
     */
    public void modificarLineaCarrito( double precio) throws SQLException{
        try (PreparedStatement query = Herramientas.getConexion().prepareStatement("UPDATE linea_carrito SET cantidad=?, precio=? WHERE dni_cliente=? AND codigo_producto=?")) {
            query.setInt(1, this.getCantidad());
            query.setDouble(2, this.getPrecio_linea());
            query.setString(3, Main.getClienteActivo().getNif());
            query.setInt(4, this.getCodigo_producto());
            query.executeUpdate();
        }
    }
}
