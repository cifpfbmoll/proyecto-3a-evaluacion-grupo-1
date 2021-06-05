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
    
    /**
     * Constructor para crear una nomina desde 0. Las peculiaridades de este constructor
     * son que asigna el codigo_nomina (seleccionanado de la BBDD la nomina con la id mas alta
     * y sumandole uno), el salario_total y el salario_base(calculandolo a traves de los datos ya asignados
     * y de una tabla en la BBDD que contiene infromacion sobre a cuanto se pagan las
     * horas de cierto puesto de trabajo) de forma automatica.
     * @param Id_empleado int
     * @param Puesto_de_trabajo String
     * @param IRPF double
     * @param Fecha_inicio String
     * @param Fecha_fin String
     * @param Horas_extras int
     * @param Horas_noct int
     * @throws SQLException Puede genrar una excepcion ya que se comunica con las BBDD.
     */
    public Nomina(int Id_empleado, String Puesto_de_trabajo, double IRPF, String Fecha_inicio, String Fecha_fin, int Horas_extras, int Horas_noct) throws SQLException {
        this.setCodigo_nomina();
        this.setId_empleado(Id_empleado);
        this.setPuesto_de_trabajo(Puesto_de_trabajo);
        this.setIRPF(IRPF);
        this.setFecha_inicio(Fecha_inicio);
        this.setFecha_fin(Fecha_fin);
        this.setHoras_extras(Horas_extras);
        this.setHoras_noct(Horas_noct);
        this.setSalarios();    
    }
    /**
     * Constructor para coger una nomina de la BBDD y copiarla en el programa.
     * @param codigo_nomina
     * @param Id_empleado int
     * @param Puesto_de_trabajo String
     * @param Salario_base double
     * @param IRPF double
     * @param Fecha_inicio String
     * @param Fecha_fin String
     * @param Horas_extras int
     * @param Horas_noct int
     * @param Salario_total double
     */
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
    /**
     * Selecc
     * @throws SQLException Puede tirar excepcion ya que se comunica con la base de datos
     */
    public void setCodigo_nomina() throws SQLException {
        try (PreparedStatement query = Herramientas.getConexion().prepareStatement("SELECT MAX(codigo_nomina) FROM nomina"); 
        ResultSet resultado = query.executeQuery()) {
            resultado.next();
            this.codigo_nomina=(resultado.getInt(1))+1;
        }
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
    
    public void setSalarios() throws SQLException {
        this.calcularSalarios();
    }

    public static void certificadoIRPFanual() {
        
    }
    
    public void calcularSalarios() throws SQLException{
        try (PreparedStatement query=Herramientas.getConexion().prepareStatement("SELECT * FROM plantilla_nomina WHERE puesto_trabajo=?")){
            query.setString(1, this.getPuesto_de_trabajo());
            try (ResultSet resultado = query.executeQuery()) {
                resultado.next();
                this.setSalario_base(resultado.getDouble("salario_base"));
                double horasExtras=resultado.getDouble("hora_extra")*this.getHoras_extras();
                double horasNocturnas=resultado.getDouble("nocturnidad")*this.getHoras_extras();
                double salrioSinIRPF=this.getSalario_base()+horasExtras+horasNocturnas;
                double retencionIRPF=(salrioSinIRPF*this.getIRPF())/100;
                this.setSalario_total(salrioSinIRPF-retencionIRPF);
            }
        }
    }
    
    public void añadirNominaBBDD(Connection conexion) throws SQLException{ 
        try (PreparedStatement query = conexion.prepareStatement("INSERT INTO nomina VALUES (?,?,?,?,?,?,?,?,?,?)")) {
            query.setInt(1, this.getCodigo_nomina());
            query.setInt(2, this.getId_empleado());
            query.setString(3, this.getPuesto_de_trabajo());
            query.setDouble(4, this.getSalario_base());
            query.setDouble(5, this.getIRPF());
            query.setString(6, this.getFecha_inicio());
            query.setString(7, this.getFecha_fin());
            query.setDouble(8, this.getHoras_extras());
            query.setDouble(9, this.getHoras_noct());
            query.setDouble(10, this.getSalario_total());
            query.executeUpdate();
        }
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
            query.setInt(1, Id_empleado);
            try (ResultSet resultado = query.executeQuery()) {
                listaNomina = new ArrayList();
                while(resultado.next()){
                    Nomina Nom=new Nomina (resultado.getInt(1), resultado.getInt(2), 
                    resultado.getString(3), resultado.getDouble(4), resultado.getDouble(5), 
                    resultado.getString(6), resultado.getString(7), resultado.getInt(8), 
                    resultado.getInt(9),resultado.getDouble(10));
                    listaNomina.add(Nom);
                }
            }
        }
        return listaNomina;
     }
}

   
