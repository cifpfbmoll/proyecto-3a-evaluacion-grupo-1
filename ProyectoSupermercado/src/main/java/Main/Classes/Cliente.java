package Main.Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import Main.Classes.Excepciones;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente extends Persona {
    
    private ArrayList <LineaCompra> cestaCompra;
    private int supermercadoCesta;
    
    public Cliente() {
        super();
    }

    public Cliente(String nombre, String apellido1, String apellido2, int edad,String nif, String cAutonoma, String localidad, String cPostal, String direccion,
    String email, String contraseña, String telefono) {
        super(nombre, apellido1, apellido2, edad, nif, cAutonoma, localidad, cPostal, direccion, email, contraseña, telefono);
        this.cestaCompra=new ArrayList();
    }

    public ArrayList<LineaCompra> getCestaCompra() {
        return cestaCompra;
    }

    public void setCestaCompra(ArrayList<LineaCompra> cestaCompra) {
        this.cestaCompra = cestaCompra;
    }

    public int getSupermercadoCesta() {
        return supermercadoCesta;
    }

    public void setSupermercadoCesta(int supermercadoCesta) {
        this.supermercadoCesta = supermercadoCesta;
    }
    
    @Override
    public String toString() {
        return super.toString()+"Cliente{" + "cestaCompra=" + cestaCompra + '}';
    }
    public static void eliminarPersona(Connection conexion, String nif) {
        try  {
            PreparedStatement borrar = conexion.prepareStatement("DELETE FROM cliente WHERE DNI_Cliente = ?");
            borrar.setString(1, nif);
            borrar.executeUpdate();
        }
        catch (SQLException ex) {
            Excepciones.pasarExcepcionLog("Ha ocurrido un error al borrar su cuenta", ex);
            Herramientas.aviso("Ha ocurrido un error al borrar su cuenta");
        }
    }

    public Cliente buscarCliente(String nif) {
        //TO DO and define
        return null;
    }

    public static void añadirPersona(String nombre, String apellido1, String apellido2, int edad, String nif, String cAutonoma, 
    String localidad, String cPostal, String direccion, String email, String contraseña, String rContraseña, String telefono, Connection conexion) throws Excepciones, SQLException{

        if (!contraseña.equals(rContraseña)) {
            Excepciones e = new Excepciones(6);
            throw e;
        }
        PreparedStatement sentencia = conexion.prepareStatement("INSERT INTO cliente"
                + " (DNI_Cliente, Nombre_cliente, Apellido_cliente_1, Apellido_cliente_2, Edad, Comunidad_autonoma, Localidad, Codigo_postal, Direccion, Telefono, Email, Contraseña)"
                + " VALUES"
                + " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
        sentencia.setString(1, nif);
        sentencia.setString(2, nombre);
        sentencia.setString(3, apellido1);
        sentencia.setString(4, apellido2);
        sentencia.setInt(5, edad);
        sentencia.setString(6, cAutonoma);
        sentencia.setString(7, localidad);
        sentencia.setString(8, cPostal);
        sentencia.setString(9, direccion);
        sentencia.setString(10, telefono);
        sentencia.setString(11, email);
        sentencia.setString(12, contraseña);
        sentencia.executeUpdate();
    }

    public static Cliente recogerCliente(Connection conexion, String nif) throws SQLException {
        PreparedStatement sentencia = conexion.prepareStatement("SELECT * FROM cliente WHERE DNI_Cliente = ?");
        sentencia.setString(1, nif);
        ResultSet resultado = sentencia.executeQuery();
        resultado.next();
        String nombre = resultado.getString("Nombre_cliente");
        String apellido1 = resultado.getString("Apellido_cliente_1");
        String apellido2 = resultado.getString("Apellido_cliente_2");
        int edad = resultado.getInt("Edad");
        String cAutonoma = resultado.getString("Comunidad_autonoma");
        String localidad = resultado.getString("Localidad");
        String cPostal = resultado.getString("Codigo_postal");
        String direccion = resultado.getString("Direccion");
        String email = resultado.getString("Email");
        String contraseña = resultado.getString("Contraseña");
        String telefono = resultado.getString("Telefono");
        Cliente per = new Cliente(nombre, apellido1, apellido2, edad, nif, cAutonoma, localidad, cPostal, direccion, email, contraseña, telefono);
        per.recuperarCesta();
        resultado.close();
        sentencia.close();
        return per;
    }
    
    public void recuperarCesta() throws SQLException{
        PreparedStatement query=Herramientas.getConexion().prepareStatement("SELECT * FROM linea_carrito WHERE dni_cliente=?");
        query.setString(1, this.getNif());
        ResultSet resultado=query.executeQuery();
        ArrayList <LineaCompra> carrito=new ArrayList();
        if(!resultado.next()){
        }
        else{
            this.setSupermercadoCesta(resultado.getInt("supermercado"));
            do{
                LineaCompra linea=new LineaCompra(resultado.getInt("codigo_producto"),
                resultado.getInt("cantidad"),resultado.getDouble("Precio"));
                carrito.add(linea);
            }
            while(resultado.next());
        }
        this.setCestaCompra(carrito);
        query.close();
        resultado.close();
    }

    public void editarCLiente() {
        //TO DO and define
    }
    /**
     * Metodo que añade una linea de compra al carrito.Es de instancia, por tanto
    necesita un objeto de esta clase.
     * @param codigo_producto
     * @param precio_producto
     * @param cantidad 
     */
    public void añadirProductoCarrito(int codigo_producto, double precio_producto, int cantidad) throws SQLException{
        int i=0;
        boolean encontrado=false;
        LineaCompra lc1=new LineaCompra(codigo_producto, precio_producto, cantidad);
        while(i<this.getCestaCompra().size() && !encontrado){
            if(this.getCestaCompra().get(i).getCodigo_producto()==codigo_producto){
                encontrado=true;
                try{
                    Herramientas.getConexion().setAutoCommit(false);
                    Main.getSupermercadoActivo().restarStock(lc1);
                    this.getCestaCompra().get(i).setCantidad(this.getCestaCompra().get(i).getCantidad()+cantidad);
                    this.getCestaCompra().get(i).setPrecio_linea(precio_producto, this.getCestaCompra().get(i).getCantidad());
                    this.getCestaCompra().get(i).modificarLineaCarrito(precio_producto);
                    Herramientas.getConexion().commit();
                } catch (SQLException ex) {
                    Herramientas.aviso("Ha habido algun error al añadir el producto en su carrito");
                    Excepciones.pasarExcepcionLog("Ha habido algun error al añadir el producto en su carrito", ex);
                    Herramientas.getConexion().rollback();
                } catch (Excepciones ex1) {
                    Herramientas.aviso(ex1.getMessage());
                    Excepciones.pasarExcepcionLog(ex1.getMessage(), ex1);
                    Herramientas.getConexion().rollback();
                }
                finally{
                    Herramientas.getConexion().setAutoCommit(true);
                }
            }
            i++;
        }
        if (!encontrado){
            try {
                Herramientas.getConexion().setAutoCommit(false);
                Main.getSupermercadoActivo().restarStock(lc1);
                lc1.insertLineaCarrito();
                this.getCestaCompra().add(lc1);
                Herramientas.getConexion().commit();
            } catch (SQLException ex) {
                Herramientas.aviso("Ha habido algun error al añadir el producto en su carrito");
                ex.printStackTrace();
                Herramientas.getConexion().rollback();
            } catch (Excepciones ex1) {
                Herramientas.aviso(ex1.getMessage());
                ex1.printStackTrace();
                Herramientas.getConexion().rollback();
            }
            finally{
                Herramientas.getConexion().setAutoCommit(true);
            }
        }
    }
    
    public void eliminarProductoCarrito(int codigo_producto, int cantidad) throws SQLException{
        try {
            Herramientas.getConexion().setAutoCommit(false);
            Main.getSupermercadoActivo().añadirStock(codigo_producto,cantidad);
            LineaCompra.borarLineaCarrito(codigo_producto);
            int i=0;
            boolean encontrado=false;
            while(i<this.getCestaCompra().size() && !encontrado){
                if (this.getCestaCompra().get(i).getCodigo_producto()==codigo_producto){
                    encontrado=true;
                    this.getCestaCompra().remove(i);
                }
                i++;
            }
            Herramientas.getConexion().commit();
        } catch (SQLException ex) {
            Herramientas.aviso("Ha habido algun error al eliminar el producto en su carrito");
            ex.printStackTrace();
            Herramientas.getConexion().rollback();
        }
        finally{
            Herramientas.getConexion().setAutoCommit(true);
        }  
    }
    
    public void confirmarCompra() throws SQLException{
        try {
            Herramientas.getConexion().setAutoCommit(false);
            Ticket.crearTicket(Main.getSupermercadoActivo().getCode(), this.getCestaCompra(), this.getNif());
            for(int i=0;i<this.getCestaCompra().size();i++){
                LineaCompra.borarLineaCarrito(this.getCestaCompra().get(i).getCodigo_producto());
            }
            this.getCestaCompra().clear();
            Herramientas.getConexion().commit();
        }catch(SQLException ex){
            Herramientas.aviso("Ha habido un error al procesar su compra");
            Excepciones.pasarExcepcionLog("Ha habido un error al procesar su compra", ex);
            ex.printStackTrace();
            Herramientas.getConexion().rollback();
        }finally{
            Herramientas.getConexion().setAutoCommit(true);
        }
    }
    
    public void escribirReclamacion(String reclamacion){
        if (reclamacion.isBlank()){
            Herramientas.aviso("La reclamacion esta vacia");
        }
        else{
            LocalDate fecha=LocalDate.now();
            LocalTime hora=LocalTime.now();
            DateTimeFormatter formatoFecha=DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter formatoHora=DateTimeFormatter.ofPattern("HH:mm");
            File archivo=new File("Reclamaciones"+Main.getSupermercadoActivo().getLocalitat()+".txt");
            try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo,true))) {
                escritor.write("-----------------RECLAMACION--------------------");
                escritor.newLine();
                escritor.newLine();
                escritor.write("NIF Cliente: "+this.getNif());
                escritor.newLine();
                escritor.write("Fecha: "+fecha.format(formatoFecha)+"   Hora: "+hora.format(formatoHora));
                escritor.newLine();
                int inicio=0;
                int fila=59;
                boolean fin=false;
                do{
                    if(inicio+fila>=reclamacion.length()){
                        fila=reclamacion.length()-inicio;
                        fin=true;
                        escritor.write(reclamacion, inicio, fila);
                        escritor.newLine();
                    }
                    else{
                        escritor.write(reclamacion, inicio, fila);
                        escritor.newLine();
                    }
                    inicio+=59;
                }
                while(!fin);
                escritor.newLine();
                escritor.newLine();
            } catch (IOException ex) {
                Excepciones.pasarExcepcionLog("Ha ocurrido un problema al insertar su reclamacion", ex);
                Herramientas.aviso("Ha ocurrido un problema al insertar su reclamacion");
            }
        }
    }
    
    
    public static void eliminarClienteYInfo(Connection conexion, String nif) throws SQLException {
        try {
            conexion.setAutoCommit(false);
            Cliente.eliminarPersona(conexion, nif);
            PreparedStatement borrar = conexion.prepareStatement("DELETE FROM linea_carrito WHERE DNI_cliente = ?");
            borrar.setString(1, nif);
            borrar.executeUpdate();
            borrar = conexion.prepareStatement("DELETE FROM tarjeta_cliente WHERE DNI_cliente = ?");
            borrar.setString(1, nif);
            borrar.executeUpdate();
            conexion.commit();
        } catch (SQLException ex) {
            conexion.rollback();
        }
        finally {
            conexion.setAutoCommit(true);
        }
    }
    
}
