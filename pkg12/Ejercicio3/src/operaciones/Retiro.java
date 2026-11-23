package operaciones;

import cuentas.Cuenta;
import excepciones.MontoInvalidoException;
import excepciones.OperacionInvalidaException;
import excepciones.SaldoInsuficienteException;

/** Retiro: resta dinero de una cuenta origen. Hereda de Operacion y usa Cuenta. */
public class Retiro extends Operacion {

    private final Cuenta cuentaOrigen;

    public Retiro(double monto, Cuenta cuentaOrigen) {
        super(monto, "RETIRO");
        this.cuentaOrigen = cuentaOrigen;
    }

    @Override
    public void ejecutar()
            throws MontoInvalidoException, SaldoInsuficienteException, OperacionInvalidaException {
        if (cuentaOrigen == null) {
            throw new OperacionInvalidaException("El retiro requiere una cuenta origen.");
        }
        cuentaOrigen.retirar(monto);
    }

    @Override
    public void registrarOperacion() {
        cuentaOrigen.getHistorial().agregarOperacion(this);
    }

    @Override
    public String toString() {
        return super.toString() + " <- cuenta " + cuentaOrigen.getNumeroCuenta();
    }
}
