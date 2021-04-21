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

    public LineaCompra() {
    }

    public LineaCompra(Producto producto, int cantidad) {
        this.setProducto(producto);
        this.setCantidad(cantidad);
    }

    public LineaCompra(LineaCompra l1) {
        this.setProducto(l1.getProducto());
        this.setCantidad(l1.getCantidad());

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

    @Override
    public String toString() {
        return "LineaTicket{" + "producto=" + producto + ", cantidad=" + cantidad + '}';
    }
    
  
}
