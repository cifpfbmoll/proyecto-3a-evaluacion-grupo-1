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
 * @author PC
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
     * @throws SQLException 
     */
    public void setCodigo() throws SQLException {
        Herramientas.enviarComando("SELECT MAX(codigo_ticket) FROM ticket");
        ResultSet resultado=Herramientas.getResultado();
        resultado.next();
        this.codigo = (resultado.getInt(1))+1;
        Herramientas.cerrarConexion();
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
        return "Ticket{" + "codigo=" + codigo + ", codigoSupermercado=" + codigoSupermercado + ", fechaCompra=" + fechaCompra + ", horaCompra=" + horaCompra + ", PrecioTotal=" + precioTotal + '}';
    }
    
    public static void crearTicket(int codigoSupermercado, double precioTotal, ArrayList <LineaCompra> lineasTicket, String nif ) throws SQLException{
        //precio total se calculara de la lineasticket, for i sumar todos los precios productos.
        //codigo supermercado y nif se coge del que se ha eligido al entrar.
        Ticket t1=new Ticket(codigoSupermercado, precioTotal, lineasTicket);
        LocalDate fecha=t1.getFechaCompra();
        LocalTime hora=t1.getHoraCompra();
        DateTimeFormatter formatoFecha=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoHora=DateTimeFormatter.ofPattern("HH:mm");
        Herramientas.enviarComando("INSERT INTO ticket Values("+t1.getCodigo()+","+nif+","+t1.getCodigoSupermercado()+","+fecha.format(formatoFecha)+","+hora.format(formatoHora)+","+t1.getPrecioTotal()+")");
        Herramientas.cerrarConexion();
    }
}
