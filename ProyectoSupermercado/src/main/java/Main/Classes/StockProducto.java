/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author jaume
 */
public class StockProducto {
    
    private int codigoProducto;
    private int cantidad;

    public StockProducto() {
    }

    public StockProducto(int codigoProducto, int cantidad) {
        this.setCodigoProducto(codigoProducto);
        this.setCantidad(cantidad);
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "StockProducto{" + "codigoProducto=" + codigoProducto + ", cantidad=" + cantidad + '}';
    }
    
    /**
     * Metodo que es llamado cuando se crea un nuevo supermercado. Inserta en la base de datos
     * una fila con el codigo del nuevo supermercado, el codigo del producto y una cantidad
     * que siempre sera 0 por cada producto en la base de datos dentro de la tabla stock_supermercado.
     * @param codigoSupermercado int que identifica al supermercado
     * @param conexion Connection con la base de datos
     * @throws SQLException Puede lanazar una SQLException ya que se comunica con la base de datos
     */
    public static void inicializarStock(int codigoSupermercado, Connection conexion) throws SQLException{
        try (PreparedStatement query = conexion.prepareStatement("INSERT INTO stock_supermercado"+
        " SELECT ?,codigo_producto,0 FROM stock_supermercado GROUP BY codigo_producto")) {
            query.setInt(1, codigoSupermercado);
            query.executeUpdate();
        }
    }
    
    /**
     * Metodo que obtiene el Stock de un supermercado a traves de un Select en la base de datos.
     * El supermercado se identifica a traves del int que se pasa por parametro, el cual es
     * su identificador. Devuelve una ArrayList con el stock.
     * @param codigoSupermercado int que identifica un supermercado
     * @return ArrayList de StockProducto donde esta guardado todo el stock de este supermercado
     * @throws SQLException Puede tirar una SQLException ya que se comunica con la base de datos.
     */
    public static ArrayList obtenerStockSupermercado(int codigoSupermercado) throws SQLException{
        ArrayList <StockProducto> stockSupermercado=new ArrayList();
        ResultSet resultado=null;
        try (PreparedStatement query = Herramientas.getConexion().prepareStatement("SELECT * FROM stock_supermercado WHERE codigo_supermercado=?")) {
            query.setInt(1, codigoSupermercado);
            resultado=query.executeQuery();
            while(resultado.next()){
                StockProducto stock=new StockProducto(resultado.getInt("codigo_producto"),resultado.getInt("cantidad"));
                stockSupermercado.add(stock);
            }
            resultado.close();
        }
        catch(SQLException ex){
            Herramientas.aviso("Ha habido algun error con las base de datos al intentar obtener el stock");
            Excepciones.pasarExcepcionLog("Ha habido algun error con las base de datos al intentar obtener el stock", ex);
        }
        finally{
            resultado.close();
        }
        return stockSupermercado;
    }
    
    /**
     * Metodo al cual se le pasa un int que identifica un supermercado para 
     * eliminar ese supermercado de la base de datos. Las SQLException se trata
     * en el propio metodo.
     * @param supermarketCode int que identifica el supermercado.
     */
    public static void deleteStockSupermercado(int supermarketCode) {
        Connection connection = Herramientas.getConexion();

        PreparedStatement deleteStockPreparedStatement = null;

        try {
            deleteStockPreparedStatement = connection.prepareStatement("DELETE FROM STOCK_SUPERMERCADO WHERE Codigo_supermercado = ?");
            deleteStockPreparedStatement.setInt(1, supermarketCode);
            deleteStockPreparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            Herramientas.aviso("Ha ocurrido un error al eliminar el stock del supermercado");
            Excepciones.pasarExcepcionLog("Ha ocurrido un error al eliminar el stock del supermercado", sqlException);

        } finally {
            try {
                deleteStockPreparedStatement.close();

            } catch (SQLException sqlException) {
                Herramientas.aviso("Ha ocurrido un error al eliminar el stock del supermercado");
                Excepciones.pasarExcepcionLog("Ha ocurrido un error al eliminar el stock del supermercado", sqlException);

            }

        }


    }
    
    /**
     * Metodo en el cual se escribe una linea de informacion sobre la modifcacion del Stock 
     * de un supermercado en un fichero. El fichero en el que se guarda tendra 
     * la localidad del supermercado como parte del nombre
     * @param nProducto String nombre del producto
     * @param cantidad String cantidad de ese producto que se ha agregado
     * @param nSupermercado String del nombre de la localidad del supermercado, que es lo que los identifica
     * @throws IOException puede tirar una excepcion ja que trabaja con ficheros
     */
    public static void ficheroGestionStock(String nProducto, String cantidad, String nSupermercado) throws IOException{
        File archivoGestion = new File("reposicionStock"+nSupermercado+".txt");
        BufferedWriter buffer = new BufferedWriter (new FileWriter(archivoGestion, true));
        buffer.append("Producto: " + nProducto + " cantidad: " + cantidad);
        buffer.newLine();
        buffer.close();
    }
    /**
     * Metodo en el cual se escribe la cabezera de un proceso de actualizacion de 
     * stock. Esta cabezera contiene la fecha en la que se realiza. El fichero en
     * el que se guarda tendra la localidad del supermercado como parte del nombre
     * @param nSupermercado String del nombre de la localidad del supermercado, que es lo que los identifica
     * @throws IOException puede tirar una excepcion ja que trabaja con ficheros
     */
    public static void ficheroGestionFecha(String nSupermercado) throws IOException {
        File archivoGestion = new File("reposicionStock"+nSupermercado+".txt");
        BufferedWriter buffer = new BufferedWriter (new FileWriter(archivoGestion, true));
        java.util.Date fecha=new java.util.Date();
        buffer.newLine();
        buffer.newLine();
        buffer.newLine();
        buffer.append("-------------------------ACTUALIZACION-----------------------");
        buffer.newLine();
        buffer.append("Fecha: " + fecha.toString());
        buffer.newLine();
        buffer.newLine();
        buffer.close();
    }
    
}
