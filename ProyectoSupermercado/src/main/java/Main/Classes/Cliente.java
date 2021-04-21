package Main.Classes;

public class Cliente extends Persona {
    public Cliente() {
        super();
    }

    public Cliente(String nombre, String apellido1, String apellido2, String nif, String cAutonoma, String localidad, String cPostal, String direccion,
    String email, String contraseña, int telefono) {
        super();
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
    public void cambiarContraseña() {
        //TODO Cuando BBDD
    }
}