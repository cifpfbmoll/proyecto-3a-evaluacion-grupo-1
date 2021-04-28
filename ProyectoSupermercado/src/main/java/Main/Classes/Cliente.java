package Main.Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import Main.Classes.Excepciones;

public class Cliente extends Persona {
    
    private ArrayList <LineaCompra> cestaCompra;
    
    public Cliente() {
        super();
    }

    public Cliente(String nombre, String apellido1, String apellido2, int edad,String nif, String cAutonoma, String localidad, int cPostal, String direccion,
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

    public void eliminarPersona(Connection conexion, String nif) {
        PreparedStatement borrar = conexion.prepareStatement("DELETE FROM employee_details WHERE salary = ?");
        borrar.setString(1, nif);
        borrar.executeQuery();
    }

    public Cliente buscarCliente(String nif) {
        //TO DO and define
        return null;
    }
    
    @Override
    public static Cliente añadirPersona(String nombre, String apellido1, String apellido2, int edad, String nif, String cAutonoma, 
    String localidad, int cPostal, String direccion, String email, String contraseña, String rContraseña, String telefono) throws Excepciones{

        if (!contraseña.equals(rContraseña)) {
            Excepciones e = new Excepciones(6);
            throw e;
        }
        Cliente per = new Cliente(nombre, apellido1, apellido2, edad, nif, cAutonoma, localidad, cPostal, direccion, email, contraseña, telefono);
        return per;
    }

    public void editarCLiente() {
        //TO DO and define
    }
    
    public void añadirProductoCarrito(Producto producto, int cantidad){
        LineaCompra lc1=new LineaCompra(producto, cantidad);
        this.getCestaCompra().add(lc1);
    }
}
