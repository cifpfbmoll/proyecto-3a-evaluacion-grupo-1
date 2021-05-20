package Main.Classes;

import java.util.Calendar;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.*;
import java.text.*;


/**
 *
 * @author jcanarte
 */
public class Tarjeta {
    private String numero;
    private String Nombre_tarjeta;
    private String fecha_caducidad;
    private String tipo_tarjeta;
    private ArrayList <LineaCompra> listaTarjetas;

    public Tarjeta() {
    }
    
    public Tarjeta(String numero, String Nombre_tarjeta, String fecha_caducidad, String tipo_tarjeta) {
        this.setNumero(numero);
        this.setNombre_tarjeta(Nombre_tarjeta);
        this.setFecha_caducidad(fecha_caducidad);
        this.setTipo_tarjeta(tipo_tarjeta);
        this.setListaTarjetas(listaTarjetas);
    }
    
    public Tarjeta(Tarjeta t1) {
        this.setNumero(t1.getNumero());
        this.setNombre_tarjeta(t1.getNombre_tarjeta());
        this.setFecha_caducidad(t1.getFecha_caducidad());
        this.setTipo_tarjeta(t1.getTipo_tarjeta());
    }

    public ArrayList<LineaCompra> getListaTarjetas() {
        return listaTarjetas;
    }

    public void setListaTarjetas(ArrayList<LineaCompra> listaTarjetas) {
        this.listaTarjetas = listaTarjetas;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNombre_tarjeta() {
        return Nombre_tarjeta;
    }

    public void setNombre_tarjeta(String Nombre_tarjeta) {
        this.Nombre_tarjeta = Nombre_tarjeta;
    }

    public String getFecha_caducidad() {
        return fecha_caducidad;
    }

    public void setFecha_caducidad(String fecha_caducidad) {
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
    
    public static void añadirTarjeta(String numero, String Nombre_tarjeta, String fecha_caducidad, String tipo_tarjeta) throws SQLException{
        Tarjeta t1=new Tarjeta(numero, Nombre_tarjeta, fecha_caducidad, tipo_tarjeta);
        try (PreparedStatement query = Herramientas.getConexion().prepareStatement("INSERT INTO TARJETA_CLIENTE VALUES(?,?,?,?,?)")) {
            query.setString(1, numero);
            //query.setString(2, Main.getClienteActivo().getNif());
            query.setString(2, "55577788A");
            query.setString(3, Nombre_tarjeta);
            query.setString(4, fecha_caducidad);
            query.setString(5, tipo_tarjeta);
            query.executeUpdate();
        }
    }

    public static void eliminarTarjeta(String numero)throws SQLException{
        Herramientas.modificarDatosTabla("DELETE FROM Tarjeta WHERE numero_tarjeta = " +numero+ ";",true);
        Herramientas.cerrarConexion();
    }
    
    public static void insertarTarjeta(String numero, String Nombre_tarjeta, String fecha_caducidad, String tipo_tarjeta, Connection conexion)throws SQLException{
        PreparedStatement insertar = conexion.prepareStatement("INSERT INTO Tarjeta"
                + " (Numero_tarjeta, Nombre_cliente, Fecha_caducidad, Tipo_tarjeta)"
                + " VALUES"
                + " (?, ?, ?, ?);");
        insertar.setString(1, numero);
        insertar.setString(2, Nombre_tarjeta);
        insertar.setObject(3, fecha_caducidad);
        insertar.setString(4, tipo_tarjeta);
        insertar.execute();
    }
}
