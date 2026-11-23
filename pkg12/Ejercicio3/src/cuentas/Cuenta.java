package cuentas;

import excepciones.MontoInvalidoException;
import excepciones.OperacionInvalidaException;
import excepciones.SaldoInsuficienteException;
import historial.Historial;

/**
 * Representa una cuenta bancaria y es la ÚNICA clase que puede modificar su saldo.
 *
 * Relaciones:
 *  - Tiene un {@link Historial} (composición: el historial nace y muere con la cuenta).
 *  - Es usada por Banco (que la almacena) y por Deposito, Retiro y Transferencia.
 */
public class Cuenta {

    private final String numeroCuenta;
    private final String titular;
    private final String nip;
    private double saldo;
    private final Historial historial;

    /**
     * Crea una cuenta con saldo inicial de cero.
     * Reutiliza el otro constructor mediante this(...) para no duplicar validaciones.
     */
    public Cuenta(String numeroCuenta, String titular, String nip)
            throws OperacionInvalidaException, MontoInvalidoException {
        this(numeroCuenta, titular, 0.0, nip);
    }

    /** Crea una cuenta con un saldo inicial válido (cero o mayor). */
    public Cuenta(String numeroCuenta, String titular, double saldoInicial, String nip)
            throws OperacionInvalidaException, MontoInvalidoException {
        if (numeroCuenta == null || numeroCuenta.isBlank()) {
            throw new OperacionInvalidaException("El número de cuenta no puede estar vacío.");
        }
        if (titular == null || titular.isBlank()) {
            throw new OperacionInvalidaException("El titular no puede estar vacío.");
        }
        if (nip == null || !nip.matches("\\d{4}")) {
            throw new OperacionInvalidaException("El NIP debe tener exactamente 4 dígitos.");
        }
        if (Double.isNaN(saldoInicial) || Double.isInfinite(saldoInicial) || saldoInicial < 0) {
            throw new MontoInvalidoException("El saldo inicial no puede ser negativo.");
        }
        this.numeroCuenta = numeroCuenta.trim();
        this.titular = titular.trim();
        this.nip = nip;
        this.saldo = saldoInicial;
        this.historial = new Historial();
    }

    // ------------------------------------------------------------------
    // Operaciones sobre el saldo
    // ------------------------------------------------------------------

    public void depositar(double monto) throws MontoInvalidoException {
        exigirMontoValido(monto);
        actualizarSaldo(saldo + monto);
    }

    public void retirar(double monto) throws MontoInvalidoException, SaldoInsuficienteException {
        exigirMontoValido(monto);
        exigirSaldoSuficiente(monto);
        actualizarSaldo(saldo - monto);
    }

    /**
     * Transfiere dinero a otra cuenta. TODAS las condiciones se comprueban antes de
     * tocar cualquiera de los dos saldos, así nunca queda una transferencia a medias.
     */
    public void transferir(double monto, Cuenta cuentaDestino)
            throws MontoInvalidoException, SaldoInsuficienteException, OperacionInvalidaException {
        if (cuentaDestino == null) {
            throw new OperacionInvalidaException("La cuenta destino no es válida.");
        }
        if (cuentaDestino == this || cuentaDestino.numeroCuenta.equals(this.numeroCuenta)) {
            throw new OperacionInvalidaException("No se puede transferir a la misma cuenta.");
        }
        exigirMontoValido(monto);
        exigirSaldoSuficiente(monto);

        // Ya está todo validado: ambas actualizaciones pueden completarse.
        this.actualizarSaldo(this.saldo - monto);
        cuentaDestino.actualizarSaldo(cuentaDestino.saldo + monto);
    }

    public double consultarSaldo() {
        return saldo;
    }

    // ------------------------------------------------------------------
    // Validaciones
    // ------------------------------------------------------------------

    /** Un monto es válido si es un número finito mayor que cero. */
    public boolean validarMonto(double monto) {
        return !Double.isNaN(monto) && !Double.isInfinite(monto) && monto > 0;
    }

    public boolean validarNip(String nipIngresado) {
        return nip.equals(nipIngresado);
    }

    private void exigirMontoValido(double monto) throws MontoInvalidoException {
        if (!validarMonto(monto)) {
            throw new MontoInvalidoException("El monto debe ser mayor a cero.");
        }
    }

    private void exigirSaldoSuficiente(double monto) throws SaldoInsuficienteException {
        if (monto > saldo) {
            throw new SaldoInsuficienteException(
                    String.format("Saldo insuficiente. Disponible: $%.2f, solicitado: $%.2f", saldo, monto));
        }
    }

    /**
     * Único punto donde se escribe el saldo. Es privado: nadie fuera de esta clase
     * puede fijar un saldo arbitrario; solo depositar/retirar/transferir llegan aquí
     * después de validar.
     */
    private void actualizarSaldo(double nuevoSaldo) {
        this.saldo = nuevoSaldo;
    }

    // ------------------------------------------------------------------
    // Getters (no existe setSaldo ni getNip a propósito)
    // ------------------------------------------------------------------

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public Historial getHistorial() {
        return historial;
    }

    @Override
    public String toString() {
        return "Cuenta " + numeroCuenta + " - Titular: " + titular;
    }
}
