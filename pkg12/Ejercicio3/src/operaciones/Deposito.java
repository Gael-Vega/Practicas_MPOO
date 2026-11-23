package operaciones;

import cuentas.Cuenta;
import excepciones.MontoInvalidoException;
import excepciones.OperacionInvalidaException;

/** Depósito: suma dinero a una cuenta destino. Hereda de Operacion y usa Cuenta. */
public class Deposito extends Operacion {

    private final Cuenta cuentaDestino;

    public Deposito(double monto, Cuenta cuentaDestino) {
        super(monto, "DEPOSITO");
        this.cuentaDestino = cuentaDestino;
    }

    @Override
    public void ejecutar() throws MontoInvalidoException, OperacionInvalidaException {
        if (cuentaDestino == null) {
            throw new OperacionInvalidaException("El depósito requiere una cuenta destino.");
        }
        cuentaDestino.depositar(monto);
    }

    @Override
    public void registrarOperacion() {
        cuentaDestino.getHistorial().agregarOperacion(this);
    }

    @Override
    public String toString() {
        return super.toString() + " -> cuenta " + cuentaDestino.getNumeroCuenta();
    }
}
