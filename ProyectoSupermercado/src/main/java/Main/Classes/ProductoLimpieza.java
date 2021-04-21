/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Classes;

/**
 *
 * @author josep
 */
public class ProductoLimpieza extends Producto {
    private Superficie superficie;
    public enum Superficie{
        madera,
        marmol,
        cristal,
        metal,
        varios
    }

    public ProductoLimpieza(Superficie superficie, int codigoProd, String nombreProd, float precioProd, String descripcionProd) {
        super(codigoProd, nombreProd, precioProd, descripcionProd);
        this.superficie = superficie;
    }

    public Superficie getSuperficie() {
        return superficie;
    }
    
    public void setSuperficie(ProductoLimpieza.Superficie superficie) {
        switch(superficie){
            case madera:
                this.superficie = superficie;
                break;
            case marmol:
                this.superficie = superficie;
                break;
            case cristal:
                this.superficie = superficie;
                break;
            case metal:
                this.superficie = superficie;
                break;
            case varios:
                this.superficie = superficie;
                break;
        }
    }
    
    public static void CrearProductoLimpieza(Superficie superficie, int codigoProd, String nombreProd, float precioProd, String descripcionProd) {
        ProductoLimpieza pl1 = new ProductoLimpieza(superficie, codigoProd, nombreProd, precioProd, descripcionProd);
    }
}
