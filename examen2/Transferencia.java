package com.mycompany.examen2;

public class Transferencia extends Pago {
    private String clabe;

    public Transferencia(double monto, String referencia, String clabe) {
        super(monto, referencia);

        if (clabe == null || !clabe.matches("[0-9]{18}")) {
            throw new IllegalArgumentException("La CLABE debe contener exactamente 18 digitos.");
        }

        this.clabe = clabe;
    }

    @Override
    public double calcularComision() {
        return 5.00;
    }

    @Override
    public double getLimite() {
        return 50000.00;
    }
}
