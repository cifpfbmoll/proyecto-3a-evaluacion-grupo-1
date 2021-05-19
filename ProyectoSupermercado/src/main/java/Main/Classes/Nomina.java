package Main.Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.sql.* ;
/**
 *
 * @author Tamara
 */
public class Nomina {
    
    private int codigo_nomina;
    private int Id_empleado;
    private String Puesto_de_trabajo;
    private double Salario_base;
    private double IRPF;
    private Calendar Fecha_inicio;
    private Calendar Fecha_fin;
    private int Horas_extras;
    private int Horas_noct;
    private double Salario_total;

    public Nomina() {
    }

    public Nomina(int codigo_nomina,int Id_empleado, String Puesto_de_trabajo, double Salario_base, double IRPF, Calendar Fecha_inicio, Calendar Fecha_fin, int Horas_extras, int Horas_noct, double Salario_total) {
        this.setCodigo_nomina(codigo_nomina);
        this.setId_empleado(Id_empleado);
        this.setPuesto_de_trabajo(Puesto_de_trabajo);
        this.setSalario_base(Salario_base);
        this.setIRPF(IRPF);
        this.setFecha_inicio(Fecha_inicio);
        this.setFecha_fin(Fecha_fin);
        this.setHoras_extras(Horas_extras);
        this.setHoras_noct(Horas_noct);
        this.setSalario_total(Salario_total);
    }

    public int getCodigo_nomina() {
        return codigo_nomina;
    }

    public void setCodigo_nomina(int codigo_nomina) {
        this.codigo_nomina = codigo_nomina;
    }
    
    public int getId_empleado() {
        return Id_empleado;
    }

    public void setId_empleado(int Id_empleado) {
        this.Id_empleado = Id_empleado;
    }

    public String getPuesto_de_trabajo() {
        return Puesto_de_trabajo;
    }

    public void setPuesto_de_trabajo(String Puesto_de_trabajo) {
        this.Puesto_de_trabajo = Puesto_de_trabajo;
    }

    public double getSalario_base() {
        return Salario_base;
    }

    public void setSalario_base(double Salario_base) {
        this.Salario_base = Salario_base;
    }

    public double getIRPF() {
        return IRPF;
    }

    public void setIRPF(double IRPF) {
        this.IRPF = IRPF;
    }

    public Calendar getFecha_inicio() {
        return Fecha_inicio;
    }

    public void setFecha_inicio(Calendar Fecha_inicio) {
        this.Fecha_inicio = Fecha_inicio;
    }

    public Calendar getFecha_fin() {
        return Fecha_fin;
    }

    public void setFecha_fin(Calendar Fecha_fin) {
        this.Fecha_fin = Fecha_fin;
    }

    public int getHoras_extras() {
        return Horas_extras;
    }

    public void setHoras_extras(int Horas_extras) {
        this.Horas_extras = Horas_extras;
    }

    public int getHoras_noct() {
        return Horas_noct;
    }

    public void setHoras_noct(int Horas_noct) {
        this.Horas_noct = Horas_noct;
    }

    public double getSalario_total() {
        return Salario_total;
    }

    public void setSalario_total(double Salario_total) {
        this.Salario_total = Salario_total;
    }

    public static void certificadoIRPFanual() {
        
    }

    public static void consultarNomina() {}
  
    public static Nomina consultarNomina(int id, Connection conexion) throws SQLException{
         
        PreparedStatement sentencia = conexion.prepareStatement("SELECT * FROM nomina WHERE ID_empleado = ?");
        sentencia.setInt(1, id);
        ResultSet resultado = sentencia.executeQuery();
        resultado.next();
        String Puesto_trabajo = resultado.getString("Puesto_trabajo");
        String fecha_inicio = resultado.getString("Fecha_inicio");
        String Fecha_fin = resultado.getString("Fecha_fin");
        int Salario_base = resultado.getInt("Salario_base");
        int IRPF = resultado.getInt("IRPF");
        int Hora_extras = resultado.getInt("Horas_extras");
        int Horas_nocturnas = resultado.getInt("Horas_nocturnas");
        int Salario_total = resultado.getInt("Salario_total");
        Nomina Nom = new Nomina();
        return Nom;
     }       
}
   
