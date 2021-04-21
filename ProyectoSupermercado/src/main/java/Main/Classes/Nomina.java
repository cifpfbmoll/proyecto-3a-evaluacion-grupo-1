
import java.util.Calendar;

/**
 *
 * @author Tamara
 */
public class Nomina {
    private int Id_empleado;
    private String Puesto_de_trabajo ;
    private int Salario_base ;
    private int IRPF ;
    private Calendar Fecha_inicio ;
    private Calendar Fecha_fin ;
    private int Horas_extras ;
    private int Horas_noct ;
    private int Salario_total ;

    public Nomina(int Id_empleado, String Puesto_de_trabajo, int Salario_base, int IRPF, Calendar Fecha_inicio, Calendar Fecha_fin, int Horas_extras, int Horas_noct, int Salario_total) {
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

    public int getSalario_base() {
        return Salario_base;
    }

    public void setSalario_base(int Salario_base) {
        this.Salario_base = Salario_base;
    }

    public int getIRPF() {
        return IRPF;
    }

    public void setIRPF(int IRPF) {
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

    public int getSalario_total() {
        return Salario_total;
    }

    public void setSalario_total(int Salario_total) {
        this.Salario_total = Salario_total;
    }
    
    public static void certificadoIRPFanual(){
        }
     public static void consultarNomina(){
         
     }       
}

