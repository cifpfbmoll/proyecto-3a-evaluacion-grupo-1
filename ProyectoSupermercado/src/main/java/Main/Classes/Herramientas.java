/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Classes;

import java.sql.*;

/**
 *
 * @author PC
 */
public class Herramientas {
    
    private static Connection conexion;
    private static PreparedStatement comando;
    private static ResultSet resultado;
    
    /* EJEMPLO DE COMO USAR METODOS PARA LA BASE DE DATOS*/
    public static void main(String[] args) throws SQLException {
        enviarComando("SELECT * FROM prueba");
        ResultSet result=Herramientas.getResultado();
        result.next();
        System.out.println("El jugador "+result.getString(1)+" juega en el ");
        cerrarConexion();
    }

    public static ResultSet getResultado() {
        return resultado;
    }
    
    public static void enviarComando(String query) throws SQLException{
        //Tomeu21!
        conexion=DriverManager.getConnection("jdbc:mysql://51.178.152.220:3306/pruebajaume", "admin1", "Tomeu21!");
        comando=conexion.prepareStatement(query);        
        resultado=comando.executeQuery();
    }
    
    public static void cerrarConexion() throws SQLException {
        resultado.close();
        comando.close();
        conexion.close();
    }
}
