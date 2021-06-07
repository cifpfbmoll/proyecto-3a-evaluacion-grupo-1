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
     * Selecciona el ultimo codigo de las nominas guardadas en la base de datos y
     * le suma 1.
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
    /**
     * Setter especial que llama a el metodo calcularSalarios para asignar los
     * valores de Salario_base y Salario_total. Este setter se utiliza cuando
     * se crea una nomina nueva.
     * @throws SQLException Puede lanzar una excepcion ya que se comunica con
     * la base de datos.
     */
    public void setSalarios() throws SQLException {
        this.calcularSalarios();
    }
    
    /**
     * Metodo que busca en la base de datos todas las nominas del año que se le pasa
     * por parametro y guarda la suma de la retenciones de IRPF en una variable. Luego
     * devuelve la suma de esas retenciones.
     * @param empleado Empleado del que se selecciona su id.
     * @param year String que contiene el año del que buscar las nominas.
     * @param conexion Connection para conectarse con la BBDD.
     * @return double que es la retencion de IRPF lo que llevamos de año de ese usuario.
     * @throws SQLException Puede lanzar una excepcion ya que se comunica con
     * la base de datos.
     */
    public static double certificadoIRPFanual(Empleado empleado, String year, Connection conexion) throws SQLException {
        PreparedStatement query=conexion.prepareStatement("SELECT * FROM nomina WHERE id_empleado=? AND fecha_inicio LIKE ?");
        query.setInt(1, empleado.getId());
        query.setString(2, "%"+year);
        ResultSet resultado=query.executeQuery();
        double retencionAnualIRPF=0;
        while (resultado.next()){
            double rentcionMensualIRPF=(resultado.getDouble("IRPF")*resultado.getDouble("salario_total"))/(100-resultado.getDouble("IRPF"));
            retencionAnualIRPF+=rentcionMensualIRPF;
        }
        return retencionAnualIRPF;
    }
    
    /**
     * Metodo para usado para obtener el salario base y calcular el salario total
     * de un Empleado. Este metodo hace una query en la base de datos para obtener la informacion 
     * referente al salario base(el cual añade a la nomina)y a cuanto se pagana los pluses
     * del empleado dependiendo del puesto de trabajo que este haya ejercido. Despues
     * con todo esto y los datos ya insertados en la nomina sobre la que se instancia
     * calcula el salario total de este empleado y lo añade a la nomina
     * @throws SQLException Puede lanzar una excepcion ya que se comunica con
     * la base de datos.
     */
    public void calcularSalarios() throws SQLException{
        try (PreparedStatement query=Herramientas.getConexion().prepareStatement("SELECT * FROM plantilla_nomina WHERE puesto_trabajo=?")){
            query.setString(1, this.getPuesto_de_trabajo());
            try (ResultSet resultado = query.executeQuery()) {
                resultado.next();
                this.setSalario_base(resultado.getDouble("salario_base"));
                double horasExtras=resultado.getDouble("hora_extra")*this.getHoras_extras();
                double horasNocturnas=resultado.getDouble("nocturnidad")*this.getHoras_noct();
                double salrioSinIRPF=this.getSalario_base()+horasExtras+horasNocturnas;
                double retencionIRPF=(salrioSinIRPF*this.getIRPF())/100;
                this.setSalario_total(salrioSinIRPF-retencionIRPF);
            }
        }
    }
    
    /**
     * Metodo usado para insertar los valores de la nomina sobre la que se instancia
     * en la base de datos. 
     * @param conexion Connection para interectuar con la base de datos
     * @throws SQLException Puede lanzar una excepcion ya que se comunica con
     * la base de datos.
     */
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
    
    /**
     * Metodo al cual se le pasa un int que hace referencia a una nomina para 
     * eliminar de la base de datos esa nomina.
     * @param codigo_nomina int que identifica a una nomina
     * @throws SQLException Puede lanzar una excepcion ya que se comunica con
     * la base de datos.
     */
    public static void eliminarNomina (int codigo_nomina)throws SQLException{
        try (PreparedStatement query = Herramientas.getConexion().prepareStatement("DELETE FROM Nomina WHERE codigo_nomina = ?")) {
            query.setInt(1, codigo_nomina);
            query.executeUpdate();
        }
    }
    
    /**
     * Metodo al cual se le pasa un int que hace referencia a un empleado para que
     * el metodo busque en la base de datos todas las nominas de ese empleado.
     * Estas nominas son guardadas en una ArrayList que luego es devuelta por el
     * metodo.
     * @param Id_empleado int que identifica al empleado
     * @return ArrayList de nominas donde se han guardado las nominas de ese empleado
     * @throws SQLException Puede lanzar una excepcion ya que se comunica con
     * la base de datos.
     */
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

   
