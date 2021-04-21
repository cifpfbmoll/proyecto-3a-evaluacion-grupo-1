/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Classes;
import java.text.SimpleDateFormat;  
import java.util.Date;

/**
 *
 * @author josep
 */
public class ProductoBebida extends Producto {
    private Date caducidad = new Date();
    private Boolean alcoholica;

    public ProductoBebida(Date caducidad, Boolean alcoholica, int codigoProd, String nombreProd, float precioProd, String descripcionProd) {
        super(codigoProd, nombreProd, precioProd,descripcionProd);
        this.setCaducidad(caducidad);
        this.setAlcoholica(alcoholica);
    }

    public Date getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(Date caducidad) {
        Date todayDate = new Date();
        if ((caducidad.after(todayDate))){ //encara no funciona el equals, hauria d'anar amb aquest or || (caducidad.equals(todayDate))){
            this.caducidad = caducidad;
            System.out.println("Se ha puesto");
        } else {
            System.out.println("Error, la fecha es anterior al dia de hoy");
        }
    }

    public Boolean getAlcoholica() {
        return alcoholica;
    }

    public void setAlcoholica(Boolean alcoholica) {
        this.alcoholica = alcoholica;
    } 
    
    public static void CrearProductoBebida(Date caducidad, Boolean alcoholica, int codigoProd, String nombreProd, float precioProd, String descripcionProd) {
        ProductoBebida pb1 = new ProductoBebida(caducidad, alcoholica, codigoProd, nombreProd, precioProd, descripcionProd);
    }
}

//Prueba añadir bebida
//Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse("02/01/2020");
//ProductoBebida bebida = new ProductoBebida(fecha, true, 1, "Test", 3, "si");
//System.out.println(bebida.getCaducidad());
