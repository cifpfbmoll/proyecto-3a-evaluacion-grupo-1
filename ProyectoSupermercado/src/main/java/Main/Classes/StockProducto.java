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
 * @author PC
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
            ex.printStackTrace();
        }
        finally{
            resultado.close();
        }
        return stockSupermercado;
    }

    public static void deleteStockSupermercado(int supermarketCode) {
        Connection connection = Herramientas.getConexion();

        PreparedStatement deleteStockPreparedStatement = null;

        try {
            deleteStockPreparedStatement = connection.prepareStatement("DELETE FROM STOCK_SUPERMERCADO WHERE Codigo_supermercado = ?");
            deleteStockPreparedStatement.setInt(1, supermarketCode);
            deleteStockPreparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();

        } finally {
            try {
                deleteStockPreparedStatement.close();

            } catch (SQLException sqlException) {
                sqlException.printStackTrace();

            }

        }


    }

    public static void ficheroGestionStock(Boolean guardarFecha, String nProducto, String cantidad, String nSupermercado) throws IOException{
        File archivoGestion = new File("supermercado"+nSupermercado+".txt");
        BufferedWriter buffer = new BufferedWriter (new FileWriter(archivoGestion, true));
        if (guardarFecha) {
            java.util.Date fecha=new java.util.Date();
            buffer.append("------------------------------------------------------------");
            buffer.newLine();
            buffer.append("Fecha: " + fecha.toString());
            buffer.newLine();
        }
        else {
        buffer.append("Producto: " + nProducto + " cantidad: " + cantidad);
        buffer.newLine();
        }
        buffer.close();
    }
    
}
