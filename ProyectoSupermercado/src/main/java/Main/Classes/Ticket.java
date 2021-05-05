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
     * @throws SQLException 
     */
    public void setCodigo() throws SQLException {
        Herramientas.hacerSelect("SELECT MAX(codigo_ticket) FROM ticket",true);
        ResultSet resultado=Herramientas.getResultado();
        resultado.next();
        this.codigo = (resultado.getInt(1))+1;
        Herramientas.cerrarStatementResult();
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

    
    //no probado
    public static void crearTicket(int codigoSupermercado, ArrayList <LineaCompra> lineasTicket, String nif ) throws SQLException{
        //codigo supermercado y nif se coge del que se ha eligido al entrar.
        try{
        double precioTotal=0;
        for(int i=0;i<lineasTicket.size();i++){
            precioTotal+=lineasTicket.get(i).getPrecio_linea();
        }
        Ticket t1=new Ticket(codigoSupermercado, precioTotal, lineasTicket);
        LocalDate fecha=t1.getFechaCompra();
        LocalTime hora=t1.getHoraCompra();
        DateTimeFormatter formatoFecha=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoHora=DateTimeFormatter.ofPattern("HH:mm");
        Herramientas.modificarDatosTabla("INSERT INTO ticket VALUES("+t1.getCodigo()+","+nif+","+t1.getCodigoSupermercado()+","+fecha.format(formatoFecha)+","+hora.format(formatoHora)+","+t1.getPrecioTotal()+")",false);
        for(int i=0;i<lineasTicket.size();i++){
            Herramientas.modificarDatosTabla("INSERT INTO linea_ticket VALUES("+t1.getCodigo()+","+lineasTicket.get(i).getCodigo_producto()+","+lineasTicket.get(i).getCantidad()+","+lineasTicket.get(i).getPrecio_linea()+")", false);
        }
        Herramientas.getConexion().commit();
        Herramientas.getConexion().setAutoCommit(true);
        Herramientas.cerrarStatementResult();
        }
        catch(SQLException error){
            Herramientas.getConexion().rollback();
            Herramientas.aviso("Ha habido un error");
        };
        
    }
    //Actualmente este metodo solo ve el ultimo ticket del cliente.
    //probado
    public static void verTicket (String cliente) throws SQLException{
        Herramientas.hacerSelect("SELECT * FROM ticket WHERE DNI_cliente="+cliente+";", true);
        ResultSet resultado=Herramientas.getResultado();
        resultado.next();
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
        LocalDate fecha=LocalDate.parse(resultado.getString(4),formatoFecha);
        LocalTime hora=LocalTime.parse(resultado.getString(5),formatoHora);
        ArrayList <LineaCompra> lineasT1=new ArrayList();
        Ticket t1=new Ticket(resultado.getInt(1),resultado.getInt(3),fecha,hora,resultado.getDouble(6),lineasT1);
        t1.verLineaTicket();
        Herramientas.cerrarStatementResult();
        System.out.println(t1.toString());
    }
    //probado
    public void verLineaTicket() throws SQLException{
        Herramientas.hacerSelect("SELECT * FROM linea_ticket WHERE codigo_ticket="+this.getCodigo()+";", true);
        ResultSet resultado=Herramientas.getResultado();
        while(resultado.next()){
            LineaCompra lineaT1=new LineaCompra(resultado.getInt(2),resultado.getInt(3),resultado.getDouble(4));
            this.getLineasTicket().add(lineaT1);
        }
    }
    
    public static void main(String[] args) throws SQLException {
        Herramientas.crearConexion();
        verTicket("'55577788A'");
        Herramientas.cerrarConexion();
    }
}
