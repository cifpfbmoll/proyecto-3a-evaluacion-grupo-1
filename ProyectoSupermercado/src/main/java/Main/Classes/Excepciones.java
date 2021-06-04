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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Jaume
 */
public class Excepciones extends Exception {
    
    private int codigoError;

    public Excepciones() {
        super();
    }

    public Excepciones(int codigoError) {
        super();
        this.setCodigoError(codigoError);
    }

    public int getCodigoError() {
        return codigoError;
    }

    public void setCodigoError(int codigoError) {
        this.codigoError = codigoError;
    }

    /**
     * Metodo de la clase padre Exception el qual es sobreescrito para poder asignar
     * nuevos mensajes a las excepciones que nosotros creamos. Estos mensajes dependen
     * del int que asignamos a la excepcion cuando la lanzamos.
     * @return mensaje String que es el mensaje de error de la excepcion lanzada
     */
    @Override
    public String getMessage() {
        String mensaje="";
        switch(this.getCodigoError()){
            case 1:
                mensaje="ERROR 1: Ese numero no esta entre las opciones disponibles, inserta un numero que si lo este";
                break;
            case 2:
                mensaje="ERROR 2: No es posible añadir esa cantidad ya que el stock es menor a la cantidad demandada";
                break;
            case 3:
                mensaje="ERROR 3: No existe ese puesto de trabajo en nuestra cadena de supermercados";
                break;
            case 4:
                mensaje="ERROR 4: Inserte un cvv correcto";
                break;
            case 5:
                mensaje="ERROR 5: No existe ninguna persona con ese nombre y apellidos en el sistema";
                break;
            case 6:
                mensaje="ERROR 6: Las contraseñas no coinciden";
                break;
            case 7:
                mensaje="La contraseña tiene que ser de almenos 8 caracteres";
                break;
        }
        return mensaje;
    }
    
    /**
     * Metodo que escribe informacion sobre una excepcion que ha sido cazada (catch) en el
     * programa. Este metodo recibe por parametro un mensaje, que es el que se ha enseñado 
     * por pantalla al usuario y una excepcion y escribe en un fichero conocido com logErrores 
     * la fecha y hora en la que ha ocurrido la excepcion, el mensaje enseñado al usuario,
     * el mensaje de error de la excepcion(puede coincidir con el enseñado al usuario) y el 
     * StackTrace de la excepcion. Si ocurre alguna excepcion en este mismo metodo es cazada en el.
     * @param mensaje String que es el mensaje que se enseña al usuario por pantalla
     * @param ex Exception que es cazada en algun catch 
     */
    public static void pasarExcepcionLog(String mensaje, Exception ex){
        LocalDate fecha=LocalDate.now();
        LocalTime hora=LocalTime.now();
        DateTimeFormatter formatoFecha=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoHora=DateTimeFormatter.ofPattern("HH:mm");
        File archivo=new File("LogErrores.txt");
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo,true))) {
            escritor.write("------------------EXEPCION------------------");
            escritor.newLine();
            escritor.newLine();
            escritor.write("Problema: "+mensaje);
            escritor.newLine();
            escritor.write("Mensaje: "+ex.getMessage());
            escritor.newLine();
            escritor.write("Fecha: "+fecha.format(formatoFecha)+"   Hora: "+hora.format(formatoHora));
            escritor.newLine();
            escritor.write("STACKTRACE:");
            escritor.newLine();
            for(int i=0;i<ex.getStackTrace().length;i++){
                escritor.write(ex.getStackTrace()[i].toString());
                escritor.newLine();
            };
            escritor.newLine();
        }
        catch(IOException exI){
            System.out.println("Ha habido un problema capturando la excepcion");
        }
    }
}
