/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Classes;

import java.sql.*;
import java.sql.SQLException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author jaume
 */
public class Ticket {
    
    private int codigo;
    private int codigoSupermercado;
    private LocalDate fechaCompra;
    private LocalTime horaCompra;
    private double precioTotal;
    private ArrayList <LineaCompra> lineasTicket;
    
    
    public Ticket() {
    }
    /**
     * Constructor para crear un nuevo ticket.
     * @param codigoSupermercado int
     * @param precioTotal double
     * @param lineasTicket ArrayList
     * @throws SQLException 
     */
    public Ticket(int codigoSupermercado, double precioTotal, ArrayList <LineaCompra> lineasTicket) throws SQLException {
        this.setCodigo();
        this.setCodigoSupermercado(codigoSupermercado);
        this.setFechaCompra();
        this.setHoraCompra();
        this.setPrecioTotal(precioTotal);
        this.setLineasTicket(lineasTicket);
    }
    /**
     * Constructor para guardar un ticket de la base da datos.
     * @param codigo int
     * @param codigoSupermercado int
     * @param fechaCompra LocalDate
     * @param horaCompra LocalTime
     * @param PrecioTotal double
     * @param lineasTicket ArrayList
     */
    public Ticket(int codigo, int codigoSupermercado, LocalDate fechaCompra, LocalTime horaCompra, double PrecioTotal, ArrayList <LineaCompra> lineasTicket) {
        this.setCodigo(codigo);
        this.setCodigoSupermercado(codigoSupermercado);
        this.setFechaCompra(fechaCompra);
        this.setHoraCompra(horaCompra);
        this.setPrecioTotal(PrecioTotal);
        this.setLineasTicket(lineasTicket);
    }
    
    /**
     * Constructor copia.
     * @param t1 objeto de la clase Ticket para copiar.
     */
    public Ticket(Ticket t1) {
        this.setCodigo(t1.getCodigo());
        this.setCodigoSupermercado(t1.getCodigoSupermercado());
        this.setFechaCompra(t1.getFechaCompra());
        this.setHoraCompra(t1.getHoraCompra());
        this.setPrecioTotal(t1.getPrecioTotal());
        this.setLineasTicket(t1.getLineasTicket());
    }

