

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tamara
 */
import java.util.ArrayList;
import java.util.Scanner;


public class nomina {
      
    public static void main (String arg[]){
        
        ArrayList<Empleados> todosEmpleados= new ArrayList<>();
        
        Scanner sc = new Scanner (System.in);
        
        //pedimos datos
        System.out.println("________________________________Bienvenido al sistema de nomina_____________________");
        System.out.print("Ingrese el ID_empleado: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese el puesto_de_trabajo:");
        String puesto = sc.nextLine();
        System.out.print("Ingrese fecha_inicio: ");
        String Fecha_inicio = sc.nextLine();
        System.out.print("Ingrese fecha_fin: ");
        String Fecha_fin = sc.nextLine();
        System.out.print("Ingrese el salario_base:");
        int salario_base = sc.nextInt(); 
        System.out.print("Ingrese el IRPF:");
        int IRPF = sc.nextInt();
        System.out.print("Ingrese el Horas_extras:");
        int Horas_extras = sc.nextInt();
        System.out.print("Ingrese el Horas_nocturnas:");
        int Horas_nocturnas = sc.nextInt();
        System.out.print("Ingrese el Salario_total:");
        int Salario_total = sc.nextInt();
        System.out.println("Salir");
        
    }
}
