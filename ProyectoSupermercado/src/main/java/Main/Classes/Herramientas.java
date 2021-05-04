/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Classes;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class Herramientas {
    
    private static Connection conexion;
    private static PreparedStatement comando;
    private static ResultSet resultado;
    private static int filasAfectadas;
    
    /* EJEMPLO DE COMO USAR METODOS PARA LA BASE DE DATOS*/
    /*Connection con=DriverManager.getConnection("jdbc:mysql://51.178.152.220:3306/metradona", "admin1", "Tomeu21!");
    PreparedStatement coman=con.prepareStatement("UPDATE ticket SET precio_total=8.5 WHERE codigo_ticket=1;");
    int fa=coman.executeUpdate();
    System.out.println(fa);*/
    public static void main(String[] args) throws SQLException {
        
    }

    public static Connection getConexion() {
        return conexion;
    }
    
    public static ResultSet getResultado() {
        return resultado;
    }

    public static int getFilasAfectadas() {
        return filasAfectadas;
    }
    /**
     * Crea una conexion a la base de datos.
     * @throws SQLException 
     */
    public static void crearConexion() throws SQLException{
        conexion=DriverManager.getConnection("jdbc:mysql://51.178.152.220:3306/metradona", "admin1", "Tomeu21!");
    };
    /**
     * Metodo que realizar una query en la bbdd a la cual nos hemos conectado previamente.
     * Recibe una string, que es una query que va a ser realizada en la bbdd,
     * y un booleano para activar o desactivar el autocommit.
     * @param query String que tiene que ser un SELECT en sql
     * @param autoCommit boolean, true=autocommitactivado, false=autocommitdesactivado
     * @throws SQLException 
     */
    public static void hacerSelect(String query, boolean autoCommit) throws SQLException{
        //Tomeu21!
        conexion.setAutoCommit(autoCommit);
        comando=conexion.prepareStatement(query);        
        resultado=comando.executeQuery();
    }
    
    /**
     * Metodo que realizar una modificacion en la bbdd a la cual nos hemos conectado previamente.
     * Una modificacion es un Update, Delete, Insert o una DDL.
     * Recibe una string, que es una modificacion que va a ser realizada en la bbdd,
     * y un booleano para activar o desactivar el autocommit.
     * @param query String que tiene que ser un SELECT en sql
     * @param autoCommit boolean, true=autocommitactivado, false=autocommitdesactivado
     * @throws SQLException 
     */
    public static void modificarDatosTabla(String query, boolean autoCommit) throws SQLException{
        //Tomeu21!
        conexion.setAutoCommit(autoCommit);
        comando=conexion.prepareStatement(query);        
        filasAfectadas=comando.executeUpdate();
    }
    
    /**Tendremos que manejar los commit i volver a activar el autocommit despues de
    una transaccion cada uno por separado.**/
    
    public static void cerrarStatementResult() throws SQLException{
        if (resultado!=null){
            resultado.close();
        }
        comando.close();
    }
    
    public static void cerrarConexion() throws SQLException {
        conexion.close();
    }
    
    public static void aviso (String mensaje){
        JOptionPane.showMessageDialog(null,mensaje); 
    }
}
