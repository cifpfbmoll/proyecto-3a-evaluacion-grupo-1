package Main.Classes;


import java.sql.*;
import java.util.ArrayList;
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
    private String Fecha_inicio;
    private String Fecha_fin;
    private int Horas_extras;
    private int Horas_noct;
    private double Salario_total;

    public Nomina() {
    }

    public Nomina(int codigo_nomina,int Id_empleado, String Puesto_de_trabajo, double Salario_base, double IRPF, String Fecha_inicio, String Fecha_fin, int Horas_extras, int Horas_noct, double Salario_total) {
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

    public String getFecha_inicio() {
        return Fecha_inicio;
    }

    public void setFecha_inicio(String Fecha_inicio) {
        this.Fecha_inicio = Fecha_inicio;
    }

    public String getFecha_fin() {
        return Fecha_fin;
    }

    public void setFecha_fin(String Fecha_fin) {
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
        int codigo_nomina = resultado.getInt("Codigo_nomina");
        int Id_empleado = resultado.getInt("Id_empleado");
        String Puesto_trabajo = resultado.getString("Puesto_trabajo");
        double Salario_base = resultado.getDouble("Salario_base");
        double IRPF = resultado.getDouble("IRPF");
        String Fecha_inicio = resultado.getString("Fecha_inicio");
        String Fecha_fin = resultado.getString("Fecha_fin");
        int Horas_extras = resultado.getInt("Horas_extras");
        int Horas_nocturnas = resultado.getInt("Horas_nocturnas");
        double Salario_total = resultado.getDouble("Salario_total");
        Nomina Nom = new Nomina(codigo_nomina,Id_empleado,Puesto_trabajo,Salario_base,IRPF,Fecha_inicio,Fecha_fin,Horas_extras,Horas_nocturnas,Salario_total);
        resultado.close();
        sentencia.close();
        return Nom;
     } 
    
    public static void eliminarNomina (int codigo_nomina)throws SQLException{
        try (PreparedStatement query = Herramientas.getConexion().prepareStatement("DELETE FROM Nomina WHERE codigo_nomina = ?")) {
            query.setInt(1, codigo_nomina);
            query.executeUpdate();
        }
    }
    
    
    public static ArrayList recogerNomina(int Id_empleado)throws SQLException{
        ArrayList <Nomina> listaNomina;
        try (PreparedStatement query = Herramientas.getConexion().prepareStatement("SELECT * FROM Nomina WHERE Id_empleado=?")) {
            query.setInt(2, Id_empleado);
            try (ResultSet resultado = query.executeQuery()) {
                listaNomina = new ArrayList();
                while(resultado.next()){
                    Nomina Nom= new Nomina (resultado.getInt(1), resultado.getInt(2), resultado.getString(3), resultado.getDouble(4), resultado.getDouble(5), resultado.getString(6), resultado.getString(7), resultado.getInt(8), resultado.getInt(9),resultado.getDouble(10));
                    listaNomina.add(Nom);
                }
            }
        }
        return listaNomina;
     }
}

   
