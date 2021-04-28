package Main.Classes;

import java.util.Calendar;
import java.sql.*;
import java.time.format.DateTimeFormatter;
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
    
    public Tarjeta(Tarjeta t1) {
        this.setNumero(t1.getNumero());
        this.setNombre_tarjeta(t1.getNombre_tarjeta());
        this.setFecha_caducidad(t1.getFecha_caducidad());
        this.setTipo_tarjeta(t1.getTipo_tarjeta());
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

    @Override
    public String toString() {
        return "Tarjeta{" + "numero=" + numero + ", Nombre_tarjeta=" + Nombre_tarjeta + ", fecha_caducidad=" + fecha_caducidad + ", tipo_tarjeta=" + tipo_tarjeta + '}';
    }
    
    public static void anadirTarjeta(int numero, String Nombre_tarjeta, Calendar fecha_caducidad, String tipo_tarjeta) throws SQLException{
        Tarjeta t1=new Tarjeta(numero, Nombre_tarjeta, fecha_caducidad, tipo_tarjeta);
        Herramientas.enviarComando("INSERT INTO Tarjeta Values("+t1.getNumero()+","+t1.getNombre_tarjeta()+","+t1.getFecha_caducidad()+","+t1.getTipo_tarjeta()+")");
        Herramientas.cerrarConexion();
    }

    public static void eliminarTarjeta(int numero)throws SQLException{
        Herramientas.enviarComando("DELETE FROM Tarjeta WHERE numero_tarjeta = " +numero+ ";");
        Herramientas.cerrarConexion();
    }
}
