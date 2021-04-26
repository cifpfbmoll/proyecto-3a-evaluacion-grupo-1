package Main.Classes;

import java.util.ArrayList;

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

    public void añadirPersona() {
        super.añadirPersona();
    }

    public void eliminarPersona() {
        super.eliminarPersona();
    }

    public void buscarCliente() {
        //TO DO cuando transacciones
    }

    public void editarCLiente() {
        //TO DO cuando transacciones
    }

    @Override
    public void cambiarContraseña(String novaContraseña) {
        //TODO Cuando BBDD
    }
    
    public void añadirProductoCarrito(Producto producto, int cantidad){
        LineaCompra lc1=new LineaCompra(producto, cantidad);
        this.getCestaCompra().add(lc1);
    }
}
