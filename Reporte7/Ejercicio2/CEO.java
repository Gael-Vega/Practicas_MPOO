public class CEO extends Empleado {
    float presupuestoAsignado;
    float acciones;
    float multiplicadorSalarioMin;
    String objetivo;

    public CEO (String nom, String sup, String exp, int num, float sueMin, float presupuestoAsignado, float acciones, String objetivo, float multiplicadorSalarioMin) {
        super (nom, sup, exp, num, sueMin);
        this.presupuestoAsignado = presupuestoAsignado;
        this.acciones = acciones;
        this.objetivo = objetivo;
        this.multiplicadorSalarioMin = multiplicadorSalarioMin;
    }

    @Override
    public void presentacion(){
        super.presentacion();
        System.out.println("Presupuesto asignado: " + presupuestoAsignado + "\nAcciones: " + acciones + "\nSueldo: " + (multiplicadorSalarioMin*sueldoMin) + "\nObjetivo: " + objetivo);
    }
}