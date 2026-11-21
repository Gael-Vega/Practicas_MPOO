package com.mycompany.examen2;

public class Tarjeta extends Pago {

    public Tarjeta(double monto, String referencia) {
        super(monto, referencia);
    }

    @Override
    public double calcularComision() {
        return monto * 0.035 + 3.00;
    }

    @Override
    public double getLimite() {
        return 10000.00;
    }
}
