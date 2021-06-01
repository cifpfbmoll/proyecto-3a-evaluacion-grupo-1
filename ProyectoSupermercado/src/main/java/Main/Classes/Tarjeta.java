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

    public Tarjeta() {
    }
    
    public Tarjeta(String numero, String Nombre_tarjeta, String fecha_caducidad, String tipo_tarjeta) {
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
    /**
     * Metodo que crea un objeto Tarjeta, le asigna los valores pasados por parametro y
     * luego inserta estos valores en la base de datos. 
     * @param numero String que identifica la tarjeta
     * @param Nombre_tarjeta String nombre completo del propietario de la tarjeta
     * @param fecha_caducidad String fecha de caducidad de la tarjeta, estara en formato MM/YY
     * @param tipo_tarjeta String que tipo de tarjeta es (Visa, MasterCard,...)
     * @throws SQLException puede tirar una SQLExcption ya que se comunica con la
     * base de datos
     */
    public static void añadirTarjeta(String numero, String Nombre_tarjeta, String fecha_caducidad, String tipo_tarjeta) throws SQLException{
        Tarjeta t1=new Tarjeta(numero, Nombre_tarjeta, fecha_caducidad, tipo_tarjeta);
        try (PreparedStatement query = Herramientas.getConexion().prepareStatement("INSERT INTO TARJETA_CLIENTE VALUES(?,?,?,?,?)")) {
            query.setString(1, numero);
            query.setString(2, Main.getClienteActivo().getNif());
            query.setString(3, Nombre_tarjeta);
            query.setString(4, fecha_caducidad);
            query.setString(5, tipo_tarjeta);
            query.executeUpdate();
        }
    }
    /**
     * Metodo al cual se le pasa una String que hace referencia a un numero de 
     * tarjeta y elimina de la base de datos esa tarjeta.
     * @param numero identificador de la tarjeta de credito
     * @throws SQLException puede tirar una SQLExcption ya que se comunica con la
     * base de datos 
     */
    public static void eliminarTarjeta(String numero)throws SQLException{
         try (PreparedStatement query = Herramientas.getConexion().prepareStatement("DELETE FROM tarjeta_cliente WHERE numero_tarjeta = ?")) {
            query.setString(1, numero);
            query.executeUpdate();
        }
    }
    /**
     * Metodo al cual se le pasa una String que es el NIF de un cliente y busca en
     * la base de datos todas las tarjetas de ese cliente. Las tarjetas se guardan
     * dentro de una ArrayList que luego es devuelta.
     * @param DNICliente String NIF que identifica al cliente
     * @return ArrayList de tarjetas donde se han guardado todas las tarjetas del empleado
     * @throws SQLException puede tirar una SQLExcption ya que se comunica con la
     * base de datos 
     */
    public static ArrayList recogerTarjeta(String DNICliente)throws SQLException{
        ArrayList <Tarjeta> listaTarjetas;
        try (PreparedStatement query = Herramientas.getConexion().prepareStatement("SELECT * FROM tarjeta_cliente WHERE dni_cliente=?")) {
            query.setString(1, DNICliente);
            try (ResultSet resultado = query.executeQuery()) {
                listaTarjetas = new ArrayList();
                while(resultado.next()){
                    Tarjeta t1=new Tarjeta(resultado.getString(1), resultado.getString(3), resultado.getString(4), resultado.getString(5));
                    listaTarjetas.add(t1);
                }
            }
        }
        return listaTarjetas;
    }
}
