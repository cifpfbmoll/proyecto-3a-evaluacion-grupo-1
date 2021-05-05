package Main.Classes;
import java.sql.*;
import Main.Classes.Excepciones;

public abstract class Persona {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int edad;
    private String nif;
    private String cAutonoma;
    private String localidad;
    private String cPostal;
    private String direccion;
    private String email;
    private String contraseña;
    private String telefono;

    public Exception contraseñasDiferentes;

    public Persona() {

    }
    
    public Persona(String nombre, String apellido1, String apellido2, int edad,String nif, String cAutonoma, String localidad, String cPostal, String direccion,
    String email, String contraseña, String telefono) {
        setNombre(nombre);
        setApellido1(apellido1);
        setApellido2(apellido2);
        setEdad(edad);
        setNif(nif);
        setCAutonoma(cAutonoma);
        setLocalidad(localidad);
        setCPostal(cPostal);
        setDireccion(direccion);
        setEmail(email);
        setContraseña(contraseña);
        setTelefono(telefono);
    }

    

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return this.apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return this.apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public String getNif() {
        return this.nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getCAutonoma() {
        return this.cAutonoma;
    }

    public void setCAutonoma(String cAutonoma) {
        this.cAutonoma = cAutonoma;
    }

    public String getLocalidad() {
        return this.localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCPostal() {
        return this.cPostal;
    }

    public void setCPostal(String cPostal) {
        this.cPostal = cPostal;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return this.contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void cambiarContraseña(String novaContraseña, String rContraseña) throws Excepciones{
        if (!contraseña.equals(rContraseña)) {
            Excepciones e = new Excepciones(6);
            throw e;
        }
        setContraseña(novaContraseña);
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", edad=" + edad + ", nif=" + nif + ", cAutonoma=" + cAutonoma + ", localidad=" + localidad + ", cPostal=" + cPostal + ", direccion=" + direccion + ", email=" + email + ", contrase\u00f1a=" + contraseña + ", telefono=" + telefono +  '}';
    }
    
    
}