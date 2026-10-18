public class Tecnico extends Empleado {
    String especialidad;
    String certificado;
    int horasMantenimiento;
    float multiplicadorSalarioMin;

    public Tecnico (String nom, String sup, String exp, int num, float sueMin, String especialidad, String certificado, int horasMantenimiento, float multiplicadorSalarioMin){
        super (nom, sup, exp, num, sueMin);
        this.especialidad = especialidad;
        this.certificado = certificado;
        this.horasMantenimiento = horasMantenimiento;
        this.multiplicadorSalarioMin = multiplicadorSalarioMin;
    }

    @Override
    public void presentacion(){
        super.presentacion();
        System.out.println("Especialidad: " + especialidad + "\nCertificado: " + certificado);
        System.out.println("Horas de mantenimiento: " + horasMantenimiento + "\nSalario: " + (multiplicadorSalarioMin*sueldoMin));
    }
}