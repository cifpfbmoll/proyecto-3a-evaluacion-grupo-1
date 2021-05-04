package Main.Classes;

import java.sql.*;

public class Empleado extends Persona {
    private int id;
    private int codigoSupermercado;
    private String puestoTrabajo;
    private int privilegios;
    //Privilegios
    //1: Dependiente
    //2: Supervisor
    //3: RRHH
    //4: Director

    public Empleado() {
        super();
    }

    public Empleado(String nombre, String apellido1, String apellido2,int edad,String nif, String cAutonoma, String localidad, String cPostal, String direccion,
    String email, String contraseña, String telefono, int id, int codigoSupermercado, String puestoTrabajo, int privilegios) {
        super(nombre, apellido1, apellido2, edad, nif, cAutonoma, localidad, cPostal, direccion, email, contraseña, telefono);
        setId(id);
        setCodigoSupermercado(codigoSupermercado);
        setPuestoTrabajo(puestoTrabajo);
        setPrivilegios(privilegios);
    }

    public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodigoSupermercado() {
		return this.codigoSupermercado;
	}

	public void setCodigoSupermercado(int codigoSupermercado) {
		this.codigoSupermercado = codigoSupermercado;
	}

	public String getPuestoTrabajo() {
		return this.puestoTrabajo;
	}

	public void setPuestoTrabajo(String puestoTrabajo) {
		this.puestoTrabajo = puestoTrabajo;
	}

	public int getPrivilegios() {
		return this.privilegios;
	}

	public void setPrivilegios(int privilegios) {
		this.privilegios = privilegios;
	}
        
    public static Empleado añadirPersona(String nombre, String apellido1, String apellido2, int edad, String nif, String cAutonoma, 
    String localidad, String cPostal, String direccion, String email, String contraseña, String rContraseña, String telefono, int id, 
    int codigoSupermercado, String puestoTrabajo, int privilegios) throws Excepciones{

        if (!contraseña.equals(rContraseña)) {
            Excepciones e = new Excepciones(6);
            throw e;
        }
        Empleado per = new Empleado(nombre, apellido1, apellido2, edad, nif, cAutonoma, localidad, cPostal, direccion, email, contraseña, telefono, 
        id, codigoSupermercado, puestoTrabajo, privilegios);
        return per;
    }

    public static Empleado recogerEmpleado(Connection conexion, int id) throws SQLException {
        PreparedStatement sentencia = conexion.prepareStatement("SELECT * FROM empleado WHERE ID_EMPLEADO = ?");
        sentencia.setInt(1, id);
        ResultSet resultado = sentencia.executeQuery();
        resultado.next();
        String nombre = resultado.getString("Nombre_empleado");
        String apellido1 = resultado.getString("Apellido_empleado_1");
        String apellido2 = resultado.getString("Apellido_empleado_2");
        int edad = resultado.getInt("Edad");
        String nif = resultado.getString("DNI_empleado");
        String cAutonoma = resultado.getString("Comunidad_autonoma");
        String localidad = resultado.getString("Localidad");
        String cPostal = resultado.getString("Codigo_postal");
        String direccion = resultado.getString("Direccion");
        String email = resultado.getString("Email");
        String contraseña = resultado.getString("Contraseña");
        String telefono = resultado.getString("Telefono");
        int codigoSupermercado = resultado.getInt("Codigo_supermercado");
        String puestoTrabajo = resultado.getString("Puesto_trabajo");
        int privilegios = resultado.getInt("Privilegios");
        Empleado per = new Empleado(nombre, apellido1, apellido2, edad, nif, cAutonoma, localidad, cPostal, direccion, email, contraseña, telefono, 
        id, codigoSupermercado, puestoTrabajo, privilegios);
        resultado.close();
        sentencia.close();
        return per;
    }

    public void eliminarPersona(Connection conexion, int id) throws SQLException {
        PreparedStatement borrar = conexion.prepareStatement("DELETE FROM empleado WHERE ID_EMPLEADO = ?");
        borrar.setInt(1, id);
        borrar.executeUpdate();
        borrar.close();
    }

    public void certificadoIRPFAnual(int id) {
        // TODO Cuando BBDD
    }

    public void consultarNominas(int id) {
        // TODO Cuando BBDD
    }

    public static void main(String[] args) throws SQLException {
        Herramientas.crearConexion();
        Empleado emp = new Empleado();
        emp = Empleado.recogerEmpleado(Herramientas.getConexion(), 1);
        System.out.println(emp.toString());
    }
}