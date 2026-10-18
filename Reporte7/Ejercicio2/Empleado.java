public class Empleado {
    String nombreEmp;
    String superiorDirecto;
    String experiencia;
    int numDeEmp;
    final double sueldoMin;

    public Empleado (String nombreEmp, String superiorDirecto, String experiencia, int numDeEmp, double sueldoMin){
        this.nombreEmp = nombreEmp;
        this.superiorDirecto  = superiorDirecto;
        this.experiencia = experiencia;
        this.numDeEmp = numDeEmp;
        if (sueldoMin<0){
            sueldoMin *=-1;
        } 
        this.sueldoMin = sueldoMin;
    }

    public void presentacion (){
        System.out.println("Nombre del empleado: " + nombreEmp + "\nSuperior directo: " + superiorDirecto);
        System.out.println("Experiencia: \n" + experiencia + "\nNumero de empleado: " + numDeEmp);
    }
}