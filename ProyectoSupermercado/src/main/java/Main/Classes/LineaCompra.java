/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Classes;

/**
 *
 * @author PC
 */
public class LineaCompra {
    
    private Producto producto;
    private int cantidad;
    private double precio_linea;

    public LineaCompra() {
    }
    /**
     * Constructor que se utiliza para crear la linea del carrito compra en el 
     * programa. Por eso utilizamos el setter que calcula el precio linea.
     * @param producto
     * @param cantidad 
     */
    public LineaCompra(Producto producto, int cantidad) {
        this.setProducto(producto);
        this.setCantidad(cantidad);
        this.setPrecio_linea(producto.getPrecioProd(), cantidad);
    }
    /**
     * Constructor que se utiliza para copiar una linea de la base de datos, por
     * eso recibe todos los valores directamente.
     * @param producto Producto
     * @param cantidad int
     * @param precio_linea double
     */
    public LineaCompra(Producto producto, int cantidad, double precio_linea) {
        this.setProducto(producto);
        this.setCantidad(cantidad);
        this.setPrecio_linea(precio_linea);
    }

    public LineaCompra(LineaCompra l1) {
        this.setProducto(l1.getProducto());
        this.setCantidad(l1.getCantidad());
        this.setPrecio_linea(l1.getPrecio_linea());
    }    

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
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
        this.precio_linea = precio_linea;
    }

    
    
    @Override
    public String toString() {
        return "LineaTicket{" + "producto=" + producto + ", cantidad=" + cantidad + '}';
    }

    
    
}
