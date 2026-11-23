package operaciones;

import cuentas.Cuenta;
import excepciones.MontoInvalidoException;
import excepciones.OperacionInvalidaException;
import excepciones.SaldoInsuficienteException;

/**
 * Transferencia: mueve dinero de una cuenta origen a una cuenta destino.
 * Hereda de Operacion; se registra en el historial de AMBAS cuentas.
 */
public class Transferencia extends Operacion {

    private final Cuenta cuentaOrigen;
    private final Cuenta cuentaDestino;

    public Transferencia(double monto, Cuenta cuentaOrigen, Cuenta cuentaDestino) {
        super(monto, "TRANSFERENCIA");
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
    }

    @Override
    public void ejecutar()
            throws MontoInvalidoException, SaldoInsuficienteException, OperacionInvalidaException {
        if (cuentaOrigen == null || cuentaDestino == null) {
            throw new OperacionInvalidaException("La transferencia requiere cuenta origen y destino.");
        }
        if (cuentaOrigen == cuentaDestino
                || cuentaOrigen.getNumeroCuenta().equals(cuentaDestino.getNumeroCuenta())) {
            throw new OperacionInvalidaException("La cuenta origen y destino deben ser diferentes.");
        }
        // Cuenta valida monto y saldo antes de modificar cualquiera de los dos saldos.
        cuentaOrigen.transferir(monto, cuentaDestino);
    }

    @Override
    public void registrarOperacion() {
        cuentaOrigen.getHistorial().agregarOperacion(this);
        cuentaDestino.getHistorial().agregarOperacion(this);
    }

    @Override
    public String toString() {
        return super.toString() + " " + cuentaOrigen.getNumeroCuenta()
                + " -> " + cuentaDestino.getNumeroCuenta();
    }
}
