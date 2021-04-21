/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Classes;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author josep
 */
public class ProductoAlimento extends Producto {
    public static Scanner lectorLibro = new Scanner(System.in);
    private Date caducidad = new Date();
    private Categoria categoria;
    
    public enum Categoria{
        vegano,
        vegetariano,
        carnivoro
    }

    public ProductoAlimento(Date caducidad, Categoria categoria, int codigoProd, String nombreProd, float precioProd, String descripcionProd) {
        super(codigoProd, nombreProd, precioProd,descripcionProd);
        this.setCaducidad(caducidad);
        this.setCategoria(categoria);
    }
    
    public Date getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(Date caducidad) {
        this.caducidad = caducidad;
    }

    public Categoria getCategoria() {
        return categoria;
    }
        
    public void setCategoria(Categoria categoria) {
        switch(categoria){
            case vegano:
                this.categoria = categoria;
                break;
            case vegetariano:
                this.categoria = categoria;
                break;
            case carnivoro:
                this.categoria = categoria;
                break;
        }
    }
}


//test constructor comida que iria dentro del metodo main
//        String entrada = "07-03-2018";
//        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
//        Date fecha;
//        fecha = formato.parse(entrada);
//        ProductoAlimento pan = new ProductoAlimento(fecha, "pipas");
//
//        System.out.println(pan.getCaducidad());
