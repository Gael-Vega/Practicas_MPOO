package banco;

import cuentas.Cuenta;
import excepciones.CuentaNoEncontradaException;
import excepciones.MontoInvalidoException;
import excepciones.NipIncorrectoException;
import excepciones.OperacionInvalidaException;
import excepciones.SaldoInsuficienteException;
import operaciones.Operacion;

import java.util.ArrayList;

/**
 * Administra la colección de cuentas: las registra, las busca y ejecuta operaciones.
 * Relaciones: tiene muchas Cuenta (agregación) y ejecuta cualquier Operacion.
 */
public class Banco {

    private final ArrayList<Cuenta> cuentas;

    public Banco() {
        this.cuentas = new ArrayList<>();
    }

    public void registrarCuenta(Cuenta cuenta) throws OperacionInvalidaException {
        if (cuenta == null) {
            throw new OperacionInvalidaException("No se puede registrar una cuenta nula.");
        }
        for (Cuenta existente : cuentas) {
            if (existente.getNumeroCuenta().equals(cuenta.getNumeroCuenta())) {
                throw new OperacionInvalidaException(
                        "Ya existe una cuenta con el número " + cuenta.getNumeroCuenta() + ".");
            }
        }
        cuentas.add(cuenta);
    }

    public Cuenta buscarCuenta(String numeroCuenta) throws CuentaNoEncontradaException {
        String buscado = numeroCuenta == null ? "" : numeroCuenta.trim();
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumeroCuenta().equals(buscado)) {
                return cuenta;
            }
        }
        throw new CuentaNoEncontradaException("No existe la cuenta " + buscado + ".");
    }

    /** Busca la cuenta y comprueba su NIP; devuelve la cuenta autenticada. */
    public Cuenta autenticar(String numeroCuenta, String nip)
            throws CuentaNoEncontradaException, NipIncorrectoException {
        Cuenta cuenta = buscarCuenta(numeroCuenta);
        if (!cuenta.validarNip(nip)) {
            throw new NipIncorrectoException("NIP incorrecto para la cuenta " + cuenta.getNumeroCuenta() + ".");
        }
        return cuenta;
    }

    /**
     * Ejecuta la operación y SOLO si no lanzó excepción la registra en el historial.
     * Así una operación fallida nunca queda guardada como exitosa.
     */
    public void realizarOperacion(Operacion operacion)
            throws MontoInvalidoException, SaldoInsuficienteException, OperacionInvalidaException {
        if (operacion == null) {
            throw new OperacionInvalidaException("La operación no es válida.");
        }
        operacion.ejecutar();
        operacion.registrarOperacion();
    }
}
