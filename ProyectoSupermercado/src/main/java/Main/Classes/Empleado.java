package Main.Classes;

import java.sql.PreparedStatement;

public class Empleado extends Persona {
    private int id;
    private int codigoSupermercado;
    private String puestoTrabajo;
    private Privilegios privilegios;

    //privilegios han de ser integers.
    public enum Privilegios {
        jefe,
        RRHH,
        BBDD
    }

    public Empleado() {
        super();
    }

    public Empleado(String nombre, String apellido1, String apellido2,int edad,String nif, String cAutonoma, String localidad, int cPostal, String direccion,
    String email, String contraseña, String telefono, int id, int codigoSupermercado, String puestoTrabajo, Privilegios privilegios) {
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

	public Privilegios getPrivilegios() {
		return this.privilegios;
	}

	public void setPrivilegios(Privilegios privilegios) {
		this.privilegios = privilegios;
	}
        
    @Override
    public static Empleado añadirPersona(String nombre, String apellido1, String apellido2, int edad, String nif, String cAutonoma, 
    String localidad, int cPostal, String direccion, String email, String contraseña, String rContraseña, String telefono, int id, 
    int codigoSupermercado, String puestoTrabajo, Privilegios privilegios) throws Excepciones{

        if (!contraseña.equals(rContraseña)) {
            Excepciones e = new Excepciones(6);
            throw e;
        }
        Empleado per = new Empleado(nombre, apellido1, apellido2, edad, nif, cAutonoma, localidad, cPostal, direccion, email, contraseña, telefono, 
        id, codigoSupermercado, puestoTrabajo, privilegios);
        return per;
    }

    @Override
    public void eliminarPersona(Connection conexion, int id) {
        PreparedStatement borrar = conexion.prepareStatement("DELETE FROM employee_details WHERE salary = ?");
        borrar.setInt(1, id);
        borrar.executeQuery();
    }

    public void certificadoIRPFAnual(int id) {
        // TODO CUando BBDD
    }

    public void consultarNominas(int id) {
        // TODO Cuando BBDD
    }
}