/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Classes;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
* @author josep
*/

abstract class Producto {
    private int codigoProd;
    private String nombreProd;
    private double precioProd;   
    private String descripcionProd;

    public Producto(int codigoProd, String nombreProd, double precioProd, String descripcionProd) {
        this.codigoProd = codigoProd;
        this.nombreProd = nombreProd;
        this.precioProd = precioProd;
        this.descripcionProd = descripcionProd;
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
    
    public static int UltimoNumero() throws SQLException{
        Herramientas.hacerSelect("SELECT MAX(Codigo_producto) FROM producto",true);
        ResultSet result=Herramientas.getResultado();
        result.next();
        int ultimo = result.getInt(1);
        Herramientas.cerrarConexion();
        return ultimo;
    }
    
    //test que he realizado en el main
    
    //    String entrada = "07-03-2018";
    //        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
    //        Date fecha;
    //        fecha = formato.parse(entrada);
    //        float myNum = 5.1f;
    //        ProductoAlimento pipas = new ProductoAlimento(fecha, Categoria.vegano, 2, "pipas" , myNum ,  "pipas saladas");
    //        System.out.println(pipas.getCaducidad());
    //        System.out.println(pipas.UltimoNumero);
}

