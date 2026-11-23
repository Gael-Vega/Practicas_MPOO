package operaciones;

import excepciones.MontoInvalidoException;
import excepciones.OperacionInvalidaException;
import excepciones.SaldoInsuficienteException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Clase abstracta que define el comportamiento general de cualquier operación bancaria.
 *
 * Relaciones: es la clase padre de Deposito, Retiro y Transferencia, y el Historial
 * guarda referencias de tipo Operacion (polimorfismo).
 */
public abstract class Operacion {

    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    protected final LocalDateTime fecha;
    protected final double monto;
    protected final String tipo;

    public Operacion(double monto, String tipo) {
        this.monto = monto;
        this.tipo = tipo;
        this.fecha = LocalDateTime.now();
    }

    /** Cada tipo de operación define cómo se ejecuta. */
    public abstract void ejecutar()
            throws MontoInvalidoException, SaldoInsuficienteException, OperacionInvalidaException;

    /**
     * Guarda la operación en el historial de las cuentas involucradas.
     * Solo se invoca después de que ejecutar() terminó sin excepciones.
     * Las subclases la sobrescriben.
     */
    public void registrarOperacion() {
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public double getMonto() {
        return monto;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "[%s] %-13s $%,.2f", fecha.format(FORMATO), tipo, monto);
    }
}
