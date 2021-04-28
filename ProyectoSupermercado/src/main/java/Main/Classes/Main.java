/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Classes;

import Main.Classes.ProductoAlimento.Categoria;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author josep
 */
public class Main {
    public static void main(String[] args) throws ParseException {
        String entrada = "07-03-2018";
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha;
        fecha = formato.parse(entrada);
        float myNum = 5.1f;
        ProductoAlimento pipas = new ProductoAlimento(fecha, Categoria.vegano, 2, "pipas" , myNum ,  "pipas saladas");
        System.out.println(pipas.getCaducidad());
        System.out.println(pipas.UltimoNumero);
    }
}
