package com.mycompany. examen2;

public class Efectivo extends Pago {

    public Efectivo(double monto, String referencia) {
        super(monto, referencia);
    }

    @Override
    public double calcularComision() {
        return 12.00;
    }

    @Override
    public double getLimite() {
        return 8000.00;
    }
}
