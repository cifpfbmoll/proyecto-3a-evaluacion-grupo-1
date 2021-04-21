package Main.Classes;


import java.util.Calendar;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author jcanarte
 */
public class Tarjeta {
    private int numero;
    private String Nombre_tarjeta;
    private Calendar fecha_caducidad;
    private String tipo_tarjeta;

    public Tarjeta() {
    }

    public Tarjeta(int numero, String Nombre_tarjeta, Calendar fecha_caducidad, String tipo_tarjeta) {
        this.setNumero(numero);
        this.setNombre_tarjeta(Nombre_tarjeta);
        this.setFecha_caducidad(fecha_caducidad);
        this.setTipo_tarjeta(tipo_tarjeta);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre_tarjeta() {
        return Nombre_tarjeta;
    }

    public void setNombre_tarjeta(String Nombre_tarjeta) {
        this.Nombre_tarjeta = Nombre_tarjeta;
    }

    public Calendar getFecha_caducidad() {
        return fecha_caducidad;
    }

    public void setFecha_caducidad(Calendar fecha_caducidad) {
        this.fecha_caducidad = fecha_caducidad;
    }

    public String getTipo_tarjeta() {
        return tipo_tarjeta;
    }

    public void setTipo_tarjeta(String tipo_tarjeta) {
        this.tipo_tarjeta = tipo_tarjeta;
    }
    
    public static void anadirTarjeta(ArrayList <Tarjeta> ListaTarjeta){
    }

    public static void eliminarTarjeta(ArrayList <Tarjeta> ListaTarjeta){
    }
    
    
}
