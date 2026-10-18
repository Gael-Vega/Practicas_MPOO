public class Vendedor extends Empleado {
    int recordDeVentas;
    float comision;
    float multiplicadorSalarioMin;
    int ventasMinMensuales;

    public Vendedor (String nom, String sup, String exp, int num, float sueMin, int recordDeVentas, float comision, int ventasMinMensuales, float multiplicadorSalarioMin){
        super (nom, sup, exp, num, sueMin);
        this.recordDeVentas = recordDeVentas;
        this.comision = comision;
        this.ventasMinMensuales = ventasMinMensuales;
        this.multiplicadorSalarioMin = multiplicadorSalarioMin;
    }

    @Override
    public void presentacion(){
        super.presentacion();
        System.out.println("Record de ventas: " + recordDeVentas + "\nComision por ventas: " + comision);
        System.out.println("Salario: " + (multiplicadorSalarioMin*sueldoMin) + "\nVentas minimas obligatorias por mes: " + ventasMinMensuales);
    }
}