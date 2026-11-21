package com.mycompany. examen2;

public abstract class Pago {
    protected double monto;
    protected String referencia;

    public Pago(double monto, String referencia) {
        if (monto <= 0) {
            throw new MontoInvalidoException("El monto debe ser mayor que cero.");
        }

        this.monto = monto;
        this.referencia = referencia;
    }

    public abstract double calcularComision();

    public abstract double getLimite();

    public String procesar() throws PagoRechazadoException {
        try {
            if (monto > getLimite()) {
                throw new PagoRechazadoException(
                    "Pago rechazado (" + getClass().getSimpleName() + "). Monto recibido: $"
                    + String.format(java.util.Locale.US, "%.2f", monto)
                    + ". Limite permitido: $"
                    + String.format(java.util.Locale.US, "%.2f", getLimite()) + "."
                );
            }

            double comision = calcularComision();
            double total = monto + comision;

            return "Pago aprobado (" + getClass().getSimpleName() + ")"
                + " | Referencia: " + referencia
                + " | Monto: $" + String.format(java.util.Locale.US, "%.2f", monto)
                + " | Comision: $" + String.format(java.util.Locale.US, "%.2f", comision)
                + " | Total a cobrar: $" + String.format(java.util.Locale.US, "%.2f", total);
        } finally {
            System.out.println("Intento registrado: " + getClass().getSimpleName()
                + " | Referencia: " + referencia);
        }
    }
}
