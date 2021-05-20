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
    
    static Scanner sc=new Scanner(System.in);

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

    //Se tienen qeu definir nuevos mensajes, codigo copiado de otro programa
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
                mensaje="ERROR 3: No existe ningun usuario de la biblioteca que tenga ese telefono y ese correo electronico";
                break;
            case 4:
                mensaje="ERROR 4: No existe ninguna biblioteca con ese nombre en nuestros registros";
                break;
            case 5:
                mensaje="ERROR 5: No existe ninguna persona con ese nombre y apellidos en el sistema";
                break;
            case 6:
                mensaje="Las contraseñas no coinciden";
                break;
            case 7:
                mensaje="La contraseña tiene que ser de almenos 8 caracteres";
                break;
        }
        return mensaje;
    }
    
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
            escritor.write("Mensaje: "+mensaje);
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
