package Main.Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import Main.Classes.Excepciones;
import java.sql.SQLException;

public class Cliente extends Persona {
    
    private ArrayList <LineaCompra> cestaCompra;
    
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

    public void eliminarPersona(Connection conexion, String nif) throws SQLException {
        PreparedStatement borrar = conexion.prepareStatement("DELETE FROM employee_details WHERE salary = ?");
        borrar.setString(1, nif);
        borrar.executeQuery();
    }

    public Cliente buscarCliente(String nif) {
        //TO DO and define
        return null;
    }
   
    public static Cliente añadirPersona(String nombre, String apellido1, String apellido2, int edad, String nif, String cAutonoma, 
    String localidad, String cPostal, String direccion, String email, String contraseña, String rContraseña, String telefono) throws Excepciones{

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
    /**
     * Metodo que añade una linea de compra al carrito. Es de instancia, por tanto
     * necesita un objeto de esta clase.
     * @param producto
     * @param cantidad 
     */
    public void añadirProductoCarrito(int codigo_producto, double precio_producto, int cantidad){
        LineaCompra lc1=new LineaCompra(codigo_producto, precio_producto, cantidad);
        this.getCestaCompra().add(lc1);
    }
}
