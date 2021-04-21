package Main.Classes;

public class Empleado extends Persona {
    private int id;
    private int codigoSupermercado;
    private String puestoTrabajo;
    private Privilegios privilegios;


    public enum Privilegios {
        jefe,
        RRHH,
        BBDD
    }

    public Empleado() {
        super();
    }

    public Empleado(String nombre, String apellido1, String apellido2, String nif, String cAutonoma, String localidad, String cPostal, String direccion,
    String email, String contraseña, int telefono, int id, int codigoSupermercado, String puestoTrabajo, Privilegios privilegios) {
        super(nombre, apellido1, apellido2, nif, cAutonoma, localidad, cPostal, direccion, email, contraseña, telefono);
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
    public void añadirPersona() {
        // TODO Cuando BBDD
        super.añadirPersona();
    }

    @Override
    public void eliminarPersona() {
        // TODO Cuando BBDD
        super.eliminarPersona();
    }

    public void certificadoIRPFAnual(int id) {
        // TODO CUando BBDD
    }

    public void consultarNominas(int id) {
        // TODO Cuando BBDD
    }

    @Override
    public void cambiarContraseña(String novaContraseña) {
        //TODO Cuando BBDD
    }

}