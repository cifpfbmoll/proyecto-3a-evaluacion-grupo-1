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

    public ProductoHigiene(TipoHigiene tipoHigiene, int codigoProd, String nombreProd, float precioProd, String descripcionProd) {
        super(codigoProd, nombreProd, precioProd, descripcionProd);
        this.tipoHigiene = tipoHigiene;
    }

    public TipoHigiene getTipoHigiene() {
        return tipoHigiene;
    }
    
    public void setTipoCategoria(ProductoHigiene.TipoHigiene tipoHigiene) {
        switch(tipoHigiene){
            case crema:
                this.tipoHigiene = tipoHigiene;
                break;
            case serum:
                this.tipoHigiene = tipoHigiene;
                break;
            case maquillaje:
                this.tipoHigiene = tipoHigiene;
                break;
            case mascarilla:
                this.tipoHigiene = tipoHigiene;
                break;
            case champu:
                this.tipoHigiene = tipoHigiene;
                break;
            case gel:
                this.tipoHigiene = tipoHigiene;
                break;
            case desorodante:
                this.tipoHigiene = tipoHigiene;
                break;
            case jabon:
                this.tipoHigiene = tipoHigiene;
                break;
            case mascarillas:
                this.tipoHigiene = tipoHigiene;
                break;
            case toallitas:
                this.tipoHigiene = tipoHigiene;
                break;
            case otros:
                this.tipoHigiene = tipoHigiene;
                break;
        }
    }
}
