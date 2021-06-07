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
 * @author jaume
 */
public class Herramientas {
    
    private static Connection conexion;
    /**
     * @deprecated Al no usar los metodos para estas variables estas quedan sin utilidad
     * @see #hacerSelect(java.lang.String, boolean)
     * @see #modificarDatosTabla(java.lang.String, boolean) 
     */
    private static PreparedStatement comando;
    /**
     * @deprecated Al no usar los metodos para estas variables estas quedan sin utilidad
     * @see #hacerSelect(java.lang.String, boolean)
     * @see #modificarDatosTabla(java.lang.String, boolean) 
     */
    private static ResultSet resultado;
    private static int filasAfectadas;
    
    /* EJEMPLO DE COMO USAR METODOS PARA LA BASE DE DATOS*/
    /*Connection con=DriverManager.getConnection("jdbc:mysql://51.178.152.220:3306/metradona", "admin1", "Tomeu21!");
    PreparedStatement coman=con.prepareStatement("UPDATE ticket SET precio_total=8.5 WHERE codigo_ticket=1;");
    int fa=coman.executeUpdate();
    System.out.println(fa);*/

    public static Connection getConexion() {
        return conexion;
    }
    
    /**
     * @deprecated Al no usar la variable de este getter este queda sin utilidad
     * @see #resultado
     * @return ResultSet resultado de la query
     */
    public static ResultSet getResultado() {
        return resultado;
    }

    /**
     * Crea una conexion a la base de datos.
     * @throws SQLException puede tirar una SQLException ya que se relaciona con la base de datos
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
     * @throws SQLException  puede tirar una SQLException ya que se relaciona con la base de datos
     * @deprecated Al final no usamos estos metodos, porque es codigo que se tenia que
     * aprender para el examen y porque causava confusion en donde poder emplearlos y en donde no
     * debido a los problemas de sqlinjection
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
     * @throws SQLException puede tirar una SQLException ya que se relaciona con la base de datos
     * @deprecated Al final no usamos estos metodos, porque es codigo que se tenia que
     * aprender para el examen y porque causava confusion en donde poder emplearlos y en donde no
     * debido a los problemas de sqlinjection
     */
    public static void modificarDatosTabla(String query, boolean autoCommit) throws SQLException{
        //Tomeu21!
        conexion.setAutoCommit(autoCommit);
        comando=conexion.prepareStatement(query);        
        filasAfectadas=comando.executeUpdate();
    }
    
    
    /**
     * Cierra las variables resultado y comando.
     * @deprecated Al no poder usar esas variables este metodo se queda sin utilidad
     * @see #resultado
     * @see #comando
     * @throws SQLException puede tirar una SQLException ya que se relaciona con la base de datos
     */
    public static void cerrarStatementResult() throws SQLException{
        if (resultado!=null){
            resultado.close();
        }
        comando.close();
    }
    /**
     * Cierra la conexion con la base de datos.
     * @throws SQLException puede tirar una SQLException ya que se relaciona con la base de datos
     */
    public static void cerrarConexion() throws SQLException {
        conexion.close();
    }
    /**
     * Metodo que sive para escribir en un jOptionPane, que viene a ser como un 
     * pop up, la String que se le pasa por parametro. 
     * @param mensaje String el mensaje que se quiere mostrar en pantalla
     */
    public static void aviso (String mensaje){
        JOptionPane.showMessageDialog(null,mensaje); 
    }
}
