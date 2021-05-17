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

        @Override
        public String toString() {
            return super.toString() + "Empleado{" + "id=" + id + ", codigoSupermercado=" + codigoSupermercado + ", puestoTrabajo=" + puestoTrabajo + ", privilegios=" + privilegios + '}';
        }


        
    public static void añadirPersona(String nombre, String apellido1, String apellido2, int edad, String nif, String cAutonoma, 
    String localidad, String cPostal, String direccion, String email, String contraseña, String rContraseña, String telefono, 
    int codigoSupermercado, String puestoTrabajo, int privilegios, Connection conexion) throws Excepciones, SQLException{
        if (!contraseña.equals(rContraseña)) {
            Excepciones e = new Excepciones(6);
            throw e;
        }
        PreparedStatement sentencia2 = conexion.prepareStatement("SELECT MAX(ID_EMPLEADO) FROM empleado;");
        ResultSet resultado2 = sentencia2.executeQuery();
        resultado2.next();
        int id = resultado2.getInt(1);
        id++;
        PreparedStatement sentencia = conexion.prepareStatement("INSERT INTO empleado"
                + " (ID_EMPLEADO, Codigo_supermercado, DNI_empleado, Nombre_empleado, Apellido_empleado_1, Apellido_empleado_2, Edad, Comunidad_autonoma, Localidad, Codigo_postal, Direccion, Telefono, Email, Puesto_trabajo, Privilegios, Contraseña)"
                + " VALUES"
                + " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
        sentencia.setInt(1, id);
        sentencia.setInt(2, codigoSupermercado);
        sentencia.setString(3, nif);
        sentencia.setString(4, nombre);
        sentencia.setString(5, apellido1);
        sentencia.setString(6, apellido2);
        sentencia.setInt(7, edad);
        sentencia.setString(8, cAutonoma);
        sentencia.setString(9, localidad);
        sentencia.setString(10, cPostal);
        sentencia.setString(11, direccion);
        sentencia.setString(12, telefono);
        sentencia.setString(13, email);
        sentencia.setString(14, puestoTrabajo);
        sentencia.setInt(15, privilegios);
        sentencia.setString(16, contraseña);
        sentencia.executeUpdate();
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

    public static void eliminarPersona(Connection conexion, int id) throws SQLException {
        PreparedStatement borrar = conexion.prepareStatement("DELETE FROM empleado WHERE ID_EMPLEADO = ?");
        borrar.setInt(1, id);
        borrar.executeUpdate();
        borrar.close();
    }

    public static void borrarEmpleadoYNominas(Connection conexion, int id, boolean comitear) throws SQLException {
        PreparedStatement borrar = null;
        try {
            
            conexion.setAutoCommit(false);
            borrar = conexion.prepareStatement("DELETE FROM nomina WHERE ID_empleado = ?");
            borrar.setInt(1, id);
            borrar.executeUpdate();
            Empleado.eliminarPersona(conexion, id);
            if (comitear){
                conexion.commit();
            }
        }

        catch (SQLException e) {
            conexion.rollback();
            //e.printStackTrace();
        }

        finally {
            borrar.close();
            conexion.setAutoCommit(comitear);
        }

    }

    public void certificadoIRPFAnual(int id) {
        // TODO Cuando BBDD
    }

    public void consultarNominas(int id) {
        // TODO Cuando BBDD
    }
    
//    public static void main(String[] args) throws SQLException {
//        Herramientas.crearConexion();
//        Empleado.borrarEmpleadoYNominas(Herramientas.getConexion(), 2, true);
//        Herramientas.cerrarConexion();
//    }
}