    public int getCodigo() {
        return codigo;
    }
    /**
     * Setter que mira en la base de datos cual es el ultimo codigo de ticket
     * y le suma 1 para luego asignarselo al nuevo ticket.
     * @throws SQLException Puede tirar una SQLEception ja que se comunica con 
     * la base de datos
     */
    public void setCodigo() throws SQLException {
        try (PreparedStatement query = Herramientas.getConexion().prepareStatement("SELECT MAX(codigo_ticket) FROM ticket"); 
        ResultSet resultado = query.executeQuery()) {
            resultado.next();
            this.codigo = (resultado.getInt(1))+1;
        }
        
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigoSupermercado() {
        return codigoSupermercado;
    }

    public void setCodigoSupermercado(int codigoSupermercado) {
        this.codigoSupermercado = codigoSupermercado;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }
    
    /**
     * Setter que directamente coje la fecha actual.
     */
    public void setFechaCompra() {
        LocalDate fecha=LocalDate.now();
        this.fechaCompra = fecha;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public LocalTime getHoraCompra() {
        return horaCompra;
    }
    
    /**
     * Setter que directamente coje la hora actual.
     */
    public void setHoraCompra() {
        LocalTime hora=LocalTime.now();
        this.horaCompra = hora;
    }

    public void setHoraCompra(LocalTime horaCompra) {
        this.horaCompra = horaCompra;
    }
    
    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double PrecioTotal) {
        this.precioTotal = PrecioTotal;
    }

    public ArrayList<LineaCompra> getLineasTicket() {
        return lineasTicket;
    }

    public void setLineasTicket(ArrayList<LineaCompra> lineasTicket) {
        this.lineasTicket = lineasTicket;
    }

    @Override
    public String toString() {
        return "Ticket{" + "codigo=" + codigo + ", codigoSupermercado=" + codigoSupermercado + ", fechaCompra=" + fechaCompra + ", horaCompra=" + horaCompra + ", precioTotal=" + precioTotal + ", lineasTicket=" + lineasTicket + '}';
    }

    
    /**
     * Metodo usado para crear un ticket e insertarlo a la base de datos, recibe por parametro el codigo del supermercado
     * en el cual se ha generado el tickets, una arraylist que es la cesta compra y son todos los productos del
     * ticket y un nif para identificar al cliente que hace la compra. Se generan todos la fecha y hora del ticket
     * automaticamente. Una vez generado el ticket se inserta en la base de datos. La transaccion se controla en el metodo
     * llamante, ya que alli hay otra transaccion(ya que al crear un ticket se eliminan unas lineas cestas en al base de datos tambien).
     * @param codigoSupermercado int que identifica el supermercado.
     * @param lineasTicket ArrayList de LineaCompra que representan las lineas del ticket.
     * @param nif String que identifica al cliente.
     * @throws SQLException Puede tirar una SQLException si algo falla con la base de datos.
     */
    public static void crearTicket(int codigoSupermercado, ArrayList <LineaCompra> lineasTicket, String nif ) throws SQLException{
        double precioTotal=0;
        for(int i=0;i<lineasTicket.size();i++){
            precioTotal+=lineasTicket.get(i).getPrecio_linea();
        }
        Ticket t1=new Ticket(codigoSupermercado, precioTotal, lineasTicket);
        LocalDate fecha=t1.getFechaCompra();
        LocalTime hora=t1.getHoraCompra();
        DateTimeFormatter formatoFecha=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoHora=DateTimeFormatter.ofPattern("HH:mm");
        try(PreparedStatement query=Herramientas.getConexion().prepareStatement("INSERT INTO ticket VALUES(?,?,?,?,?,?)")){
            query.setInt(1, t1.getCodigo());
            query.setString(2, nif);
            query.setInt(3, t1.getCodigoSupermercado());
            query.setString(4, fecha.format(formatoFecha));
            query.setString(5, hora.format(formatoHora));
            query.setDouble(6, t1.getPrecioTotal());
            query.executeUpdate();
            for(int i=0;i<lineasTicket.size();i++){
                try(PreparedStatement query2=Herramientas.getConexion().prepareStatement("INSERT INTO linea_ticket VALUES(?,?,?,?)")){
                    query2.setInt(1, t1.getCodigo());
                    query2.setInt(2, lineasTicket.get(i).getCodigo_producto());
                    query2.setInt(3, lineasTicket.get(i).getCantidad());
                    query2.setDouble(4, lineasTicket.get(i).getPrecio_linea());
                    query2.executeUpdate();
                }
            }
        }
    }

    /**
     * Metodo que hace un select de la base de datos y coge todos los tickets de un usuario y
     * los inserta a cada uno en un objeto Ticket. Esos tickets son insertados en una ArrayList
     * que luego es devuelta.
     * @param DNICliente nif que identifica al cliente
     * @return ArrayList de ticket donde se han guardado todos los tickets seleccionados
     * @throws SQLException Aunque realmente la mayoria de excepciones se controlan en el metodo,
     * puede tirar una SQLException cuando se cierran los PreparedStatement y los ResultSet.
     */
    public static ArrayList verTicket (String DNICliente) throws SQLException{
        PreparedStatement query=null;
        ResultSet resultado=null;
        ArrayList <Ticket> listaTickets=new ArrayList();
        try{
            query=Herramientas.getConexion().prepareStatement("SELECT * FROM ticket WHERE DNI_cliente=?");
            query.setString(1, DNICliente);
            resultado=query.executeQuery();
            while(resultado.next()){
                DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
                LocalDate fecha=LocalDate.parse(resultado.getString(4),formatoFecha);
                LocalTime hora=LocalTime.parse(resultado.getString(5),formatoHora);
                ArrayList <LineaCompra> lineasT1=new ArrayList();
                Ticket t1=new Ticket(resultado.getInt(1),resultado.getInt(3),fecha,hora,resultado.getDouble(6),lineasT1);
                t1.verLineaTicket();
                listaTickets.add(t1);
            }
        } catch(SQLException ex){
            Herramientas.aviso("Ha habido un error con al recuperar sus tickets");
            Excepciones.pasarExcepcionLog("Ha habido un error con al recuperar sus tickets", ex);
        } finally{
            resultado.close();
            query.close();
        }
        return listaTickets;
    }
    /**
     * Metodo de instancia que hace un select en la base de datos para recoger las
     * lineas del ticket en el que se ha instanciado. 
     * @throws SQLException Puede tirar una SQLException si algo falla con la base de datos.
     */
    public void verLineaTicket() throws SQLException{
        try (PreparedStatement query = Herramientas.getConexion().prepareStatement("SELECT * FROM linea_ticket WHERE codigo_ticket=?")) {
            query.setInt(1, this.getCodigo());
            try (ResultSet resultado = query.executeQuery()) {
                while(resultado.next()){
                    LineaCompra lineaT1=new LineaCompra(resultado.getInt(2),resultado.getInt(3),resultado.getDouble(4));
                    this.getLineasTicket().add(lineaT1);
                }
            }
        }
    }
}
