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
        Herramientas.hacerSelect("SELECT MAX(Codigo_producto) FROM producto");
        ResultSet result=Herramientas.getResultado();
        result.next();
        int ultimo = result.getInt(1);
        Herramientas.cerrarConexion();
        return ultimo;
    }
}

