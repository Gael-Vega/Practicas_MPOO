import java.util.ArrayList;

public class Empresa {
    String nombreEmpresa;
    ArrayList <Empleado> empleados = new ArrayList<>();

    public Empresa(String nombreEmpresa){
        this.nombreEmpresa = nombreEmpresa;
    }

    public void agregarEmpleado(Empleado nuevoEmpleado){
        empleados.add(nuevoEmpleado);
    }
 
    public void presentacion () {
        System.out.println("-----" + nombreEmpresa + "-----");
        for (Empleado emp : empleados) {
            emp.presentacion();
            System.out.println("-----------------------------------");
        }
    }
}